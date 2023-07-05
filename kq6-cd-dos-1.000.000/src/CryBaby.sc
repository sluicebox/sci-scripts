;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 481)
(include sci.sh)
(use Main)
(use Kq6Sound)
(use n913)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	proc481_0 0
	proc481_1 1
	takeBottleAway 2
	proc481_3 3
	cryMusic 4
	suckMusic 5
	proc481_6 6
	proc481_7 7
)

(local
	local0
	local1
	local2
	local3
)

(procedure (proc481_0)
	((ScriptID 480 5) register: 1) ; wallFlowerDance
	(gEgo setScript: takeBottleAway 0 (ScriptID 480 6)) ; myBottle
)

(procedure (proc481_1 param1 &tmp temp0)
	((ScriptID 480 5) register: 1) ; wallFlowerDance
	(if (not (IsFlag 118))
		(SetFlag 118)
		(gGame givePoints: 2)
	)
	(switch param1
		(1
			(= local2 0)
			(= local3 12)
			((ScriptID 40 0) bottleSucker: 1) ; rWonder
			(gEgo setScript: giveBabyBottle 0 babyFace1)
		)
		(2
			(= local2 1)
			(= local3 11)
			((ScriptID 40 0) bottleSucker: 2) ; rWonder
			(gEgo setScript: giveBabyBottle 0 babyFace2)
		)
		(3
			(= local2 0)
			(= local3 9)
			((ScriptID 40 0) bottleSucker: 3) ; rWonder
			(gEgo setScript: giveBabyBottle 0 babyFace3)
		)
		(4
			(= local2 0)
			(= local3 7)
			((ScriptID 40 0) bottleSucker: 4) ; rWonder
			(gCurRoom setScript: giveBabyBottle 0 babyFace4)
		)
	)
)

(procedure (proc481_3 param1 &tmp temp0)
	((ScriptID 480 5) register: 1) ; wallFlowerDance
	(switch param1
		(1
			(gEgo setScript: getBabyTears 0 babyFace1)
		)
		(2
			(gEgo setScript: getBabyTears 0 babyFace2)
		)
		(3
			(gEgo setScript: getBabyTears 0 babyFace3)
		)
		(4
			(gEgo setScript: getBabyTears 0 babyFace4)
		)
	)
)

(procedure (proc481_6)
	(cryMusic stop: dispose:)
	(suckMusic stop: dispose:)
	(if (gCast contains: babyFace1)
		(babyFace1 setCycle: 0 dispose: delete:)
	)
	(if (gCast contains: babyFace2)
		(babyFace2 setCycle: 0 dispose: delete:)
	)
	(if (gCast contains: babyFace3)
		(babyFace3 setCycle: 0 dispose: delete:)
	)
	(if (gCast contains: babyFace4)
		(babyFace4 setCycle: 0 dispose: delete:)
	)
	(DisposeScript 481)
)

(procedure (proc481_7)
	(if (!= (babyFace1 bottleNum:) ((ScriptID 40 0) bottleSucker:)) ; rWonder
		(babyFace1 init: setCycle: Fwd)
	)
	(if (!= (babyFace2 bottleNum:) ((ScriptID 40 0) bottleSucker:)) ; rWonder
		(babyFace2 init: setCycle: Fwd)
	)
	(if (!= (babyFace3 bottleNum:) ((ScriptID 40 0) bottleSucker:)) ; rWonder
		(babyFace3 init: setCycle: Fwd)
	)
	(if (!= (babyFace4 bottleNum:) ((ScriptID 40 0) bottleSucker:)) ; rWonder
		(babyFace4 init: setCycle: Fwd)
	)
	(cryMusic setLoop: -1 play:)
	(suckMusic setLoop: -1 play:)
)

