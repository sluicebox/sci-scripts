;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm009 0
)

(local
	local0
	[local1 14] = [71 116 53 118 46 123 53 128 132 130 143 126 141 120]
	[local15 14] = [41 131 24 135 27 139 53 144 96 144 96 136 56 133]
	[local29 14] = [9 157 50 157 49 149 37 148 25 141 0 141 1 149]
	[local43 10] = [42 166 53 161 91 161 88 168 63 172]
	[local53 10] = [142 156 168 161 194 155 191 151 141 151]
	[local63 10] = [141 119 189 117 207 117 200 110 135 110]
	[local73 10] = [163 123 232 118 226 127 191 129 152 127]
	[local83 12] = [179 189 195 182 250 183 265 186 319 171 319 189]
	[local95 10] = [0 101 233 99 319 109 319 0 0 0]
	[local105 8] = [72 114 80 123 68 131 59 123]
	local113
)

(instance rm009 of Rm
	(properties
		picture 9
		east 8
		south 10
		west 13
	)

	(method (init)
		(super init:)
		(= global320 190)
		(= global321 83)
		(= global325 {"Come on, Graham. Let's go someplace else!"})
		(gGlobalSound number: 24 loop: -1 play:)
		(= local0 (gEgo illegalBits:))
		(cond
			((!= ((gInventory at: 9) owner:) 9) ; Heart
				(self addObstacle: poly1)
				(gGlobalSound2 number: 32 loop: -1 play:)
				(harp init: stopUpd:)
				(wFace cycleSpeed: 3 init: stopUpd:)
				(wArm cycleSpeed: 5 init: stopUpd:)
				(wTear1 init: yStep: 4 hide:)
				(ripple init: hide:)
				(willow init: stopUpd:)
			)
			((== ((gInventory at: 10) owner:) 9) ; Harp
				(harp
					view: 256
					setLoop: 4
					setPri: 1
					posn: 56 124
					init:
					stopUpd:
				)
			)
		)
		(self setFeatures: pond forest setRegions: 202) ; owl
		(gEgo illegalBits: $8000 offset: 3 init:)
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
					(gCast contains: willow)
					(not (wFace script:))
					(== (global322 loop:) 8)
				)
				(wFace setScript: faceMove)
				(wArm setScript: armMove)
				(wTear1 setScript: tearMove)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
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
			(if (proc0_15 temp1 1 4)
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
				(Say 160 9 0 67 140 100 25 3) ; "Uh, Miss...Willow?"
				(RedrawCast)
				(PrintDC 9 1 #at 180 10 #dispose) ; "Yes?"
				(wFace loop: 2 setCycle: 0 setScript: mouthMove)
				(= seconds 2)
			)
			(3
				(cls)
				(wFace cel: 0 setScript: 0)
				(Say 160 9 2 67 140 100 25 3) ; "You can talk?"
				(RedrawCast)
				(PrintDC 9 3 #at 180 10 #width 120 #dispose) ; "Why, of COURSE I can! What did you expect?"
				(wFace setScript: mouthMove)
				(= seconds 4)
			)
			(4
				(cls)
				(wFace cel: 0 setScript: 0)
				(Say 160 9 4 67 135 100 25 5) ; "Well, I've never seen a talking tree before. What's wrong?"
				(RedrawCast)
				(PrintDC 9 5 #at 180 10 #width 120 #dispose) ; "Everything's wrong! Can't you tell? I'm not really a tree...I'm really a princess. (Sigh.) You see, my fiance and I were walking through this wood when a nasty old witch came along and was instantly charmed by my handsome prince."
				(wFace setScript: mouthMove)
				(= seconds 10)
			)
			(5
				(PrintDC 9 6 #at 180 10 #width 120 #dispose) ; "When he naturally refused her advances, she jealously banished him to a faraway land and turned me into a tree. Then she stole my heart!"
				(= seconds 8)
			)
			(6
				(cls)
				(wFace cel: 0 setScript: 0)
				(Say 160 9 7 67 140 100 25 3) ; "Stole your heart?"
				(RedrawCast)
				(PrintDC 9 8 #at 180 10 #width 120 #dispose) ; "Yes. She turned my heart to gold and took it away with her. The only way I can become human again is to have my heart brought back."
				(wFace setScript: mouthMove)
				(= seconds 10)
			)
			(7
				(PrintDC 9 9 #at 180 10 #width 120 #dispose) ; "Now all I have to cheer me up is my harp. It's quite magical, you know. It plays the sweetest music you've ever heard. Now please! Leave me alone in my sorrow."
				(wFace setScript: mouthMove)
				(= seconds 10)
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
				(harp dispose:)
				(gEgo setMotion: PolyPath 120 138 self)
			)
			(1
				(wFace loop: 2 setScript: mouthMove)
				(PrintDC 9 10 #at 140 120 #dispose) ; "My heart! You found it!"
				(= seconds 5)
			)
			(2
				(cls)
				(wTear1 setScript: 0 dispose:)
				(ripple dispose:)
				(wFace setScript: 0 dispose:)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 242
					loop: 4
					cel: 0
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(3
				(wArm
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
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(5
				(gGlobalSound stop:)
				(gEgo put: 9 9) ; Heart
				(SetScore 4)
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
					cycleSpeed: 0
					setCycle: Walk
					normal: 1
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(8
				(wArm setScript: 0 dispose:)
				(willow view: 252 loop: 0 cel: 0 startUpd:)
				(eHair cycleSpeed: 2 setCycle: End self init:)
				(wHair cycleSpeed: 2 setCycle: End self init:)
			)
			(9)
			(10
				(eHair dispose:)
				(wHair dispose:)
				(= cycles 2)
			)
			(11
				(willow loop: 3 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(12
				(willow loop: 4 cel: 0 setCycle: End self)
			)
			(13
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
				(= seconds 5)
			)
			(14
				(eHair hide:)
				(cls)
				(= cycles 5)
			)
			(15
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
			(16
				(harp show: setMotion: MoveTo 73 124 self)
				(willow loop: 3 cel: 0 setCycle: End)
			)
			(17
				(gGlobalSound3 number: 23 loop: 1 play:)
				(harp setPri: 1)
				((gCurRoom obstacles:) add: poly10)
				(willow view: 254 loop: 2 illegalBits: 0 startUpd:)
				(= cycles 20)
			)
			(18
				(eHair x: (willow x:) y: (willow y:) z: 31 show:)
				(PrintDC 9 12 #at 20 20 #dispose) ; "Look at me! I'm a princess again!"
				(= seconds 5)
			)
			(19
				(eHair hide:)
				(willow
					setCycle: Walk
					moveSpeed: 2
					setMotion: MoveTo 106 107 self
				)
			)
			(20
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
				(willow loop: 1)
				(= seconds 3)
			)
			(21
				(eHair hide:)
				(prince
					setLoop: 0
					setCycle: Walk
					moveSpeed: 2
					setMotion: MoveTo 91 105 self
					init:
				)
				(PrintDC 9 14 #at 20 20 #dispose) ; "Alicia!!"
			)
			(22
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
			(23
				(prince loop: 6 cel: 0 cycleSpeed: 2 setCycle: End)
				(= seconds 5)
			)
			(24
				(prince setCycle: Beg self)
			)
			(25
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
				(= seconds 4)
			)
			(26
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
				(= seconds 4)
			)
			(27
				(eHair dispose:)
				(cls)
				(willow setMotion: MoveTo 97 107 self)
			)
			(28
				(willow setMotion: MoveTo -20 107 self)
				(prince
					setLoop: 1
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo -20 105
				)
				(gGlobalSound2 stop:)
			)
			(29
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
				(= seconds 5)
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
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 0 cel: 1 cycleSpeed: 1 setCycle: Beg self)
			)
			(4
				(gEgo view: 46 loop: 0 cycleSpeed: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(Say 75 9 18 67 160 20 25 4) ; "What's wrong, Graham?!"
				(Say 160 9 19 67 140 100 25 5) ; "That's SALT water! Yech!"
				(gEgo normal: 1 view: 0 setCycle: Walk loop: 0 cycleSpeed: 0)
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
				(gEgo normal: 1 view: 0 setCycle: Walk loop: 7 cel: 1)
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
				(not (proc0_18 self event))
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

(instance wTear1 of Act
	(properties
		y 30
		x 91
		view 250
		loop 4
		priority 10
		signal 18448
		illegalBits 0
	)
)

(instance ripple of Prop
	(properties
		y 145
		x 93
		view 250
		loop 5
		priority 1
		signal 16400
	)
)

(instance wFace of Prop
	(properties
		y 129
		x 97
		z 87
		view 250
		signal 16384
	)
)

(instance wArm of Prop
	(properties
		y 130
		x 97
		z 77
		view 242
		loop 1
		signal 16384
	)
)

(instance wHair of Prop
	(properties
		y 70
		x 63
		view 252
		loop 1
		priority 10
		signal 16400
	)
)

(instance eHair of Prop
	(properties
		y 65
		x 132
		view 252
		loop 2
		priority 10
		signal 16400
	)
)

(instance willow of Act
	(properties
		y 129
		x 95
		view 242
		signal 16384
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(proc0_18 global322 event)
					(== (event message:) 4) ; Talk
					(not local113)
				)
				(++ local113)
				(Say 75 9 24) ; "What a sad song she plays. Let's try to cheer her up, Graham."
				(event claimed: 1)
			)
			(
				(or
					(event claimed:)
					(not (== (event type:) evVERB))
					(not (proc0_18 self event))
				)
				(return)
			)
			(else
				(switch (event message:)
					(2 ; Look
						(PrintDC 9 25) ; "A graceful weeping willow tree grows beside a small pond created from...her tears? In her branch-like arms she clutches a beautiful harp as a child would a cherished toy."
						(event claimed: 1)
					)
					(4 ; Talk
						(if (not (IsFlag 1))
							(SetFlag 1)
							(HandsOff)
							(gCurRoom setScript: talkTree)
						else
							(PrintDC 9 26) ; "Following the willow tree's wishes, Graham politely decides not to bother her further."
						)
						(event claimed: 1)
					)
					(5 ; Inventory
						(switch global69
							(9 ; Heart
								(HandsOff)
								(gCurRoom setScript: changePrincess)
								(event claimed: 1)
							)
							(28 ; Wand
								(event claimed: 0)
							)
							(else
								(PrintDC 9 27) ; "The poor tree is too distraught to care about any of Graham's possessions."
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance harp of Act
	(properties
		y 72
		x 89
		view 242
		loop 3
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (gCast contains: willow)
						(PrintDC 9 25) ; "A graceful weeping willow tree grows beside a small pond created from...her tears? In her branch-like arms she clutches a beautiful harp as a child would a cherished toy."
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

(instance prince of Act
	(properties
		y 107
		x -20
		view 146
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

