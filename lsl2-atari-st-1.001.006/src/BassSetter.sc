;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use System)

(class BassSetter of Code
	(properties
		radii 7
	)

	(method (doit whom)
		(whom brBottom: (+ (whom y:) 1))
		(whom brTop: (- (whom brBottom:) (whom yStep:)))
		(whom brLeft: (- (whom x:) radii))
		(whom brRight: (+ (whom x:) radii))
	)
)

