;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1450)
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
(use StopWalk)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1450 0
)

(local
	local0
)

(instance rm1450 of KQRoom
	(properties
		picture 1450
	)

	(method (init)
		(super init:)
		(gGame handsOn:)
		(cond
			((IsFlag 20)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 30 128 0 135 316 135 292 90 212 95 195 90 166 66 147 66 151 82 93 90 32 90 29 96 117 95 140 110 124 126 72 133
							yourself:
						)
				)
			)
			((and (or (not (IsFlag 36)) (not (IsFlag 23))) (== gChapter 1))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 57 110 0 135 316 135 292 90 212 95 195 90 187 106 127 111 82 105 86 92 31 92 30 98
							yourself:
						)
				)
			)
			(else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 57 110 0 135 316 135 294 91 208 97 185 74 173 74 160 65 146 61 154 82 115 85 95 93 31 92 30 98
							yourself:
						)
				)
			)
		)
		(Load rsMESSAGE 1450)
		(SetFlag 21)
		(gEgo init: normalize: 0 setScaler: Scaler 98 54 114 73)
		(if (== gPrevRoomNum 1460)
			(gEgo posn: 245 97 normalize: 3)
		else
			(gEgo posn: 48 97)
		)
		(if (and (== gChapter 1) (not (IsFlag 23)))
			(gEgo disableHotspot:)
			(scorpion init:)
		)
		(if (IsFlag 317)
			(lightShaft init: setCel: 5)
		)
		(if (and (== ((gInventory at: 1) owner:) 1450) (== gChapter 1)) ; Ripped_Petticoat
			(peticoat init:)
		)
		(exitPyramid init:)
		(if
			(and
				(not (IsFlag 15))
				(or (not (gCast contains: scorpion)) (IsFlag 20))
			)
			(altar init:)
		)
		(if
			(and
				(or (not (gCast contains: scorpion)) (IsFlag 20))
				(not (IsFlag 28))
			)
			(godFace init:)
		)
		(if
			(and
				(== gChapter 1)
				(not (IsFlag 20))
				(not (IsFlag 23))
				(!= gPrevRoomNum 1460)
			)
			(gEgo disableHotspot:)
			(self setScript: seeTheScorpion)
		)
		(if (and (IsFlag 316) (not (IsFlag 317)))
			(SetFlag 317)
			(gEgo posn: 245 97 normalize: 3)
			(self setScript: showLight)
		)
		(if
			(and
				(== ((ScriptID 0 6) seconds:) -1) ; scorpDeathTimer
				(IsFlag 20)
				(not (IsFlag 23))
			)
			((ScriptID 0 6) setReal: (ScriptID 0 6) 90) ; scorpDeathTimer, scorpDeathTimer
		)
		(if (gCast contains: scorpion)
			(gKqMusic1
				number: 1450
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		else
			(gKqMusic1
				number: 1460
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
		(gWalkHandler add: self)
	)

	(method (cue)
		(super cue:)
		(if (not (IsFlag 23))
			(Load 140 1451) ; WAVE
			(self setScript: killEgo)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (IsFlag 20) (not (mySound handle:)))
			(stuckSoundManager doit:)
		)
		(cond
			((and (gEgo mover:) (IsFlag 20))
				(if (== (gEgo view:) 800)
					(gEgo view: 801 setStep: 5 4)
				)
			)
			((and (== (gEgo view:) 801) (IsFlag 20))
				(gEgo view: 800 setStep: 3 2)
			)
		)
		(if
			(or
				local0
				(and
					(== gChapter 1)
					(not script)
					(gCast contains: scorpion)
					(not (IsFlag 20))
					(> (gEgo x:) 104)
				)
			)
			(gEgo setMotion: 0)
			(= local0 0)
			(if (== (scorpion script:) threaten)
				(scorpion setScript: 0)
			)
			(self setScript: stungScript)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (and (& (event type:) evMOVE) (> (standAround seconds:) 0))
			(standAround cue:)
			(event claimed: 1)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(SetFlag 36)
		(mySound dispose:)
		(gEgo setScale:)
		(gKqMusic1 fade:)
		(gKqSound1 stop:)
		(DisposeScript 64939)
		(standAround client: 0 delete: dispose:)
		(super dispose:)
	)
)

(instance waveFlag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(standAround client: 0 delete: dispose:)
				(gEgo view: 801 setMotion: PolyPath 35 135 self)
				(Load 140 1451) ; WAVE
				(Load 140 1452) ; WAVE
				(Load rsVIEW 1454)
			)
			(1
				(proc11_3 gEgo scorpion self)
			)
			(2
				(gKqMusic1 number: 1458 setLoop: -1 play:)
				(gEgo view: 1454 setLoop: 0 setCel: 0 setCycle: End self)
				(Load 140 14590) ; WAVE
			)
			(3
				(gKqSound1 number: 1451 setLoop: -1 play:)
				(scorpion
					view: 1454
					setLoop: 1
					setCel: 0
					setPri: -1
					setCycle: CT 7 1 self
				)
			)
			(4
				(gKqSound1 setLoop: 1 stop:)
				(Load 140 822) ; WAVE
				(scorpion setCel: 8 setCycle: CT 10 1 self)
			)
			(5
				(scorpion setCel: 11 setCycle: End self)
				(gKqSound1 number: 822 setLoop: 1 play:)
				(Load 140 14591) ; WAVE
			)
			(6
				(SetFlag 20)
				(peticoat init:)
				(gEgo normalize: 0 801 setStep: 4 3)
				(gKqMusic1 fade:)
				(scorpion
					view: 1455
					posn: 95 129
					setPri: 125
					setLoop: 0
					setCel: 0
					setCycle: Fwd
					setHotspot: 0
				)
				(gKqSound1 number: 1452 setLoop: 1 play: self)
				(Load 140 1459) ; WAVE
			)
			(7
				((ScriptID 0 6) setReal: (ScriptID 0 6) 90) ; scorpDeathTimer, scorpDeathTimer
				(gEgo put: 4 get: 3 ignoreActors: 1) ; Flag, Stick
				((gInventory at: 1) owner: 1450) ; Ripped_Petticoat
				(gKqMusic1
					number: 1450
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
				(gCurRoom obstacles: 148)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 30 128 0 135 316 135 292 90 212 95 195 90 166 66 147 66 151 82 93 90 32 90 29 96 117 95 140 110 124 126 72 133
							yourself:
						)
				)
				(altar init:)
				(if (not (IsFlag 28))
					(godFace init:)
				)
				(gEgo enableHotspot:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance reduceScorp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(standAround client: 0 delete: dispose:)
				(Load 140 1453) ; WAVE
				(Load 140 1455) ; WAVE
				(Load 140 825) ; WAVE
				(Load rsSOUND 819)
				(Load rsVIEW 1451)
				(gEgo view: 801 setMotion: PolyPath 35 135 self)
			)
			(1
				(proc11_3 gEgo scorpion self)
			)
			(2
				(gEgo view: 1451 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(gKqSound1 number: 1453 play:)
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(Load rsSOUND 819)
				(Load rsSOUND 1454)
				(gEgo setLoop: 2 setCel: 0 setCycle: CT 11 1 self)
			)
			(5
				(gEgo setLoop: 2 setCel: 12 setCycle: End self)
				(gKqSound1 number: 819 setLoop: 1 play:)
				(gKqMusic1 number: 1454 setLoop: 1 play:)
			)
			(6
				(mySound number: 1455 setLoop: 1 play:)
				(scorpion
					view: 1456
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
				(gKqSound1 number: 825 setLoop: 1 play: self)
			)
			(7
				(Load 140 1457) ; WAVE
				(Load 140 14560) ; WAVE
			)
			(8
				(scorpion setLoop: 1 setCel: 0 setCycle: End self)
				(gKqSound1 number: 1457 setLoop: -1 play:)
				(mySound number: 14560 setLoop: 1 play:)
			)
			(9
				(gKqSound1 setLoop: 1 stop:)
				(gKqMusic1
					number: 1460
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
				(scorpion dispose:)
				(gEgo normalize: 6 put: 18) ; Bug_Reducing_Powder
				(ClearFlag 44)
				(SetFlag 23)
				(gCurRoom obstacles: 148)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 57 110 0 135 316 135 294 91 208 97 185 74 173 74 160 65 146 61 154 82 115 85 95 93 31 92 30 98
							yourself:
						)
				)
				(altar init:)
				(if (not (IsFlag 28))
					(godFace init:)
				)
				(gEgo enableHotspot:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stungScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 821)
				(Load rsVIEW 801)
				(gKqSound1 number: 1459 setLoop: 1 play: self)
			)
			(1
				(gMessager say: 1 8 0 1 self) ; "(TERRIFIED, SHOUTING)Stay away!"
			)
			(2
				(gEgo view: 8025 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo
					view: 801
					setCycle: StopWalk -1
					setMotion: PolyPath 35 135 self
				)
			)
			(4
				(gEgo normalize: 6)
				(= cycles 2)
			)
			(5
				(gMessager say: 1 8 0 2 self) ; "(TERRIFIED, SHOUTING)No! Stop!"
			)
			(6
				(gEgo
					posn: 36 128
					view: 8025
					setLoop: 0
					setCel: 0
					setCycle: End
				)
				(scorpion
					view: 1452
					setLoop: 0
					setCel: 0
					setPri: -1
					ignoreActors: 1
					setCycle: CT 3 1 self
				)
			)
			(7
				(gEgo hide:)
				(scorpion setCel: 4 setCycle: CT 17 1 self)
			)
			(8
				(gKqMusic1 number: 821 setVol: 127 setLoop: 1 play: self)
				(scorpion setCycle: End self)
			)
			(9 0)
			(10
				(EgoDead 3 self)
			)
			(11
				(gKqMusic1
					number: 1450
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
				(scorpion view: 1453 setLoop: 1 setCel: 0 setPri: 85)
				(gEgo normalize: posn: 104 122 setHeading: 0 self)
			)
			(12
				(gEgo view: 8025 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(13
				(scorpion setScript: threaten)
				(gEgo normalize: 6)
				(standAround setReal: standAround 20)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance killEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setScript: 0 setMotion: 0)
				(gKqSound1 number: 1451 setLoop: -1 play:)
				(scorpion
					view: 1454
					setLoop: 1
					setCel: 13
					setCycle: CT 6 -1 self
				)
			)
			(1
				(scorpion view: 1455 setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(2
				(gKqSound1 setLoop: 1 stop:)
				(scorpion setCel: 5 setCycle: End self)
			)
			(3
				(EgoDead 4 self)
			)
			(4
				(= seconds 2)
			)
			(5
				(ClearFlag 5)
				(gEgo posn: 160 112 normalize:)
				(scorpion view: 1455 setLoop: 0 setCel: 0 setCycle: Fwd)
				(SetFlag 20)
				((ScriptID 0 6) setReal: (ScriptID 0 6) 90) ; scorpDeathTimer, scorpDeathTimer
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tooCloseToAltar of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(gKqSound1 number: 1451 setLoop: -1 play:)
				(scorpion
					view: 1455
					setLoop: 1
					setCel: 0
					posn: 167 115
					setCycle: CT 5 1 self
				)
			)
			(1
				(scorpion setCel: 6 setCycle: End self)
				(gKqSound1 setLoop: 1 stop:)
			)
			(2
				(EgoDead 3 self)
			)
			(3
				(= seconds 2)
			)
			(4
				(ClearFlag 5)
				(gEgo posn: 160 122 normalize:)
				(scorpion view: 1453 setLoop: 1 setCel: 0 posn: 100 129)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance seeTheScorpion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 1452) ; WAVE
				(gEgo setMotion: PolyPath 104 122 self)
			)
			(1
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 8131
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: Osc 1 self
				)
			)
			(2
				(Load 140 1451) ; WAVE
				(gKqSound1 number: 1452 play: self)
			)
			(3
				(gKqSound1 number: 1451 setLoop: -1 play:)
				(scorpion
					view: 1450
					setLoop: 0
					setCel: 0
					setCycle: CT 13 1 self
				)
			)
			(4
				(gEgo
					view: 8283
					setLoop: 0
					setCel: 0
					cycleSpeed: 16
					setCycle: Osc 1
				)
				(gKqSound1 setLoop: 1 stop:)
				(scorpion setCel: 13 setCycle: End self)
			)
			(5
				(scorpion setCycle: CT 13 -1 self)
			)
			(6
				(scorpion setCycle: End self)
			)
			(7
				(gEgo normalize: 6 cycleSpeed: register setStep: 4 3)
				(scorpion setScript: threaten)
				(standAround setReal: standAround 20)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance threaten of Script
	(properties)

	(method (dispose)
		(mySound stop:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (Random 0 2) 1)
					(gKqSound1 number: 14591 setLoop: 1 play:)
				)
				(mySound number: 1451 setLoop: -1 play:)
				(scorpion view: 1450 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(mySound stop:)
				(= seconds 2)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance wavePeticoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 1451) ; WAVE
				(Load rsVIEW 1453)
				(gEgo view: 801 setMotion: PolyPath 35 135 self)
			)
			(1
				(proc11_3 gEgo scorpion self)
			)
			(2
				(gEgo view: 1453 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(gKqSound1 number: 1451 setLoop: -1 play:)
				(scorpion view: 1453 setLoop: 1 setCel: 0 setCycle: CT 6 1 self)
			)
			(4
				(gKqSound1 number: 820 setLoop: 1 play:)
				(scorpion setCycle: End self)
			)
			(5
				(gKqSound1 number: 820 setLoop: 1 play:)
				(scorpion setCycle: CT 6 -1 self)
			)
			(6
				(scorpion setCycle: Beg self)
			)
			(7
				(gEgo normalize: 6)
				(= cycles 2)
			)
			(8
				(if (IsFlag 45)
					(self cue:)
				else
					(SetFlag 45)
					(gMessager say: 1 6 1 0 self) ; "That was too close for me!"
				)
			)
			(9
				(scorpion setScript: threaten)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 6)
			)
			(1
				(gKqSound1 number: 1462 setLoop: 1 play:)
				(lightShaft init: setCycle: End self)
			)
			(2
				(= seconds 3)
			)
			(3
				(gGame handsOn:)
				(gCurRoom newRoom: 1460)
			)
		)
	)
)

(instance leavePyramid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: scorpion)
					(gEgo view: 801)
				)
				(gEgo
					ignoreActors: 1
					setCycle: StopWalk -1
					setMotion: PolyPath 28 95 self
				)
			)
			(1
				(gCurRoom newRoom: 1250)
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
				(gEgo setMotion: PolyPath 68 110 self)
			)
			(1
				(gEgo
					posn: 71 111
					view: 8071
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo get: 1) ; Ripped_Petticoat
				((gInventory at: 1) setHotspot: 0 11) ; Ripped_Petticoat, Stick
				(peticoat dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo posn: 68 110 normalize: 1)
				(= cycles 2)
			)
			(4
				(gEgo setHeading: 90 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showComb of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8103 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(= ticks 60)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 3)
				(self dispose:)
			)
		)
	)
)

