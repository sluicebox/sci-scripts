;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use BalloonTalker)
(use ADRoom)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm140 0
	fredTalker 19
)

(local
	[local0 200]
	local200
	local201
	[local202 200]
	[local402 22] = [1 4 13 36 5 17 0 13 10 11 8 13 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1]
	[local424 24] = [7 4 11 11 14 36 19 7 0 3 3 4 20 18 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1]
	[local448 73] = [1 4 13 9 0 12 8 13 36 5 17 0 13 10 11 8 13 38 36 18 4 11 5 36 3 4 19 4 17 12 8 13 0 19 8 14 13 37 4 16 20 0 11 8 19 24 37 3 4 12 14 2 17 0 2 24 36 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1]
	[local521 4] = [-1 -1 -1 -1]
	local525
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(= temp1 param1)
	(for ((= temp0 0)) (<= temp0 115) ((++ temp0))
		(switch temp1
			(0
				(= [local202 temp0] [local424 temp0])
			)
			(1
				(= [local202 temp0] [local402 temp0])
			)
			(2
				(= [local202 temp0] [local448 temp0])
			)
			(3
				(= [local202 temp0] [local521 temp0])
			)
		)
	)
)

(procedure (localproc_1)
	(if argc
		(gNarrator x: 25 y: 20)
	else
		(gNarrator x: -1 y: -1)
	)
)

(instance rm140 of ADRoom
	(properties
		noun 1
		picture 140
		north 150
		vanishingY -60
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 100)
			(= gPrevRoomNum 135)
		)
		((ScriptID 895 0) normalize: posn: 65 172 init:) ; pepper
		(if (!= gPrevRoomNum 200)
			(target init: stopUpd:)
		else
			(target init: addToPic:)
		)
		(books init: setOnMeCheck: 1 2)
		(feet init: setOnMeCheck: 1 64)
		(globe init: setOnMeCheck: 1 4)
		(machine init: setOnMeCheck: 1 32)
		(microwave init: setOnMeCheck: 1 16)
		(paintBucket init: setOnMeCheck: 1 8)
		(beakers init:)
		(redButton init:)
		(displayIt init: setOnMeCheck: 1 256)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 5 188 242 188 242 172 269 136 246 130 214 140 216 152 141 171 107 167 110 142 69 142 60 132 19 146 30 161 18 169 3 173
					yourself:
				)
		)
		(gGame handsOn:)
		(gTheIconBar disable: 0)
		(switch gPrevRoomNum
			(135
				(self setScript: startScr)
			)
			(340
				(if (IsFlag 56)
					(self setScript: s2ndTimeJump)
				else
					(self setScript: fromBensHouseScr)
				)
			)
			(200
				(gCurRoom setScript: endingCartoonScr)
			)
			(else
				((ScriptID 895 0) posn: 100 100) ; pepper
				((ScriptID 895 1) posn: 100 120) ; lockjaw
			)
		)
		(gWalkHandler addToFront: gCurRoom)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 0) ; Walk
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 381)
			(gLongSong fade:)
		)
		(gWalkHandler delete: gCurRoom)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance endingCartoonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) view: 2000) ; pepper
				(uncleFred
					view: 152
					setLoop: 0
					cel: 0
					posn: 240 157
					init:
					stopUpd:
				)
				(= cycles 1)
			)
			(1
				(toaster
					view: 149
					setLoop: 0
					cel: 0
					posn: 123 157
					priority: 15
					setCycle: Fwd
					init:
				)
				(= cycles 1)
			)
			(2
				(steamer
					view: 149
					setLoop: 1
					cel: 0
					posn: 87 86
					priority: 15
					setCycle: Fwd
					cycleSpeed: 8
					init:
				)
				(= cycles 1)
			)
			(3
				(barberPole
					view: 149
					setLoop: 2
					cel: 0
					posn: 24 73
					priority: 15
					setCycle: Fwd
					init:
				)
				(= cycles 1)
			)
			(4
				(microChar
					view: 147
					setLoop: 3
					cel: 0
					posn: 31 125
					priority: 15
					init:
					stopUpd:
				)
				(= cycles 1)
			)
			(5
				(= global215 74)
				(fredTalker x: 42 y: 94 talkWidth: 170 tailPosn: 1)
				(gMessager say: 12 0 7 1 self) ; ""Your confidence is inspiring, lad!" GAG ME!"
			)
			(6
				(uncleFred view: 152 setLoop: 0 cel: 0 setCycle: Fwd)
				(= ticks 10)
			)
			(7
				(gMessager say: 12 0 7 2 self) ; "So you think you've won, Pepper? HAH! This machine now has enough power to pull a woolly mammoth into the 1998 world's fair! I've tried it! Heh heh heh!"
			)
			(8
				(= ticks 60)
			)
			(9
				(uncleFred
					view: 153
					setLoop: 0
					cel: 0
					posn: 265 155
					setCycle: End self
				)
				(gLongSong2 number: 1410 setLoop: 1 flags: 1 play:)
			)
			(10
				(microChar
					init:
					view: 154
					setLoop: 0
					cel: 0
					posn: 32 99
					setPri: 14
					setCycle: Fwd
				)
				(= ticks 30)
			)
			(11
				(uncleFred stopUpd:)
				(= cycles 1)
			)
			(12
				(gMessager say: 12 0 7 3 self) ; "I've got you, my pretty, and your little alligator-in-a-dog-suit too! BWAH HA HA! I'm gonna send you into the ice age! Goodbye, Pepper! BWAH HA HA HA!"
			)
			(13
				(= ticks 60)
			)
			(14
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(gCurRoom newRoom: 381)
				(self dispose:)
			)
		)
	)
)

