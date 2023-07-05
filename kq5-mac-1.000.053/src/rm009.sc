;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use Language)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm009 0
)

(local
	local0
	[local1 14] = [141 120 143 126 132 130 48 130 37 123 50 116 71 116]
	[local15 14] = [56 133 96 136 96 144 53 144 27 139 24 135 41 131]
	[local29 14] = [1 149 0 141 25 141 37 148 49 149 50 157 9 157]
	[local43 10] = [42 166 53 161 91 161 88 168 63 172]
	[local53 10] = [141 151 191 151 194 155 166 164 142 156]
	[local63 10] = [135 110 200 110 207 117 189 117 141 119]
	[local73 10] = [163 123 232 118 226 127 191 129 152 127]
	[local83 12] = [179 189 195 182 250 183 265 186 319 171 319 189]
	[local95 10] = [0 0 319 0 319 109 233 99 0 101]
	[local105 8] = [72 114 80 123 68 131 59 123]
	local113
	local114
)

(instance rm009 of KQ5Room
	(properties
		picture 9
		east 8
		south 10
		west 13
	)

	(method (init)
		(super init:)
		(if (or (== gHowFast 0) (< (gGame detailLevel:) 3))
			(= local114 1)
		)
		(= global320 190)
		(= global321 83)
		(= global325 {"Come on, Graham. Let's go someplace else!"})
		(gGlobalSound number: 24 loop: -1 play:)
		(= local0 (gEgo illegalBits:))
		(gEgo illegalBits: -32768 init:)
		(cond
			((and (!= ((gInventory at: 9) owner:) 9) local114) ; Heart
				(self addObstacle: poly1)
				(gGlobalSound2 number: 32 loop: -1 play:)
				(if (== ((gInventory at: 9) owner:) 21) ; Heart
					(willow view: 255 init: addToPic:)
				else
					(willow view: 255 init: stopUpd:)
					(willow signal: (| (willow signal:) $0100))
				)
			)
			((!= ((gInventory at: 9) owner:) 9) ; Heart
				(self addObstacle: poly1)
				(gGlobalSound2 number: 32 loop: -1 play:)
				(harp init: stopUpd:)
				(wFace cycleSpeed: 3 init: stopUpd:)
				(wArm cycleSpeed: 5 init: stopUpd:)
				(wTear1 init: yStep: 4 hide:)
				(ripple init: hide:)
				(willow init: stopUpd:)
				(willowProp init: addToPic:)
			)
			((== ((gInventory at: 10) owner:) 9) ; Harp
				(harp
					view: 256
					setLoop: 4
					setPri: 1
					posn: 73 124
					init:
					stopUpd:
				)
			)
		)
		(self setFeatures: pond forest setRegions: 202) ; owl
		(switch gPrevRoomNum
			(west
				(gEgo posn: 6 110)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(east
				(gEgo posn: 314 140)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(south
				(gEgo posn: 149 180)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(else
				(gEgo posn: 149 180)
			)
		)
		(poly1 points: @local1 size: 7)
		(poly2 points: @local15 size: 7)
		(poly3 points: @local29 size: 7)
		(poly4 points: @local43 size: 5)
		(poly5 points: @local53 size: 5)
		(poly6 points: @local63 size: 5)
		(poly7 points: @local73 size: 5)
		(poly8 points: @local83 size: 6)
		(poly9 points: @local95 size: 5)
		(poly10 points: @local105 size: 4)
		(self addObstacle: poly2 poly3 poly4 poly5 poly6 poly7 poly8 poly9)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
				(self setScript: (ScriptID 202 2)) ; stdWalkOut
			)
			((& (gEgo onControl: 1) $0002)
				(gEgo view: 26)
			)
			(else
				(gEgo view: 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(gEgo illegalBits: local0)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound2 fade:)
		(gGlobalSound fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance armMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (Random 0 7) 4)
					(wArm setCycle: CT 2 -1 self)
				else
					(wArm setCycle: CT 0 -1 self)
				)
			)
			(1
				(if (== (wArm cel:) 2)
					(wArm setCycle: CT 3 1 self)
				else
					(wArm setCycle: CT 5 1 self)
				)
			)
			(2
				(= state -1)
				(= cycles 6)
			)
		)
	)
)

(instance faceMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wFace setCycle: End)
				(= state -1)
				(= seconds (Random 6 12))
			)
		)
	)
)

