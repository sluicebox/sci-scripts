;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)
(use System)

(public
	ScaryTalker 0
)

(local
	local0
)

(class ScaryTalker of Talker
	(properties)

	(method (init param1 param2 param3 param4 &tmp temp0 temp1)
		(= initialized 1)
		(gTalkers addToFront: self)
		(= temp0 (self x:))
		(= temp1 (self y:))
		((ScriptID 0 11) ; overlayPlane
			addCast: (= local0 ((Cast new:) name: {faceCast} init: yourself:))
		)
		(if argc
			(if param1
				((= mouth (param1 new:))
					x: (+ (param1 x:) temp0)
					y: (+ (param1 y:) temp1)
				)
			)
			(if (> argc 1)
				(if param2
					((= bust (param2 new:))
						x: (+ (param2 x:) temp0)
						y: (+ (param2 y:) temp1)
					)
				)
				(if (> argc 2)
					(if param3
						((= eyes (param3 new:))
							x: (+ (param3 x:) temp0)
							y: (+ (param3 y:) temp1)
						)
					)
					(if (> argc 3)
						(= frame param4)
					)
				)
			)
		)
		(if (not mouth)
			(= mouth
				((Prop new:)
					name: {mouth}
					view: 98
					loop: 0
					cel: 0
					x: x
					y: y
					yourself:
				)
			)
		)
		(mouth init: local0 setPri: priority)
		(if bust
			(bust setPri: priority init: local0)
		)
		(if eyes
			(eyes setPri: priority init: local0)
		)
		(if frame
			(frame setPri: priority init: local0)
		)
		(= initialized 1)
	)

	(method (doit)
		(if local0
			(local0 doit:)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if local0
			(local0 dispose:)
			(= local0 0)
			(= mouth (= eyes (= bust (= frame 0))))
			(super dispose: &rest)
		)
	)
)

