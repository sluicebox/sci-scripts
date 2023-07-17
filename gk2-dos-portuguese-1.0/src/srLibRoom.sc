;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use Scaler)
(use Polygon)
(use Feature)

(public
	srLibRoom 0
)

(instance srLibRoom of GK2Room ; "Schloss Ritter: Library"
	(properties
		noun 20
		picture 1301
	)

	(method (init)
		(bedroomDoor init:)
		(occultSection init:)
		(schattenjagerSection init:)
		(biographySection init:)
		(table init:)
		(gEgo
			posn: 219 305
			heading: 135
			sel_737:
			setScaler: Scaler 72 50 323 286
			init:
		)
		(super init: &rest)
		(if (not (IsFlag 477))
			(SetFlag 477)
			(PlayScene 153)
			(gEgo put: 22) ; invLibraryKey
		)
		(Lock rsAUDIO 121 0)
		(Lock rsAUDIO 122 0)
		(Lock rsAUDIO 123 0)
	)
)

(instance bedroomDoor of ExitFeature
	(properties
		nsLeft 74
		nsTop 144
		nsRight 136
		nsBottom 297
		sightAngle 40
		approachY 207
		x 104
		y 220
		BAD_SELECTOR 154
		BAD_SELECTOR 1403
		BAD_SELECTOR 6
	)
)

(instance occultSection of GKFeature
	(properties
		nsLeft 284
		nsTop 60
		nsRight 408
		nsBottom 247
		sightAngle 40
		approachX 348
		approachY 254
		x 346
		y 153
	)

	(method (handleEvent)
		(if (or (== gChapter 6) (IsFlag 178))
			(= global141 self)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((== gChapter 6)
					(gMessager say: 16 62 0 1) ; "(SCHLOSS RITTER LIBRARY, CLICK ON BOOKS IN CH 6)I think the time for research has passed."
				)
				((IsFlag 178)
					(gMessager say: 27 62 0 1) ; "(LOOK AT OCCULT SECTION AFTER GETTING LUDWIG BIO)There's nothing else on werewolves in the occult section."
				)
				(else
					(PlayScene 155)
					(gEgo get: 23 get: 26) ; invWerewolfBook, invLudwigLetter
					(SetFlag 178)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance table of ExitFeature
	(properties
		nsLeft 490
		nsTop 261
		nsRight 628
		nsBottom 328
		approachX 600
		approachY 300
		BAD_SELECTOR 1313
		BAD_SELECTOR 3
	)
)

(instance schattenjagerSection of GKFeature
	(properties
		nsLeft 428
		nsTop 76
		nsRight 556
		nsBottom 249
		sightAngle 40
		approachX 476
		approachY 300
		x 492
		y 163
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(!= (event message:) $003e) ; >
					(== gChapter 6)
					(gEgo has: 24) ; invVictorJournal
					(IsFlag 486)
					(gEgo has: 25) ; invChristianJournal
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 62) ; Do
				(super doVerb: theVerb)
			)
			((== gChapter 6)
				(gMessager say: 16 62 0 1) ; "(SCHLOSS RITTER LIBRARY, CLICK ON BOOKS IN CH 6)I think the time for research has passed."
			)
			((not (or (gEgo has: 24) (IsFlag 486))) ; invVictorJournal
				(PlayScene 156)
				(SetFlag 486)
				(gEgo get: 24) ; invVictorJournal
			)
			(
				(and
					(gEgo has: 24) ; invVictorJournal
					(IsFlag 466)
					(not (IsFlag 476))
					(not (IsFlag 487))
				)
				(SetFlag 476)
				(PlayScene 157)
				(SetFlag 487)
				(gEgo get: 25) ; invChristianJournal
			)
			(else
				(gMessager say: 6 62 0 1) ; "(CLICK ON SCHATTENJAGER BOOKS AFTER GETTING BOTH JOURNALS)I'm not sure what other casebooks would be relevant."
			)
		)
	)
)

(instance biographySection of Feature
	(properties
		approachX 600
		approachY 297
		x 602
		y 213
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 158 103 158 209 268 210 271 96
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(== gChapter 6)
					(gEgo has: 40) ; invLudwigBio
					(and (== gChapter 2) (not (IsFlag 466)))
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((== gChapter 6)
					(gMessager say: 16 62 0 1) ; "(SCHLOSS RITTER LIBRARY, CLICK ON BOOKS IN CH 6)I think the time for research has passed."
				)
				((gEgo has: 40) ; invLudwigBio
					(gMessager say: 24 62 0 1) ; "(LOOK AT BIOGRAPHY SECTION AFTER GETTING LUDWIG BIO)Nothing else I can use in the biography section."
				)
				((and (== gChapter 4) (IsFlag 458))
					(PlayScene 1419)
					(gEgo get: 40) ; invLudwigBio
					(gGame changeScore: 1036)
				)
				((IsFlag 466)
					(PlayScene 1570)
				)
				(else
					(gMessager say: 19 62 0 1) ; "(NOT VERY INTERESTED)Biographys. Looks like they're mostly about Germans."
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

