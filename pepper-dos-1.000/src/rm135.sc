;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 135)
(include sci.sh)
(use Main)
(use BalloonTalker)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm135 0
	fredTalker 19
)

(local
	[local0 200]
	local200
	local201
	[local202 200]
	[local402 73] = [1 4 13 9 0 12 8 13 36 5 17 0 13 10 11 8 13 38 36 18 4 11 5 36 3 4 19 4 17 12 8 13 0 19 8 14 13 37 4 16 20 0 11 8 19 24 37 3 4 12 14 2 17 0 2 24 36 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1]
	[local475 36] = [19 0 17 6 4 19 38 36 15 7 8 11 8 3 4 11 15 7 8 0 38 36 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1]
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(= temp1 param1)
	(for ((= temp0 0)) (<= temp0 75) ((++ temp0))
		(switch temp1
			(1
				(= [local202 temp0] [local402 temp0])
			)
			(2
				(= [local202 temp0] [local475 temp0])
			)
		)
	)
)

(instance rm135 of ADRoom
	(properties
		noun 1
		picture 135
		style 14
		north 140
		vanishingY -60
	)

	(method (init)
		(super init: &rest)
		(gLongSong number: 135 setLoop: -1 flags: 1 play:)
		(gGame setEgo: (ScriptID 895 0) handsOn:) ; pepper
		(gEgo init: view: 135 setLoop: 1 cel: 0 posn: 91 164 setCycle: Walk)
		((ScriptID 895 1) ; lockjaw
			init:
			view: 132
			setLoop: 6
			cel: 6
			posn: 83 240
			approachX: 93
			approachY: 158
			setCycle: 0
		)
		((ScriptID 2004 0) winX: 105 winY: 175 tailPosn: 0) ; LockjawTalker
		(windowFeature init: setOnMeCheck: 1 16)
		(sky init: setOnMeCheck: 1 4)
		(trees init: setOnMeCheck: 1 256)
		(appleTree init: setOnMeCheck: 1 16384)
		(peppersRoof init: setOnMeCheck: 1 2)
		(gWalkHandler addToFront: peppersRoof)
		(gWalkHandler add: gCurRoom)
		(roofTops init: setOnMeCheck: 1 32)
		(upperPeppersRoof init: setOnMeCheck: 1 2048)
		(obrienWindow init: setOnMeCheck: 1 128)
		(obrienHouse init: setOnMeCheck: 1 64)
		(gGame handsOn:)
		(self setScript: onPipeScr)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(gWalkHandler delete: peppersRoof delete: gCurRoom)
		(super dispose: &rest)
	)

	(method (newRoom)
		(gLongSong fade:)
		(super newRoom: &rest)
	)
)

(instance onPipeScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(User canInput: 1 canControl: 0)
	)

	(method (dispose)
		(SetFlag 150)
		(peppersRoof init:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 1 canControl: 0)
				(gMessager say: 9 7 2 1) ; "Let's see, I think I can make it up there..."
			)
			(1
				(gGame handsOff:)
				(gEgo setLoop: 1 setSpeed: 10 setCycle: End self)
				(gLongSong2 number: 1352 flags: 1 setLoop: 1 play:)
			)
			(2
				((ScriptID 2004 0) winX: 105 winY: 175 tailPosn: 0) ; LockjawTalker
				(gMessager say: 9 7 2 2 self) ; "All right!"
			)
			(3
				(= ticks 80)
			)
			(4
				((ScriptID 2004 0) ; LockjawTalker
					winX: 86
					winY: 165
					tailPosn: 0
					talkWidth: 100
				)
				(gMessager say: 9 7 2 3 4 self) ; "Mbuff! Mbuff!"
			)
			(5
				(= ticks 80)
			)
			(6
				((ScriptID 895 0) setLoop: 2 cel: 0 setCycle: CT 5 1 self) ; pepper
			)
			(7
				((ScriptID 895 0) setCycle: End self) ; pepper
				(gLongSong2 number: 1354 setLoop: 1 flags: 1 play:)
			)
			(8
				((ScriptID 895 1) view: 807 setLoop: 8 posn: 76 160) ; lockjaw
				(= cycles 15)
			)
			(9
				((ScriptID 2004 0) ; LockjawTalker
					winX: 90
					winY: 145
					tailPosn: 0
					talkWidth: 100
				)
				(gMessager say: 9 7 2 5 6 self) ; "Poor guy! You were hanging there like a fat old spider, ha ha!"
			)
			(10
				(= ticks 10)
			)
			(11
				(gEgo
					normalize:
					setSpeed: 6
					setCycle: Walk
					setMotion: PolyPath 107 163
				)
				(= seconds 1)
			)
			(12
				(gEgo normalize: 800)
				(= cycles 1)
			)
			(13
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 103 162 104 166 184 166 229 134 255 125 286 121 319 121 319 118 208 118 186 150 168 152 167 158 140 158 111 158 105 149 103 156
							yourself:
						)
				)
				(= cycles 2)
			)
			(14
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 139 165 self
				)
			)
			(15
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sky of Feature
	(properties
		noun 2
	)
)

