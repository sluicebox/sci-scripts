;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1250)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1250 0
	cryInBowl 1
)

(local
	[local0 2]
	local2
	local3 = 1
	local4
	local5
	local6 = 63
)

(instance rm1250 of KQRoom
	(properties
		picture 1251
		screen_mid 1300
		screen_right 1350
	)

	(method (init)
		(super init:)
		(= eastSide 890)
		(SetFlag 21)
		(if (and (not (gEgo has: 3)) (not (gEgo has: 4)) (<= gChapter 3)) ; Stick, Flag
			(= local4
				((Polygon new:)
					type: PBarredAccess
					init: 237 86 260 86 261 91 237 91
					yourself:
				)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 181 75 183 83 137 80 131 85 153 83 163 92 131 99 125 105 92 116 4 102 4 121 140 133 141 137 148 153 678 145 686 127 799 127 810 142 952 144 952 105 898 114 886 93 923 69 886 90 876 82 851 86 825 82 822 94 748 91 738 78 753 70 761 62 737 63 728 83 745 99 742 109 715 111 618 102 590 104 572 95 561 62 311 65 317 80 302 84 275 84 196 77 183 73
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 209 90 271 98 300 113 273 130 237 127 162 125 138 118 130 113 129 104 148 96
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 384 123 322 125 323 110 343 100 378 100 394 113
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 379 97 320 98 310 84 359 78
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 526 95 495 98 457 98 436 98 414 89 373 89 365 82 400 70 502 82
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 530 107 622 112 648 118 578 134 480 123 484 118
					yourself:
				)
		)
		((ScriptID 19 1) code: myExitCode) ; westFeat
		(Load rsMESSAGE 1250)
		(collar init:)
		(bowl init:)
		(saltCrystal1 init:)
		(saltCrystal2 init:)
		(saltCrystal3 init:)
		(godFace init:)
		(if (IsFlag 344)
			(theKernel init:)
		)
		(if (not (IsFlag 37))
			(wellWater init:)
		)
		(if
			(and
				(== gChapter 1)
				(!= gPrevRoomNum 26)
				(!= gPrevRoomNum 35) ; chapEndRm
				(not (gEgo has: 1)) ; Ripped_Petticoat
				(not (gEgo has: 4)) ; Flag
				(!= ((gInventory at: 1) owner:) 1450) ; Ripped_Petticoat
			)
			(peticoat init:)
		)
		(if (IsFlag 27)
			(godHand init:)
		)
		(if (and (not (gEgo has: 3)) (not (gEgo has: 4)) (<= gChapter 3)) ; Stick, Flag
			(stick init:)
		)
		(if
			(and
				(== gChapter 1)
				(IsFlag 34)
				(not (IsFlag 6))
				(not (gEgo has: 9)) ; Glasses
			)
			(glasses init:)
		)
		(if
			(and
				(== ((gInventory at: 10) owner:) 1250) ; Jackalope_Fur
				(IsFlag 34)
				(not (gEgo has: 10)) ; Jackalope_Fur
				(not (IsFlag 218))
			)
			(jackFur init:)
		)
		(bunnyTrail init:)
		(if (!= gChapter 4)
			(pictograms init:)
			(wristBand init:)
		)
		(if (and (== gChapter 1) (not (IsFlag 34)))
			(leftCactus init:)
			(rightCactus init:)
		)
		(if (and (== gValOrRoz -4) (not (IsFlag 27))) ; Val
			(hand init:)
		)
		(if (not (IsFlag 323))
			(waterGod init:)
		)
		(pyramidDoor init:)
		(midScreenNorth init:)
		(leftScreenNorth init:)
		(rightScreenNorth init:)
		(eSouth init:)
		(eWest init:)
		(eEast init:)
		(if (and (== gValOrRoz -4) (IsFlag 37)) ; Val
			(wellExit init:)
		)
		(if (and (!= gPrevRoomNum 26) (!= gPrevRoomNum 35)) ; chapEndRm
			(gEgo init: normalize: setScaler: Scaler 100 24 100 59)
			(if (and (== gValOrRoz -4) (not global116) (not (gEgo has: 0))) ; Val, Golden_Comb
				(gEgo get: 0) ; Golden_Comb
			)
		)
		(switch gPrevRoomNum
			(1100
				(cond
					((< (gEgo x:) 320)
						(self setRect: 0 0 959 136)
						(gEgo posn: 181 75)
						(self setScript: fromTopScroller)
					)
					((< (gEgo x:) 640)
						(self setRect: -318 0 640 136)
						(gEgo posn: 520 61)
						(self setScript: fromTopScroller)
					)
					(else
						(self setRect: 64897 0 319 136)
						(gEgo posn: 749 63)
						(self setScript: fromTopScroller)
					)
				)
			)
			(1400
				(self setRect: 0 0 959 136)
				(gEgo
					view: 8164
					posn: (well approachX:) (well approachY:)
					setLoop: 1
					setCel: 4
				)
				(self setScript: lookAwayFromWell)
			)
			(35 ; chapEndRm
				(self setRect: -318 0 640 136)
				(gEgo posn: 470 130)
				(if
					(and
						(== gValOrRoz -4) ; Val
						(not global116)
						(not (gEgo has: 0)) ; Golden_Comb
					)
					(gEgo get: 0) ; Golden_Comb
				)
				(self setScript: openingCartoon)
			)
			(26
				(self setRect: -318 0 640 136)
				(if
					(and
						(== gValOrRoz -4) ; Val
						(not global116)
						(not (gEgo has: 0)) ; Golden_Comb
					)
					(gEgo get: 0) ; Golden_Comb
				)
				(gEgo posn: 470 130)
				(if (== gChapter 1)
					(self setScript: openingCartoon)
				else
					(gEgo init: setScaler: Scaler 100 24 100 59 normalize:)
					(gGame handsOn:)
				)
			)
			(1450
				(self setRect: 64897 0 319 136)
				(gEgo posn: 904 80)
				(gCurRoom setScript: fromPyramid)
			)
			(1500
				(cond
					((and (== global312 1) (== global313 1))
						(self setRect: 0 0 959 136)
						(if (== global314 1)
							(gEgo posn: 180 138)
						else
							(gEgo posn: 1 120)
						)
						(gCurRoom setScript: walkFromDesert)
					)
					((and (== global312 1) (== global313 2))
						(self setRect: -318 0 640 136)
						(gEgo posn: 470 138)
						(gCurRoom setScript: walkFromDesert)
					)
					((and (== global312 1) (== global313 3))
						(self setRect: 64897 0 319 136)
						(if (== global314 1)
							(gEgo posn: 900 138)
						else
							(gEgo posn: 959 120)
						)
						(gCurRoom setScript: walkFromDesert)
					)
					(else
						(ClearFlag 5)
						(self setRect: -318 0 640 136)
						(gEgo
							init:
							posn: 470 138
							setScaler: Scaler 100 24 100 59
							normalize: 2
						)
						(gGame handsOn:)
					)
				)
			)
			(1260
				(self setRect: 0 0 959 136)
				(gEgo posn: 118 118)
				(gGame handsOn:)
			)
			(1255
				(gEgo
					posn: 57 109
					view: 12515
					setCycle: 0
					setLoop: 3
					setCel: 12
				)
				(self setRect: 0 0 959 136 setScript: backFromCollar)
			)
			(else
				(self setRect: -318 0 640 136)
				(gEgo posn: 470 130)
				(gGame handsOn:)
			)
		)
		(cond
			((or (and (== gPrevRoomNum 26) script) (== gPrevRoomNum 35)) ; chapEndRm
				(gKqMusic1
					number: 1300
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
			)
			((or (== gPrevRoomNum 26) (== gPrevRoomNum 1400) (== gPrevRoomNum 1450))
				(gKqMusic1
					number: 1320
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
			)
		)
		(if
			(and
				(not (IsFlag 34))
				(== gChapter 1)
				(not (gEgo has: 9)) ; Glasses
				(not (IsFlag 6))
				(!= script openingCartoon)
			)
			(chaseTimer setReal: chaseTimer 30)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== gChapter 1)
				(not (IsFlag 337))
				(not (IsFlag 34))
				local5
				(not script)
				(not (gEgo script:))
				(< 640 (gThePlane right:) 780)
				(not (bunnyTrail onMe: gEgo))
			)
			(gEgo setMotion: 0)
			(= local5 0)
			(gCurRoom setScript: chaseScene)
		)
		(cond
			(
				(and
					(gEgo scratch:)
					(& ((gEgo scratch:) _respondVerbs:) (gKqRespondCode doit: 5))
					(IsFlag 326)
					(IsFlag 24)
					(> (gEgo x:) 250)
				)
				(gEgo deleteHotVerb: 5) ; Golden_Comb
			)
			(
				(and
					(gEgo scratch:)
					(not
						(&
							((gEgo scratch:) _respondVerbs:)
							(gKqRespondCode doit: 5)
						)
					)
					(IsFlag 326)
					(IsFlag 24)
					(< (gEgo x:) 250)
				)
				(gEgo addRespondVerb: 5) ; Golden_Comb
			)
		)
	)

	(method (notify)
		(if (not (IsFlag 31))
			(if (bowl scratch:)
				(bowl addRespondVerb: 5) ; Golden_Comb
			else
				(bowl setHotspot: 0 5) ; Golden_Comb
			)
		)
	)

	(method (dispose)
		(if (or (== gNewRoomNum 1450) (== gNewRoomNum 1400))
			(gKqMusic1 fade:)
		)
		(if (or (== gPrevRoomNum 26) (== gPrevRoomNum 35)) ; chapEndRm
			(SetFlag 48)
		)
		(chaseTimer client: 0 delete: dispose:)
		(gEgo setScale:)
		(DisposeScript 64941)
		(DisposeScript 64939)
		(super dispose:)
	)
)

