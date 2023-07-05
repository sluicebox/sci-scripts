;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use AnimatePrint)
(use KQ6Room)
(use Kq6Talker)
(use CartoonScript)
(use n913)
(use Messager)
(use Motion)
(use Actor)
(use System)

(public
	rm140 0
)

(local
	local0
	local1
	local2
	[local3 35] = [285 48 0 262 60 1 238 73 2 222 83 3 201 92 4 177 105 5 -99 159 109 0 146 114 1 139 116 2 -99 139 116 0 -1 -1 -1]
	[local38 31] = [139 116 0 139 116 1 146 114 2 -99 159 109 0 177 105 1 201 92 2 222 83 3 238 73 4 262 60 5 -1 -1 -1]
	local69 = -1
	local70
	local71
	local72
)

(instance rm140 of KQ6Room
	(properties
		picture 140
		horizon 0
	)

	(method (init)
		(super init: &rest)
		(= local72 gMessager)
		(= gMessager localMessager)
		(gTheIconBar disable:)
		(SetFlag 59)
		(singSing init:)
		(leftArm init:)
		(= local0 ((gInventory at: 47) owner:)) ; poem
		(= local1 ((gInventory at: 39) owner:)) ; royalRing
		(= local2 ((gInventory at: 38) owner:)) ; rose
		(cond
			((== local0 gCurRoomNum)
				(self setScript: poemSegueScr)
			)
			((== local2 gCurRoomNum)
				(self setScript: roseSegueScr)
			)
			((== local1 gCurRoomNum)
				(self setScript: ringSegueScr)
			)
		)
		(gGlobalSound4 fade:)
		(gGlobalSound3 number: 140 loop: -1 play:)
	)

	(method (dispose)
		(= gMessager local72)
		(ClearFlag 59)
		(DisposeScript 371)
		(super dispose: &rest)
		(gTheIconBar enable:)
	)
)

(instance cassyPrint of AnimatePrint ; UNUSED
	(properties)

	(method (init)
		(= myMouth cassyMouth)
		(= x -1)
		(= y 15)
		(super init:)
	)
)