(class CryBaby of Prop
	(properties
		walkToX 0
		walkToY 0
		stoopX 0
		stoopY 0
		bottleNum 0
	)

	(method (dispose)
		(cryMusic stop: dispose:)
		(suckMusic stop: dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 57 58 59 60 96) ; fakeLamp6, fakeLamp4, fakeLamp3, fakeLamp2, fakeLamp1
			(if (== ((ScriptID 40 0) bottleSucker:) (self bottleNum:)) ; rWonder
				(gMessager say: 9 56 17 0 0 480) ; "That baby has nothing to offer Alexander for that lamp."
			else
				(gMessager say: 9 56 ((ScriptID 40 0) lampMsg:) 0 0 480) ; rWonder
			)
		else
			(switch theVerb
				(14 ; potion
					(gMessager say: 9 14 0 1 0 480) ; "Alexander shouldn't give that bottle of potion to the baby's tears! Who knows WHAT the potion will do?"
				)
				(5 ; Do
					(cond
						((== ((ScriptID 40 0) bottleSucker:) (self bottleNum:)) ; rWonder
							(gCurRoom
								setScript: takeBottleAway 0 (ScriptID 480 6) ; myBottle
							)
						)
						((== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
							(gMessager say: 9 5 15 1 0 480) ; "Alexander doesn't want to pick the baby's tears! They may not be done growing!"
						)
						(else
							(gMessager say: 9 5 18 1 0 480) ; "As much as Alexander might wish to comfort the crying babies, he feels a little awkward about picking them up. He's rather new at this."
						)
					)
				)
				(43 ; huntersLamp
					(cond
						((== ((ScriptID 40 0) bottleSucker:) (self bottleNum:)) ; rWonder
							(gMessager say: 9 43 17 1 0 480) ; "That baby has nothing to offer Alexander for that hunter's lamp."
						)
						((not (IsFlag 77))
							(gMessager say: 9 43 21 1 0 480) ; "Alexander has no reason to gather tears in that lamp."
						)
						((or (& global161 $0004) (IsFlag 144))
							(gMessager say: 9 43 20 1 0 480) ; "Alexander has already collected some tears. He doesn't need any more."
						)
						((& global161 $0001)
							(gMessager say: 9 43 13 1 0 480) ; "The hunter's lamp is full to the brim with fountain water. There's not even room enough for a few tears in there!"
						)
						((& global161 $0002)
							(gCurRoom setScript: getBabyTears 0 self)
						)
						((== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
							(gMessager say: 9 43 15 1 0 480) ; "The baby's tears don't have anything to offer Alexander for that hunter's lamp--at least, not at the moment."
						)
						(else
							(gCurRoom setScript: getBabyTears 0 self)
						)
					)
				)
				(1 ; Look
					(if (== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
						(gMessager say: 9 1 ((ScriptID 40 0) lampMsg:) 1 0 480) ; rWonder
					else
						(gMessager say: 9 1 16 1 0 480) ; "One of the babies is sucking happily on a bottle of milk while the others are spilling copious tears over their lack of the same."
					)
				)
				(2 ; Talk
					(if (== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
						(gMessager say: 9 2 ((ScriptID 40 0) lampMsg:) 0 0 480) ; rWonder
					else
						(gMessager say: 9 2 16 1 0 480) ; "Alexander can't make himself heard over the wailing of the baby's tears."
					)
				)
				(44 ; teaCup
					(cond
						((== ((ScriptID 40 0) bottleSucker:) (self bottleNum:)) ; rWonder
							(gMessager say: 9 44 17 1 0 480) ; "That baby has nothing to offer Alexander for that teacup."
						)
						((not (IsFlag 77))
							(gMessager say: 9 44 21 1 0 480) ; "There's no reason to collect the baby's tears' tears in that teacup."
						)
						(else
							(gMessager say: 9 44 22 1 0 480) ; "Why would Alexander want to put tears in a teaCUP?"
						)
					)
				)
				(24 ; sacredWater
					(if (== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
						(gMessager say: 9 24 15 1 0 480) ; "The baby's tears don't want the Oracle's sacred water."
					else
						(gMessager say: 9 24 16 1 0 480) ; "The Oracle's vial is already full and won't hold anything more--not even a few baby's tears."
					)
				)
				(else
					(self setScript: inventOnBaby 0 self)
				)
			)
		)
	)
)

(instance inventOnBaby of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(register walkToX:)
						(register walkToY:)
						self
				)
			)
			(1
				(= temp0
					(GetAngle
						(gEgo x:)
						(gEgo y:)
						(register x:)
						(register y:)
					)
				)
				(gEgo setHeading: temp0 self)
			)
			(2
				(= cycles 6)
			)
			(3
				(gMessager say: 9 0 16 0 self 480) ; "Would you babies be interested in this?"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance babyFace1 of CryBaby
	(properties
		x 51
		y 152
		noun 9
		modNum 480
		view 4803
		priority 12
		signal 16400
		walkToX 95
		walkToY 159
		stoopX 83
		stoopY 162
		bottleNum 1
	)
)

(instance babyFace2 of CryBaby
	(properties
		x 6
		y 147
		noun 9
		modNum 480
		view 4803
		loop 1
		priority 11
		signal 16400
		walkToX 55
		walkToY 153
		stoopX 36
		stoopY 157
		bottleNum 2
	)
)

(instance babyFace3 of CryBaby
	(properties
		x 35
		y 122
		noun 9
		modNum 480
		view 4803
		loop 2
		priority 9
		signal 16400
		walkToX 81
		walkToY 131
		stoopX 63
		stoopY 135
		bottleNum 3
	)
)

(instance babyFace4 of CryBaby
	(properties
		x 15
		y 107
		noun 9
		modNum 480
		view 4803
		loop 3
		priority 7
		signal 16400
		walkToX 62
		walkToY 116
		stoopX 43
		stoopY 119
		bottleNum 4
	)
)

(instance cryMusic of Kq6Sound
	(properties
		number 481
		loop -1
	)

	(method (check)
		(if (and local0 (DoAudio audPAUSE) (== (DoAudio audPOSITION) -1) (not gFastCast))
			(self play:)
		)
		(super check:)
	)

	(method (stop)
		(= local0 0)
		(super stop:)
	)

	(method (play)
		(= local0 1)
		(super play:)
	)
)

(instance suckMusic of Kq6Sound
	(properties
		number 485
		loop -1
	)
)

(instance giveBabyBottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= register babyFace2)
					(SetFlag 59)
				)
				(gEgo
					setMotion:
						PolyPath
						(register walkToX:)
						(register walkToY:)
						self
				)
			)
			(1
				(gEgo
					view: 4811
					setLoop: 1
					cel: 0
					posn: (register stoopX:) (register stoopY:)
					normal: 0
					cycleSpeed: 12
					setCycle: End self
				)
				(UnLoad 128 900)
			)
			(2
				(gMessager say: 9 62 0 1 self 480) ; "Alexander gives one of the baby's tears a bottle of milk."
			)
			(3
				(cryMusic setLoop: -1 play:)
				(suckMusic setLoop: -1 play:)
				((ScriptID 480 6) ; myBottle
					setLoop:
						(if (or (== register babyFace1) (== register babyFace2))
							1
						else
							0
						)
					x: (- (gEgo x:) 24)
					y: (- (gEgo y:) 10)
					z: 5
					setPri: local3
					init:
				)
				(if (IsFlag 77)
					((ScriptID 40 0) lampMsg: 22) ; rWonder
				else
					((ScriptID 40 0) lampMsg: 21) ; rWonder
				)
				(if (!= register babyFace1)
					(babyFace1 init: setCycle: Fwd)
				)
				(if (!= register babyFace2)
					(babyFace2 init: setCycle: Fwd)
				)
				(if (!= register babyFace3)
					(babyFace3 init: setCycle: Fwd)
				)
				(if (!= register babyFace4)
					(babyFace4 init: setCycle: Fwd)
				)
				(gEgo setLoop: 3 cycleSpeed: 3 setCycle: Beg self)
				(UnLoad 128 4811)
			)
			(4
				(gEgo posn: (register walkToX:) (register walkToY:) reset: 1)
				(= ticks 8)
			)
			(5
				(gMessager say: 9 62 0 2 self 480) ; "!!!Do sound effect.  "<whimper, whimper> wa! WAAAAA!!""
			)
			(6
				(gEgo setMotion: PolyPath 135 170 self)
			)
			(7
				(gMessager say: 9 62 0 3 self 480) ; "The other baby's tears seem to resent Alexander's gift, for some reason."
			)
			(8
				(cryMusic setLoop: -1 play:)
				(gGame handsOn:)
				(ClearFlag 59)
				(register hide:)
				(self dispose:)
			)
		)
	)
)

