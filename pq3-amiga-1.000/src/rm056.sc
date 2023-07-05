;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm056 0
)

(local
	local0
	[local1 14] = [89 94 71 80 72 0 229 0 204 86 180 101 140 84]
	[local15 48] = [75 99 57 105 60 120 82 124 112 112 165 147 127 163 98 145 60 172 76 182 286 183 274 146 239 150 211 119 211 115 193 106 211 95 244 0 319 0 319 189 0 189 0 0 55 0 55 78]
	[local63 10] = [212 135 184 150 164 137 175 123 198 124]
	[local73 56] = [75 99 57 105 60 120 82 124 112 112 128 123 163 116 176 125 148 135 165 147 127 163 98 145 60 172 76 182 286 183 274 146 239 150 211 119 211 115 193 106 211 95 244 0 319 0 319 189 0 189 0 0 55 0 55 78]
	[local129 22] = [89 94 71 80 72 0 229 0 204 86 180 101 170 96 150 99 136 96 147 87 140 84]
)

(instance polyList0 of List
	(properties)
)

(instance polyList1 of List
	(properties)
)

(instance polyList2 of List
	(properties)
)

(instance polyList3 of List
	(properties)
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

(instance rm056 of PQRoom
	(properties
		picture 56
	)

	(method (init)
		(poly1 points: @local1 size: 7)
		(poly2 points: @local15 size: 24)
		(poly3 points: @local63 size: 5)
		(poly4 points: @local73 size: 26)
		(poly5 points: @local129 size: 11)
		(polyList0 add: poly1 poly2)
		(polyList1 add: poly1 poly2 poly3)
		(polyList2 add: poly1 poly4)
		(polyList3 add: poly2 poly5)
		(self obstacles: polyList0)
		(self posn: 84 94)
		(cushion init:)
		(theDoor init:)
		(thePaper init:)
		(thePicture init:)
		(theWalls init:)
		(theWindow init:)
		(theCouch approachVerbs: 3 init:) ; Do
		(stairs init:)
		(theRoom init:)
		(LoadMany rsVIEW 592 605)
		(gEgo observeControl: 8 ignoreControl: 4)
		(switch gPrevRoomNum
			(55
				(if (and ((gInventory at: 1) state:) (not (IsFlag 50))) ; gun
					(gEgo
						normal: 1
						view: 590
						loop: 0
						setStep: 3 2
						posn: 88 83
						init:
						hide:
					)
					(HandsOff)
					(self setScript: enterGunScript)
				else
					(gEgo view: 4 loop: 2 setStep: 3 2 posn: 76 85 init:)
					(self setScript: (ScriptID 896 1)) ; sWI
				)
			)
			(57
				(SetFlag 50)
				(SetFlag 53)
				(if ((gInventory at: 1) state:) ; gun
					(gEgo
						normal: 0
						view: 589
						posn: 175 108
						loop: (gEgo cel:)
						setCycle: Walk
						init:
					)
				else
					(gEgo view: 4 loop: 2 setStep: 3 2 posn: 175 108 init:)
				)
			)
			(else
				(SetFlag 50)
				(SetFlag 53)
				(if ((gInventory at: 1) state:) ; gun
					(gEgo
						normal: 0
						view: 589
						posn: 175 108
						loop: (gEgo cel:)
						setCycle: Walk
						init:
					)
				else
					(gEgo view: 4 loop: 2 setStep: 3 2 posn: 175 108 init:)
				)
			)
		)
		(if (not (IsFlag 53))
			(fireplace init: stopUpd:)
		else
			(gEgo ignoreControl: 8)
			(stairs init:)
		)
		(tv approachVerbs: 3 setCycle: Fwd init:) ; Do
		(tvSound flags: 1 play:)
		(if (IsFlag 52)
			(if (gEgo has: 43) ; remoteControl
				(self obstacles: polyList3)
				(dog loop: 4 posn: 159 95 init:)
			else
				(self obstacles: polyList2)
				(dog loop: 5 posn: 150 127 init:)
			)
		)
		(if (not (IsFlag 50))
			(mSound play:)
			(dust init:)
		else
			(badGuy posn: global184 global185 loop: 3 cel: 8 stopUpd: 1 init:)
		)
		(super init:)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((& temp0 $0002)
				(cond
					((gCast contains: bains)
						(HandsOff)
						(gCurRoom setScript: goBack)
					)
					((not (IsFlag 190))
						(HandsOff)
						(gCurRoom setScript: goBack)
					)
					(else
						(gCurRoom newRoom: 55)
					)
				)
			)
			((& temp0 $0008)
				(gCurRoom newRoom: 57)
			)
			((and (not (badGuy script:)) (not (IsFlag 50)))
				(SetFlag 50)
				(badGuy setScript: shootOutScript init:)
			)
			((and (gEgo normal:) ((gInventory at: 1) state:)) ; gun
				(HandsOff)
				(gCurRoom setScript: drawGunScript)
			)
			(
				(and
					(not (gEgo normal:))
					(not ((gInventory at: 1) state:)) ; gun
					(not local0)
				)
				(HandsOff)
				(gCurRoom setScript: holsterGunScript)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(= global184 (badGuy x:))
		(= global185 (badGuy y:))
		(gEgo setAvoider: 0)
		(polyList0 dispose:)
		(polyList1 dispose:)
		(polyList2 dispose:)
		(polyList3 dispose:)
		(super dispose:)
	)
)

(instance goBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((gCast contains: bains)
						(Print 56 0) ; "You had better do something with the suspect first."
					)
					((not (IsFlag 190))
						(Print 56 1) ; "You better check out the room first."
					)
				)
				(gEgo setMotion: MoveTo 84 94 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterGunScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dust setCycle: End self)
			)
			(1
				(gEgo normal: 0 loop: 0 setCycle: CT 3 1 self show:)
				(dust dispose:)
			)
			(2
				(gEgo setPri: 6 cycleSpeed: 8 setCycle: End self)
			)
			(3
				(gEgo
					posn: 67 86
					setPri: -1
					cycleSpeed: (gEgo moveSpeed:)
					cel: 0
					loop: 1
					setCycle: End self
				)
			)
			(4
				(gEgo
					view: 589
					setCycle: Walk
					loop: 2
					setMotion: MoveTo 84 94 self
				)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance drawGunScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					view: 589
					loop: (gEgo cel:)
					setCycle: Walk
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance holsterGunScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
				(gEgo normal: 1 view: 4 setCycle: Walk)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance drawScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(gEgo
					normal: 0
					view: 9
					loop: 5
					cel: 0
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(2
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance shootOutScript of Script
	(properties)

	(method (doit)
		(if
			(and
				(& (gEgo onControl: 0) $0004)
				(== (shootOutScript state:) 0)
			)
			(self changeState: 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(User canControl: 0)
				(gEgo setMotion: 0)
				(badGuy cycleSpeed: 4 setCycle: End self init:)
				(sFX number: 566 play:)
			)
			(2
				(badGuy
					loop: (if (< (gEgo x:) 116) 2 else 1)
					cel: 0
					posn: 88 142
					cycleSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(3
				(if (< (gEgo x:) 116)
					(bulletHole posn: 91 55)
				)
				(bulletHole init:)
				(badGuy setCycle: End self)
				(gunShotSound play:)
			)
			(4
				(HandsOff)
				(= local0 1)
				(badGuy cel: 0 setCycle: CT 5 1 self)
			)
			(5
				(badGuy setCycle: CT 6 1)
				(gEgo
					normal: 0
					view: 605
					loop: 3
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(gunShotSound play:)
			)
			(6
				(= seconds 4)
			)
			(7
				(EgoDead 10) ; "Next time you enter a suspect dwelling, make sure both you and your gun are ready!"
			)
		)
	)
)

(instance shootBadGuy of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (badGuy loop:) 3)
					(= state -1)
				)
				(= cycles 1)
			)
			(1
				(gEgo normal: 0 view: 590 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(badGuy setScript: 0 loop: 3 cel: 4 setCycle: End self)
				(gunShotSound play:)
			)
			(3
				(gEgo cel: 3 setCycle: Beg)
				(SetScore 190 10)
				(= seconds 3)
			)
			(4
				(gEgo view: 590 loop: 1 cel: 4 setCycle: Beg self)
			)
			(5
				(= save1 1)
				(Say gEgo 56 2) ; "Freeze!"
				(= seconds 2)
			)
			(6
				(bains setLoop: 1 setCycle: Walk init:)
				(Say bains 56 3) ; "Don't shoot, I give up."
				(= seconds 3)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(bains setMotion: MoveTo 186 137 self)
			)
			(8
				(gEgo view: 589 setCycle: Walk loop: 2)
				(gCurRoom obstacles: polyList1)
				(bains loop: 5 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance couchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 130 122 self)
			)
			(1
				(gEgo setMotion: MoveTo 116 123 self)
			)
			(2
				(gEgo
					normal: 0
					view: 590
					loop: 4
					cel: 0
					setPri: 12
					setCycle: End self
				)
			)
			(3
				(if (not (gEgo has: 43)) ; remoteControl
					(gEgo get: 43) ; remoteControl
					(SetScore 192 5)
					(Print 56 4) ; "You look underneath the filthy cushion and find a remote control."
					(if (gCast contains: dog)
						(gCurRoom obstacles: polyList3)
						(dog
							setLoop: 8
							setCycle: Walk
							setMotion: MoveTo 159 95 self
						)
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
				(gEgo normal: 1 view: 4 loop: 5 setPri: -1 setCycle: Walk)
			)
			(4
				(if (gCast contains: dog)
					(dog loop: 6)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cuffHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 200 146 self)
			)
			(1
				(gEgo setMotion: MoveTo 200 146 self)
			)
			(2
				((gInventory at: 1) state: 0) ; gun
				(gEgo normal: 0 view: 593 loop: 3 cel: 0 setCycle: End)
				(bains loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 4 cel: 0 setCycle: CT 7 1 self)
				(sFX number: 918 play:)
			)
			(4
				(gEgo normal: 1 view: 4 loop: 7 setCycle: Walk put: 2 56) ; handcuff
				((gInventory at: 1) cursor: 15) ; gun
				(SetScore 191 5)
				(bains setLoop: 0)
				(Animate (gCast elements:) 0)
				(Print 56 5) ; "You feel a sense of satisfaction as you slip the cuffs on the wrists of Michael Bains."
				(officer
					setLoop: 4
					setCycle: Walk
					setMotion: PolyPath 176 144 self
					init:
				)
			)
			(5
				(gCurRoom obstacles: polyList0)
				(Face officer gEgo)
				(Say officer 56 6) ; "I'll take it from here, Sonny."
				(= seconds 4)
			)
			(6
				(mSound fade:)
				(officer loop: 3)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(bains setCycle: Walk setMotion: PolyPath 148 118 self)
			)
			(7
				(bains setMotion: PolyPath 52 85 self)
				(officer setLoop: 7 ignoreActors: 1 setMotion: PolyPath 52 85)
			)
			(8
				(bains setMotion: MoveTo 25 85 self)
			)
			(9
				(bains dispose:)
				(officer setMotion: MoveTo 25 85 self)
			)
			(10
				(officer dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openFireplace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stairs init:)
				(moveFirePlaceSnd play:)
				(fireplace setCycle: End self)
			)
			(1
				(gEgo ignoreControl: 8)
				(SetFlag 53)
				(fireplace dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shootSonny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(bains view: 594 cel: 0 setCycle: CT 7 1 self)
			)
			(2
				(gunShotSound play:)
				(gEgo
					normal: 0
					view: 605
					loop: 3
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(bains view: 594 setCycle: End)
			)
			(3
				(EgoDead 23) ; "A good cop is ALWAYS prepared."
			)
		)
	)
)

(instance talkBains of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Say gEgo 56 7) ; "Don't you move an inch, buddy."
				(= seconds 5)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance badGuy of Prop
	(properties
		x 71
		y 156
		view 592
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (!= loop 3)
					(Print 56 8) ; "This is not the time to be checking him out."
				else
					(Print 56 9) ; "The man you shot is dead."
				)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(if (not (IsFlag 190))
							(if ((gInventory at: 1) state:) ; gun
								(HandsOff)
								(self setScript: 0)
								(gCurRoom setScript: shootBadGuy)
							else
								(gEgo setScript: drawScript)
							)
						else
							(Print 56 10) ; "You already dealt with him."
						)
					)
					(else
						(Print 56 11) ; "That will really stop him."
					)
				)
			)
			(3 ; Do
				(if (not (IsFlag 190))
					(Print 56 12) ; "You must think you're superman?"
				else
					(Print 56 13) ; "There is nothing of interest on him."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fireplace of Prop
	(properties
		x 203
		y 104
		lookStr {A large fireplace dominates the room.}
		view 595
		priority 4
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 56 14) ; "You examine the fireplace but do not find anything of interest."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tv of Prop
	(properties
		x 237
		y 127
		approachX 220
		approachY 136
		lookStr {You don't have time for that now!}
		view 595
		loop 1
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(43 ; remoteControl
						(if (gCast contains: fireplace)
							(HandsOff)
							(gCurRoom setScript: remoteScript)
						else
							(Print 56 15) ; "You already have the passage open."
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(3 ; Do
				(Print 56 16) ; "You examine the TV but find nothing unusual."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dust of Prop
	(properties
		x 106
		y 68
		view 598
		signal 16384
		cycleSpeed 14
	)
)

(instance bulletHole of View
	(properties
		x 165
		y 70
		view 592
		loop 4
		priority 5
		signal 16
	)
)

(instance bains of Actor
	(properties
		x 267
		y 189
		sightAngle 30
		lookStr {A second suspect is surrendering. It takes you a moment to realize it's... it's Michael Bains!}
		view 593
		signal 16384
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (gCurRoom script:))
				(== loop 5)
				(== (gEgo view:) 4)
				(self facingMe: gEgo)
			)
			(HandsOff)
			(gCurRoom setScript: shootSonny)
		)
	)

	(method (facingMe param1 &tmp temp0 temp1)
		(= temp0 (if argc param1 else gEgo))
		(if
			(>
				(= temp1
					(Abs
						(- (GetAngle x y (temp0 x:) (temp0 y:)) (self heading:))
					)
				)
				180
			)
			(= temp1 (- 360 temp1))
		)
		(if (<= temp1 sightAngle)
			(return 1)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(2 ; handcuff
						(HandsOff)
						(gCurRoom setScript: cuffHim)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(3 ; Do
				(Print 56 17) ; "You better restrain him first."
			)
			(5 ; Talk
				(HandsOff)
				(gCurRoom setScript: talkBains)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance officer of Actor
	(properties
		x 58
		y 91
	)
)

(instance dog of Actor
	(properties
		lookStr {Spike looks agitated. He seems to have found something.}
		view 597
		signal 16384
		cycleSpeed 12
		moveSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 56 18) ; "Spike prefers not to be petted while he's concentrating."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cushion of Feature
	(properties
		onMeCheck 16
		lookStr {A scuffed up cushion sits on the couch.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((gEgo has: 43) ; remoteControl
						(Print 56 19) ; "There is nothing more under the cushion."
					)
					((gCast contains: bains)
						(Print 56 20) ; "Now is not the time to snoop around."
					)
					(else
						(HandsOff)
						(gCurRoom setScript: couchScript)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stairs of Feature
	(properties
		x 202
		y 93
		onMeCheck 16384
		lookStr {Part of the fireplace has moved away to reveal a hidden staircase.}
	)
)

(instance theDoor of Feature
	(properties
		x 101
		y 103
		onMeCheck 512
		lookStr {The ruined steel door lies useless on the floor.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 56 21) ; "Now that the door's been knocked in, it doesn't interest you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePaper of Feature
	(properties
		x 78
		y 131
		onMeCheck 128
		lookStr {Newspapers are scattered around the floor.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 56 22) ; "You see nothing of interest."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePicture of Feature
	(properties
		x 249
		y 64
		onMeCheck 64
		lookStr {She's from December, if you remember correctly.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 56 23) ; "Marie wouldn't approve of you taking that picture home."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theWalls of Feature
	(properties
		x 139
		y 76
		onMeCheck 4096
		lookStr {The walls are cracked and peeling.}
	)
)

(instance theWindow of Feature
	(properties
		x 115
		y 70
		onMeCheck 256
		lookStr {There are bars on the windows.}
	)
)

(instance theCouch of Feature
	(properties
		x 145
		y 138
		onMeCheck 1024
		approachX 152
		approachY 139
		lookStr {The old couch has a few cushions on it.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 56 24) ; "There's nothing under that cushion."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		x 160
		y 100
		lookStr {You're in the alleged crack house.}
	)
)

(class remoteBut of Prop
	(properties
		priority 15
		signal 17
		cycleSpeed 0
		number 0
		keyEquiv 0
		whoCalled 0
	)

	(method (init param1)
		(super init:)
		(self whoCalled: param1)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(cond
					((InRect nsLeft nsTop nsRight nsBottom event)
						(self setCycle: Beg)
						(whoCalled register: (self number:))
						(event claimed: 1)
					)
					((== (event message:) keyEquiv)
						(self setCycle: Beg)
						(whoCalled register: (self number:))
						(event claimed: 1)
					)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(self setCycle: Beg)
					(whoCalled register: (self number:))
					(event claimed: 1)
				)
			)
		)
	)
)

(instance remote of View
	(properties
		x 145
		y 110
		view 591
		priority 14
		signal 16
	)

	(method (init param1)
		(no1 init: param1)
		(no2 init: param1)
		(no3 init: param1)
		(no4 init: param1)
		(no5 init: param1)
		(no6 init: param1)
		(no7 init: param1)
		(no8 init: param1)
		(no9 init: param1)
		(no10 init: param1)
		(pwr init: param1)
		(super init:)
	)

	(method (dispose)
		(no1 dispose:)
		(no2 dispose:)
		(no3 dispose:)
		(no4 dispose:)
		(no5 dispose:)
		(no6 dispose:)
		(no7 dispose:)
		(no8 dispose:)
		(no9 dispose:)
		(no10 dispose:)
		(pwr dispose:)
		(super dispose:)
	)
)

(instance no1 of remoteBut
	(properties
		x 133
		y 66
		view 591
		loop 2
		number 1
		keyEquiv 49
	)
)

(instance no2 of remoteBut
	(properties
		x 144
		y 66
		view 591
		loop 3
		number 2
		keyEquiv 50
	)
)

(instance no3 of remoteBut
	(properties
		x 155
		y 66
		view 591
		loop 4
		number 3
		keyEquiv 51
	)
)

(instance no4 of remoteBut
	(properties
		x 133
		y 76
		view 591
		loop 5
		number 4
		keyEquiv 52
	)
)

(instance no5 of remoteBut
	(properties
		x 144
		y 76
		view 591
		loop 6
		number 5
		keyEquiv 53
	)
)

(instance no6 of remoteBut
	(properties
		x 155
		y 76
		view 591
		loop 7
		number 6
		keyEquiv 54
	)
)

(instance no7 of remoteBut
	(properties
		x 133
		y 86
		view 591
		loop 8
		number 7
		keyEquiv 55
	)
)

(instance no8 of remoteBut
	(properties
		x 144
		y 86
		view 591
		loop 9
		number 8
		keyEquiv 56
	)
)

(instance no9 of remoteBut
	(properties
		x 155
		y 86
		view 591
		loop 10
		number 9
		keyEquiv 57
	)
)

(instance no10 of remoteBut
	(properties
		x 133
		y 96
		view 591
		loop 12
		number 9
		keyEquiv 57
	)
)

(instance pwr of remoteBut
	(properties
		x 149
		y 96
		view 591
		loop 11
		keyEquiv 48
	)
)

(instance remoteScript of Script
	(properties)

	(method (doit)
		(if
			(and
				(OneOf state 0 1)
				(or (not (gCast contains: remote)) (& (remote signal:) $0080))
			)
			(self state: 1 cue:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(Face gEgo tv)
				(gTheIconBar disable:)
				(User canInput: 1)
				(User mapKeyToDir: 0)
				(remote init: self)
				(gTheIconBar enable: 2)
				(gGame setCursor: 20)
				(self register: -1)
				(= cycles 3)
			)
			(1
				(switch register
					(2
						(tv loop: 2)
					)
					(8
						(HandsOff)
						(SetScore 193 5)
						(gCurRoom setScript: openFireplace)
						(User mapKeyToDir: 1)
						(remote dispose:)
						(gTheIconBar enable:)
					)
					(-1
						(= state 0)
					)
					(else
						(tv loop: 1)
					)
				)
				(= cycles 6)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(User mapKeyToDir: 1)
				(remote dispose:)
				(gTheIconBar enable:)
				(self dispose:)
			)
		)
	)
)

(instance tvSound of Sound
	(properties
		number 565
		loop -1
	)
)

(instance sFX of Sound
	(properties)
)

(instance gunShotSound of Sound
	(properties
		number 937
	)
)

(instance moveFirePlaceSnd of Sound
	(properties
		number 567
	)
)

(instance mSound of Sound
	(properties
		flags 1
		number 530
		loop -1
	)
)