(instance startScr of Script
	(properties)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(animationActor init: stopUpd:)
				(if (!= gPrevRoomNum 200)
					(gLongSong number: 140 setLoop: -1 flags: 1 play:)
				)
				((ScriptID 895 0) ; pepper
					view: 143
					setLoop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 4 1 self
				)
			)
			(1
				((ScriptID 895 0) setCycle: End self) ; pepper
				(theMusic3 number: 1357 setLoop: 1 flags: 1 play:)
				(target init: stopUpd:)
			)
			(2
				(fredTalker x: 1 y: 90 talkWidth: 150 tailPosn: 1)
				((ScriptID 2004 0) ; LockjawTalker
					winX: 137
					winY: 159
					talkWidth: 100
					tailPosn: 0
				)
				((ScriptID 2000 3) ; PepperTalker
					forceWidth: 1
					winX: 125
					winY: 132
					talkWidth: 75
					tailPosn: 0
				)
				(gMessager say: 12 0 4 1 2 self) ; "OW!"
			)
			(3
				(= cycles 3)
				((ScriptID 2000 3) winX: 0 winY: 0 forceWidth: 0) ; PepperTalker
			)
			(4
				(fredTalker x: 22 y: 104 talkWidth: 150 tailPosn: 1)
				(gMessager say: 12 0 4 3 4 self) ; "Wha?!?-- YOU! You nosy little brat! Get out of here! You'd better keep your mouth shut about this invention, or I'll turn your ugly mutt into dog puree!"
			)
			(5
				(animationActor
					setSpeed: 4
					setLoop: 1
					setPri: 4
					setCycle: Walk
					setMotion: MoveTo 181 175 self
				)
			)
			(6
				(theMusic3 number: 900 setLoop: 1 flags: 1 play:)
				((ScriptID 2004 0) ; LockjawTalker
					winX: 137
					winY: 159
					talkWidth: 100
					tailPosn: 0
				)
				(gMessager say: 12 0 4 5 self) ; "GRRRRRR! WOOF!"
			)
			(7
				((ScriptID 895 0) hide:) ; pepper
				((ScriptID 895 1) hide:) ; lockjaw
				(= cycles 1)
			)
			(8
				(animationActor
					setSpeed: 10
					view: 150
					setLoop: 0
					cel: 0
					posn: 181 175
					setCycle: End self
				)
			)
			(9
				(animationActor setLoop: 1 cel: 0 setCycle: CT 7 1 self)
			)
			(10
				(gLongSong2 number: 1403 setLoop: 1 flags: 1 play: self)
			)
			(11
				(animationActor setLoop: 1 cel: 8 setCycle: End self)
			)
			(12
				(gLongSong2 number: 1413 setLoop: -1 flags: 1 play:)
				(= cycles 1)
			)
			(13
				(theMusic3 number: 902 setLoop: 1 flags: 1 play:)
				(= ticks 50)
			)
			(14
				(theMusic3 number: 2105 setLoop: 1 flags: 1 play:)
				(gMessager say: 12 0 4 6 self) ; "YEOWCH!"
			)
			(15
				(target init: setCycle: Fwd)
				(= cycles 1)
			)
			(16
				(= seconds 2)
			)
			(17
				(animationActor
					posn: 213 175
					view: 144
					setLoop: 2
					cel: 0
					setCycle: End self
				)
				(theMusic3 number: 1407 setLoop: 1 flags: 1 play:)
			)
			(18
				(= local525 0)
				(gGame setScript: uncleFredPullOutHairScr)
				(animationActor dispose:)
				((ScriptID 895 0) view: 145 loop: 0 cel: 0 posn: 280 126 show:) ; pepper
				(= cycles 2)
			)
			(19
				(target setLoop: (+ (target loop:) 1) forceUpd:)
				(= cycles 1)
			)
			(20
				(= cycles 1)
			)
			(21
				(fredTalker x: 12 y: 91 talkWidth: 150 tailPosn: 1)
				(localproc_1 1)
				(gMessager say: 12 0 4 7 8 self) ; "LOCKJAW!"
			)
			(22
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(User canInput: 1 canControl: 0)
				(= cycles 1)
			)
			(23
				(uncleFredPullOutHairScr dispose:)
				(self dispose:)
			)
		)
	)
)

