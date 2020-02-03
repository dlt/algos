def flatten_dictionary(dict)
  result = {}
  for key, value in dict do
    append_to_result(result, key, value)
  end

  result 
end
  
def append_to_result(result, key, value)
  if !value.is_a?(Hash)
    result[key] = value
  else
    for inner_key, inner_value in value
      append_to_result(result, build_key(key, inner_key), inner_value)
    end
  end
end

def build_key(k1, k2)
  return k2.intern if k1.empty?
  return k1.intern if k2.empty?
  return "#{k1}.#{k2}".intern
end

# { 'a' : 1, b: { 'c' : 2, 'd': 3, '': 4} } 


puts flatten_dictionary({Key: {a: 2, b: 3}}).to_s