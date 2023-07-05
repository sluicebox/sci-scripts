;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use FidgetScript)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	labRm 0
)

(instance labRm of GK2Room
	(properties
		noun 3
		picture 3001
	)

	(method (init)
		(super init: &rest)
		(gEgo
			view: 22086
			loop: 0
			setScale: 0
			cel: 0
			posn: 309 168
			init:
			setScript: FidgetScript
		)
		(Lock rsAUDIO 300 1)
		(gGk2Music number: 300 setLoop: 1 play:)
		(fCabinets init:)
		(fMetalPan init:)
		(fSink init:)
		(fLabDoor init:)
		(pMichael init: setScript: (FidgetScript new:))
		(gCurRoom setScript: sEnterLab)
	)

	(method (newRoom newRoomNumber)
		(Lock rsAUDIO 300 0)
		(super newRoom: newRoomNumber)
	)
)

(instance sEnterLab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (and (== gChapter 1) (not (IsFlag 431)))
					(PlayScene 85 self)
					(SetFlag 431)
				else
					(PlayScene 1085 self)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pMichael of Prop
	(properties
		noun 2
		x 444
		y 205
		priority 231
		fixPriority 1
		view 21086
		signal 30753
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (and (IsFlag 423) (IsFlag 424))
					(gMessager say: 7) ; "(CLICK ON MICHAEL AFTER SHOWING HIM EVERYTHING)I don't know what else to show him."
				else
					(gMessager say: 2 62) ; "(BIO LAB. TRY TO TALK TO MICHAEL WITHOUT SHOWING EVIDENCE)I need to show him what I've got."
				)
			)
			(56 ; invFarmHair
				(if (not (IsFlag 423))
					(if (IsFlag 424)
						(PlayScene 90)
						(PlayScene 96)
						(PlayScene 91)
						(if (IsFlag 425)
							(PlayScene 92)
						)
					else
						(PlayScene 89)
						(PlayScene 95)
						(PlayScene 91)
						(if (IsFlag 425)
							(PlayScene 92)
						)
					)
					(gGame changeScore: 857)
					(SetFlag 423)
					(gEgo put: 10) ; invFarmHair
				else
					(super doVerb: theVerb)
				)
			)
			(57 ; invZooHair
				(if (not (IsFlag 424))
					(if (IsFlag 423)
						(PlayScene 90)
						(PlayScene 98)
					else
						(PlayScene 89)
						(PlayScene 97)
					)
					(gGame changeScore: 858)
					(SetFlag 424)
					(gEgo put: 12) ; invZooHair
				else
					(super doVerb: theVerb)
				)
			)
			(58 ; invPawPrintCast
				(if (not (IsFlag 425))
					(if (IsFlag 423)
						(PlayScene 99)
					else
						(PlayScene 1099)
					)
					(SetFlag 425)
					(gEgo put: 11) ; invPawPrintCast
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(gMessager say: 1) ; "(TRY TO SHOW MICHAEL SOMETHING OTHER THAN HAIR OR PRINT)I don't think I need Michael to analyze THAT."
			)
		)
	)
)

(instance fLabDoor of ExitFeature
	(properties
		exitDir 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 292 237 294 74 236 69 234 211)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (and (IsFlag 424) (IsFlag 423) (IsFlag 425))
					(SetFlag 426)
					(gEgo get: 16) ; invEvidenceReport
					(gCurRoom setScript: exitScript 0 87)
				else
					(gCurRoom setScript: exitScript 0 2085)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom picture: -1 drawPic: -1)
				(gCast eachElementDo: #dispose)
				(= cycles 2)
			)
			(1
				(PlayScene register self)
			)
			(2
				(gCurRoom newRoom: 200) ; MunichMapRm
			)
		)
	)
)

(instance fSink of Feature
	(properties
		noun 4
		modNum 300
	)

	(method (init)
		(self setPolygon: ((Polygon new:) type: PTotalAccess init: yourself:))
		(super init: &rest)
		(self
			createPoly:
				170
				254
				137
				231
				137
				166
				162
				166
				162
				221
				174
				221
				174
				165
				198
				165
				198
				220
				244
				241
		)
	)
)

(instance fMetalPan of Feature
	(properties
		noun 5
		modNum 300
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 273 279 343 275 342 302 275 309)
	)
)

(instance fCabinets of Feature
	(properties
		noun 6
		modNum 300
	)

	(method (init)
		(self setPolygon: ((Polygon new:) type: PTotalAccess init: yourself:))
		(super init: &rest)
		(self
			createPoly:
				321
				80
				341
				77
				547
				102
				545
				172
				416
				186
				404
				182
				401
				166
				390
				158
				386
				144
				367
				144
				366
				164
				369
				177
				381
				180
				380
				185
				367
				187
				365
				192
				350
				196
				350
				253
				321
				245
		)
	)
)

