;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm16200 0
)

(instance rm16200 of ScaryRoom
	(properties
		stepSound 7
	)

	(method (init &tmp temp0)
		(self picture: (+ 16200 (== gChapter 5)))
		(KillRobot)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo init: setScaler: Scaler 200 43 169 83 normalize:)
		(if (and (>= gChapter 5) (IsFlag 195))
			(magicLamp init:)
			(if (== gChapter 5)
				(base init:)
			)
			(cond
				((not (IsFlag 214))
					(magicLamp setHotspot: 4 3) ; Do, Move
					(glint init:)
				)
				((not (IsFlag 215))
					(dragon posn: 170 60 view: 16201 init:)
					(beam posn: 89 60 view: 16201 init:)
					(gGDacSound
						number: 16052
						init:
						setVol: 100
						setLoop: -1
						play:
					)
				)
			)
		else
			(lantern init: setHotspot: 4 3) ; Do, Move
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(16100
				(cond
					((== global125 7)
						(gEgo posn: 65 85 normalize: 3)
						(= global125 7)
						(gGame handsOn:)
					)
					((< global125 40)
						(gEgo posn: 157 112 normalize: 0)
						(= global125 11)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					((< global125 60)
						(switch global125
							(41
								(gEgo posn: 131 97 normalize: 6)
								(= global125 12)
								(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
							)
							(else
								(gEgo posn: 157 112 normalize: 0)
								(= global125 11)
								(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
							)
						)
					)
					((< global125 80)
						(switch global125
							(64
								(gEgo posn: 65 85 normalize: 7)
								(= global125 7)
								(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
							)
							(65
								(gEgo posn: 171 89 normalize: 0)
								(= global125 9)
								(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
							)
							(else
								(gEgo posn: 65 85 normalize: 6)
								(= global125 7)
								(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
							)
						)
					)
					((< global125 100)
						(switch global125
							(84
								(gEgo posn: 65 85 normalize: 7)
								(= global125 7)
								(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
							)
							(else
								(gEgo posn: 65 85 normalize: 6)
								(= global125 7)
								(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
							)
						)
					)
					(else
						(= picture 16129)
						(gCurRoom setScript: sDoMagicLamp)
					)
				)
			)
			(38200
				(magicLamp hide:)
				(if (== gChapter 5)
					(base hide:)
				)
				(= picture (+ 16240 (== gChapter 5)))
				(gCurRoom setScript: sEnterFromPassage)
			)
			(else
				(gEgo posn: 237 94 normalize: 1)
				(= global125 10)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(lgPainting init: setHotspot: 4 3) ; Do, Move
		(door init: 2 approachVerbs: 0)
		(northwestExit init: 4 approachVerbs: 0)
		(southwestExit init: 4 approachVerbs: 0)
		(if (IsFlag 214)
			(passage init: setHotspot: 4 3) ; Do, Move
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

(instance sEnterFromPassage of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(secretPanel
						posn: 102 62
						view: (+ 16240 (== gChapter 5))
						init:
					)
					(if (== gChapter 5)
						(DoRobot 5053 73 50)
					else
						(DoRobot 5052 -2 0)
					)
				)
				(1
					(secretPanel dispose:)
				)
				(2
					(magicLamp show:)
					(if (== gChapter 5)
						(base show:)
					)
					(gEgo posn: 171 89 normalize: 5)
					(= global125 9)
					(gCurRoom drawPic: (+ 16200 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(magicLamp show:)
			(if (== gChapter 5)
				(base show:)
			)
			(if (gCast contains: secretPanel)
				(secretPanel dispose:)
			)
			(gEgo posn: 171 89 normalize: 5)
			(= global125 9)
			(gCurRoom drawPic: (+ 16200 (== gChapter 5)))
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
						(7
							(self changeState: 1)
						)
						(8
							(gEgo setHeading: 315 self)
						)
						(11
							(gEgo setHeading: 0 self)
						)
						(12
							(gEgo setHeading: 315 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(seeLantern init:)
					(RemapColors 2 236 40) ; ByPercent
					(RemapColors 2 237 35) ; ByPercent
					(RemapColors 2 238 30) ; ByPercent
					(RemapColors 2 239 25) ; ByPercent
					(RemapColors 2 240 20) ; ByPercent
					(RemapColors 2 241 15) ; ByPercent
					(RemapColors 2 242 10) ; ByPercent
					(DoRobot 1311 27 25 gEgo 1)
					(gCurRoom drawPic: (+ 16120 (== gChapter 5)))
				)
				(2
					(KillRobot)
					(RemapColors 0) ; Off
					(seeLantern dispose:)
					(gEgo posn: 65 85 normalize: 7)
					(= global125 7)
					(gCurRoom drawPic: (+ 16200 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(RemapColors 0) ; Off
			(if (gCast contains: seeLantern)
				(seeLantern dispose:)
			)
			(gEgo posn: 65 85 normalize: 7)
			(= global125 7)
			(gCurRoom drawPic: (+ 16200 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sDoMagicLamp of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(108
							(self changeState: 1)
						)
						(7
							(gEgo setHeading: 90 self)
						)
						(11
							(gEgo setHeading: 315 self)
						)
						(12
							(gEgo setHeading: 315 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(if (gCast contains: glint)
						(glint dispose:)
					)
					(SetFlag 214)
					(magicLamp
						view: 16129
						posn: 206 108
						setHotspot: 0
						setPri: 200
					)
					(base hide:)
					(DoRobot 5040 45 0 gEgo 0)
					(if (not (== global125 108))
						(gCurRoom drawPic: 16129)
					)
				)
				(2
					(gEgo hide:)
					(magicLamp hide:)
					(gCurRoom drawPic: 16231)
					(= seconds 5)
				)
				(3
					(gEgo show:)
					(magicLamp show:)
					(DoRobot 5041 -7 -30)
					(gCurRoom drawPic: 16129)
				)
				(4
					(RemapColors 2 236 165) ; ByPercent
					(RemapColors 2 237 160) ; ByPercent
					(RemapColors 2 238 155) ; ByPercent
					(RemapColors 2 239 140) ; ByPercent
					(RemapColors 2 240 135) ; ByPercent
					(RemapColors 2 241 130) ; ByPercent
					(RemapColors 2 242 125) ; ByPercent
					(RemapColors 2 243 120) ; ByPercent
					(RemapColors 2 244 100) ; ByPercent
					(dragon init:)
					(beam init:)
					(magicLamp
						view: 16251
						loop: 0
						posn: 125 71
						setCycle: Osc
						setPri: 200
					)
					(base show: view: 16251 loop: 1 posn: 125 71 setPri: 180)
					(gGDacSound
						number: 16052
						init:
						setVol: 100
						setLoop: -1
						play:
					)
					(gCurRoom drawPic: 16251)
					(DoRobot 5042 -66 -36)
				)
				(5
					(passage init: setHotspot: 4 3) ; Do, Move
					(dragon posn: 170 60 view: 16201 setPri: 95)
					(beam posn: 89 60 view: 16201 setPri: 94)
					(magicLamp posn: 80 60 view: 16201 setCycle: Osc setPri: 95)
					(base posn: 80 60 view: 16201 setPri: 94)
					(gEgo show: posn: 83 93 normalize: 4)
					(= global125 8)
					(gCurRoom drawPic: 16201)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(SetFlag 214)
			(gGDacSound number: 16052 init: setVol: 100 setLoop: -1 play:)
			(if (gCast contains: glint)
				(glint dispose:)
			)
			(if (not (gCast contains: passage))
				(passage init: setHotspot: 4 3) ; Do, Move
			)
			(if (not (gCast contains: dragon))
				(RemapColors 2 236 165) ; ByPercent
				(RemapColors 2 237 160) ; ByPercent
				(RemapColors 2 238 155) ; ByPercent
				(RemapColors 2 239 140) ; ByPercent
				(RemapColors 2 240 135) ; ByPercent
				(RemapColors 2 241 130) ; ByPercent
				(RemapColors 2 242 125) ; ByPercent
				(RemapColors 2 243 120) ; ByPercent
				(RemapColors 2 244 100) ; ByPercent
				(dragon init:)
				(beam init:)
			)
			(dragon posn: 170 60 view: 16201 setPri: 95)
			(beam posn: 89 60 view: 16201 setPri: 94)
			(magicLamp posn: 80 60 view: 16201 setCycle: Osc setPri: 95)
			(base posn: 80 60 view: 16201 setPri: 94)
			(gEgo show: posn: 83 93 normalize: 4)
			(= global125 8)
			(gCurRoom drawPic: 16201)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sPassageReveal of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(7
							(gEgo setHeading: 135 self)
						)
						(8
							(gEgo setHeading: 90 self)
						)
						(10
							(gEgo setHeading: 270 self)
						)
						(11
							(gEgo setHeading: 45 self)
						)
						(12
							(gEgo setHeading: 45 self)
						)
					)
				)
				(1
					(Load rsVIEW 16240)
					(dragon posn: 70 50 view: 16241 loop: 1 setPri: 200)
					(magicLamp hide:)
					(base hide:)
					(beam dispose:)
					(SetFlag 215)
					(gEgo hide:)
					(DoRobot 5051 40 34 gEgo -1 1)
					(gCurRoom drawPic: 16241)
				)
				(2
					(secretPanel
						posn: 102 62
						view: (+ 16240 (== gChapter 5))
						loop: 0
						init:
					)
					(gGDacSound fade:)
					(RemapColors 2 236 135) ; ByPercent
					(RemapColors 2 237 130) ; ByPercent
					(RemapColors 2 238 125) ; ByPercent
					(RemapColors 2 239 120) ; ByPercent
					(RemapColors 2 240 115) ; ByPercent
					(RemapColors 2 241 110) ; ByPercent
					(RemapColors 2 242 105) ; ByPercent
					(RemapColors 2 243 100) ; ByPercent
					(RemapColors 2 244 100) ; ByPercent
					(= cycles 2)
				)
				(3
					(RemapColors 2 236 130) ; ByPercent
					(RemapColors 2 237 125) ; ByPercent
					(RemapColors 2 238 120) ; ByPercent
					(RemapColors 2 239 115) ; ByPercent
					(RemapColors 2 240 110) ; ByPercent
					(RemapColors 2 241 105) ; ByPercent
					(RemapColors 2 242 100) ; ByPercent
					(= cycles 2)
				)
				(4
					(RemapColors 2 236 125) ; ByPercent
					(RemapColors 2 237 120) ; ByPercent
					(RemapColors 2 238 115) ; ByPercent
					(RemapColors 2 239 110) ; ByPercent
					(RemapColors 2 240 105) ; ByPercent
					(RemapColors 2 241 100) ; ByPercent
					(= cycles 2)
				)
				(5
					(RemapColors 2 236 120) ; ByPercent
					(RemapColors 2 237 115) ; ByPercent
					(RemapColors 2 238 110) ; ByPercent
					(RemapColors 2 239 105) ; ByPercent
					(RemapColors 2 240 100) ; ByPercent
					(= cycles 2)
				)
				(6
					(RemapColors 2 236 115) ; ByPercent
					(RemapColors 2 237 110) ; ByPercent
					(RemapColors 2 238 105) ; ByPercent
					(RemapColors 2 239 100) ; ByPercent
					(= cycles 2)
				)
				(7
					(RemapColors 2 236 110) ; ByPercent
					(RemapColors 2 237 105) ; ByPercent
					(RemapColors 2 238 100) ; ByPercent
					(= cycles 2)
				)
				(8
					(RemapColors 2 236 110) ; ByPercent
					(RemapColors 2 237 100) ; ByPercent
					(= cycles 2)
				)
				(9
					(RemapColors 2 236 100) ; ByPercent
				)
				(10
					(secretPanel hide:)
					(= global125 0)
					(gCurRoom newRoom: 38200)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(gGDacSound stop:)
			(SetFlag 215)
			(= global125 0)
			(gCurRoom newRoom: 38200)
			(self dispose:)
		)
	)
)

(instance sPassageOpen of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load rsVIEW (+ 16240 (== gChapter 5)))
					(switch global125
						(7
							(gEgo setHeading: 135 self)
						)
						(8
							(gEgo setHeading: 90 self)
						)
						(9
							(gEgo setHeading: 45 self 15)
						)
						(10
							(gEgo setHeading: 270 self)
						)
						(11
							(gEgo setHeading: 45 self)
						)
						(12
							(gEgo setHeading: 45 self)
						)
					)
				)
				(1
					(magicLamp dispose:)
					(if (== gChapter 5)
						(base dispose:)
					)
					(gEgo hide:)
					(if (== gChapter 5)
						(DoRobot 5061 47 50 gEgo -1 1)
					else
						(DoRobot 5060 1 0 gEgo -1 1)
					)
					(gCurRoom drawPic: (+ 16240 (== gChapter 5)))
				)
				(2
					(secretPanel
						posn: 104 62
						view: (+ 16240 (== gChapter 5))
						init:
					)
				)
				(3
					(secretPanel hide:)
					(= global125 0)
					(gCurRoom newRoom: 38200)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(= global125 0)
			(gCurRoom newRoom: 38200)
			(self dispose:)
		)
	)
)

(instance sExitDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(7
							(gEgo setHeading: 135 self)
						)
						(9
							(gEgo setHeading: 135 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(gGDacSound stop:)
					(= global125 0)
					(gCurRoom newRoom: 15300)
					(self dispose:)
				)
			)
		else
			(gGDacSound stop:)
			(= global125 0)
			(gCurRoom newRoom: 15300)
			(self dispose:)
		)
	)
)

(instance sExitNorthWest of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(7
							(gEgo setHeading: 225 self)
						)
						(11
							(gEgo setHeading: 315 self)
						)
						(12
							(gEgo setHeading: 315 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(+= global125 20)
					(gCurRoom newRoom: 16100)
					(self dispose:)
				)
			)
		else
			(if (< global125 20)
				(+= global125 20)
			)
			(gCurRoom newRoom: 16100)
			(self dispose:)
		)
	)
)

(instance sExitSouthWest of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(7
							(gEgo setHeading: 225 self)
						)
						(9
							(gEgo setHeading: 225 self)
						)
						(12
							(gEgo setHeading: 225 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(gCurRoom newRoom: 16100)
					(self dispose:)
				)
			)
		else
			(gCurRoom newRoom: 16100)
			(self dispose:)
		)
	)
)

(instance sExitPainting of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(global114 pause:)
					(switch global125
						(7
							(gEgo setHeading: 225 self)
						)
						(9
							(gEgo setHeading: 225 self)
						)
						(10
							(gEgo setHeading: 225 self)
						)
						(12
							(gEgo setHeading: 225 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(if (gCast contains: glint)
						(glint dispose:)
					)
					(if (gCast contains: lantern)
						(lantern dispose:)
					)
					(smallPaintings
						view: (+ 16105 (== gChapter 5))
						posn: 200 126
						loop: 1
						init:
					)
					(if (gCast contains: magicLamp)
						(magicLamp hide:)
						(if (== gChapter 5)
							(base hide:)
						)
					)
					(if (gCast contains: dragon)
						(dragon hide:)
						(beam hide:)
					)
					(largePainting
						view: (+ 16105 (== gChapter 5))
						posn: 62 18
						loop: 0
						init:
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
								posn: 78 76
								setPri: 200
							)
						)
						(if (and (IsFlag 214) (not (IsFlag 215)))
							(magicLamp setCycle: Osc)
							(dragon
								posn: 119 61
								loop: 2
								setPri: 11
								view: 16211
								setCycle: Osc
								show:
							)
							(beam
								posn: 81 61
								loop: 3
								setPri: 10
								view: 16211
								setCycle: Osc
								show:
							)
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
							(DoRobot 12922 -1 -15 gEgo -1 1)
						)
						((== gChapter 3)
							(DoRobot 12932 -9 -15 gEgo -1 1)
						)
						((== gChapter 4)
							(DoRobot 12942 0 -15 gEgo -1 1)
						)
						((== gChapter 5)
							(DoRobot 12952 -16 -17 gEgo -1 1)
						)
						((== gChapter 6)
							(DoRobot 12952 -16 -17 gEgo -1 1)
						)
						((== gChapter 7)
							(DoRobot 12962 -16 -17 gEgo -1 1)
						)
					)
					(gCurRoom drawPic: (+ 16210 (== gChapter 5)))
				)
				(5
					(global114 endPause:)
					(= global125 41)
					(gCurRoom newRoom: 16100)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(global114 endPause: 1)
			(= global125 41)
			(gCurRoom newRoom: 16100)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance sGlint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGDacSound number: 16051 init: setVol: 127 setLoop: 1 play:)
				(= ticks 2)
			)
			(2
				(glint cycleSpeed: 8 cel: 0 setCycle: End self)
			)
			(3
				(= seconds 5)
			)
			(4
				(self changeState: 2)
			)
		)
	)
)

(instance glint of Prop
	(properties
		x 80
		y 60
		priority 96
		fixPriority 1
		view 16201
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self setScript: sGlint)
	)

	(method (dispose)
		((self script:) dispose:)
		(super dispose: &rest)
	)
)

(instance magicLamp of Prop
	(properties
		x 80
		y 60
		priority 95
		fixPriority 1
	)

	(method (init)
		(self view: (+ 16200 (== gChapter 5)))
		(if (and (IsFlag 214) (not (IsFlag 215)) (== gChapter 5))
			(RemapColors 2 236 165) ; ByPercent
			(RemapColors 2 237 160) ; ByPercent
			(RemapColors 2 238 155) ; ByPercent
			(RemapColors 2 239 140) ; ByPercent
			(RemapColors 2 240 135) ; ByPercent
			(RemapColors 2 241 130) ; ByPercent
			(RemapColors 2 242 125) ; ByPercent
			(RemapColors 2 243 120) ; ByPercent
			(RemapColors 2 244 100) ; ByPercent
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
			(if (not (IsFlag 214))
				(gGame handsOff:)
				(gCurRoom setScript: sDoMagicLamp)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dragon of Prop
	(properties
		x 178
		y 57
		priority 95
		fixPriority 1
		view 16251
		loop 2
	)

	(method (init)
		(self setCycle: Osc)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(passage doVerb: theVerb)
	)
)

(instance beam of Prop
	(properties
		x 154
		y 57
		priority 94
		fixPriority 1
		view 16251
		loop 3
	)

	(method (init)
		(self setCycle: Osc)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(passage doVerb: theVerb)
	)
)

(instance secretPanel of View
	(properties
		x 102
		y 62
		view 16240
	)
)

(instance base of View
	(properties
		x 80
		y 60
		loop 1
	)

	(method (init)
		(self view: (+ 16200 (== gChapter 5)))
		(super init:)
	)

	(method (doVerb)
		(magicLamp doVerb: &rest)
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
	(properties)
)

(instance largePainting of View
	(properties
		x 62
		y 18
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
				(largePainting cel: 0)
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
)

(instance lgPainting of Feature
	(properties
		nsLeft -1
		nsTop 42
		nsRight 21
		nsBottom 128
		x 10
		y 85
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sExitPainting)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance passage of Feature
	(properties
		nsLeft 163
		nsTop 53
		nsRight 191
		nsBottom 84
		x 177
		y 68
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 215)
					(gGame handsOff:)
					(gCurRoom setScript: sPassageOpen)
				else
					(gGame handsOff:)
					(gCurRoom setScript: sPassageReveal)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lantern of View
	(properties
		x 61
		y 73
	)

	(method (init)
		(self view: (+ 16202 (== gChapter 5)))
		(super init:)
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

(instance door of ExitFeature
	(properties
		nsLeft 231
		nsTop 51
		nsRight 295
		nsBottom 89
		x 241
		y 70
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitDoor)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northwestExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 24 81 64 81 68 97 22 101
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitNorthWest)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southwestExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 23 101 67 97 75 130 22 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthWest)
		else
			(super doVerb: theVerb)
		)
	)
)