(instance uncleFredPullOutHairScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(uncleFred
					view: 148
					setLoop: 0
					cel: 0
					posn: 181 174
					setCycle: End self
					init:
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(uncleFred cel: 0)
				(= cycles 1)
			)
			(3
				(if (>= (++ local525) 4)
					(self dispose:)
				else
					(= ticks 60)
				)
			)
			(4
				(-= state 4)
			)
		)
	)
)

(instance fromBensHouseScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) view: 2000) ; pepper
				(gLongSong number: 141 setLoop: -1 flags: 1 play:)
				(uncleFred
					view: 152
					setLoop: 0
					cel: 0
					posn: 240 157
					init:
					stopUpd:
				)
				(= cycles 5)
			)
			(1
				(= cycles 1)
			)
			(2
				(microChar
					view: 147
					setLoop: 0
					cel: 0
					posn: 30 126
					priority: 15
					init:
					stopUpd:
				)
				(= cycles 1)
			)
			(3
				(toaster
					view: 149
					setLoop: 0
					cel: 0
					posn: 123 157
					priority: 15
					setCycle: Fwd
					init:
				)
				(= cycles 1)
			)
			(4
				(uncleFred
					view: 152
					setLoop: 0
					cel: 0
					posn: 252 155
					setCycle: Fwd
				)
				(= cycles 2)
			)
			(5
				(gMessager say: 12 0 5 1 self) ; "Gonna Getcha! Gonna pull you right out of there! Here it comes...here it comes..."
			)
			(6
				(= ticks 30)
			)
			(7
				(uncleFred
					view: 153
					setLoop: 0
					cel: 0
					posn: 265 155
					setCycle: End self
				)
				(gLongSong2 number: 1410 setLoop: 1 flags: 1 play:)
			)
			(8
				(gMessager say: 12 0 5 2 self) ; "GOTCHA!"
			)
			(9
				(microChar setLoop: 1 cel: 0 forceUpd: stopUpd:)
				(= cycles 1)
			)
			(10
				(= ticks 40)
			)
			(11
				(uncleFred
					view: 148
					setLoop: 0
					cel: 0
					posn: 252 155
					setCycle: End self
				)
			)
			(12
				(gMessager say: 12 0 5 3 self) ; "Oh, NOOOO! I sent her to Ben Franklin's boyhood! Oh, RAT NOSES! More power! I MUST give the machine more power!"
			)
			(13
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(gCurRoom newRoom: 500)
				((ScriptID 895 0) normalize:) ; pepper
				(self dispose:)
			)
		)
	)
)

