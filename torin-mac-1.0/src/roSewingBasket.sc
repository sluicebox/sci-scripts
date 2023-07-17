;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11200)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use foEExit)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roSewingBasket 0
)

(local
	nInchies
)

(procedure (SetInchieScript aScript)
	(cond
		((not (poInchie script:))
			(poInchie setScript: aScript)
		)
		((!= aScript (poInchie script:))
			((poInchie script:) next: aScript)
		)
	)
)

(instance soMoveLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (poInchie cel:) (poInchie lastCel:))
					(poInchie setCel: 0)
				)
				(goSound1 playSound: 11202)
				(poInchie setCycle: CT 4 1 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance foNearInchie of Feature
	(properties
		x 359
		y 186
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 326 157 321 210 326 247 393 251 404 184 393 126 333 122
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (onMe ev &tmp reallyOnMe)
		(return
			(and
				(= reallyOnMe (super onMe: ev))
				(!= (poInchie cel:) 4)
				(SetInchieScript soMoveLeft)
			)
		)
	)
)

(instance soMoveRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 playSound: 11201)
				(poInchie setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance foFarInchie of Feature
	(properties
		x 247
		y 177
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 329 122 314 242 184 218 202 104
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (onMe ev &tmp reallyOnMe)
		(return
			(and
				(= reallyOnMe (super onMe: ev))
				(!= (poInchie cel:) (poInchie lastCel:))
				(!= (poInchie cel:) 0)
				(SetInchieScript soMoveRight)
			)
		)
	)
)

(instance oNotInchie of Polygon
	(properties)

	(method (init)
		(super
			init: 436 243 412 237 375 232 338 226 311 220 292 214 264 204 271 116 206 122 150 305 461 306
		)
	)
)

(instance poInchie of Prop
	(properties
		noun 1
		x 325
		y 279
		view 11200
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(oNotInchie init:)
	)

	(method (dispose)
		(super dispose:)
		(oNotInchie dispose:)
	)

	(method (onMe event)
		(return
			(and
				(not (oNotInchie onMe: (event x:) (event y:)))
				(super onMe: event)
			)
		)
	)

	(method (doVerb theVerb)
		(++ nInchies)
		(gMessager kill: say: noun theVerb 0 nInchies)
		(if (> nInchies 3)
			(gEgo get: ((ScriptID 64001 0) get: 3)) ; oInvHandler, ioInchworm
			((ScriptID 64017 0) set: 3) ; oFlags
			(self dispose:)
		)
	)
)

(instance foExit of CUExitFeature
	(properties
		rExitTo 11100
	)
)

(instance soEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poInchie
					loop: 0
					cel: 0
					init:
					addHotspotVerb: 1
					setCycle: End self
				)
			)
			(1
				(gGame handsOn:)
				(poInchie setLoop: 1 setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance roSewingBasket of TPRoom
	(properties
		picture 11200
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 11200)
		(goSound1 preload: 11202 11201)
		(foExit init:)
		(foNearInchie init:)
		(foFarInchie init:)
		(gGame handsOff:)
		(poInchie setScript: soEnter)
		(= nInchies 0)
	)
)