(instance openingCartoon of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load rsVIEW 1302)
					(= ticks 20)
				)
				(1
					(gEgo
						posn: 391 126
						view: 1301
						init:
						setLoop: 0
						setCel: 0
						setScaler: Scaler 100 24 100 59
						setCycle: End self
					)
					(gKqSound1 init: number: 876 setLoop: -1 play:)
				)
				(2
					(gEgo
						posn: 387 126
						setLoop: 1
						setCel: 0
						setCycle: End self
					)
				)
				(3
					(gEgo view: 1302 setLoop: 0 setCel: 0 setCycle: End self)
				)
				(4
					(gKqSound1 setLoop: 1 stop:)
					(gEgo setLoop: 1 setCel: 0 setCycle: End self)
				)
				(5
					(gEgo normalize: 2 posn: 480 135)
					(= cycles 2)
				)
				(6
					(gMessager sayRange: 0 0 1 2 3 self) ; "My daughter..."
				)
				(7
					(Load rsVIEW 1303)
					(gEgo setMotion: PolyPath 560 135 self)
				)
				(8
					(gEgo
						posn: 575 138
						view: 1303
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				)
				(9
					(gEgo setLoop: 1 setCel: 0 setCycle: End self)
					(Load 140 1304) ; WAVE
				)
				(10
					(gEgo setLoop: 2 setCel: 0 setCycle: CT 6 1 self)
				)
				(11
					(gKqSound1 number: 1304 setLoop: 1 play:)
					(gEgo setCel: 7 setCycle: CT 12 1 self)
				)
				(12
					(peticoat init:)
					(gEgo setCel: 13 setCycle: End self)
				)
				(13
					(gEgo normalize: 5 posn: 581 133)
					(= cycles 2)
				)
				(14
					(gMessager sayRange: 0 0 1 4 5 self) ; "Oh, blast."
				)
				(15
					(gKqMusic1 fade: 0 20 20 1 self)
					(Load rsVIEW 1305)
					(Load 140 1311) ; WAVE
					(Load 140 1315) ; WAVE
					(Load 140 1316) ; WAVE
					(Load 140 1314) ; WAVE
					(Load 140 841) ; WAVE
				)
				(16
					(gKqMusic1
						number: 1310
						setLoop: -1
						play:
						setVol: 0
						fade: 127 20 40 0
					)
					(rat init: cycleSpeed: 8 setCycle: CT 7 1 self)
					(proc11_3 gEgo rat)
				)
				(17
					(rat setPri: 100 setCel: 8 setCycle: End self)
				)
				(18
					(rat
						posn: 640 71
						setLoop: 2
						setCel: 4
						setCycle: CT 6 1 self
					)
					(gKqMusic1 fade: 0 20 30 1)
				)
				(19
					(rat dispose:)
					(gKqMusic1
						number: 1312
						setLoop: -1
						play:
						setVol: 0
						fade: 127 20 20 0
					)
					(= local3 1)
					(jackalope init: cycleSpeed: 8 setCycle: CT 10 1 self)
					(mySound number: 1315 setLoop: 1 play:)
				)
				(20
					(jackalope setPri: 100 setCel: 11 setCycle: End self)
					(mySound number: 1316 setLoop: 1 play:)
					(gKqMusic1 fade: 0 25 10 1)
				)
				(21
					(jackalope dispose:)
					(gKqSound1 number: 1314 setLoop: 1 play:)
					(gEgo
						posn: 585 133
						view: 1320
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				)
				(22
					(gKqSound1 stop:)
					(gKqMusic1
						number: 1320
						setLoop: -1
						play:
						setVol: 0
						fade: 127 25 10 0
					)
					(mySound dispose:)
					(gEgo
						normalize:
						setHeading: 180
						setMotion: PolyPath 536 135 self
					)
				)
				(23
					(gEgo setHeading: 180 self)
				)
				(24
					(chaseTimer setReal: chaseTimer 30)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gKqSound1 setLoop: 1 stop:)
					(mySound dispose:)
					(if (!= (gKqMusic1 number:) 1320)
						(gKqMusic1
							number: 1320
							setLoop: -1
							play:
							setVol: 0
							fade: 127 25 10 0
						)
					)
					(jackalope dispose:)
					(rat dispose:)
					(peticoat init:)
					(gEgo show: setMotion: 0 normalize: 2 posn: 536 135)
					(chaseTimer setReal: chaseTimer 30)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance walkNorth of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((> local2 649)
						(gEgo setMotion: PolyPath 747 71 self)
					)
					((> local2 304)
						(gEgo setMotion: PolyPath local2 65 self)
					)
					(else
						(gEgo setMotion: PolyPath 181 75 self)
					)
				)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 1100)
			)
		)
	)
)