(instance trees of Feature
	(properties
		noun 8
	)
)

(instance roofTops of Feature
	(properties
		noun 5
	)
)

(instance appleTree of Feature
	(properties
		noun 11
	)
)

(instance windowFeature of Feature
	(properties
		noun 3
		approachX 137
		approachY 159
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 6 7) ; Look, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gGame points: 206 2)
				(if (IsFlag 150)
					(if (not (IsFlag 68))
						(SetFlag 68)
						(gGame points: 207 1)
						(gCurRoom setScript: cleanWindowScr)
					else
						(gMessager say: 3 7 5) ; "The window seems to be stuck."
					)
				else
					(gMessager say: 3 7 8) ; "Pepper can't reach the window unless she climbs up on the roof."
				)
			)
			(6 ; Look
				(cond
					((not (IsFlag 150))
						(gMessager say: 3 6 8) ; "Pepper can't see the window from down there."
					)
					((not (IsFlag 68))
						(gMessager say: (self noun:) 6 1)
					)
					(else
						(gCurRoom setScript: cartoonAndFallInScr)
					)
				)
				(SetFlag 143)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance obrienWindow of Feature
	(properties
		noun 7
	)
)

(instance obrienHouse of Feature
	(properties
		noun 6
	)
)

(instance cleanWindowScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(if (IsFlag 143)
			(= next cartoonAndFallInScr)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					setSpeed: 5
					setMotion:
						MoveTo
						(windowFeature approachX:)
						(windowFeature approachY:)
						self
				)
			)
			(2
				(if (IsFlag 143)
					(gMessager say: 3 7 6 1 self) ; "Let me wipe some of this dirt off..."
				else
					(gMessager say: 3 7 7 1 self) ; "Yech, look at this filthy window! I'll just wipe some of this dirt off..."
				)
			)
			(3
				(gLongSong2 number: 1355 loop: 1 play:)
				(= ticks 130)
				(gEgo view: 135 setLoop: 3 cel: 0 setCycle: Fwd)
			)
			(4
				(gEgo normalize: 800)
				(= cycles 2)
			)
			(5
				(if (IsFlag 143)
					(gMessager say: 3 7 6 2 self) ; "There! C'mon, Lockjaw, let's take a peek..."
				else
					(gMessager say: 3 7 7 2 self) ; "There, that's better!"
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cartoonAndFallInScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong fade:)
				(= cycles 1)
			)
			(1
				(gCurRoom drawPic: 141 10)
				(gLongSong number: 136 flags: 1 setLoop: -1 play:)
				(uncleFred init: view: 140 loop: 1 cel: 0 posn: 262 153)
				((ScriptID 895 0) dispose:) ; pepper
				((ScriptID 895 1) dispose:) ; lockjaw
				(book init: stopUpd:)
				(= cycles 20)
			)
			(2
				(= global215 72)
				(fredTalker x: 37 y: 85 tailPosn: 1)
				(gMessager say: 12 0 3 1 4 self 140) ; "You're crazy, Fred. You're sick, Fred. You should be locked up, Fred. That's what they said about me in the institution. Ha ha ha!"
			)
			(3
				(= ticks 50)
			)
			(4
				(uncleFred setCycle: CT 4 1 self)
			)
			(5
				(book dispose:)
				(= cycles 1)
			)
			(6
				(uncleFred cel: 5 setCycle: End self)
			)
			(7
				(uncleFred setLoop: 2 cel: 0 setCycle: End self)
			)
			(8
				(fredTalker x: 32 y: 86 tailPosn: 1)
				(gMessager say: 12 0 3 5 6 self 140) ; "Okay, okay, now where do I start? Who's gonna get Fredified first?"
			)
			(9
				(= ticks 60)
			)
			(10
				(uncleFred setCycle: Beg self)
			)
			(11
				(uncleFred setLoop: 1 cel: 8 setCycle: CT 5 -1 self)
			)
			(12
				(book init: stopUpd:)
				(= cycles 1)
			)
			(13
				(uncleFred cel: 4 setCycle: CT 0 -1 self)
			)
			(14
				(= ticks 40)
			)
			(15
				(uncleFred
					view: 153
					setLoop: 0
					cel: 0
					posn: 265 155
					setCycle: End self
				)
				(gLongSong2 number: 1410 setLoop: 1 flags: 1 play:)
			)
			(16
				(microBen
					init:
					view: 139
					setLoop: 0
					cel: 0
					posn: 27 115
					setPri: 15
				)
				(= ticks 20)
			)
			(17
				(localproc_0 1)
				(= ticks 180)
			)
			(18
				(self setScript: readerBoardScr)
				(= cycles 5)
			)
			(19
				(fredTalker x: 55 y: 100 tailPosn: 4)
				(gMessager say: 12 0 3 7 8 self 140) ; "Self-determination! Equality! What a load of flamingo feathers! Equality is only for those who deserve it. Namely, me...Ooh! I know JUST the thing! 1968! YES!"
			)
			(20
				(uncleFred view: 141 setLoop: 4 cel: 0 setCycle: End self)
			)
			(21
				(fredTalker x: 48 y: 110 tailPosn: 4)
				(gMessager say: 12 0 3 9 self 140) ; "This potion has all the mellow stuff from 1968; the 'let it be' attitude and all that junk...but I took out the backbone! I took out all the will to protest!"
			)
			(22
				(uncleFred setLoop: 5 setCycle: End self)
			)
			(23
				(gMessager say: 12 0 3 10 self 140) ; "When I get done with Benjamin Franklin, he'll be an incense-burning, headband-wearing jellyfish! BWAH HA HA HA HA!"
			)
			(24
				(uncleFred
					view: 153
					setLoop: 0
					cel: 0
					posn: 265 155
					setCycle: End self
				)
				(gLongSong2 number: 1410 setLoop: 1 flags: 1 play:)
			)
			(25
				(fredTalker x: 55 y: 100 tailPosn: 4)
				(gMessager say: 12 0 3 11 self 140) ; "Open wide, Mr. Franklin! Once you've become a flower child, you'll destroy any chance for an American revolution!"
			)
			(26
				(microBen
					init:
					view: 139
					setLoop: 0
					cel: 0
					posn: 27 115
					setPri: 15
					setCycle: End self
				)
			)
			(27
				(= ticks 40)
			)
			(28
				(microBen setLoop: 1 cel: 0 setCycle: Fwd)
				(= ticks 120)
			)
			(29
				(= ticks 30)
			)
			(30
				(gMessager say: 12 0 3 12 self 140) ; "You're so influential, you'll probably have all the colonists quitting their jobs and staging rock concerts in no time! Here goes! Heh heh heh heh!"
			)
			(31
				(book dispose:)
				(readerBoardScr register: 1)
				(= ticks 220)
			)
			(32
				(uncleFred dispose:)
				(microBen dispose:)
				(gLongSong fade:)
				((ScriptID 895 0) ; pepper
					init:
					view: 135
					setLoop: 5
					cel: 0
					posn: 136 157
					setCycle: 0
				)
				(gCurRoom drawPic: 135 10)
				(= cycles 3)
			)
			(33
				(alternateDoggie
					view: 135
					loop: 4
					cel: 0
					posn: 144 157
					setSpeed: 7
					setCycle: Fwd
					init:
				)
				((ScriptID 2004 0) ; LockjawTalker
					winX: 151
					winY: 131
					tailPosn: 0
					talkWidth: 100
				)
				(gLongSong number: 135 setLoop: -1 play:)
				(gMessager say: 10 0 4 0 self) ; "Holy time warp, Lockjaw! He's gonna change the course of history! We've gotta stop him, or else I'll be singing "God Save the Queen" at school tomorrow!"
				(alternateWindow
					view: 136
					loop: 0
					cel: 0
					posn: 138 100
					init:
					stopUpd:
				)
			)
			(34
				(alternateWindow setCycle: End self)
			)
			(35
				(alternateDoggie dispose:)
				(gLongSong2 number: 1357 flags: 1 setLoop: 1 play:)
				((ScriptID 895 0) ; pepper
					view: 135
					setSpeed: 5
					setLoop: 5
					cel: 0
					setCycle: End self
				)
			)
			(36
				(gGame handsOn:)
				(self dispose:)
				(gCurRoom newRoom: 140)
				(= cycles 1)
			)
		)
	)
)

