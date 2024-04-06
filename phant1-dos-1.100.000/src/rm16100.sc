;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	rm16100 0
)

(instance rm16100 of ScaryRoom
	(properties
		stepSound 7
	)

	(method (init)
		(self picture: (+ 16100 (== gChapter 5)))
		((ScriptID 30) init:) ; FidgetCode
		(gEgo init: setScaler: Scaler 121 43 133 85 normalize:)
		(largePainting init: setHotspot: 4 3) ; Do, Move
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(16200
				(switch global125
					(41
						(KillRobot)
						(gEgo show: posn: 38 116 normalize: 7)
						(gGame handsOn:)
					)
					(7
						(gEgo posn: 210 103 normalize: 1)
						(= global125 5)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(27
						(gEgo posn: 210 103 normalize: 1)
						(= global125 5)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(8
						(gEgo posn: 210 103 normalize: 3)
						(= global125 5)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(28
						(gEgo posn: 210 103 normalize: 3)
						(= global125 5)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(11
						(gEgo posn: 85 120 normalize: 7)
						(= global125 4)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(31
						(gEgo posn: 85 120 normalize: 7)
						(= global125 4)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(9
						(gEgo posn: 85 120 normalize: 7)
						(= global125 4)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(29
						(gEgo posn: 210 103 normalize: 3)
						(= global125 5)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(12
						(gEgo posn: 85 120 normalize: 7)
						(= global125 4)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(32
						(gEgo posn: 210 103 normalize: 6)
						(= global125 5)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(else
						(gEgo posn: 85 120 normalize: 7)
						(= global125 4)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
			)
			(else
				(gEgo posn: 85 120 normalize: 7)
				(= global125 4)
				(gGame handsOn:)
			)
		)
		(cond
			((== 4 global125)
				(southwestRExit init: 3 approachVerbs: 0)
				(southwestLExit init: 3 approachVerbs: 0)
				(southeastRExit init: 2 approachVerbs: 0)
				(southeastLExit init: 2 approachVerbs: 0)
			)
			((== global125 41)
				(southwestRExit init: 11 approachVerbs: 0)
				(southwestLExit init: 3 approachVerbs: 0)
				(southeastRExit init: 2 approachVerbs: 0)
				(southeastLExit init: 2 approachVerbs: 0)
				(= global125 1)
			)
			(else
				(southeastRExit init: 2 approachVerbs: 0)
				(southeastLExit init: 3 approachVerbs: 0)
			)
		)
		(vase init: setHotspot: 4 3) ; Do, Move
		(smallPaintings init: setHotspot: 4 3) ; Do, Move
		(if (and (>= gChapter 5) (IsFlag 195))
			(magicLamp init:)
			(if (== gChapter 5)
				(base init:)
			)
			(if (not (IsFlag 214))
				(magicLamp setHotspot: 4 3) ; Do, Move
			)
		else
			(lantern init: setHotspot: 4 3) ; Do, Move
		)
		(super init: &rest)
	)

	(method (dispose)
		(if (and (>= gChapter 5) (IsFlag 195))
			(RemapColors 0) ; Off
		)
		(super dispose: &rest)
	)
)

(instance sLookUrn of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 90 self)
						)
						(2
							(gEgo setHeading: 45 self)
						)
						(3
							(gEgo setHeading: 45 self 15)
						)
						(4
							(gEgo setHeading: 0 self)
						)
						(5
							(gEgo setHeading: 315 self)
						)
						(6
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(SetFlag 68)
					(largePainting hide:)
					(if (gCast contains: magicLamp)
						(magicLamp hide:)
						(if (== gChapter 5)
							(base hide:)
						)
					)
					(smallPaintings hide:)
					(global114 pause:)
					(DoRobot 1305 -4 -3)
					(gCurRoom drawPic: (+ 16140 (== gChapter 5)))
				)
				(2
					(global114 endPause:)
					(southwestRExit init: 3 approachVerbs: 0)
					(southwestLExit init: 3 approachVerbs: 0)
					(southeastRExit init: 2 approachVerbs: 0)
					(southeastLExit init: 2 approachVerbs: 0)
					(smallPaintings show:)
					(if (gCast contains: magicLamp)
						(magicLamp show:)
						(if (== gChapter 5)
							(base show:)
						)
					)
					(largePainting show:)
					(gEgo posn: 90 88 normalize: 0)
					(= global125 3)
					(gCurRoom drawPic: (+ 16100 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(global114 endPause: 1)
			(southwestRExit init: 3 approachVerbs: 0)
			(southwestLExit init: 3 approachVerbs: 0)
			(southeastRExit init: 2 approachVerbs: 0)
			(southeastLExit init: 2 approachVerbs: 0)
			(SetFlag 68)
			(largePainting show:)
			(smallPaintings show:)
			(if (gCast contains: magicLamp)
				(magicLamp show:)
				(if (== gChapter 5)
					(base show:)
				)
			)
			(gEgo posn: 90 88 normalize: 0)
			(= global125 3)
			(gCurRoom drawPic: (+ 16100 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sLookAtPainting of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(global114 pause:)
					(switch global125
						(1
							(self changeState: 1)
						)
						(2
							(gEgo setHeading: 225 self)
						)
						(3
							(gEgo setHeading: 180 self)
						)
						(4
							(gEgo setHeading: 315 self 15)
						)
						(5
							(gEgo setHeading: 315 self)
						)
						(6
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(smallPaintings
						view: (+ 16105 (== gChapter 5))
						posn: 200 126
						loop: 1
					)
					(if (gCast contains: magicLamp)
						(magicLamp hide:)
						(if (== gChapter 5)
							(base hide:)
						)
					)
					(largePainting
						view: (+ 16105 (== gChapter 5))
						posn: 62 18
						loop: 0
					)
					(DoRobot 1297 97 -10)
					(gCurRoom drawPic: (+ 16105 (== gChapter 5)))
				)
				(2
					(smallPaintings hide:)
					(if (gCast contains: magicLamp)
						(magicLamp
							show:
							view: (+ 16210 (== gChapter 5))
							posn: 79 76
							cel: 0
							loop: 0
						)
						(if (== gChapter 5)
							(base
								show:
								view: (+ 16210 (== gChapter 5))
								loop: 1
								posn: 78 76
								setPri: 200
							)
						)
						(if (and (IsFlag 214) (not (IsFlag 215)))
							(magicLamp setCycle: Osc)
							(dragon init:)
							(beam init:)
						)
					)
					(largePainting hide:)
					(cond
						((< gChapter 3)
							(DoRobot 1292 -1 -15)
						)
						((== gChapter 3)
							(DoRobot 1293 -9 -15)
						)
						((== gChapter 4)
							(DoRobot 1294 0 -15)
						)
						((== gChapter 5)
							(DoRobot 1295 -16 -17)
						)
						((== gChapter 6)
							(DoRobot 1295 -16 -17)
						)
						((== gChapter 7)
							(DoRobot 1296 -16 -17)
						)
					)
					(gCurRoom drawPic: (+ 16210 (== gChapter 5)))
				)
				(3
					(if (gCast contains: magicLamp)
						(magicLamp hide:)
						(if (== gChapter 5)
							(base hide:)
						)
						(if (and (IsFlag 214) (not (IsFlag 215)))
							(dragon hide:)
							(beam hide:)
						)
					)
					(gEgo hide:)
					(largePainting
						show:
						view: (+ 16110 (== gChapter 5))
						posn: 81 10
						loop: 1
					)
					(gCurRoom drawPic: (+ 16110 (== gChapter 5)))
					(cond
						((< gChapter 3)
							(sfx number: 16020 setLoop: 1 play: self)
						)
						((== gChapter 3)
							(sfx number: 16021 setLoop: 1 play: self)
						)
						((== gChapter 4)
							(sfx number: 16022 setLoop: 1 play: self)
						)
						((== gChapter 5)
							(sfx number: 16023 setLoop: 1 play: self)
						)
						((== gChapter 6)
							(sfx number: 16023 setLoop: 1 play: self)
						)
						((== gChapter 7)
							(sfx number: 16024 setLoop: 1 play: self)
						)
					)
				)
				(4
					(sfx dispose:)
					(if (gCast contains: magicLamp)
						(magicLamp show:)
						(if (== gChapter 5)
							(base show:)
						)
						(if (and (IsFlag 214) (not (IsFlag 215)))
							(dragon show:)
							(beam show:)
						)
					)
					(largePainting hide:)
					(cond
						((< gChapter 3)
							(DoRobot 12922 -1 -15)
						)
						((== gChapter 3)
							(DoRobot 12932 -9 -15)
						)
						((== gChapter 4)
							(DoRobot 12942 0 -15)
						)
						((== gChapter 5)
							(DoRobot 12952 -16 -17)
						)
						((== gChapter 6)
							(DoRobot 12952 -16 -17)
						)
						((== gChapter 7)
							(DoRobot 12962 -16 -17)
						)
					)
					(gCurRoom drawPic: (+ 16210 (== gChapter 5)))
				)
				(5
					(if (gCast contains: magicLamp)
						(magicLamp
							view: (+ 16100 (== gChapter 5))
							posn: 132 64
							cel: 0
							loop: 0
						)
						(if (== gChapter 5)
							(base
								view: (+ 16100 (== gChapter 5))
								posn: 132 64
								loop: 3
								setPri: -1
							)
						)
						(if (and (IsFlag 214) (not (IsFlag 215)))
							(magicLamp setCycle: Osc)
							(dragon dispose:)
							(beam dispose:)
						)
					)
					(largePainting
						show:
						view: (+ 16100 (== gChapter 5))
						posn: 4 63
						loop: 1
					)
					(smallPaintings
						view: (+ 16100 (== gChapter 5))
						posn: 64 90
						loop: 2
						show:
					)
					(if (gCast contains: magicLamp)
						(magicLamp show:)
						(if (== gChapter 5)
							(base show:)
						)
					)
					(southwestRExit init: 11 approachVerbs: 0)
					(global114 endPause:)
					(southwestLExit init: 3 approachVerbs: 0)
					(southeastRExit init: 2 approachVerbs: 0)
					(southeastLExit init: 2 approachVerbs: 0)
					(gEgo show: posn: 38 116 normalize: 7)
					(= global125 1)
					(gCurRoom drawPic: (+ 16100 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(global114 endPause: 1)
			(southwestRExit init: 11 approachVerbs: 0)
			(southwestLExit init: 3 approachVerbs: 0)
			(southeastRExit init: 2 approachVerbs: 0)
			(southeastLExit init: 2 approachVerbs: 0)
			(smallPaintings
				view: (+ 16100 (== gChapter 5))
				posn: 64 90
				loop: 2
				show:
			)
			(if (Sounds contains: sfx)
				(sfx dispose:)
			)
			(if (gCast contains: magicLamp)
				(magicLamp
					show:
					view: (+ 16100 (== gChapter 5))
					posn: 132 64
					cel: 0
					loop: 0
				)
				(if (== gChapter 5)
					(base
						show:
						view: (+ 16100 (== gChapter 5))
						posn: 132 64
						loop: 3
						setPri: -1
					)
				)
				(if (and (IsFlag 214) (not (IsFlag 215)))
					(magicLamp setCycle: Osc)
					(dragon dispose:)
					(beam dispose:)
				)
			)
			(if (gCast contains: magicLamp)
				(magicLamp show:)
				(if (== gChapter 5)
					(base show:)
				)
			)
			(largePainting
				show:
				view: (+ 16100 (== gChapter 5))
				posn: 4 63
				loop: 1
			)
			(gEgo show: posn: 38 116 normalize: 7)
			(= global125 1)
			(gCurRoom drawPic: (+ 16100 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sLookAtSmallPaintings of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 90 self 15)
						)
						(2
							(self changeState: 1)
						)
						(3
							(gEgo setHeading: 225 self 15)
						)
						(4
							(gEgo setHeading: 0 self 15)
						)
						(5
							(gEgo setHeading: 315 self)
						)
						(6
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(largePainting view: (+ 16130 (== gChapter 5)) posn: -1 11)
					(smallPaintings hide:)
					(if (gCast contains: magicLamp)
						(magicLamp hide:)
						(if (== gChapter 5)
							(base hide:)
						)
					)
					(DoRobot 1282 169 9)
					(gCurRoom drawPic: (+ 16130 (== gChapter 5)))
				)
				(2
					(gEgo hide:)
					(largePainting hide:)
					(closeup init:)
					(= seconds 5)
				)
				(3
					(largePainting show:)
					(closeup dispose:)
					(DoRobot 1283 176 8)
				)
				(4
					(largePainting
						view: (+ 16100 (== gChapter 5))
						posn: 4 63
						loop: 1
						show:
					)
					(smallPaintings show:)
					(if (gCast contains: magicLamp)
						(magicLamp show:)
						(if (== gChapter 5)
							(base show:)
						)
					)
					(southwestRExit init: 3 approachVerbs: 0)
					(southwestLExit init: 3 approachVerbs: 0)
					(southeastRExit init: 2 approachVerbs: 0)
					(southeastLExit init: 2 approachVerbs: 0)
					(gEgo show: posn: 79 100 normalize: 1)
					(= global125 2)
					(gCurRoom drawPic: (+ 16100 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(southwestRExit init: 3 approachVerbs: 0)
			(southwestLExit init: 3 approachVerbs: 0)
			(southeastRExit init: 2 approachVerbs: 0)
			(southeastLExit init: 2 approachVerbs: 0)
			(smallPaintings show:)
			(if (gCast contains: closeup)
				(closeup dispose:)
			)
			(if (gCast contains: magicLamp)
				(magicLamp show:)
				(if (== gChapter 5)
					(base show:)
				)
			)
			(largePainting
				view: (+ 16100 (== gChapter 5))
				posn: 4 63
				loop: 1
				show:
			)
			(gEgo show: posn: 79 100 normalize: 1)
			(= global125 2)
			(gCurRoom drawPic: (+ 16100 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sLookAtLamp of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(6
							(self changeState: 1)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(smallPaintings hide:)
					(largePainting hide:)
					(seeLantern init:)
					(RemapColors 2 236 40) ; ByPercent
					(RemapColors 2 237 35) ; ByPercent
					(RemapColors 2 238 30) ; ByPercent
					(RemapColors 2 239 25) ; ByPercent
					(RemapColors 2 240 20) ; ByPercent
					(RemapColors 2 241 15) ; ByPercent
					(RemapColors 2 242 10) ; ByPercent
					(gEgo hide:)
					(DoRobot 1311 27 25 gEgo 1 1)
					(gCurRoom drawPic: (+ 16120 (== gChapter 5)))
				)
				(2
					(RemapColors 0) ; Off
					(= global125 7)
					(gCurRoom newRoom: 16200)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(RemapColors 0) ; Off
			(= global125 7)
			(gCurRoom newRoom: 16200)
			(self dispose:)
		)
	)
)

(instance sExitDragon of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 90 self)
						)
						(2
							(gEgo setHeading: 135 self)
						)
						(3
							(gEgo setHeading: 135 self 15)
						)
						(4
							(gEgo setHeading: 90 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(= global125 108)
					(gCurRoom newRoom: 16200)
				)
			)
		else
			(= global115 0)
			(= global125 108)
			(gCurRoom newRoom: 16200)
		)
	)
)

(instance sExitSouthWestL of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 180 self)
				)
				(1
					(+= global125 20)
					(gCurRoom newRoom: 16200)
				)
			)
		else
			(= global115 0)
			(if (< global125 20)
				(+= global125 20)
			)
			(gCurRoom newRoom: 16200)
		)
	)
)

(instance sExitSouthWestR of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 135 self)
						)
						(else
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(+= global125 40)
					(gCurRoom newRoom: 16200)
				)
			)
		else
			(= global115 0)
			(if (< global125 40)
				(+= global125 40)
			)
			(gCurRoom newRoom: 16200)
		)
	)
)

(instance sExitSouthEastL of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(5
							(gEgo setHeading: 180 self)
						)
						(3
							(gEgo setHeading: 135 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(+= global125 60)
					(gCurRoom newRoom: 16200)
				)
			)
		else
			(= global115 0)
			(if (< global125 60)
				(+= global125 60)
			)
			(gCurRoom newRoom: 16200)
		)
	)
)

(instance sExitSouthEastR of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(3
							(gEgo setHeading: 135 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(+= global125 80)
					(gCurRoom newRoom: 16200)
				)
			)
		else
			(= global115 0)
			(if (< global125 80)
				(+= global125 80)
			)
			(gCurRoom newRoom: 16200)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance dragon of Prop
	(properties
		x 119
		y 61
		priority 11
		fixPriority 1
		loop 2
	)

	(method (init)
		(self view: (+ 16210 (== gChapter 5)))
		(super init: &rest)
		(self setCycle: Osc)
	)
)

(instance beam of Prop
	(properties
		x 81
		y 61
		priority 10
		fixPriority 1
		loop 3
	)

	(method (init)
		(self view: (+ 16210 (== gChapter 5)))
		(super init: &rest)
		(self setCycle: Osc)
	)
)

(instance magicLamp of Prop
	(properties
		x 132
		y 64
		priority 112
		fixPriority 1
	)

	(method (init)
		(self view: (+ 16100 (== gChapter 5)))
		(if (and (IsFlag 214) (not (IsFlag 215)) (== gChapter 5))
			(RemapColors 2 236 140) ; ByPercent
			(RemapColors 2 237 145) ; ByPercent
			(RemapColors 2 238 130) ; ByPercent
			(RemapColors 2 239 135) ; ByPercent
			(RemapColors 2 240 120) ; ByPercent
			(RemapColors 2 241 125) ; ByPercent
			(RemapColors 2 242 110) ; ByPercent
			(RemapColors 2 243 110) ; ByPercent
			(RemapColors 2 244 110) ; ByPercent
			(self setCycle: Osc)
		else
			(RemapColors 2 236 45) ; ByPercent
			(RemapColors 2 237 40) ; ByPercent
			(RemapColors 2 238 35) ; ByPercent
			(RemapColors 2 239 30) ; ByPercent
			(RemapColors 2 240 25) ; ByPercent
			(RemapColors 2 241 20) ; ByPercent
			(RemapColors 2 242 15) ; ByPercent
			(RemapColors 2 243 15) ; ByPercent
			(RemapColors 2 244 5) ; ByPercent
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sExitDragon)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance base of View
	(properties
		x 132
		y 64
		priority 111
		fixPriority 1
		loop 3
	)

	(method (init)
		(self view: (+ 16100 (== gChapter 5)))
		(super init: &rest)
	)

	(method (doVerb)
		(magicLamp doVerb: &rest)
	)
)

(instance largePainting of View
	(properties
		x 4
		y 63
		view 16100
		loop 1
	)

	(method (init)
		(switch gChapter
			(1
				(largePainting cel: 0)
			)
			(2
				(largePainting cel: 0)
			)
			(3
				(largePainting cel: 1)
			)
			(4
				(largePainting cel: 2)
			)
			(5
				(largePainting view: 16101 cel: 0 posn: 4 63)
			)
			(6
				(largePainting cel: 3)
			)
			(7
				(largePainting cel: 4)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sLookAtPainting)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance closeup of View
	(properties
		y 130
		view 1283
	)
)

(instance seeLantern of View
	(properties
		x 101
		y 120
		priority 200
		fixPriority 1
	)

	(method (init)
		(self view: (+ 16120 (== gChapter 5)))
		(super init: &rest)
	)
)

(instance smallPaintings of View
	(properties
		x 64
		y 90
		loop 2
	)

	(method (init)
		(self view: (+ 16100 (== gChapter 5)))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sLookAtSmallPaintings)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lantern of Feature
	(properties
		nsLeft 243
		nsTop 72
		nsRight 292
		nsBottom 91
		x 267
		y 81
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sLookAtLamp)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vase of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 93 84 95 78 104 78 108 83 106 86 96 87
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sLookUrn)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance southwestLExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 118
		nsRight 40
		nsBottom 129
		x 61
		y 123
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthWestL)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southwestRExit of ExitFeature
	(properties
		nsLeft 41
		nsTop 118
		nsRight 122
		nsBottom 129
		x 61
		y 123
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthWestR)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southeastRExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 224 100 269 96 292 101 292 129 224 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthEastR)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southeastLExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 129 185 106 224 100 224 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthEastL)
		else
			(super doVerb: theVerb)
		)
	)
)