(instance s2ndTimeJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) view: 2000) ; pepper
				(gLongSong number: 141 setLoop: -1 flags: 1 play:)
				(uncleFred
					view: 152
					setLoop: 0
					cel: 0
					posn: 240 157
					init:
					stopUpd:
				)
				(= cycles 1)
			)
			(1
				(= cycles 1)
			)
			(2
				(microChar
					view: 147
					setLoop: 0
					cel: 0
					posn: 30 126
					priority: 15
					init:
					stopUpd:
				)
				(= cycles 1)
			)
			(3
				(toaster
					view: 149
					setLoop: 0
					cel: 0
					posn: 123 157
					priority: 15
					setCycle: Fwd
					init:
				)
				(= cycles 1)
			)
			(4
				(steamer
					view: 149
					setLoop: 1
					cel: 0
					posn: 87 86
					priority: 15
					setCycle: Fwd
					cycleSpeed: 8
					init:
				)
				(= cycles 1)
			)
			(5
				(uncleFred view: 152 setLoop: 0 cel: 0 setCycle: Fwd)
				(= cycles 2)
			)
			(6
				(= global215 74)
				(gMessager say: 12 0 6 1 self) ; "Okay! This baby has enough power to zap that rotten girl into the |r||c0|Pleistocene|c||r| age! I'm gonna send her somewhere that she'll NEVER come back from! Ha ha ha! Here...it...comes!"
			)
			(7
				(uncleFred
					view: 153
					setLoop: 0
					cel: 0
					posn: 265 155
					setCycle: End self
				)
				(gLongSong2 number: 1410 setLoop: 1 flags: 1 play:)
			)
			(8
				(microChar setLoop: 2 cel: 0 forceUpd: stopUpd:)
				(= ticks 30)
			)
			(9
				(uncleFred
					view: 148
					setLoop: 0
					cel: 0
					posn: 252 155
					setCycle: End self
				)
			)
			(10
				(gMessager say: 12 0 6 2 self) ; "NO! NO, NO, NO! IT CAN'T BE! I sent her to the CONSTITUTIONAL CONVENTION?!? AAAAAARGH!"
			)
			(11
				(= ticks 60)
			)
			(12
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(SetFlag 72)
				((ScriptID 895 0) normalize:) ; pepper
				(gCurRoom newRoom: 530)
				(self dispose:)
			)
		)
	)
)

(instance books of Feature
	(properties
		noun 9
	)
)

(instance feet of Feature
	(properties
		noun 5
	)

	(method (doVerb theVerb)
		(= global215 99)
		(super doVerb: theVerb)
	)
)

(instance globe of Feature
	(properties
		noun 4
	)
)

(instance machine of Feature
	(properties
		noun 10
	)
)

(instance microwave of Feature
	(properties
		noun 2
	)

	(method (doVerb theVerb)
		(= global215 56)
		(super doVerb: theVerb)
	)
)

(instance paintBucket of Feature
	(properties
		noun 11
	)
)

(instance beakers of Feature
	(properties
		x 246
		y 65
		noun 8
		nsTop 60
		nsLeft 238
		nsBottom 70
		nsRight 254
		sightAngle 40
		approachX 248
		approachY 142
	)
)

