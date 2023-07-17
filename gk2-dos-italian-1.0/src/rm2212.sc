;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2212)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Motion)

(public
	rm2212 0
)

(local
	local0 = 2212
)

(instance rm2212 of ExitRoom
	(properties
		modNum 220
		picture 2212
	)

	(method (cue)
		(gCurRoom newRoom: local0)
	)

	(method (init)
		(if (gEgo has: 73) ; invPitcher
			(Palette 1 (= global249 207)) ; PalLoad
		else
			(Palette 1 (= global249 206)) ; PalLoad
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(2242
				(gEgo posn: 50 315 heading: 225)
			)
			(else
				(gEgo posn: 45 315 sel_737: 45)
			)
		)
		(gEgo sel_737: setScale: 0 init:)
		(if (not (gEgo has: 73)) ; invPitcher
			(fTreeLine init:)
		)
		(fPawPrint init:)
		(fLog init:)
		(westExit init:)
		(gGame handsOn:)
	)
)

(instance westExit of ExitFeature
	(properties
		x 63536
		y 250
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: -1 -1 67 0 69 221 79 292 178 313 178 333 -1 333)
	)

	(method (doVerb)
		(gCurRoom newRoom: 2202)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (gEgo has: 73)) ; invPitcher
			(gGame handsOff:)
			(= global141 self)
			(= local0 2202)
			(if (== gPrevRoomNum 2242)
				(gEgo view: 473 cel: 0 loop: 0 setCycle: End gCurRoom)
			else
				(super handleEvent: event &rest)
			)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance fLog of GKFeature
	(properties
		modNum 220
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				195
				178
				334
				182
				344
				192
				503
				192
				524
				182
				588
				193
				583
				269
				360
				265
				326
				245
				191
				249
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 16 62 0 1 0 220) ; "(LOOK AT TROUGH)It's a water trough. Grounds a bit muddy over here."
			)
			(111 ; invPitcher
				(gMessager say: 25 62 0 1 0 220) ; "(PICKUP, TRY TO CLICK ON CAR OR OTHER ITEMS WHILE CARRYING CEMENT PAIL)I don't want to use cement on THAT."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fPawPrint of GKFeature
	(properties
		modNum 220
		sightAngle 360
		x 100
		y 300
		BAD_SELECTOR 2242
	)

	(method (init)
		(super init:)
		(self
			createPoly:
				196
				276
				174
				278
				116
				278
				108
				285
				152
				295
				192
				295
				214
				292
				218
				288
				218
				280
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((or (IsFlag 830) (> gChapter 1))
						(PlayScene 4020 0 2242) ; rm2242
					)
					((IsFlag 415)
						(PlayScene 1022 0 2242) ; rm2242
					)
					(else
						(SetFlag 413)
						(PlayScene 19 0 2242) ; rm2242
					)
				)
			)
			(111 ; invPitcher
				(PlayScene 20 0 2242) ; rm2242
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fTreeLine of ExitFeature
	(properties
		x 310
		y 111
		BAD_SELECTOR 2211
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 69 -1 619 0 616 204 599 201 578 176 528 160 470 184 454 141 385 143 377 182 315 174 272 151 190 162 158 221 70 220
					yourself:
				)
		)
		(super init: &rest)
	)
)

