;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2242)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm2242 0
)

(local
	local0
)

(instance rm2242 of ExitRoom
	(properties
		modNum 220
		picture 2242
		south 2212 ; rm2212
	)

	(method (init)
		(cond
			((and (IsFlag 415) (not (IsFlag 425)) (not (gEgo has: 11))) ; invPawPrintCast
				(= picture 2247)
				(fCast init:)
			)
			((or (IsFlag 415) (> gChapter 1))
				(= picture 2248)
				(fHole init:)
			)
			(else
				(fPawPrint init:)
			)
		)
		(super init: &rest)
		(fMud init:)
		(gGame handsOn:)
	)

	(method (dispose)
		(cond
			(local0)
			((or (IsFlag 830) (> gChapter 1))
				(PlayScene 3020 0 2242) ; rm2242
			)
			((or (IsFlag 415) (> gChapter 1))
				(PlayScene 2020 0 2242) ; rm2242
			)
			((gEgo has: 73) ; invPitcher
				(PlayScene 1020 0 2242) ; rm2242
			)
			(else
				(PlayScene 2019 0 2242) ; rm2242
			)
		)
		(super dispose:)
	)
)

(instance fMud of GKFeature
	(properties
		noun 18
		modNum 220
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				616
				-1
				324
				-1
				324
				18
				408
				59
				425
				145
				408
				249
				312
				298
				226
				250
				192
				200
				198
				104
				254
				46
				323
				18
				323
				-1
				-1
				-1
				-1
				334
				616
				334
		)
	)
)

(instance fHole of GKFeature
	(properties
		noun 26
		modNum 220
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 178 128 257 65 372 76 432 154 380 230 336 247 236 235)
	)
)

(instance fPawPrint of GKFeature
	(properties
		modNum 220
		x 140
		y 180
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 178 128 257 65 372 76 432 154 380 230 336 247 236 235)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (or (IsFlag 414) (not (== gChapter 1)))
					(gMessager say: 8 62 0 1 0 220) ; "(LOOK AT PAW PRINT IN MUD CH 1)That paw print is as big as my hand!"
				else
					(PlayScene 1019)
					(SetFlag 414)
				)
			)
			(111 ; invPitcher
				(= local0 1)
				(SetFlag 415)
				(gEgo put: 73) ; invPitcher
				(gGame sel_849: 0)
				(PlayScene 21 0 2244) ; rm2244
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fCast of GKFeature
	(properties
		modNum 220
		x 140
		y 180
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 178 128 257 65 372 76 432 154 380 230 336 247 236 235)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(= local0 1)
			(gEgo get: 11) ; invPawPrintCast
			(SetFlag 435)
			(PlayScene 22 0 2212) ; rm2212
		else
			(super doVerb: theVerb)
		)
	)
)