(instance uncleFred of Actor
	(properties
		x 248
		y 154
		view 143
		loop 1
		cel 7
	)
)

(instance alternateDoggie of Actor
	(properties
		x 143
		y 159
		view 135
		loop 5
		cel 4
		priority 15
		signal 16400
	)
)

(instance alternateWindow of Prop
	(properties
		x 138
		y 100
		view 136
	)
)

(instance peppersRoof of Feature
	(properties
		noun 9
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 7) ; Walk, Do
			(gGame points: 205 2)
			(gWalkHandler delete: peppersRoof delete: gCurRoom)
			(if (< (onPipeScr state:) 1)
				(onPipeScr cue:)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance upperPeppersRoof of Feature
	(properties
		noun 4
	)
)

(instance readerBoardScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 21])
		(switch (= state newState)
			(0
				(if (not register)
					(= [local0 local200] (readerLetters new:))
					(if ([local0 local200] respondsTo: #setMotion)
						([local0 local200]
							init:
							moveSpeed: 3
							setMotion: MoveTo 9 19 [local0 local200]
						)
						(thadList add: [local0 local200])
						(= cycles 3)
					else
						(-- state)
						(self cue:)
					)
				else
					(++ state)
					(= cycles 2)
				)
			)
			(1
				(++ local200)
				(cond
					(register
						(self cue:)
					)
					((!= [local202 local200] -1)
						(= state -1)
						(= cycles 2)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(thadList
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
					dispose:
				)
				(= ticks 320)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance thadList of Set
	(properties)
)

(instance readerLetters of Actor
	(properties
		x 118
		y 19
		view 138
		loop 2
		cel 5
		priority 8
		signal 26640
	)

	(method (init param1 &tmp temp0)
		(cond
			((== [local202 local200] -1) 0)
			((< [local202 local200] 16)
				(self setLoop: 1)
				(= cel [local202 local200])
			)
			((< [local202 local200] 26)
				(self setLoop: 2)
				(= cel (- [local202 local200] 16))
			)
			((< [local202 local200] 36)
				(self setLoop: 0)
				(= cel (- [local202 local200] 26))
			)
			((OneOf [local202 local200] 36 37 38)
				(self setLoop: 0)
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
		)
		(super init: &rest)
	)

	(method (cue)
		(super cue:)
		(++ local201)
		(self dispose:)
	)

	(method (doVerb)
		(return 0)
	)
)

(instance microBen of Actor
	(properties
		view 139
	)
)

(instance target of Prop ; UNUSED
	(properties
		x 257
		y 37
		view 146
		loop 1
		priority 3
	)
)

(instance book of View
	(properties
		x 284
		y 139
		view 137
		cel 3
	)
)

(instance fredTalker of BalloonTalker
	(properties
		x 88
		y 80
		talkWidth 180
		tailPosn 1
	)
)

