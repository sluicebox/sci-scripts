;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8349)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use System)

(public
	rm8349 0
)

(instance rm8349 of ExitRoom
	(properties
		picture 8349
		south 8342 ; rm8342
		west 8346 ; rm8346
	)

	(method (init)
		(super init: &rest)
		(gGame changeScore: 1005)
		(plaque init:)
	)
)

(instance readIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 8 62 0 1 self 830) ; "(HERRENCHEIMSEE MUSEUM, READING DISPLAYS)June 18, 1886. Ludwig's funeral procession marches through the streets of Munich, followed by enormous crowds of mourners. The service is held at a packed St. Michael's church. Lightening strikes the church during the service, but no one is harmed."
			)
			(1
				(gMessager say: 8 62 0 2 self 830) ; "(READING DISPLAYS)Ludwig's body is entombed in the Wittelsbach crypt at St. Michael's. His heart is placed in an urn in the pilgrimage chapel at Alt\99tting in the Wittelsbach tradition. The urn is shown to the right."
			)
			(2
				(if (IsFlag 598)
					(self dispose:)
				else
					(SetFlag 598)
					(gMessager say: 8 62 0 3 self 830) ; "His heart in an urn! How bizarre!"
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance plaque of Feature
	(properties
		nsLeft 188
		nsTop 28
		nsRight 464
		nsBottom 304
	)

	(method (doVerb)
		(gCurRoom setScript: readIt)
	)
)

