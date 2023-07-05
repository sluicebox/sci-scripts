;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4640)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm4640 0
)

(instance rm4640 of ExitRoom ; "Hunt Club: Ritual Room"
	(properties
		modNum 460
		noun 6
		picture 4640
		south 4611 ; rm4611
	)

	(method (init)
		(super init: &rest)
		(SetFlag 524)
		(fPictures init:)
		(gGame handsOn:)
	)
)

(instance fPictures of GKFeature
	(properties
		modNum 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 0 333 615 333 615 0 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gGame changeScore: 936)
			(gMessager say: 3 62 0 0 0 460) ; "(THOUGHTFUL)Photos of the club hunts. Looks like von Glower and von Zell monopolized the camera. Or the hunts."
		else
			(super doVerb: theVerb)
		)
	)
)