(instance walkSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 190 self)
			)
			(1
				(cond
					((< (gEgo x:) 320)
						(= global313 1)
					)
					((< (gEgo x:) 640)
						(= global313 2)
					)
					(else
						(= global313 3)
					)
				)
				(= global312 2)
				(gCurRoom newRoom: 1500)
			)
		)
	)
)

(instance walkEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 980 130 self)
			)
			(1
				(gCurRoom newRoom: 1500)
			)
		)
	)
)

(instance walkWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -13 121 self)
			)
			(1
				(gCurRoom newRoom: 1500)
			)
		)
	)
)

(instance moveCollarStones of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(gEgo view: 12515 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(2
				(gCurRoom newRoom: 1255)
			)
		)
	)
)

(instance backFromCollar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 90)
			)
			(1
				(cond
					(
						(and
							(not (IsFlag 37))
							(IsFlag 31)
							(IsFlag 9)
							(IsFlag 10)
						)
						(SetFlag 37)
						(wellWater
							setLoop: 2
							setCel: 0
							cycleSpeed: 6
							setCycle: End wellWater
						)
						(mySound number: 894 setLoop: -1 play:)
						(wellExit init:)
					)
					(
						(and
							(not (IsFlag 9))
							(not (gCast contains: wellWater))
						)
						(ClearFlag 37)
						(wellExit dispose:)
						(wellWater
							init:
							setLoop: 2
							setCel: 10
							cycleSpeed: 12
							setCycle: Beg self
						)
						(mySound number: 894 setLoop: -1 play:)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if (gCast contains: wellWater)
					(mySound stop:)
					(wellWater setLoop: 1 setCycle: Fwd)
				else
					(mySound fade: 0 25 10 1)
				)
				(gEgo view: 12515 setLoop: 3 setCel: 12 setCycle: Beg self)
			)
			(3
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cryInBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 57 109 self)
			)
			(1
				(gEgo view: 12515 setLoop: 4 setCel: 0 setCycle: CT 8 1 self)
			)
			(2
				(gEgo setLoop: 4 setCel: 9 setCycle: End self)
				(SetFlag 25)
				(gKqSound1 number: 1256 setLoop: -1 play:)
			)
			(3
				(gEgo setCycle: CT 7 -1 self)
			)
			(4
				(gKqSound1 setLoop: 1 stop:)
				(gEgo setLoop: 4 setCel: 7 setCycle: CT 0 -1 self)
			)
			(5
				(gEgo normalize: 6)
				(= ticks 30)
			)
			(6
				(if
					(and
						(IsFlag 25)
						(IsFlag 26)
						(IsFlag 27)
						(not (IsFlag 10))
					)
					(gCurRoom setScript: makeFreshWater)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance getTheStick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8065 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(stick dispose:)
				(gEgo get: 3 setCycle: Beg self) ; Stick
			)
			(2
				(gEgo normalize: 6 setHeading: 180 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pourWaterIntoBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 1253)
				(gEgo setHeading: 225 self)
			)
			(1
				(gEgo
					view: 1253
					setLoop: 0
					setCel: 0
					posn: 123 110
					setCycle: CT 6 1 self
				)
			)
			(2
				(gEgo put: 15 setCycle: End self) ; Salt_Water
				(gKqSound1 number: 836 play:)
			)
			(3
				(if (and (IsFlag 326) (IsFlag 24))
					(bowl approachVerbs: 8 10 12 setHotspot: 8 10 12 5) ; Do, Exit, Clay_Pot, Do, Exit, Clay_Pot, Golden_Comb
				else
					(bowl approachVerbs: 8 10 12 setHotspot: 8 10 12) ; Do, Exit, Clay_Pot, Do, Exit, Clay_Pot
				)
				(gEgo get: 2 normalize: 1) ; Clay_Pot
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getWaterFromBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 1253)
				(gEgo setHeading: 225 self)
			)
			(1
				(gEgo
					view: 1253
					setLoop: 1
					setCel: 0
					posn: 123 110
					setCycle: CT 6 1 self
				)
			)
			(2
				(gEgo setCycle: End self)
				(gKqSound1 number: 836 setLoop: 1 play:)
			)
			(3
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(cond
					((IsFlag 26)
						(gEgo put: 2 get: 15) ; Clay_Pot, Salt_Water
						(gMessager say: 4 8 5 0 self) ; "Eeow! Salty!"
						(bowl approachVerbs: 27 28 cycleSpeed: 14) ; Salt_Water, Fresh_Water
						(if (and (IsFlag 326) (IsFlag 24))
							(bowl setHotspot: 0 27 28 5) ; Salt_Water, Fresh_Water, Golden_Comb
						else
							(bowl setHotspot: 0 27 28) ; Salt_Water, Fresh_Water
						)
					)
					((IsFlag 30)
						(gEgo put: 2 get: 16) ; Clay_Pot, Fresh_Water
						(gMessager say: 4 8 6 0 self) ; "Mmm. Fresh."
						(bowl
							approachVerbs: 27 28 ; Salt_Water, Fresh_Water
							setHotspot: 0 27 28 5 ; Salt_Water, Fresh_Water, Golden_Comb
							cycleSpeed: 14
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(5
				(ClearFlag 26)
				(ClearFlag 30)
				(gEgo normalize: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance makeFreshWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqSound1 number: 834 setLoop: 1 play:)
				(bowl
					posn: 67 63
					view: 1256
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(godHand dispose:)
				(hand init:)
				(ClearFlag 27)
				(ClearFlag 16)
				(ClearFlag 26)
				(ClearFlag 25)
				(SetFlag 30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putCornInHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 1255) ; WAVE
				(gEgo view: 8081 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(hand dispose:)
				(godHand init: setLoop: 0 setCel: 0 setCycle: End self)
				(mySound number: 834 setLoop: 1 play:)
				(SetFlag 27)
				(gKqSound1 number: 1255 play: self)
				(gEgo put: 19 setCycle: Beg self) ; Ear_of_Corn
			)
			(2 0)
			(3
				(gEgo normalize: 1)
				(if
					(and
						(IsFlag 25)
						(IsFlag 26)
						(IsFlag 27)
						(not (IsFlag 10))
					)
					(bowl
						posn: 67 63
						view: 1256
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
					(mySound number: 834 setLoop: 1 play:)
					(godHand dispose:)
					(hand init:)
					(ClearFlag 27)
					(ClearFlag 16)
					(ClearFlag 25)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(ClearFlag 26)
				(SetFlag 30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putKernelInHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8081 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(if (IsFlag 344)
					(theKernel dispose:)
					(gEgo get: 14) ; Corn_Kernel
				else
					(theKernel init:)
					(gEgo put: 14) ; Corn_Kernel
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo normalize: 1)
				(if (IsFlag 344)
					(ClearFlag 344)
				else
					(SetFlag 344)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance touchLeftCactus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(Load rsVIEW 8071)
				(Load rsVIEW 8111)
				(gEgo setMotion: PolyPath 347 98 self)
			)
			(1
				(gEgo view: 8073 setLoop: 0 setCel: 0 setCycle: CT 4 1 self)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(2
				(gEgo
					posn: 349 96
					view: 8113
					setLoop: 0
					setCel: 5
					cycleSpeed: 3
					setCycle: Beg self
				)
				(gMessager say: 1 8 2 0) ; "Ow!"
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(SetFlag 33)
				(gEgo normalize: 1 cycleSpeed: register)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance touchRightCactus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(Load rsVIEW 8071)
				(Load rsVIEW 8111)
				(gEgo setMotion: PolyPath 379 89 self)
			)
			(1
				(gEgo view: 8071 setLoop: 0 setCel: 0 setCycle: CT 4 1 self)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(2
				(gEgo
					posn: 381 87
					view: 8111
					setLoop: 0
					setCel: 5
					cycleSpeed: 3
					setPri: 90
					setCycle: Beg self
				)
				(gMessager say: 1 8 2 0) ; "Ow!"
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(SetFlag 336)
				(gEgo normalize: 0 posn: 379 89 cycleSpeed: register)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sayHmmm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gEgo setMotion: PolyPath 379 89 self)
				else
					(gEgo setMotion: PolyPath 373 98 self)
				)
			)
			(1
				(if register
					(gEgo view: 8291 setLoop: 0 setCel: 0 setCycle: End self)
				else
					(gEgo view: 8291 setLoop: 1 setCel: 0 setCycle: End self)
				)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(2
				(gMessager say: 1 8 3 0 self) ; "Hmmm."
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(4
				(if register
					(gEgo normalize: 0)
				else
					(gEgo normalize: 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance catchTheJackalope of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(chaseTimer client: 0 delete: dispose:)
					(gGame handsOff: 1)
					(Load rsVIEW 1307)
					(Load rsVIEW 1309)
					(Load 140 865) ; WAVE
					(gEgo setMotion: PolyPath 340 100 self)
				)
				(1
					(gEgo
						setScale:
						view: 1307
						setLoop: 0
						setCel: 0
						setPri: 201
						setCycle: End self
					)
				)
				(2
					(leftRopePiece init:)
					(gEgo
						posn: 346 101
						setLoop: 6
						setCel: 0
						setCycle: End self
					)
				)
				(3
					(gEgo
						posn: 387 90
						view: 1307
						setLoop: 1
						setCel: 0
						setCycle: CT 6 1 self
					)
				)
				(4
					(rightRopePiece init:)
					(gEgo setCel: 7 setCycle: End self)
				)
				(5
					(leftRopePiece dispose:)
					(rightRopePiece dispose:)
					(wholeRope init:)
					(gEgo
						put: 17 ; Rope
						normalize:
						setPri: 201
						setScaler: Scaler 100 24 100 59
						setMotion: PolyPath 485 92 self
					)
					(Load 140 1326) ; WAVE
				)
				(6
					(Load rsVIEW 1327)
					(gKqMusic1
						number: 1325
						setLoop: -1
						play:
						setVol: 0
						fade: 127 25 10 0
					)
					(gEgo
						setScale:
						setPri: -1
						view: 1309
						setLoop: 2
						setCel: 3
						setCycle: Beg
					)
					(jackalope
						view: 1309
						setCel: 0
						setLoop: 4
						posn: 455 74
						ignoreActors: 1
						init:
						setPri: 50
						setCycle: End self
					)
				)
				(7
					(wholeRope dispose:)
					(= local3 0)
					(gKqSound1 number: 1326 setLoop: 1 play:)
					(jackalope
						posn: 368 92
						setLoop: 0
						setCel: 0
						setPri: -1
						setCycle: End self
					)
				)
				(8
					(Load rsVIEW 1310)
					(jackalope
						posn: 361 91
						setLoop: 1
						setCel: 0
						setCycle: CT 7 1 self
					)
					(jackFur init:)
					((gInventory at: 10) owner: 1250) ; Jackalope_Fur
					(gEgo view: 1309 setLoop: 2 setCel: 0 setCycle: End)
				)
				(9
					(jackalope hide:)
					(gMessager say: 1 25 3 1 self) ; "I've got you, you mad little hare!"
				)
				(10
					(gEgo setCycle: Beg)
					(jackalope show: setPri: 110 setCel: 8 setCycle: End self)
				)
				(11
					(gKqSound1 number: 824 play:)
					(jackalope
						posn: 445 106
						view: 1327
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
					(gKqMusic1 fade: 0 25 10 1)
					(mySound number: 865 setLoop: 1 play:)
				)
				(12
					(gKqMusic1
						number: 1328
						setLoop: -1
						play:
						setVol: 0
						fade: 127 25 10 0
					)
					(glasses init:)
					(gMessager say: 1 25 3 2) ; "Racha fracha racha fracha grr!"
					(jackalope setLoop: 1 setCel: 0 setCycle: End self)
				)
				(13
					(gEgo setCycle: End)
					(jackalope setLoop: 2 setCel: 0 setCycle: CT 3 1 self)
				)
				(14
					(jackalope setLoop: 2 setCel: 4 setCycle: End self)
					(gEgo
						setScaler: Scaler 100 24 100 59
						view: 8132
						setLoop: 0
						setCel: 0
						cycleSpeed: 14
						setCycle: End
					)
					(gKqMusic1 fade: 0 25 10 1)
				)
				(15
					(gEgo normalize: 2)
					(jackalope dispose:)
					(SetFlag 34)
					(gKqMusic1
						number: 1320
						setLoop: -1
						play:
						setVol: 0
						fade: 127 25 10 0
					)
					(leftCactus dispose:)
					(rightCactus dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(SetFlag 34)
					(gEgo
						setMotion: 0
						normalize:
						setScaler: Scaler 100 24 100 59
						put: 17 ; Rope
						posn: 485 92
						setHeading: 180
					)
					(jackalope dispose:)
					(wholeRope dispose:)
					(rightRopePiece dispose:)
					(leftRopePiece dispose:)
					(leftCactus dispose:)
					(rightCactus dispose:)
					(jackFur init:)
					((gInventory at: 10) owner: 1250) ; Jackalope_Fur
					(glasses init:)
					(gKqMusic1
						number: 1320
						setLoop: -1
						play:
						setVol: 0
						fade: 127 25 10 0
					)
					(if (gKqSound1 handle:)
						(gKqSound1 stop:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance getTheCrystal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(if (== gValOrRoz -4) ; Val
					(gMessager say: 6 8 8 0 self) ; "Salt crystals. How odd."
				else
					(gMessager say: 6 8 11 0 self) ; "(THINKS TO HERSELF)Salt! How odd!"
				)
			)
			(2
				(if (== gValOrRoz -4) ; Val
					(gEgo view: 8063 setLoop: 0 setCel: 0 setCycle: End self)
				else
					(gEgo
						view: 8423
						setLoop: 0
						setCel: 0
						setCycle: CT 9 1 self
					)
				)
			)
			(3
				(if (== gValOrRoz -4) ; Val
					(gEgo get: 21 setCycle: Beg self) ; Salt_Crystals
				else
					(gEgo get: 21 setCycle: End self) ; Salt_Crystals
				)
			)
			(4
				(gEgo normalize: setHeading: 180 self)
			)
			(5
				(saltCrystal1 setHotspot: 0)
				(saltCrystal2 setHotspot: 0)
				(saltCrystal3 setHotspot: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 12550) ; WAVE
				(Load 140 810) ; WAVE
				(gEgo
					posn: 36 112
					view: 8071
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gKqSound1 number: 12550 setLoop: 1 play: self)
				(gEgo setCycle: Beg)
				(if (IsFlag 31)
					(ClearFlag 31)
					(bowl
						posn: 57 63
						setPri: 66
						view: 1254
						setLoop: 0
						setCel: 5
						cycleSpeed: 10
						setCycle: Beg self
					)
					(cond
						((and (IsFlag 326) (IsFlag 24))
							(bowl setHotspot: 0 27 28 5 approachVerbs: 27 28 5) ; Salt_Water, Fresh_Water, Golden_Comb, Salt_Water, Fresh_Water, Golden_Comb
						)
						((IsFlag 24)
							(bowl setHotspot: 0 27 28 approachVerbs: 27 28) ; Salt_Water, Fresh_Water, Salt_Water, Fresh_Water
						)
						(else
							(bowl setHotspot: 0 approachVerbs: 0)
						)
					)
				else
					(SetFlag 31)
					(bowl
						posn: 57 63
						setPri: 66
						view: 1254
						setLoop: 0
						setCel: 0
						cycleSpeed: 10
						setHotspot: 0
						setCycle: End self
					)
				)
			)
			(2 0)
			(3
				(bowl setPri: -1)
				(gEgo posn: 40 112 normalize: 0)
				(self cue:)
			)
			(4
				(cond
					(
						(and
							(not (IsFlag 37))
							(IsFlag 31)
							(IsFlag 9)
							(IsFlag 10)
						)
						(SetFlag 37)
						(gKqSound1 number: 837 play:)
						(well setHotspot: 0)
						(wellExit init:)
						(wellWater
							setLoop: 2
							setCel: 0
							cycleSpeed: 6
							setCycle: End wellWater
						)
						(mySound number: 894 setLoop: -1 play:)
					)
					((not (gCast contains: wellWater))
						(ClearFlag 37)
						(wellExit dispose:)
						(wellWater
							init:
							setLoop: 2
							setCel: 10
							cycleSpeed: 12
							setCycle: Beg self
						)
						(mySound number: 894 setLoop: -1 play:)
					)
					(else
						(self cue:)
					)
				)
			)
			(5
				(cond
					((gCast contains: wellWater)
						(mySound stop:)
						(wellWater setLoop: 1 setCycle: Fwd)
					)
					((mySound handle:)
						(mySound fade: 0 25 10 1)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnBowlWithWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 1255) ; WAVE
				(Load 140 810) ; WAVE
				(gEgo
					posn: 36 112
					view: 8071
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gKqSound1 number: 1255 play:)
				(gEgo setCycle: Beg)
				(bowl
					posn: 61 65
					view: 1254
					setLoop: 3
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(2
				(gKqSound1 stop:)
				(gMessager say: 5 8 7 0 self) ; "Oops!"
			)
			(3
				(gKqSound1 number: 1255 play:)
				(bowl setCycle: Beg self)
				(gEgo setCycle: Osc 1 self)
			)
			(4
				(gKqSound1 stop:)
			)
			(5
				(gEgo normalize: 0 posn: 40 112)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getPeticoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8063 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(peticoat dispose:)
				(gEgo get: 1 setCycle: Beg self) ; Ripped_Petticoat
			)
			(2
				(gEgo normalize: 3 800 setHeading: 180 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterWell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 1251
					posn: 199 103
					setPri: 115
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo posn: 1000 0)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 1400)
			)
		)
	)
)

(instance lookAtWell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8164 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 1400)
			)
		)
	)
)

(instance getWellWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 836) ; WAVE
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 1255
					posn: 253 97
					setLoop: 0
					setCel: 0
					setPri: 200
					cycleSpeed: 6
					setCycle: CT 7 1 self
				)
			)
			(1
				(gEgo cel: 8 setCycle: CT 12 1 self)
				(gKqSound1 number: 836 play:)
			)
			(2
				(gKqSound1 stop:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					put: 2 ; Clay_Pot
					get: 15 ; Salt_Water
					cycleSpeed: register
					posn: 254 95
					normalize: 2
					setHeading: 180 self
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getFur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -4) ; Val
					(gEgo
						posn: 372 90
						view: 8071
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				else
					(gEgo view: 8421 setLoop: 0 setCel: 0 setCycle: End self)
				)
			)
			(1
				(jackFur dispose:)
				(gEgo get: 10 setCycle: Beg self) ; Jackalope_Fur
			)
			(2
				(gEgo posn: 377 90 normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getGlasses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8061 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(glasses dispose:)
				(gEgo get: 9 setCycle: Beg self) ; Glasses
			)
			(2
				(gEgo normalize: setHeading: 180 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAwayFromWell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 8164 setLoop: 1 setCel: 0 setCycle: Beg self)
			)
			(1
				(gEgo normalize: 5 setHeading: 180 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tasteWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 1253)
				(gEgo setHeading: 225 self)
			)
			(1
				(gEgo
					view: 1253
					setLoop: 2
					setCel: 0
					posn: 121 108
					setCycle: End self
				)
			)
			(2
				(cond
					((IsFlag 26)
						(gMessager say: 4 8 5 0 self) ; "Eeow! Salty!"
					)
					((IsFlag 30)
						(gMessager say: 4 8 6 0 self) ; "Mmm. Fresh."
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(gEgo posn: 123 110 normalize: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromPyramid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (== gChapter 1) (not (IsFlag 23)))
					(gEgo view: 801 setStep: 4 3)
				else
					(gEgo normalize:)
				)
				(gEgo setMotion: PolyPath 865 94 self)
			)
			(1
				(if (== gValOrRoz -4) ; Val
					(gEgo
						posn: 862 93
						view: 8142
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(2
				(gEgo posn: 865 94 normalize: 2)
				(= cycles 2)
			)
			(3
				(if
					(and
						(not (IsFlag 23))
						(not (IsFlag 20))
						(not (IsFlag 327))
					)
					(gMessager say: 0 0 4 0 self) ; "How can I get rid of that creature?"
				else
					(self cue:)
				)
			)
			(4
				(SetFlag 327)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tasteWellWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 1255
					posn: 253 97
					setLoop: 3
					setCel: 0
					setPri: 200
					setCycle: CT 16 1 self
				)
			)
			(1
				(gKqSound1 number: 1260 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo normalize: 2)
				(= cycles 2)
			)
			(3
				(gMessager say: 7 8 9 1 self) ; "Eeow! Salt water!"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 894) ; WAVE
				(gEgo view: 12515 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(if (IsFlag 10)
					(ClearFlag 10)
					(godFace cycleSpeed: 4 setCycle: End self)
				else
					(SetFlag 10)
					(godFace cycleSpeed: 6 setCycle: Beg self)
				)
				(gKqSound1 number: 1412 setLoop: 1 play:)
			)
			(2
				(cond
					(
						(and
							(not (IsFlag 37))
							(IsFlag 31)
							(IsFlag 9)
							(IsFlag 10)
						)
						(SetFlag 37)
						(well setHotspot: 0)
						(wellExit init:)
						(mySound number: 894 setLoop: -1 play:)
						(wellWater
							setLoop: 2
							setCel: 0
							cycleSpeed: 6
							setCycle: End wellWater
						)
						(= ticks 120)
					)
					((not (gCast contains: wellWater))
						(ClearFlag 37)
						(wellExit dispose:)
						(wellWater
							init:
							setLoop: 2
							setCel: 10
							cycleSpeed: 12
							setCycle: Beg self
						)
						(mySound number: 894 setLoop: -1 play:)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if
					(and
						(IsFlag 25)
						(IsFlag 26)
						(IsFlag 27)
						(not (IsFlag 10))
					)
					(gKqSound1 number: 834 setLoop: 1 play:)
					(bowl
						posn: 67 63
						view: 1256
						setLoop: 0
						setCel: 0
						setCycle: End
					)
					(godHand dispose:)
					(hand init:)
					(ClearFlag 27)
					(ClearFlag 16)
					(ClearFlag 25)
					(ClearFlag 26)
					(SetFlag 30)
				)
				(if (gCast contains: wellWater)
					(mySound stop:)
					(wellWater setLoop: 1 setCycle: Fwd)
				else
					(mySound fade: 0 25 10 1)
				)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtSunGod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 323)
				(gEgo view: 8291 setLoop: 1 setCel: 0 setCycle: End self)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(1
				(gMessager say: 1 8 3 0 self) ; "Hmmm."
			)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(3
				(waterGod dispose:)
				(gEgo normalize: setHeading: 180 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 320 self)
			)
			(1
				(gMessager say: 3 8 0 0 self) ; "It looks like he's expecting something."
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chaseScene of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqMusic1 fade: 0 20 20 1 self)
			)
			(1
				(gKqMusic1
					number: 1312
					setLoop: -1
					play:
					setVol: 0
					fade: 127 20 20 0
				)
				(= local3 1)
				(jackalope
					init:
					posn: 479 78
					view: 1305
					setPri: -1
					setLoop: 0
					setCel: 0
					cycleSpeed: 8
					setCycle: CT 10 1 self
				)
				(gMessager sayRange: 0 0 1 6 7) ; "Eeeheeheeheeheehee!"
			)
			(2
				(jackalope setPri: 100 setCel: 11 setCycle: End self)
				(gKqMusic1 fade: 0 25 10 1)
			)
			(3
				(jackalope dispose:)
				(gKqMusic1
					number: 1320
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
				(= cycles 3)
			)
			(4
				(gEgo normalize: setHeading: 180 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkFromDesert of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch global314
					(1
						(gEgo setMotion: PolyPath (gEgo x:) 120 self)
					)
					(2
						(gEgo setMotion: PolyPath 50 (gEgo y:) self)
					)
					(4
						(gEgo setMotion: PolyPath 900 (gEgo y:) self)
					)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromTopScroller of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((< (gEgo x:) 320)
						(gEgo setMotion: PolyPath 180 87 self)
					)
					((< (gEgo x:) 640)
						(gEgo setMotion: PolyPath 525 84 self)
					)
					(else
						(gEgo setMotion: PolyPath 743 86 self)
					)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jackalope of Prop
	(properties
		x 479
		y 78
		view 1305
	)

	(method (doit)
		(super doit:)
		(if (and local3 (OneOf cel 2 5 8 11 14 17 21))
			(gKqSound1 number: 841 setLoop: 1 play:)
			(if (== cel 21)
				(= local3 0)
			)
		)
	)
)

(instance rat of Prop
	(properties
		x 515
		y 73
		view 1305
		loop 1
	)

	(method (doit)
		(super doit:)
		(if (and local3 (OneOf cel 3 6 9 12 15 18))
			(mySound number: 1311 setLoop: 1 play:)
			(if (== cel 18)
				(= local3 0)
			)
		)
	)
)

(instance collar of Prop
	(properties
		approachX 57
		approachY 109
		x 73
		y 37
		view 1251
	)

	(method (init)
		(super init: &rest)
		(switch gGem1Position
			(0
				(-= local6 48)
				(switch gGem2Position
					(0
						(-= local6 12)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(1
						(-= local6 8)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(2
						(-= local6 4)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(3
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
				)
			)
			(1
				(-= local6 32)
				(switch gGem2Position
					(0
						(-= local6 12)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(1
						(-= local6 8)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(2
						(-= local6 4)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(3
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
				)
			)
			(2
				(-= local6 16)
				(switch gGem2Position
					(0
						(-= local6 12)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(1
						(-= local6 8)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(2
						(-= local6 4)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(3
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
				)
			)
			(3
				(switch gGem2Position
					(0
						(-= local6 12)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(1
						(-= local6 8)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
					(2
						(-= local6 4)
						(switch gGem3Position
							(0
								(-= local6 3)
							)
							(1
								(-= local6 2)
							)
							(2
								(-= local6 1)
							)
						)
					)
				)
			)
		)
		(if (!= gChapter 4)
			(self approachVerbs: 8 10 setHotspot: 8 10 setCel: local6) ; Do, Exit, Do, Exit
		else
			(self setCel: local6)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: moveCollarStones)
			)
		)
	)
)

(instance bowl of Prop
	(properties
		noun 4
		approachX 123
		approachY 110
		x 57
		y 63
		view 1254
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 31)
			(self setCel: 5)
		)
		(cond
			((IsFlag 31)
				(self setHotspot: 0)
			)
			((or (IsFlag 30) (IsFlag 26))
				(if (and (IsFlag 326) (IsFlag 24))
					(self
						setHotspot: 8 10 12 5 ; Do, Exit, Clay_Pot, Golden_Comb
						approachVerbs: 8 10 12 ; Do, Exit, Clay_Pot
						cycleSpeed: 14
					)
				else
					(self
						setHotspot: 8 10 12 ; Do, Exit, Clay_Pot
						approachVerbs: 8 10 12 ; Do, Exit, Clay_Pot
						cycleSpeed: 14
					)
				)
			)
			((and (IsFlag 326) (IsFlag 24))
				(self setHotspot: 0 27 28 5 approachVerbs: 27 28) ; Salt_Water, Fresh_Water, Golden_Comb, Salt_Water, Fresh_Water
			)
			((IsFlag 24)
				(self setHotspot: 0 27 28 approachVerbs: 27 28) ; Salt_Water, Fresh_Water, Salt_Water, Fresh_Water
			)
			(else
				(self setHotspot: 0 approachVerbs: 27 28) ; Salt_Water, Fresh_Water
			)
		)
		(if (== gChapter 4)
			(self setHotspot: 0)
		)
	)

	(method (handleEvent event)
		(if (== (event message:) JOY_DOWN)
			(self approachX: 57 approachY: 109)
		else
			(self approachX: 123 approachY: 110)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27 ; Salt_Water
				(if (not (IsFlag 31))
					(SetFlag 26)
					(if
						(and
							(IsFlag 25)
							(IsFlag 26)
							(IsFlag 27)
							(not (IsFlag 10))
						)
						(pourWaterIntoBowl next: makeFreshWater)
					)
					(gCurRoom setScript: pourWaterIntoBowl)
				)
				(return 1)
			)
			(8 ; Do
				(if (or (IsFlag 26) (IsFlag 30))
					(gCurRoom setScript: tasteWater)
				)
			)
			(5 ; Golden_Comb
				(gEgo setScript: cryInBowl)
			)
			(12 ; Clay_Pot
				(if (or (IsFlag 30) (IsFlag 26))
					(gCurRoom setScript: getWaterFromBowl)
				)
			)
			(28 ; Fresh_Water
				(gMessager say: noun theVerb 0 0) ; "I'd better save this water. I don't know when I'll need it."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance godHand of Prop
	(properties
		x 78
		y 49
		view 1252
	)

	(method (init)
		(super init:)
		(self setPri: 65 cycleSpeed: 14)
		(if (IsFlag 27)
			(self setCel: 9)
		)
	)
)

(instance peticoat of Prop
	(properties
		approachX 546
		approachY 130
		x 546
		y 132
		view 1303
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setHotspot: 8 10 approachVerbs: 8 10 setPri: 125) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: getPeticoat)
			)
		)
	)
)

(instance saltCrystal1 of Prop
	(properties
		approachX 173
		approachY 133
		x 175
		y 127
		z 10
		view 1310
		loop 2
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle cycleSpeed: 16 setPri: 120)
		(cond
			((== gValOrRoz -4) ; Val
				(if (and (not (gEgo has: 21)) (not (IsFlag 122))) ; Salt_Crystals
					(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
				)
			)
			((and (not (gEgo has: 21)) (not (IsFlag 149))) ; Salt_Crystals
				(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gEgo setScript: getTheCrystal 0 self)
			)
		)
	)
)

(instance saltCrystal2 of Prop
	(properties
		approachX 185
		approachY 133
		x 184
		y 130
		z 10
		view 1310
		loop 3
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle cycleSpeed: 16 setPri: 120)
		(cond
			((== gValOrRoz -4) ; Val
				(if (and (not (gEgo has: 21)) (not (IsFlag 122))) ; Salt_Crystals
					(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
				)
			)
			((and (not (gEgo has: 21)) (not (IsFlag 149))) ; Salt_Crystals
				(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gEgo setScript: getTheCrystal 0 self)
			)
		)
	)
)

(instance saltCrystal3 of Prop
	(properties
		approachX 197
		approachY 134
		x 196
		y 128
		z 10
		view 1310
		loop 4
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle cycleSpeed: 16 setPri: 120)
		(cond
			((== gValOrRoz -4) ; Val
				(if (and (not (gEgo has: 21)) (not (IsFlag 122))) ; Salt_Crystals
					(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
				)
			)
			((and (not (gEgo has: 21)) (not (IsFlag 149))) ; Salt_Crystals
				(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gEgo setScript: getTheCrystal 0 self)
			)
		)
	)
)

(instance wellWater of Prop
	(properties
		sightAngle 10
		approachX 253
		approachY 97
		x 217
		y 120
		loop 1
	)

	(method (init)
		(if (== gValOrRoz -3) ; Roz
			(self view: 1258)
		else
			(self view: 1255)
		)
		(super init:)
		(cond
			((IsFlag 37)
				(self setHotspot: 8 10 28) ; Do, Exit, Fresh_Water
			)
			((== gValOrRoz -4) ; Val
				(self setHotspot: 8 10 12 28) ; Do, Exit, Clay_Pot, Fresh_Water
			)
			(else
				(self setHotspot: 0 12 28) ; Clay_Pot, Fresh_Water
			)
		)
		(self
			approachVerbs: 8 10 12 ; Do, Exit, Clay_Pot
			setCycle: RandCycle
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 153 100 144 106 164 110 214 112 255 109 263 103 222 96 169 97
					yourself:
				)
		)
	)

	(method (cue)
		(super cue:)
		(cond
			((== (gCurRoom script:) turnBowl)
				(turnBowl cue:)
			)
			((== (gCurRoom script:) backFromCollar)
				(backFromCollar cue:)
			)
		)
		(self dispose:)
	)

	(method (doVerb theVerb)
		(well doVerb: theVerb)
	)
)

(instance godFace of Prop
	(properties
		approachX 57
		approachY 109
		x 84
		y 29
		view 1251
		loop 2
	)

	(method (init)
		(if (IsFlag 10)
			(self setCel: 0)
		else
			(self setCel: 24)
		)
		(super init: &rest)
		(if (!= gChapter 4)
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: turnHead)
			)
		)
	)
)

(instance theKernel of Prop
	(properties
		approachX 118
		approachY 114
		x 80
		y 53
		view 1252
		loop 2
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10 setCycle: Fwd) ; Do, Exit, Do, Exit
	)

	(method (doVerb)
		(gCurRoom setScript: putKernelInHand)
	)
)

(instance jackFur of View
	(properties
		approachX 377
		approachY 90
		x 391
		y 51
		view 1310
		loop 1
	)

	(method (init)
		(super init:)
		(if (== gValOrRoz -4) ; Val
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self setPri: 85 approachVerbs: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: getFur)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance glasses of View
	(properties
		approachX 454
		approachY 124
		x 474
		y 122
		view 1310
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: getGlasses)
			)
		)
	)
)

(instance stick of View
	(properties
		approachX 230
		approachY 92
		x 244
		y 92
		view 1257
	)

	(method (init)
		(super init: &rest)
		(gCurRoom addObstacle: local4)
		(if (== gValOrRoz -4) ; Val
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self
			setPri: 90
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 242 86 249 78 247 68 255 60 256 65 254 70 258 77 249 88
					yourself:
				)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(if ((gCurRoom obstacles:) contains: local4)
			((gCurRoom obstacles:) delete: local4)
			(= local4 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gEgo setScript: getTheStick)
			)
		)
	)
)

(instance rightRopePiece of View
	(properties
		x 405
		y 78
		view 1307
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 200)
	)
)

(instance leftRopePiece of View
	(properties
		x 346
		y 89
		view 1307
		loop 5
	)

	(method (init)
		(super init:)
		(self setPri: 200)
	)
)

(instance wholeRope of View
	(properties
		x 349
		y 90
		view 1307
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 200)
	)
)

(instance leftCactus of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 25) ; Do, Exit, Rope
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 342 90 349 93 358 92 353 77 361 59 354 54 348 57 344 44 352 25 338 12 330 13 331 32 315 35 327 80
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((not (IsFlag 33))
						(gEgo setScript: touchLeftCactus)
					)
					((not (IsFlag 34))
						(gEgo setScript: sayHmmm 0 0)
					)
				)
			)
			(25 ; Rope
				(cond
					((not (IsFlag 32))
						(gEgo setScript: sayHmmm 0 0)
					)
					((not (IsFlag 6))
						(SetFlag 324)
						(gEgo setScript: catchTheJackalope)
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightCactus of Feature
	(properties
		noun 1
		x 406
		y 80
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 393 80 402 85 413 85 411 41 426 21 425 0 389 0 387 32 379 39 395 63
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((not (IsFlag 336))
						(gEgo setScript: touchRightCactus)
					)
					((not (IsFlag 34))
						(gEgo setScript: sayHmmm 0 1)
					)
				)
			)
		)
	)
)

(instance bunnyTrail of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 594 57 413 63 359 73 340 94 359 107 406 112 637 112 673 116 698 121 780 110 722 94 711 85 751 75 756 69 701 80 708 91 733 105 709 112 658 105 513 96 417 89 394 78 451 68
					yourself:
				)
		)
	)
)

(instance pictograms of Feature
	(properties
		sightAngle 20
		approachX 118
		approachY 118
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 85 99 93 111 125 102 114 93
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 24)
				(gCurRoom newRoom: 1260)
			)
		)
	)
)

(instance hand of Feature
	(properties
		noun 3
		nsLeft 80
		nsTop 49
		nsRight 100
		nsBottom 61
		approachX 118
		approachY 114
		y 200
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 24)
			(self setHotspot: 8 10 24 30) ; Do, Exit, Corn_Kernel, Ear_of_Corn
		else
			(self setHotspot: 0)
		)
		(self approachVerbs: 8 24 30) ; Do, Corn_Kernel, Ear_of_Corn
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 344)
					(gCurRoom setScript: putKernelInHand)
				else
					(gCurRoom setScript: lookAtHand)
				)
			)
			(24 ; Corn_Kernel
				(gCurRoom setScript: putKernelInHand)
			)
			(30 ; Ear_of_Corn
				(gCurRoom setScript: putCornInHand)
			)
		)
	)
)

(instance well of Feature
	(properties
		noun 7
		nsLeft 144
		nsTop 91
		nsRight 263
		nsBottom 106
		approachX 253
		approachY 98
		y 20
	)

	(method (init)
		(super init: &rest)
		(cond
			((IsFlag 37)
				(self setHotspot: 8 10 28 approachVerbs: 8 10) ; Do, Exit, Fresh_Water, Do, Exit
			)
			((== gValOrRoz -4) ; Val
				(self setHotspot: 8 10 12 28 approachVerbs: 8 10 12) ; Do, Exit, Clay_Pot, Fresh_Water, Do, Exit, Clay_Pot
			)
			(else
				(self setHotspot: 0 12 28 approachVerbs: 12) ; Clay_Pot, Fresh_Water, Clay_Pot
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((IsFlag 37)
						(Load rsVIEW 1251)
						(gCurRoom setScript: enterWell)
					)
					((< gChapter 1)
						(gCurRoom setScript: tasteWellWater)
					)
					((IsFlag 319)
						(gMessager say: noun theVerb 10 1) ; "How can I possibly get down there?"
					)
					((IsFlag 318)
						(SetFlag 319)
						(gCurRoom setScript: tasteWellWater)
					)
					(else
						(SetFlag 318)
						(gCurRoom setScript: lookAtWell)
					)
				)
			)
			(12 ; Clay_Pot
				(gCurRoom setScript: getWellWater)
			)
			(28 ; Fresh_Water
				(gMessager say: 4 28 0 0) ; "I'd better save this water. I don't know when I'll need it."
			)
		)
	)
)

