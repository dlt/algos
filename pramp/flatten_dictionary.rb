#Flatten a Dictionary
#A dictionary is a type of data structure that is supported natively in all major interpreted languages such as JavaScript, Python, Ruby and PHP, where it’s known as an Object, Dictionary, Hash and Array, respectively.
#In simple terms, a dictionary is a collection of unique keys and their values. The values can typically be of any primitive type (i.e an integer, boolean, double, string etc) or other dictionaries (dictionaries can be nested).
#However, for this exercise assume that values are either an integer, a string or another dictionary.
#Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it.


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