(instance getBabyTears of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(register walkToX:)
						(register walkToY:)
						self
				)
			)
			(1
				(gEgo
					view: 4811
					setLoop: 0
					cel: 0
					posn: (register stoopX:) (register stoopY:)
					normal: 0
					cycleSpeed: 6
					setCycle: End self
				)
				(UnLoad 128 900)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(|= global161 $0004)
				(gGame givePoints: 1)
				(gEgo reset: 1 posn: (register walkToX:) (register walkToY:))
				(UnLoad 128 4811)
				(= ticks 8)
			)
			(5
				(if (& global161 $0002)
					(gMessager say: 9 43 14 1 self 480) ; "Alexander collects some of the tears in the old hunter's lamp containing the Oracle's sacred water."
				else
					(gMessager say: 9 43 19 1 self 480) ; "Alexander collects some of the baby's tears' tears in the old hunter's lamp."
				)
			)
			(6
				(gEgo setMotion: PolyPath 135 170 self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeBottleAway of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(+ ((ScriptID 480 6) x:) 45) ; myBottle
						(+ ((ScriptID 480 6) y:) 1) ; myBottle
						self
				)
			)
			(1
				(gEgo
					view: 4811
					setLoop: 3
					setPri:
						(if local2
							-1
						else
							(+ ((ScriptID 480 6) priority:) 1) ; myBottle
						)
					cel: 0
					posn:
						(+ ((ScriptID 480 6) x:) 21) ; myBottle
						(+ ((ScriptID 480 6) y:) 6) ; myBottle
					normal: 0
					cycleSpeed: 12
					setCycle: End self
				)
				(UnLoad 128 900)
			)
			(2
				(gMessager say: 9 5 17 1 self 480) ; "What a grip! The baby is not at all willing to let go of that milk bottle!"
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(if (== ((ScriptID 40 0) bottleSucker:) 3) ; rWonder
					(= temp0 10)
				else
					(= temp0 1)
				)
				(gEgo
					reset: 1
					setPri: 15
					posn:
						(+ ((ScriptID 480 6) x:) 45) ; myBottle
						(+ ((ScriptID 480 6) y:) temp0) ; myBottle
					setMotion: PolyPath 135 170 self
				)
				(UnLoad 128 4811)
			)
			(5
				(gGame handsOn:)
				(gEgo setPri: -1)
				(self dispose:)
			)
		)
	)
)