(instance wristBand of Feature
	(properties
		noun 5
		nsLeft 57
		nsTop 66
		nsRight 67
		nsBottom 80
		approachX 40
		approachY 112
		x 62
		y 70
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (or (IsFlag 26) (IsFlag 30))
					(gCurRoom setScript: turnBowlWithWater)
				else
					(gCurRoom setScript: turnBowl)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance waterGod of Feature
	(properties
		approachX 126
		approachY 104
		y 210
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 10 ; Do, Exit
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 51 37 37 54 38 98 92 112 124 102 110 84 127 60 87 31 103 23 104 0 49 0 47 25 62 26 64 34
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: lookAtSunGod)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pyramidDoor of ExitFeature
	(properties
		sightAngle 360
		approachX 927
		approachY 74
		y 200
		exitDir 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 876 79 875 29 920 27 919 82
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom newRoom: 1450)
			)
		)
	)
)

(instance rightScreenNorth of ExitFeature
	(properties
		nsLeft 703
		nsRight 796
		nsBottom 73
		sightAngle 360
		approachX 747
		approachY 71
		exitDir 6
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(gCurRoom newRoom: 1100)
			)
		)
	)
)

(instance midScreenNorth of ExitFeature
	(properties
		nsLeft 478
		nsRight 568
		nsBottom 65
		sightAngle 10
		approachX 526
		approachY 65
		x 526
		y 65
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(gCurRoom newRoom: 1100)
			)
		)
	)
)