(instance redButton of Feature
	(properties
		x 257
		y 108
		noun 7
		nsTop 100
		nsLeft 251
		nsBottom 117
		nsRight 264
		sightAngle 40
		approachX 253
		approachY 142
	)
)

(instance displayIt of Feature
	(properties
		noun 3
	)
)

(instance uncleFred of Actor
	(properties
		x 205
		y 173
		noun 13
		view 143
		loop 1
		cel 7
	)
)

(instance animationActor of Actor
	(properties
		x 205
		y 173
		view 143
		loop 1
	)
)

(instance toaster of Prop
	(properties
		x 124
		y 157
		view 149
		cel 4
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance barberPole of Prop
	(properties
		x 24
		y 73
		view 149
		loop 2
		cel 2
		priority 14
		signal 16
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance steamer of Prop
	(properties
		x 87
		y 86
		view 149
		loop 1
		cel 1
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance target of Prop
	(properties
		x 257
		y 37
		noun 6
		view 146
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gGame points: 208 2)
				(if (not (gCurRoom script:))
					(gCurRoom setScript: pepperFallScr)
				else
					((gCurRoom script:) setScript: pepperFallScr)
				)
			)
			(6 ; Look
				(gMessager say: 6 6 2 0 self) ; "Pepper can see Lockjaw's stubby little tail going around and around in the target! Yikes!"
			)
			(85 ; Talk
				(gMessager say: 6 85 2 0 self) ; "Lockjaw! Lockjaw! Come out of there!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pepperFallScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 6 7 2 0 self) ; "<Sigh.> I guess I'll save the furry little jerk."
			)
			(2
				(gLongSong2 number: 1412 setLoop: 1 flags: 1 play:)
				((ScriptID 895 0) ; pepper
					view: 145
					loop: 1
					cel: 0
					posn: 282 113
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: 150)
				(self dispose:)
			)
		)
	)
)

(instance readerBoardScr of Script ; UNUSED
	(properties)

	(method (init)
		(localproc_0 2)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= [local0 local200] (readerLetters new:))
					setSpeed: 10
					init:
					setMotion: MoveTo 9 19 readerLetters
				)
				(= ticks 20)
			)
			(1
				(++ local200)
				(= ticks 10)
			)
			(2
				(if (!= [local202 local200] -1)
					(self init:)
				else
					(= cycles 1)
				)
			)
			(3
				(= ticks 340)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(class CueIt of Code
	(properties)

	(method (cue)
		([local0 local201] dispose:)
		(++ local201)
	)
)

(instance readerLetters of Actor
	(properties
		x 118
		y 19
		view 138
		loop 2
		cel 5
	)

	(method (init param1 &tmp temp0)
		(self setPri: 15 ignoreActors:)
		(cond
			((== [local202 local200] -1) 0)
			((< [local202 local200] 16)
				(self setLoop: 2)
				(= cel [local202 local200])
			)
			((< [local202 local200] 26)
				(self setLoop: 3)
				(= cel (- [local202 local200] 16))
			)
			((< [local202 local200] 36)
				(self setLoop: 1)
				(= cel (- [local202 local200] 26))
			)
			((OneOf [local202 local200] 36 37 38)
				(self setLoop: 1)
				(switch [local202 local200]
					(36
						(= cel 10)
					)
					(37
						(= cel 11)
					)
					(38
						(= cel 12)
					)
				)
			)
		)
		(if (> [local202 local200] -1)
			(gLongSong2 number: 1401 setLoop: 1 flags: 1 play:)
			(super init: &rest)
		)
	)

	(method (cue)
		([local0 local201] dispose:)
		(++ local201)
	)

	(method (doVerb)
		(return 0)
	)
)

(instance fredTalker of BalloonTalker
	(properties
		x 32
		y 95
		talkWidth 180
		tailPosn 1
	)
)

(instance microChar of Actor
	(properties
		view 143
		loop 2
	)

	(method (init)
		(self setPri: 15)
		(super init: &rest)
	)
)

(instance theMusic3 of Sound
	(properties
		flags 1
	)
)