(instance mouthMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wFace loop: 2 cel: (Random 0 8))
				(= state -1)
				(= cycles 3)
			)
		)
	)
)

(instance tearMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wTear1 show: setMotion: MoveTo (wTear1 x:) 132 self)
			)
			(1
				(gGlobalSound4 number: 98 loop: 1 play:)
				(wTear1 hide: setCel: (Random 0 2))
				(ripple
					show:
					posn: (wTear1 x:) (wTear1 y:)
					cel: 0
					setCycle: End self
				)
				(switch (Random 0 2)
					(0
						(wTear1 x: 50 y: 109)
					)
					(1
						(wTear1 x: 142 y: 51)
					)
					(else
						(wTear1 x: 133 y: 88)
					)
				)
			)
			(2
				(ripple hide:)
				(= state -1)
				(= seconds (Random 3 5))
			)
		)
	)
)

(instance talkTree of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if (and (>= state 2) (not (User canInput:)) (not (User controls:)))
			(= temp1 ((= temp0 (Event new:)) type:))
			(if (OneOf temp1 1 4)
				(= seconds 0)
				(= cycles 1)
			)
			(temp0 dispose:)
		)
		(if (& (gEgo onControl: 1) $0002)
			(gEgo view: 26)
		else
			(gEgo view: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 95 138 self)
			)
			(1
				(proc0_7 gEgo willow 5)
				(= cycles 3)
			)
			(2
				(proc0_28 160 9 0 67 60 100 25 3) ; "Uh, Miss...Willow?"
				(RedrawCast)
				(PrintDC 9 1 #at 180 10 #dispose) ; "Yes?"
				(wFace loop: 2 setCycle: 0 setScript: mouthMove)
				(= seconds (LangSwitch 2 3))
			)
			(3
				(cls)
				(wFace cel: 0 setScript: 0)
				(proc0_28 160 9 2 67 60 100 25 3) ; "You can talk?"
				(RedrawCast)
				(PrintDC 9 3 #at 180 10 #width 120 #dispose) ; "Why, of COURSE I can! What did you expect?"
				(wFace setScript: mouthMove)
				(= seconds (LangSwitch 4 6))
			)
			(4
				(cls)
				(wFace cel: 0 setScript: 0)
				(proc0_28 160 9 4 67 60 100 25 5) ; "Well, I've never seen a talking tree before. What's wrong?"
				(RedrawCast)
				(PrintDC 9 5 #at 180 10 #width 120 #dispose) ; "Everything's wrong! Can't you tell? I'm not really a tree...I'm really a princess. (Sigh.) You see, my fiance and I were walking through this wood when a nasty old witch came along and was instantly charmed by my handsome prince."
				(wFace setScript: mouthMove)
				(= seconds (LangSwitch 10 15))
			)
			(5
				(PrintDC 9 6 #at 180 10 #width 120 #dispose) ; "When he naturally refused her advances, she jealously banished him to a faraway land and turned me into a tree. Then she stole my heart!"
				(= seconds (LangSwitch 8 12))
			)
			(6
				(cls)
				(wFace cel: 0 setScript: 0)
				(proc0_28 160 9 7 67 60 100 25 3) ; "Stole your heart?"
				(RedrawCast)
				(PrintDC 9 8 #at 180 10 #width 120 #dispose) ; "Yes. She turned my heart to gold and took it away with her. The only way I can become human again is to have my heart brought back."
				(wFace setScript: mouthMove)
				(= seconds (LangSwitch 10 15))
			)
			(7
				(PrintDC 9 9 #at 180 10 #width 120 #dispose) ; "Now all I have to cheer me up is my harp. It's quite magical, you know. It plays the sweetest music you've ever heard. Now please! Leave me alone in my sorrow."
				(wFace setScript: mouthMove)
				(= seconds (LangSwitch 10 15))
			)
			(8
				(wFace cel: 0 loop: 0 setScript: faceMove)
				(cls)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance changePrincess of Script
	(properties)

	(method (doit &tmp [temp0 2])
		(super doit:)
		(if (== state 0)
			(if (& (gEgo onControl: 1) $0002)
				(gEgo view: 26)
			else
				(gEgo view: 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local114
					(self setScript: slowChangePrincess self)
				else
					(gEgo put: 9 9) ; Heart
					(SetScore 4)
					(HandsOff)
					(harp dispose:)
					(gEgo setMotion: PolyPath 120 138 self)
				)
			)
			(1
				(if (< (gGame detailLevel:) 3)
					(self dispose:)
				else
					(wFace loop: 2 setScript: mouthMove)
					(PrintDC 9 10 #at 140 120 #dispose) ; "My heart! You found it!"
					(= seconds (LangSwitch 5 8))
				)
			)
			(2
				(cls)
				(wTear1 setScript: 0 setMotion: 0 dispose:)
				(ripple dispose:)
				(wFace setScript: 0 setCycle: 0 dispose:)
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 251 loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(wArm
					view: 251
					setScript: 0
					cycleSpeed: 2
					loop: 2
					cel: 0
					x: 103
					y: 127
					setCycle: CT 3 1 self
				)
			)
			(4
				(wArm setCycle: End self)
				(gEgo view: 251 loop: 5 cel: 0 setCycle: End self)
			)
			(5
				(gGlobalSound stop:)
				(= cycles 3)
			)
			(6
				(gGlobalSound2 number: 33 loop: 1 play:)
			)
			(7
				(gEgo
					view: 26
					loop: 7
					cel: 3
					setCycle: KQ5SyncWalk
					normal: 1
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(8
				(wArm setScript: 0 setCycle: 0 dispose:)
				(willow view: 252 loop: 0 cel: 0 startUpd:)
				(eHair init:)
				(wHair init:)
				(gCurRoom drawPic: 9 100)
				(= cycles 15)
			)
			(9
				(eHair cycleSpeed: 2 setCycle: End self)
				(wHair cycleSpeed: 2 setCycle: End self)
			)
			(10)
			(11
				(eHair dispose:)
				(wHair dispose:)
				(= cycles 2)
			)
			(12
				(willow loop: 3 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(13
				(willow loop: 4 cel: 0 setCycle: End self)
			)
			(14
				(eHair
					view: 256
					x: (willow x:)
					y: (willow y:)
					z: 33
					loop: 0
					cycleSpeed: 3
					setCycle: Fwd
					init:
				)
				(willow view: 256 loop: 1 cycleSpeed: 0 cel: 0)
				(PrintDC 9 11 #at 20 20 #dispose) ; "I don't need this old thing anymore!"
				(= seconds (LangSwitch 5 8))
			)
			(15
				(eHair hide:)
				(cls)
				(= cycles 5)
			)
			(16
				(willow
					loop: 2
					cel: 0
					setCycle: End self
					illegalBits: 0
					startUpd:
				)
				(harp
					view: 256
					setLoop: 4
					x: 97
					y: 88
					setCycle: Walk
					illegalBits: 0
					init:
				)
			)
			(17
				(DoAudio audWPLAY 8023)
				(harp show: setMotion: MoveTo 73 124 self)
				(willow loop: 3 cel: 0 setCycle: End)
			)
			(18
				(gGlobalSound3 number: 23 loop: 1 play:)
				(harp setPri: 1 stopUpd:)
				((gCurRoom obstacles:) add: poly10)
				(willow view: 254 loop: 2 illegalBits: 0 startUpd:)
				(= cycles 20)
			)
			(19
				(eHair x: (willow x:) y: (willow y:) z: 31 show:)
				(PrintDC 9 12 #at 20 20 #dispose) ; "Look at me! I'm a princess again!"
				(= seconds (LangSwitch 5 8))
			)
			(20
				(eHair hide:)
				(willow
					setCycle: Walk
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: MoveTo 106 107 self
				)
			)
			(21
				(cls)
				(eHair
					view: 254
					loop: 4
					x: (willow x:)
					y: (willow y:)
					z: 31
					show:
				)
				(PrintDC 9 13 #at 60 20 #dispose) ; "Herbert!!"
				(= seconds (LangSwitch 3 5))
				(willow loop: 1)
			)
			(22
				(eHair hide:)
				(prince
					setLoop: 0
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 91 105 self
					init:
				)
				(PrintDC 9 14 #at 20 20 #dispose) ; "Alicia!!"
			)
			(23
				(cls)
				(willow hide:)
				(prince
					posn: 97 106
					loop: 5
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(24
				(prince loop: 6 cel: 0 cycleSpeed: 2 setCycle: End)
				(= seconds 5)
			)
			(25
				(prince setCycle: Beg self)
			)
			(26
				(willow show:)
				(prince setLoop: 0 cel: 0 posn: 91 105)
				(wHair
					view: 146
					loop: 13
					x: (+ (prince x:) 2)
					y: (prince y:)
					z: 35
					cycleSpeed: 3
					setCycle: Fwd
					init:
				)
				(PrintDC 9 15 #at 20 20 #dispose) ; "Where have you been all this time, my love?"
				(= seconds (LangSwitch 4 6))
			)
			(27
				(eHair
					view: 254
					loop: 4
					x: (willow x:)
					y: (willow y:)
					z: 31
					show:
				)
				(wHair dispose:)
				(PrintDC 9 16 #at 60 20 #dispose) ; "Oh, darling. Just take me home. I'll tell you on the way."
				(= seconds (LangSwitch 4 6))
			)
			(28
				(eHair dispose:)
				(cls)
				(willow setMotion: MoveTo 97 107 self)
			)
			(29
				(willow setMotion: MoveTo -20 107 self)
				(prince
					setLoop: 1
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Walk
					setMotion: MoveTo -20 105
				)
				(gGlobalSound2 stop:)
			)
			(30
				(gGlobalSound number: 24 loop: -1 play:)
				(HandsOn)
				((gCurRoom obstacles:) delete: poly1)
				(willow dispose:)
				(prince dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance tryForHarp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PrintDC 9 17 #at 180 10 #width 110 #dispose) ; "Leave my harp alone! It's mine!"
				(= seconds (LangSwitch 5 8))
				(wFace setScript: mouthMove)
			)
			(1
				(wFace cel: 0 loop: 0 setScript: faceMove)
				(cls)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getDrink of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 0)
			(if (& (gEgo onControl: 1) $0002)
				(gEgo view: 26)
			else
				(gEgo view: 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 110 143 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 40
					loop: 0
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 0 cel: 1 setCycle: Beg self)
			)
			(4
				(= seconds 3)
				(gEgo view: 46 loop: 0 setCycle: Fwd)
			)
			(5
				(proc0_28 75 9 18 67 60 20 25 4) ; "What's wrong, Graham?!"
				(proc0_28 160 9 19 67 60 100 25 5) ; "That's SALT water! Yech!"
				(gEgo normal: 1 view: 0 setCycle: KQ5SyncWalk loop: 0)
				((gEgo head:) show:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getHarp of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 0)
			(if (& (gEgo onControl: 1) $0002)
				(gEgo view: 26)
			else
				(gEgo view: 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 88 121 self)
			)
			(1
				(PrintDC 9 20) ; "Bending down, Graham picks the harp up off the ground and takes it with him."
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 56 loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(SetScore 2)
				(harp dispose:)
				(gEgo get: 10 setCycle: Beg self) ; Harp
			)
			(3
				(gEgo normal: 1 view: 0 setCycle: KQ5SyncWalk loop: 7 cel: 1)
				((gEgo head:) show:)
				((gCurRoom obstacles:) delete: poly10)
				(= cycles 2)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance pond of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (gCast contains: willow)
						(PrintDC 9 21) ; "A lovely little pond surrounds the base of a beautiful weeping willow tree."
					else
						(PrintDC 9 22) ; "There is a small pond here near the edge of a dark forest."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getDrink)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance forest of RFeature
	(properties
		nsBottom 90
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 9 23) ; "To the north, Graham can see the gnarly edge of a deep, dark forest."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance wTear1 of Actor
	(properties
		x 91
		y 30
		view 250
		loop 4
		priority 10
		signal 18448
		illegalBits 0
	)

	(method (setMotion)
		(if (gCast contains: self)
			(super setMotion: &rest)
		)
	)
)

(instance ripple of Prop
	(properties
		x 93
		y 145
		view 250
		loop 5
		priority 1
		signal 16400
	)
)

(instance wFace of Prop
	(properties
		x 97
		y 129
		z 87
		view 250
		signal 16384
	)

	(method (handleEvent event &tmp [temp0 2])
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 9 24) ; "A graceful weeping willow tree grows beside a small pond created from...her tears? In her branch-like arms she clutches a beautiful harp as a child would a cherished toy."
					(event claimed: 1)
				)
				(5 ; Talk
					(if (not (IsFlag 1))
						(SetFlag 1)
						(HandsOff)
						(gCurRoom setScript: talkTree)
					else
						(PrintDC 9 25) ; "Following the willow tree's wishes, Graham politely decides not to bother her further."
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(9
							(gCurRoom setScript: changePrincess)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 9 26) ; "The poor tree is too distraught to care about any of Graham's possessions."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)

	(method (setCycle)
		(if (and (not local114) (gCast contains: self))
			(super setCycle: &rest)
		)
	)

	(method (setScript)
		(if (not local114)
			(super setScript: &rest)
		)
	)
)

(instance wArm of Prop
	(properties
		x 97
		y 130
		z 77
		view 242
		loop 1
		signal 16384
	)

	(method (handleEvent event)
		(switch (event message:)
			(4 ; Inventory
				(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
					(9
						(gCurRoom setScript: changePrincess)
						(event claimed: 1)
					)
				)
			)
		)
	)

	(method (setCycle)
		(if (gCast contains: self)
			(super setCycle: &rest)
		)
	)
)

(instance wHair of Prop
	(properties
		x 63
		y 70
		view 252
		loop 1
		priority 10
		signal 16400
	)
)

(instance eHair of Prop
	(properties
		x 132
		y 65
		view 252
		loop 2
		priority 10
		signal 16400
	)
)

(instance willowProp of Actor
	(properties
		x 95
		y 129
		view 242
		signal 16384
	)

	(method (handleEvent event)
		(willow handleEvent: event)
	)
)

(instance willow of Actor
	(properties
		x 95
		y 129
		view 242
		loop 3
		signal 16384
	)

	(method (doit)
		(super doit:)
		(if (and (not (wFace script:)) (== (global322 loop:) 8))
			(wFace setScript: faceMove)
			(wArm setScript: armMove)
			(wTear1 setScript: tearMove)
		)
	)

	(method (handleEvent event &tmp [temp0 2])
		(cond
			(
				(and
					(MousedOn global322 event)
					(== (event message:) 5) ; Talk
					(not local113)
				)
				(++ local113)
				(proc0_28 75 9 27) ; "What a sad song she plays. Let's try to cheer her up, Graham."
				(event claimed: 1)
			)
			(
				(or
					(event claimed:)
					(not (== (event type:) evVERB))
					(not (MousedOn self event))
				)
				(return)
			)
			(else
				(switch (event message:)
					(2 ; Look
						(PrintDC 9 24) ; "A graceful weeping willow tree grows beside a small pond created from...her tears? In her branch-like arms she clutches a beautiful harp as a child would a cherished toy."
						(event claimed: 1)
					)
					(5 ; Talk
						(if (not (IsFlag 1))
							(SetFlag 1)
							(HandsOff)
							(gCurRoom setScript: talkTree)
						else
							(PrintDC 9 25) ; "Following the willow tree's wishes, Graham politely decides not to bother her further."
						)
						(event claimed: 1)
					)
					(4 ; Inventory
						(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
							(9
								(gCurRoom setScript: changePrincess)
								(event claimed: 1)
							)
							(28
								(event claimed: 0)
							)
							(else
								(PrintDC 9 26) ; "The poor tree is too distraught to care about any of Graham's possessions."
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance harp of Actor
	(properties
		x 89
		y 72
		view 242
		loop 3
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (gCast contains: willow)
						(PrintDC 9 24) ; "A graceful weeping willow tree grows beside a small pond created from...her tears? In her branch-like arms she clutches a beautiful harp as a child would a cherished toy."
					else
						(PrintDC 9 28) ; "A beautiful harp lies on the ground near the small pond."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (gCast contains: willow)
						(if (not (IsFlag 7))
							(HandsOff)
							(SetFlag 7)
							(gCurRoom setScript: tryForHarp)
							(event claimed: 1)
						)
					else
						(HandsOff)
						(gCurRoom setScript: getHarp)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance prince of Actor
	(properties
		x -20
		y 107
		view 146
	)
)

(instance slowChangePrincess of Script
	(properties)

	(method (doit &tmp [temp0 2])
		(super doit:)
		(if (== state 0)
			(if (& (gEgo onControl: 1) $0002)
				(gEgo view: 26)
			else
				(gEgo view: 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 9 9) ; Heart
				(SetScore 4)
				(HandsOff)
				(harp dispose:)
				(gEgo setMotion: PolyPath 120 138 self)
			)
			(1
				(wFace loop: 2 setScript: mouthMove)
				(PrintDC 9 10 #at 140 120 #dispose) ; "My heart! You found it!"
				(= seconds (LangSwitch 5 8))
			)
			(2
				(cls)
				(wTear1 setScript: 0 setMotion: 0 dispose:)
				(ripple dispose:)
				(wFace setScript: 0 setCycle: 0 dispose:)
				(gEgo
					view: 26
					loop: 7
					cel: 3
					setCycle: KQ5SyncWalk
					normal: 1
				)
				((gEgo head:) show:)
				(gGlobalSound stop:)
				(gGlobalSound2 number: 33 loop: 1 play:)
				(wArm setScript: 0 setCycle: 0 dispose:)
				(willow view: 252 loop: 4 cel: (willow lastCel:) startUpd:)
				(eHair
					view: 256
					x: (willow x:)
					y: (willow y:)
					z: 33
					loop: 0
					cycleSpeed: 3
					setCycle: Fwd
					init:
				)
				(= cycles 1)
			)
			(3
				(willow signal: (& (willow signal:) $feff))
				(willow view: 256 loop: 1 cycleSpeed: 0 cel: 0)
				(PrintDC 9 11 #at 20 20 #dispose) ; "I don't need this old thing anymore!"
				(= seconds (LangSwitch 5 8))
			)
			(4
				(cls)
				(eHair hide:)
				(willow loop: 2 cel: 0 setCycle: End self illegalBits: 0)
				(harp
					view: 256
					setLoop: 4
					x: 97
					y: 88
					setCycle: Walk
					illegalBits: 0
					init:
				)
			)
			(5
				(DoAudio audWPLAY 8023)
				(harp show: setMotion: MoveTo 73 124 self)
				(willow loop: 3 cel: 0 setCycle: End)
			)
			(6
				(gGlobalSound3 number: 23 loop: 1 play:)
				(harp setPri: 1)
				((gCurRoom obstacles:) add: poly10)
				(willow view: 254 loop: 2 illegalBits: 0 startUpd:)
				(= cycles 20)
			)
			(7
				(eHair x: (willow x:) y: (willow y:) z: 31 show:)
				(PrintDC 9 12 #at 20 20 #dispose) ; "Look at me! I'm a princess again!"
				(= seconds (LangSwitch 5 8))
			)
			(8
				(eHair hide:)
				(willow
					setCycle: Walk
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: MoveTo 106 107 self
				)
			)
			(9
				(cls)
				(eHair
					view: 254
					loop: 4
					x: (willow x:)
					y: (willow y:)
					z: 31
					show:
				)
				(PrintDC 9 13 #at 60 20 #dispose) ; "Herbert!!"
				(= seconds (LangSwitch 3 5))
				(willow loop: 1)
			)
			(10
				(eHair hide:)
				(prince
					setLoop: 0
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 91 105 self
					init:
				)
				(PrintDC 9 14 #at 20 20 #dispose) ; "Alicia!!"
			)
			(11
				(cls)
				(willow hide:)
				(prince
					posn: 97 106
					loop: 5
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(12
				(prince loop: 6 cel: 0 cycleSpeed: 2 setCycle: End)
				(= seconds 5)
			)
			(13
				(prince setCycle: Beg self)
			)
			(14
				(willow show:)
				(prince setLoop: 0 cel: 0 posn: 91 105)
				(wHair
					view: 146
					loop: 13
					x: (+ (prince x:) 2)
					y: (prince y:)
					z: 35
					cycleSpeed: 3
					setCycle: Fwd
					init:
				)
				(PrintDC 9 15 #at 20 20 #dispose) ; "Where have you been all this time, my love?"
				(= seconds (LangSwitch 4 6))
			)
			(15
				(eHair
					view: 254
					loop: 4
					x: (willow x:)
					y: (willow y:)
					z: 31
					show:
				)
				(wHair dispose:)
				(PrintDC 9 16 #at 60 20 #dispose) ; "Oh, darling. Just take me home. I'll tell you on the way."
				(= seconds (LangSwitch 4 6))
			)
			(16
				(eHair dispose:)
				(cls)
				(willow setMotion: MoveTo 97 107 self)
			)
			(17
				(willow setMotion: MoveTo -20 107 self)
				(prince
					setLoop: 1
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Walk
					setMotion: MoveTo -20 105
				)
				(gGlobalSound2 stop:)
			)
			(18
				(gGlobalSound number: 24 loop: -1 play:)
				(HandsOn)
				((gCurRoom obstacles:) delete: poly1)
				(willow dispose:)
				(prince dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly6 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly7 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly8 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly9 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly10 of Polygon
	(properties
		type PBarredAccess
	)
)