(instance leftScreenNorth of ExitFeature
	(properties
		nsLeft 132
		nsRight 227
		nsBottom 80
		sightAngle 10
		approachX 181
		approachY 75
		x 181
		y 75
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(gCurRoom newRoom: 1100)
			)
		)
	)
)

(instance eSouth of ExitFeature
	(properties
		nsTop 130
		nsRight 950
		nsBottom 136
		sightAngle 360
		approachY 136
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (handleEvent event)
		(= approachX (event x:))
		(if
			(and
				(& (event type:) evALL_EVENTS)
				(or (< 688 (event x:) 803) (< (event x:) 121))
			)
			(return 0)
		)
		(super handleEvent: event)
	)

	(method (doVerb)
		(= global314 3)
		(gCurRoom setScript: walkSouth)
	)
)

(instance eWest of ExitFeature
	(properties
		nsRight 20
		nsBottom 140
		sightAngle 360
		approachX 1
		approachY 111
		y 200
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(= global314 4)
				(= global313 0)
				(= global312 1)
				(gCurRoom setScript: walkWest)
			)
		)
	)
)

(instance eEast of ExitFeature
	(properties
		nsLeft 929
		nsRight 960
		nsBottom 140
		sightAngle 360
		approachX 959
		approachY 113
		y 20
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(= global314 2)
				(= global313 4)
				(= global312 1)
				(gCurRoom setScript: walkEast)
			)
		)
	)
)