(instance singSingEnterScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 40] temp40 temp41 temp42)
		(switch (= state newState)
			(0
				(switch register
					(0
						(followItem view: 1412)
					)
					(2
						(followItem view: 1411)
					)
					(1
						(followItem view: 1414)
					)
				)
				(leftArm setCycle: End)
				(++ state)
				(followItem init:)
				(self cue:)
			)
			(1
				(= ticks 15)
			)
			(2
				(if (!= [local3 (++ local69)] -1)
					(-= state 2)
					(if (== [local3 local69] -99)
						(singSing loop: (+ (singSing loop:) 1))
						(followItem loop: (+ (followItem loop:) 1))
						(++ local69)
					)
					(= temp40 [local3 local69])
					(= temp41 [local3 (++ local69)])
					(= temp42 [local3 (++ local69)])
					(singSing posn: temp40 temp41 cel: temp42)
					(followItem posn: temp40 temp41 cel: temp42)
				)
				(self cue:)
			)
			(3
				(cHead init: 0)
				(= seconds 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance singSingLeaveScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(if (not local71)
					(leftArm view: 1401 loop: 0 cel: 2)
					(rightArm dispose:)
				)
				(switch register
					(1
						(followItem init: loop: 1 view: 1413)
					)
					(2
						(followItem init: view: 1411 loop: 3)
					)
					(else
						(= register 0)
					)
				)
				(= local69 -1)
				(singSing loop: 3)
				(++ state)
				(self cue:)
			)
			(1
				(= ticks 20)
			)
			(2
				(if (!= [local38 (++ local69)] -1)
					(-= state 2)
					(if (== [local38 local69] -99)
						(singSing loop: (+ (singSing loop:) 1))
						(if register
							(followItem loop: (+ (followItem loop:) 1))
						)
						(++ local69)
					)
					(= temp0 [local38 local69])
					(= temp1 [local38 (++ local69)])
					(= temp2 [local38 (++ local69)])
					(singSing posn: temp0 temp1 cel: temp2)
					(if register
						(followItem posn: temp0 temp1 cel: temp2)
					)
				)
				(self cue:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance ringSegueScr of CartoonScript
	(properties)

	(method (changeState newState)
		(if script
			(script dispose:)
		)
		(switch (= state newState)
			(0
				(self setScript: singSingEnterScr self 0)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 1 0 1 1 self) ; "(SWEET BUT SAD) Sing Sing! What have you got in your mouth, my pretty?"
			)
			(3
				(= ticks 12)
			)
			(4
				(rightArm init:)
				(followItem dispose:)
				(leftArm view: 1422 loop: 0 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 1 0 1 2 self) ; "(CONFUSED, SHOCKED, THEN EXCITED) A gold ring? Sing Sing, where did you get this? 'Realm of Daventry....?' But, this is Alexander's ring! Oh, my soul, he must be here!"
			)
			(8
				(= cycles 2)
			)
			(9
				(gMessager say: 1 0 1 3 self) ; "(EXCITED, WISHFUL) Sing Sing, I wish you could tell me what you've seen! Is he really here, then; on this very island? Oh, if only I could leave this castle as easily as you!"
			)
			(10
				(cHead dispose:)
				(= ticks 12)
			)
			(11
				(leftArm loop: 1 cel: 0 setCycle: End self)
			)
			(12
				(= ticks 30)
			)
			(13
				(gMessager say: 1 0 1 4 self) ; "(EXCITED, BUT WORRIED) Take this ribbon, Sing Sing. If you know where he is, return it to him!"
			)
			(14
				(= ticks 12)
			)
			(15
				(leftArm view: 1423 loop: 0 cel: 0 setCycle: End self)
			)
			(16
				(= cycles 2)
			)
			(17
				(if (and (== local2 210) (== local0 210))
					(gMessager say: 1 0 8 1 self) ; "(SAD, WORRIED) Once you've delivered the ribbon, find a new place to hide. I don't want Alexander endangered any more than he already is. If Alexander is seen with you, Abdul will surely take revenge!"
				else
					(gMessager say: 1 0 1 5 self) ; "(WORRIED, WHISPERING) Please be careful, Alexander. It is so dangerous, and yet...I could not wish you away."
				)
			)
			(18
				(self setScript: singSingLeaveScr self 1)
			)
			(19
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance roseSegueScr of CartoonScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: singSingEnterScr self 1)
			)
			(1
				(= cycles 2)
			)
			(2
				(= register
					(cond
						((and (!= local1 210) (!= local0 210)) 5)
						((and (!= local1 210) (== local0 210)) 6)
						(else 4)
					)
				)
				(self cue:)
			)
			(3
				(rightArm init:)
				(followItem dispose:)
				(leftArm view: 1424 loop: 0 cel: 0)
				(if (== register 4)
					(cHead init: 0)
					(leftArm setCycle: End self)
				else
					(cHead init: 1)
					(= local71 1)
					(leftArm setCycle: CT 1 1 self)
				)
			)
			(4
				(= ticks 30)
			)
			(5
				(if (!= register 4)
					(= state 10)
					(gMessager say: 1 0 register 1 self)
				else
					(leftArm setPri: 15)
					(leftArm setCycle: Beg self)
				)
			)
			(6
				(gMessager say: 1 0 register 1 self)
			)
			(7
				(if (== register 4)
					(cHead init: 0)
				)
				(= cycles 2)
			)
			(8
				(if (!= local0 210)
					(= state 10)
					(gMessager say: 1 0 9 1 self) ; "Be careful, Sing Sing! Do not allow anyone to see you with Alexander!"
				else
					(gMessager say: 1 0 register 2 self)
				)
			)
			(9
				(= cycles 2)
			)
			(10
				(gMessager say: 1 0 register 3 self)
			)
			(11
				(if (gCast contains: cHead)
					(cHead dispose:)
				)
				(self setScript: singSingLeaveScr self)
			)
			(12
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance poemSegueScr of CartoonScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: singSingEnterScr self 2)
			)
			(1
				(= register (if (!= local1 210) 3 else 2))
				(= cycles 2)
			)
			(2
				(gMessager say: 1 0 register 1 self)
			)
			(3
				(= ticks 25)
			)
			(4
				(leftArm view: 1421 loop: 0 cel: 0 setCycle: End self)
				(followItem dispose:)
				(rightArm init:)
				(if (!= local1 210)
					(cHead init: 1)
				)
			)
			(5
				(gMessager say: 1 0 register 2 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 1 0 register 3 self)
				(if (== register 3)
					(+= state 9)
				)
			)
			(8
				(= cycles 2)
			)
			(9
				(cHead init: 2)
				(gMessager say: 1 0 register 4 self 140)
			)
			(10
				(= cycles 2)
			)
			(11
				(if (== local2 210)
					(gMessager say: 1 0 7 1 self) ; "I was hoping he'd return to you. Take this to him, my fleet one, then find some new place to hide! It isn't safe for him to be seen with you, however precious his messages! Now, go!"
				else
					(gMessager say: 1 0 register 5 self)
				)
			)
			(12
				(leftArm loop: 1 cel: 0 setCycle: End self)
			)
			(13
				(= ticks 20)
			)
			(14
				(leftArm setCycle: Beg self)
			)
			(15
				(= cycles 2)
			)
			(16
				(leftArm loop: 0 cel: 0)
				(= ticks 30)
			)
			(17
				(cHead dispose:)
				(self
					setScript:
						singSingLeaveScr
						self
						(if (OneOf register 7 2) 2 else 0)
				)
			)
			(18
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance singSing of Actor
	(properties
		x 285
		y 48
		view 141
		loop 1
		signal 16384
		illegalBits 0
	)

	(method (init)
		(super init: &rest)
		(self loop: 0 setPri: 14)
	)
)

(instance leftArm of Prop
	(properties
		x 87
		y 161
		view 1401
		signal 16384
	)
)

(instance rightArm of Prop
	(properties
		x 142
		y 157
		view 1401
		loop 1
		signal 16384
	)
)

(instance followItem of Actor
	(properties
		view 1412
		priority 15
		signal 16400
		illegalBits 0
	)
)

(instance cassyMouth of Prop
	(properties
		x 106
		y 97
		view 142
		loop 3
		signal 16384
	)
)

(instance cassyMouth2 of Prop
	(properties
		x 122
		y 82
		view 140
		loop 1
		signal 16384
	)
)

(instance cHead of Prop
	(properties
		x 91
		y 55
		view 142
		loop 2
	)

	(method (init param1)
		(= loop
			(switch param1
				(0 0)
				(1 1)
				(2 2)
			)
		)
		(super init: &rest)
	)
)

(instance localMessager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(= temp0
			(switch param1
				(28 Cassima)
				(99 gNarrator)
			)
		)
	)
)

(instance Cassima of Kq6Talker
	(properties
		x 5
		y 5
		view 891
		talkWidth 213
		textX 79
		textY 8
	)

	(method (init)
		(if (gCast contains: cHead)
			(= cel 1)
			(self x: 94 y: 87 textX: -60 textY: 30)
			(super init: 0 0 cassyMouth &rest)
		else
			(= cel 1)
			(self x: 97 y: 85 textX: -60 textY: 30)
			(super init: 0 0 cassyMouth2 &rest)
		)
	)
)

