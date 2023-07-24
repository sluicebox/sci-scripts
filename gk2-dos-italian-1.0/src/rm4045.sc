;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4045)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm4045 0
)

(instance rm4045 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4045
		south 400 ; marienRm
	)

	(method (init)
		(super init: &rest)
		(fPlaque init:)
		(gGame handsOn:)
	)
)

(instance fPlaque of Feature
	(properties
		modNum 400
	)

	(method (init)
		(self
			createPoly: 298 264 259 259 231 249 205 232 187 211 177 189 173 160 179 131 191 112 215 93 241 82 262 79 290 79 286 86 288 94 301 98 318 92 318 83 313 78 350 83 375 90 396 105 413 123 422 145 424 174 418 195 405 217 391 233 367 249 346 256 327 261
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 29 62 0 0 0 400) ; "(LOOK AT RATHAUS MARIENPLATZ)Rathaus. That's a town hall. Rittersberg has one, too."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

