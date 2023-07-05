;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm160 0
)

(local
	local0 = -1
	local1 = -1
	local2 = -1
	local3
	local4
	[local5 4]
	[local9 4] = [11 89 220 306]
	[local13 4] = [47 35 40 72]
	[local17 4] = [0 2 2 0]
	[local21 4]
	[local25 4] = [184 196 55 27]
	[local29 4] = [75 86 135 160]
	[local33 4] = [2048 1024 4096 8192]
	local37
	local38
	local39
)

(instance rm160 of Rm
	(properties
		noun 16
		picture 160
		north 180
		south 140
	)

	(method (init)
		(= local38 (IsFlag 41))
		(gCMusic number: 6 setLoop: -1 play:)
		(super init:)
		(hanoiPuzzle init:)
		(sarcPuzzle init:)
		(cartPuzzle init:)
		(lamps init:)
		(for ((= local3 0)) (< local3 4) ((++ local3))
			(= [local5 local3]
				((Prop new:)
					view: 160
					x: [local9 local3]
					y: [local13 local3]
					noun: 15
					signal: 16384
					init:
					hide:
					yourself:
				)
			)
		)
		(for ((= local3 0)) (< local3 4) ((++ local3))
			(= [local21 local3]
				((snakeProp new:)
					x: [local25 local3]
					y: [local29 local3]
					onMeCheck: [local33 local3]
					init:
					stopUpd:
					yourself:
				)
			)
		)
		(sarcophagus init:)
		(bowl init:)
		(door1 y: (if (IsFlag 41) 15 else 63) setLoop: 12 init: stopUpd:)
		(door2 y: (if (IsFlag 41) 15 else 63) setLoop: 13 init: stopUpd:)
		(lid init: stopUpd:)
		(redSkeleton
			loop: (if (IsFlag 40) 14 else 5)
			cel: (if (IsFlag 40) 4 else 0)
			init:
			stopUpd:
		)
		(if (IsFlag 40)
			(disks init:)
		)
		(screen init: stopUpd:)
		(if (not (IsFlag 39))
			(ticket init: stopUpd:)
		)
		(face init: stopUpd:)
		(theSwitch init: stopUpd:)
		(microscopeLight init:)
		(LoadMany rsSOUND 115 116 119 125 126 127 257)
	)

	(method (dispose)
		(if (!= local0 -1)
			((ScriptID 169 0) dispose:) ; hanoi
		)
		(if (!= local1 -1)
			((ScriptID 175 0) dispose:) ; sarc
		)
		(if (!= local2 -1)
			((ScriptID 165 0) dispose:) ; cartesian
		)
		(DisposeScript 165)
		(DisposeScript 175)
		(DisposeScript 169)
		(super dispose: &rest)
	)

	(method (doit)
		(Palette palANIMATE 231 236 12)
		(super doit:)
	)
)