(instance scorpEnters of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(scorpion
					init:
					posn: 90 99
					view: 14570
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
				(proc11_3 gEgo scorpion)
			)
			(1
				(gEgo disableHotspot:)
				(scorpion setScript: chap5Threaten)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chap5Threaten of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(scorpion
					posn: 110 89
					view: 14570
					setLoop: 1
					setCel: 0
					cycleSpeed: 10
					setCycle: RandCycle -1 self 0
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance scorpDeath of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (scorpion script:)
					(scorpion setScript: 0)
				)
				(self cue:)
			)
			(1
				(EgoDead 48 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shootScorp of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (scorpion script:)
					(scorpion setScript: 0)
				)
				(gEgo
					setScale: 0
					view: 14590
					setLoop: 0
					setCel: 0
					setCycle: CT 11 1 self
				)
			)
			(1
				(gKqSound1 number: 1464 setLoop: 1 play:)
				(charge
					init:
					posn: 244 75
					view: 14590
					setPri: 200
					setLoop: 1
					setCel: 0
					cycleSpeed: 14
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: End self)
				(charge dispose:)
				(gKqSound1 number: 1465 setLoop: 1 play:)
				(scorpion
					posn: 90 99
					view: 14570
					setLoop: 0
					setCel: 12
					setCycle: Beg self
				)
			)
			(3 0)
			(4
				(gEgo normalize: 1 setScaler: Scaler 98 54 114 73)
				(scorpion dispose:)
				(gEgo enableHotspot:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance touchLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8103 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chargeCrystal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8103 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(charge
					init:
					setPri: (+ (lightShaft priority:) 1)
					cycleSpeed: 13
					setCycle: End self
				)
				(gKqSound1 number: 1463 setLoop: 1 play:)
			)
			(2
				(charge dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(SetFlag 214)
				((gInventory at: 71) view: 371 cView: 991 cLoop: 1 cCel: 15) ; Crystal_Shaft
				(gTheInvCursor view: 991 loop: 1 cel: 15)
				(gEgo normalize: 3)
				(lightShaft setHotspot: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stabScorp of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (scorpion script:)
					(scorpion setScript: 0)
				)
				(scorpion setPri: 200)
				(gEgo
					setScale: 0
					posn: 275 93
					view: 14600
					setLoop: 0
					setCel: 8
					setCycle: CT 15 1 self
				)
			)
			(1
				(gKqSound1 number: 821 setLoop: 1 play:)
				(mySound number: 1466 setLoop: 1 play:)
				(gEgo setCycle: End self)
				(scorpion
					posn: 95 111
					view: 14600
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(2 0)
			(3
				(EgoDead 48 self)
			)
			(4
				(scorpion setPri: 85 setScript: chap5Threaten)
				(gEgo
					posn: 249 94
					normalize: 1
					setScaler: Scaler 98 54 114 73
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance touchScorp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 153 106 self)
				(scorpion setPri: 200)
			)
			(1
				(gEgo normalize: 1)
				(scorpion
					posn: 95 111
					view: 14600
					setLoop: 1
					setCel: 0
					setCycle: CT 10 1 self
				)
			)
			(2
				(gKqSound1 number: 821 setLoop: 1 play:)
				(gEgo
					setScale: 0
					posn: 279 96
					view: 14600
					setLoop: 0
					setCel: 34
					setCycle: End self
				)
				(scorpion setCycle: End self)
			)
			(3 0)
			(4
				(EgoDead 48 self)
			)
			(5
				(scorpion setPri: 85 setScript: chap5Threaten)
				(gEgo
					posn: 249 94
					setScaler: Scaler 98 54 114 73
					normalize: 1
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance scorpion of Actor
	(properties
		noun 1
		x 100
		y 129
		view 1450
		cel 17
		signal 4129
	)

	(method (init)
		(super init: &rest)
		(self setPri: 85)
		(cond
			((not (IsFlag 20))
				(self view: 1450 setLoop: 0 setCel: 0 setHotspot: 8 13 10 26 6) ; Do, Flag, Exit, Bug_Reducing_Powder, Ripped_Petticoat
			)
			((IsFlag 20)
				(self
					posn: 95 129
					view: 1455
					setLoop: 0
					setCel: 0
					setPri: -1
					setCycle: Fwd
					setHotspot: 0
				)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== (self script:) threaten)
			(self setScript: 0)
		)
		(switch theVerb
			(13 ; Flag
				(standAround seconds: 0 client: 0 delete: dispose:)
				(gCurRoom setScript: waveFlag)
			)
			(26 ; Bug_Reducing_Powder
				(standAround seconds: 0 client: 0 delete: dispose:)
				(Load 140 1453) ; WAVE
				(gCurRoom setScript: reduceScorp)
			)
			(6 ; Ripped_Petticoat
				(gCurRoom setScript: wavePeticoat)
			)
			(5 ; Golden_Comb
				(gCurRoom setScript: stungScript)
			)
			(else
				(if (not (IsFlag 20))
					(if (== gChapter 5)
						(gCurRoom setScript: touchScorp)
					else
						(gCurRoom setScript: stungScript)
					)
				)
			)
		)
	)
)

(instance lightShaft of Prop
	(properties
		approachX 249
		approachY 94
		x 282
		y 3
		view 1457
	)

	(method (init)
		(super init: &rest)
		(self setPri: 90 approachVerbs: 8 10 87) ; Do, Exit, Crystal_Shaft
		(if (and (== gValOrRoz -4) (not (IsFlag 214))) ; Val
			(self setHotspot: 8 10 87) ; Do, Exit, Crystal_Shaft
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: touchLight)
			)
			(87 ; Crystal_Shaft
				(gCurRoom setScript: chargeCrystal)
			)
		)
	)
)

(instance charge of Prop
	(properties
		x 249
		y 56
		view 14580
	)
)

(instance peticoat of View
	(properties
		x 38
		y 104
		view 1303
		loop 3
	)

	(method (init)
		(super init: &rest)
		(if (and (!= gChapter 4) (not (IsFlag 20)))
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self setPri: 125)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: getPeticoat)
		)
	)
)

(instance altar of Feature
	(properties
		nsLeft 209
		nsTop 58
		nsRight 272
		nsBottom 84
		sightAngle 20
		approachX 245
		approachY 97
		x 245
		y 84
	)

	(method (init)
		(super init: &rest)
		(if (== gChapter 1)
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom newRoom: 1460)
			)
		)
	)
)

