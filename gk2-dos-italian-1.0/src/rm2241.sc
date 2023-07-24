;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2241)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm2241 0
)

(instance rm2241 of ExitRoom
	(properties
		modNum 220
		picture 2246
		south 2211 ; rm2211
	)

	(method (init)
		(if
			(or
				(== gChapter 5)
				(and
					(not (gEgo has: 10)) ; invFarmHair
					(not (IsFlag 423))
					(not (== gChapter 3))
				)
			)
			(fHair init:)
			(if (< gChapter 5)
				(= picture 2245)
			else
				(= picture 2249)
			)
		)
		(fFlattenedEarth init:)
		(super init: &rest)
		(gGame handsOn: 0)
	)

	(method (dispose)
		(PlayScene 1017 0 2211) ; rm2211
		(super dispose:)
	)
)

(instance fFlattenedEarth of GKFeature
	(properties
		modNum 220
	)

	(method (init)
		(super init:)
		(self createPoly: 1 -1 615 0 614 300 0 300)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(switch gChapter
				(1
					(gMessager say: 3 62 0 1 0 220) ; "(LOOKING CLOSER AT SPY AREA CH 1)Something's been here. Maybe the thing that killed Huber's daughter."
				)
				(3
					(gMessager say: 3 62 0 1 0 220) ; "(LOOKING CLOSER AT SPY AREA CH 1)Something's been here. Maybe the thing that killed Huber's daughter."
				)
				(5
					(gMessager say: 11 62 0 1 0 220) ; "(HUBER FARM EXT, LOOK AT SPY AREA AFTER WOLF MOVIE CH 3)Something's been here again."
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fHair of GKFeature
	(properties
		modNum 220
		x 40
		y 48
	)

	(method (init)
		(super init: &rest)
		(if (< gChapter 5)
			(self
				createPoly: 236 267 257 179 199 138 291 107 276 149 295 189 356 175 403 212
			)
		else
			(self
				createPoly: 78 157 78 157 119 111 167 115 197 131 225 126 245 127 287 109 277 142 234 168 228 190 200 207 161 189 137 174 110 171 91 189
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(switch gChapter
				(1
					(PlayScene 18)
					(gEgo get: 10) ; invFarmHair
					(gCurRoom drawPic: 2246 picture: 2246)
					(SetFlag 435)
					(self dispose:)
				)
				(3
					(if (IsFlag 416)
						(gMessager say: 13 62 0 1 0 220) ; "(TRY TO PICK UP NEW HAIR AFTER CH 3 WOLF MOVIE)I don't think there's any point testing this stuff -- it looks the same as the other hair to me."
					else
						(gMessager say: 12 62 0 1 0 220) ; "(FIND NEW HAIR IN SPY AREA AFTER CH 3 WOLF MOVIE)That's odd. I thought I picked up everthing a few days ago."
						(SetFlag 416)
					)
				)
				(5
					(if (IsFlag 416)
						(gMessager say: 13 62 0 1 0 220) ; "(TRY TO PICK UP NEW HAIR AFTER CH 3 WOLF MOVIE)I don't think there's any point testing this stuff -- it looks the same as the other hair to me."
					else
						(gMessager say: 12 62 0 1 0 220) ; "(FIND NEW HAIR IN SPY AREA AFTER CH 3 WOLF MOVIE)That's odd. I thought I picked up everthing a few days ago."
						(SetFlag 416)
					)
					(gGame changeScore: 1059)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