(instance hanoiPuzzle of Feature
	(properties
		noun 6
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(37
					(gCurRoom setScript: placeDisk)
				)
				(4
					(cond
						((gEgo has: 10)
							(gCurRoom setScript: placeDisk)
							(return 0)
						)
						((not (IsFlag 6))
							(gMessager say: noun theVerb 10) ; "If only you had some disks, you could play this puzzle."
							(return 0)
						)
						((< local0 0)
							(= local0 global114)
							((ScriptID 169 0) init:) ; hanoi
						)
						((!= local0 global114)
							(= local0 global114)
							((ScriptID 169 0) dispose: init:) ; hanoi
						)
					)
					(switch ((ScriptID 169 0) show:) ; hanoi
						(1
							((ScriptID 169 0) dispose:) ; hanoi
							(= local0 -1)
							(if (not (IsFlag 41))
								(gCurRoom setScript: hanoiWin)
								(SetFlag 41)
							)
						)
						(2 0)
						(0)
					)
				)
				(1
					(cond
						((not (IsFlag 6))
							(gMessager say: noun theVerb 10) ; "This is Dr. Brain's Tower of Hanoi puzzle. Now where did those stone disks go? They're probably around here somewhere."
						)
						((IsFlag 4)
							(gMessager say: noun theVerb 13) ; "The Tower of Hanoi has been solved."
						)
						(else
							(gMessager say: noun theVerb) ; "Although the disks are there, the Tower of Hanoi puzzle still needs to be finished."
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance sarcPuzzle of Feature
	(properties
		noun 5
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(28
					(if (IsFlag 42)
						(sarcPuzzle doVerb: theVerb)
					else
						(gCurRoom setScript: enterNumbers)
					)
				)
				(4
					(cond
						((gEgo has: 2)
							(gCurRoom setScript: enterNumbers)
							(return 0)
						)
						((< local1 0)
							(= local1 global114)
							((ScriptID 175 0) init:) ; sarc
						)
						((!= local1 global114)
							(= local1 global114)
							((ScriptID 175 0) dispose: init:) ; sarc
						)
					)
					(switch ((ScriptID 175 0) show: (IsFlag 7)) ; sarc
						(1
							((ScriptID 175 0) dispose:) ; sarc
							(= local1 -1)
							(if (not (IsFlag 40))
								(gCurRoom setScript: sarcWin)
								(SetFlag 40)
							)
						)
						(0)
						(2
							((ScriptID 175 0) dispose:) ; sarc
							(= local1 -1)
						)
					)
				)
				(1
					(cond
						((not (IsFlag 7))
							(gMessager say: noun theVerb 3) ; "The sarcophagus is locked. But why are there no numbers on the lock?"
						)
						((IsFlag 6)
							(gMessager say: noun theVerb 13) ; "You have successfully solved the Sarcophagus Lock Puzzle. Perhaps you'd like to try again at another level?"
						)
						(else
							(gMessager say: noun theVerb) ; "Although the old sarcophagus looks peaceful enough, who knows what'll happen when it's open."
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance cartPuzzle of Feature
	(properties
		noun 11
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(4
					(cond
						((not local37)
							(gMessager say: noun theVerb) ; "Hmmm. The large microscope feels cold to the touch. The |c0|red button|c| on the side turns it on."
							(return 0)
						)
						((< local2 0)
							(= local2 global114)
							((ScriptID 165 0) init:) ; cartesian
						)
						((!= local2 global114)
							(= local2 global114)
							((ScriptID 165 0) dispose: init:) ; cartesian
						)
					)
					(switch ((ScriptID 165 0) show:) ; cartesian
						(1
							((ScriptID 165 0) dispose:) ; cartesian
							(= local2 -1)
							(if (not (IsFlag 39))
								(gCurRoom setScript: cartWin)
								(SetFlag 39)
							)
						)
						(2 0)
						(0 0)
					)
				)
				(1
					(cond
						((not local37)
							(gMessager say: noun theVerb 11) ; "Hmmm. The microscope seems to be turned off right now. Press the |c0|red button|c| on the side."
						)
						((IsFlag 7)
							(gMessager say: noun theVerb 13) ; "You've solved Dr. Brain's Cartesian Microscope Puzzle. Perhaps you'd like to play again at another level?"
						)
						(else
							(gMessager say: noun theVerb) ; "This is Dr. Brain's Microscope. Lay your hands on it."
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance lamps of Feature
	(properties
		noun 15
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not local4)
					(rm160 setScript: turnLampsOn)
					(= local4 1)
				else
					(for ((= local3 0)) (< local3 4) ((++ local3))
						([local5 local3] hide:)
					)
					(= local4 0)
				)
			)
			(1
				(if local4
					(gMessager say: noun theVerb) ; "These cave torches are truly in the limelight."
				else
					(gMessager say: noun theVerb 5) ; "To conserve energy, Dr. Brain turns his cave torches off when he leaves the cave."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sarcophagus of Feature
	(properties
		noun 5
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(28
				(if (IsFlag 42)
					(sarcPuzzle doVerb: theVerb)
				else
					(gCurRoom setScript: enterNumbers)
				)
			)
			(1
				(if (IsFlag 6)
					(gMessager say: noun theVerb 2) ; "On this side of the sarcophagus is a strange carved face. Those who created the sarcophagus thought it would keep away evil spirits."
				else
					(gMessager say: noun theVerb) ; "Although the old sarcophagus looks peaceful enough, who knows what'll happen when it's open."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bowl of Feature
	(properties
		noun 14
		onMeCheck 64
	)
)

(instance door1 of Actor
	(properties
		x 152
		noun 8
		onMeCheck 32
		view 160
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (IsFlag 4)
					(gCurRoom newRoom: 180)
				else
					(gMessager say: noun theVerb) ; "You can't open the door that way. It's solid steel! Even with a blow torch, it would probably take you a year to cut through it. Find another way to open the door."
				)
			)
			(1
				(if (IsFlag 4)
					(gMessager say: noun theVerb 2) ; "You may now slip surreptitiously out the back of the cave."
				else
					(gMessager say: noun theVerb) ; "You examine the large steel door at the back of the cave. You notice there's no lock on it."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance door2 of Actor
	(properties
		x 158
		noun 8
		view 160
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

(instance lid of Prop
	(properties
		x 4
		y 94
		noun 17
		view 160
		loop 4
		cel 2
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (IsFlag 6)
					(self setScript: toggleLid)
				else
					(gMessager say: noun theVerb 4 0 0 gCurRoomNum) ; "The lid to the sarcophagus is stuck. Perhaps it's locked."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance redSkeleton of Prop
	(properties
		x 55
		y 93
		noun 18
		onMeCheck 128
		view 160
		priority 3
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (< local39 4)
					(++ local39)
					(gMessager say: noun theVerb 0 local39)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 102
		y 156
		noun 19
		view 160
		loop 11
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if local37
					(cartPuzzle doVerb: theVerb &rest)
				else
					(gMessager say: noun theVerb 5 0 0 gCurRoomNum) ; "Please turn the microscope on first before using it. Press the |c0|red button|c| above the screen."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ticket of Prop
	(properties
		x 146
		y 155
		noun 21
		view 160
		loop 10
		priority 13
		signal 16400
	)
)

(instance face of Prop
	(properties
		x 235
		y 122
		noun 13
		onMeCheck 512
		view 160
		loop 8
		cel 3
		signal 16384
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(self setScript: changeFace)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance theSwitch of Prop
	(properties
		x 123
		y 144
		noun 20
		view 160
		loop 7
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if local37
					(self setScript: turnScreenOff)
				else
					(self setScript: turnScreenOn)
				)
				(= local37 (not local37))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance microscopeLight of Prop
	(properties
		x 134
		y 125
		noun 1
		view 160
		loop 6
	)
)

(instance snakeProp of Prop
	(properties
		noun 14
		view 160
		loop 9
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(self setScript: (snakeUp new:) 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance disks of View
	(properties
		x 238
		y 65
		view 160
		loop 12
		cel 1
		signal 16384
	)

	(method (onMe)
		(return 0)
	)
)

(instance turnLampsOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 257 setLoop: 1 play:)
				(for ((= local3 0)) (< local3 4) ((++ local3))
					([local5 local3] setLoop: [local17 local3] setCel: 0 show:)
				)
				(= ticks 10)
			)
			(1
				(for ((= local3 0)) (< local3 4) ((++ local3))
					([local5 local3]
						setLoop: (+ [local17 local3] 1)
						setCycle: Fwd
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance snakeS of Sound
	(properties)
)

(instance snakeUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(snakeS number: 116 setLoop: 1 play:)
				(register startUpd: setCycle: End self)
			)
			(1
				(register setCycle: Beg self)
			)
			(2
				(register stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance changeFace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(face startUpd: setCycle: Beg self)
			)
			(1
				(= ticks 150)
			)
			(2
				(face setCycle: End self)
			)
			(3
				(face stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance turnScreenOn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theSwitch startUpd: setCycle: End self)
			)
			(1
				(gCSoundFX number: 176 setLoop: 1 play: 127)
				(microscopeLight setCycle: End)
				(screen startUpd: setCycle: End self)
			)
			(2
				(screen stopUpd:)
				(theSwitch stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance turnScreenOff of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theSwitch startUpd: setCycle: Beg self)
			)
			(1
				(gCSoundFX number: 114 setLoop: 1 play: 127)
				(microscopeLight setCycle: Beg)
				(screen startUpd: setCycle: Beg self)
			)
			(2
				(screen stopUpd:)
				(theSwitch stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance cartWin of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 115 setLoop: 1 play:)
				(ticket startUpd: setCycle: End self)
			)
			(1
				(gMessager say: 11 20 0 0 self) ; "You take the receipt from the microscope."
			)
			(2
				(ticket dispose:)
				(gEgo get: 2)
				(proc5_12 2)
				(gGame setCursor: gTheCursor 1 144 164)
				(self dispose:)
			)
		)
	)
)

(instance sarcWin of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 125 setLoop: 1 play:)
				(lid startUpd:)
				(if (lid cel:)
					(lid setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(1
				(lid stopUpd:)
				(gCSoundFX number: 119 setLoop: 1 play:)
				(redSkeleton startUpd: setPri: 13 setCycle: End self)
			)
			(2
				(gMessager say: 5 20 0 0 self) ; "You take the stone disks from the friendly and smelly skeleton."
			)
			(3
				(= ticks 30)
			)
			(4
				(redSkeleton loop: 14 cel: 0)
				(= ticks 45)
				(gEgo get: 10)
				(proc5_12 10)
				(gGame setCursor: gTheCursor 1 47 84)
			)
			(5
				(redSkeleton setCycle: End self)
			)
			(6
				(redSkeleton setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance hanoiWin of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 127 setLoop: 1 play:)
				(door2 startUpd: setMotion: MoveTo (door2 x:) (- (door2 y:) 48))
				(door1
					startUpd:
					setMotion: MoveTo (door1 x:) (- (door1 y:) 48) self
				)
			)
			(1
				(door1 stopUpd:)
				(door2 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance toggleLid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 124 setLoop: 1 play:)
				(lid startUpd:)
				(if (lid cel:)
					(lid setCycle: Beg)
				else
					(lid setCycle: End)
				)
			)
			(1
				(lid stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance enterNumbers of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 42)
				(gMessager say: 5 28 0 0 self) ; "You insert the receipt from the microscope into the slot on the Sarcophagus."
			)
			(1
				(gCSoundFX number: 115 setLoop: 1 play:)
				(ticket x: 47 y: 106 loop: 15 cel: 0 init: setCycle: End self)
			)
			(2
				(gEgo put: 2)
				(proc0_1)
				(ticket dispose:)
				(= cycles 2)
			)
			(3
				(sarcPuzzle doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance placeDisk of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 6 37 0 0 self) ; "You place the disks from the Sarcophagus on the left pole."
			)
			(1
				(gCSoundFX number: 126 setLoop: 1 play:)
				(gEgo put: 10)
				(proc0_1)
				(disks init:)
				(= cycles 10)
			)
			(2
				(hanoiPuzzle doVerb: 4)
				(self dispose:)
			)
		)
	)
)