(instance exitPyramid of ExitFeature
	(properties
		nsLeft 24
		nsRight 75
		nsBottom 95
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(if (gCast contains: scorpion)
					(gCurRoom setScript: leavePyramid)
				else
					(self approachX: 28 approachY: 95 approachVerbs: 10 8) ; Exit, Do
					(super handleEvent: event)
				)
				(event claimed: 1)
				(return)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: leavePyramid)
	)
)

(instance godFace of Feature
	(properties
		noun 2
		nsLeft 274
		nsTop 1
		nsRight 293
		nsBottom 8
		sightAngle 5
		x 335
		y 75
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gEgo view: 800 setStep: 3 2)
				(gMessager say: noun theVerb 2 0) ; "That eye looks like it could open further."
			)
		)
	)
)

(instance mySound of Sound
	(properties)
)

(instance standAround of Timer
	(properties)

	(method (cue)
		(cond
			((IsFlag 20)
				(self seconds: 0 client: 0 delete: dispose:)
			)
			((or (gEgo script:) (gCurRoom script:))
				(self setReal: self 10)
			)
			(else
				(= local0 1)
				(self client: 0 seconds: 0 delete: dispose:)
			)
		)
	)
)

(instance stuckSoundManager of Code
	(properties)

	(method (doit &tmp temp0)
		(switch (= temp0 (Random 0 2))
			(0
				(mySound number: 1459 setLoop: 1 play:)
			)
			(1
				(mySound number: 14590 setLoop: 1 play:)
			)
			(2
				(mySound number: 14591 setLoop: 1 play:)
			)
		)
	)
)