(instance wellExit of ExitFeature
	(properties
		nsLeft 144
		nsTop 91
		nsRight 263
		nsBottom 116
		approachX 253
		approachY 98
		x 230
		y 106
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: enterWell)
			)
		)
	)
)

(instance mySound of Sound
	(properties)
)

(instance chaseTimer of Timer
	(properties)

	(method (cue)
		(if (and (not (gCurRoom script:)) (not (gEgo script:)))
			(= local5 1)
		else
			(self setReal: self 90)
		)
	)
)

(instance myExitCode of Code
	(properties)

	(method (doit)
		(if (and (> (gEgo x:) 684) (IsFlag 97))
			((gCurRoom obstacles:) delete: ((gCurRoom obstacles:) at: 0))
			((gCurRoom obstacles:)
				addToFront:
					((Polygon new:)
						type: PContainedAccess
						init: 181 75 183 83 137 80 131 85 153 83 163 92 131 99 125 105 92 116 4 102 4 121 140 133 141 137 148 153 678 145 686 127 799 127 810 142 952 144 952 105 898 114 886 93 923 69 886 90 876 82 851 86 825 82 822 94 748 91 738 78 753 70 761 62 737 63 728 83 745 99 742 109 715 111 618 102 318 100 302 84 275 84 196 77 183 73
						yourself:
					)
			)
			(gEgo setMotion: PolyPath 50 117)
			((gCurRoom obstacles:) delete: ((gCurRoom obstacles:) at: 0))
			((gCurRoom obstacles:)
				addToFront:
					((Polygon new:)
						type: PContainedAccess
						init: 181 75 183 83 137 80 131 85 153 83 163 92 131 99 125 105 92 116 4 102 4 121 140 133 141 137 148 153 678 145 686 127 799 127 810 142 952 144 952 105 898 114 886 93 923 69 886 90 876 82 851 86 825 82 822 94 748 91 738 78 753 70 761 62 737 63 728 83 745 99 742 109 715 111 618 102 590 104 572 95 561 62 311 65 317 80 302 84 275 84 196 77 183 73
						yourself:
					)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

