;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4046)
(include sci.sh)
(use Main)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm4046 0
)

(instance rm4046 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4046
		south 400 ; marienRm
	)

	(method (init)
		(fLizard init:)
		(super init: &rest)
	)
)

(instance fLizard of Feature
	(properties
		noun 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 314 309 322 295 319 274 307 259 289 252 261 258 244 260 224 246 219 227 228 202 246 186 276 171 255 171 231 150 231 135 251 118 261 104 311 105 318 82 303 78 296 67 299 39 329 54 337 49 358 64 372 86 378 108 378 124 397 115 403 100 399 81 408 83 417 103 416 116 413 124 387 142 411 133 415 145 411 160 397 207 389 175 391 158 373 175 337 195 364 207 366 218 359 227 320 212 278 210 250 221 245 229 248 235 261 239 286 235 309 242 320 258 333 285 334 296 324 312 316 317
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 30 62 0 0 0 400) ; "(LOOK AT DRAGON GARGOYLE IN MARIENPLATZ, OMINOUS)Looks like this isn't the first time there's been a shadow over Munich."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

