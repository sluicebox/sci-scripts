;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm055 0
)

(local
	local0
	local1
)

(instance rm055 of PQRoom
	(properties
		picture 55
		east -1
		south -1
		west -1
	)

	(method (init)
		(SetScore 177 5)
		(super init:)
		(yourCar init:)
		(frontDoor approachVerbs: 3 init:) ; Do
		(dog setCycle: Fwd setScript: barkDogScript init:)
		(gEgo normal: 1 setStep: 3 2 posn: -40 -40 setPri: 13 init:)
		(if (gEgo has: 9) ; judicialOrder
			(= local1 1)
			(if (!= gPrevRoomNum 56)
				(bSound setVol: 5 init: play:)
			)
			(pCar init:)
			(gAddToPics add: pCar doit:)
			(yourCar setPri: 14)
			(yourDoor init:)
			(officer init:)
			(halfTrack init:)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 135 36 125 72 139 68 155 0 172
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 128 189 183 173 217 189
						yourself:
					)
			)
		)
		(if (== gPrevRoomNum 56)
			(HandsOff)
			(= local1 0)
			(halfTrack addToPic:)
			(frontDoor addToPic:)
			(yourDoor addToPic:)
			(officer dispose:)
			((gInventory at: 1) state: 0) ; gun
			(gEgo view: 5 posn: 123 106)
			(frontDoor cel: 4 addToPic:)
			(if (not (IsFlag 52))
				(handler init: stopUpd:)
				(self setScript: dogScript)
			else
				(handler loop: 3 init: stopUpd:)
				(self setScript: exitScript)
			)
			(= local0 1)
		else
			(yourDoor init:)
			(shadowWindow init:)
			(if (not (gEgo has: 9)) ; judicialOrder
				(erieSound play:)
			)
			(gEgo
				normal: 0
				view: 17
				loop: 3
				cel: 0
				posn: (- (yourCar x:) 15) (- (yourCar y:) 25)
				setPri: 13
				observeControl: 4
			)
			(self setScript: exitCar)
			(pat posn: (+ (yourCar x:) 15) (- (yourCar y:) 6) init:)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 73 0 0 319 0 319 23 262 113 231 130 169 114 162 114 156 115 138 122 128 115 143 105 132 102 149 94 139 89 120 99 102 96 87 106 73 103 52 107 35 95 55 87
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 329 149 265 184 219 173 199 177 179 166 167 155 162 151 163 146 189 137 211 150 205 161 216 160 275 120 275 111 319 40 329 148
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 72 167 115 189 17 189 0 189
					yourself:
				)
		)
		(barrel init:)
		(stairs init:)
		(wreak init:)
		(theHouse init:)
		(porch init:)
		(meter approachVerbs: 2 init:) ; Look
		(windows init:)
		(theRoom init:)
		(theStair init: stopUpd:)
		(if (and (not (IsFlag 62)) (== gDay 6))
			(SetFlag 62)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(local1 0)
			((& temp0 $0010)
				(gEgo priority: 14 signal: (| $0010 (gEgo signal:)))
			)
			(else
				(gEgo priority: -1 signal: (& $ffef (gEgo signal:)))
			)
		)
		(cond
			(script
				(script doit:)
			)
			((& temp0 $0002)
				(HandsOff)
				(self setScript: stairScript)
			)
			((& temp0 $0004)
				(gCurRoom newRoom: 56)
			)
			((and (== (frontDoor cel:) 0) ((gInventory at: 1) state:)) ; gun
				(HandsOff)
				(gCurRoom setScript: ramScript)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gEgo ignoreControl: 4)
		(super dispose:)
	)
)

(instance exitScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 120 110 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitCar of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_17 10)
				(HandsOff)
				(= seconds 2)
			)
			(1
				(ShowClock 1)
				(= seconds 2)
			)
			(2
				(if (gEgo has: 9) ; judicialOrder
					(Print 55 0) ; "Thanks to Judge Simpson, the ram is in place and ready to go."
				)
				(sfx1 number: 900 play:)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(sfx1 number: 901 play:)
				(gEgo
					normal: 1
					view: 5
					setCycle: Walk
					posn: (- (gEgo x:) 7) (+ (gEgo y:) 2)
					cycleSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 36 178 self
				)
			)
			(5
				(= save1 1)
				(ShowClock 0)
				(if (and (not (gEgo has: 9)) (not (gEgo has: 8))) ; judicialOrder, warrant
					(pInset init:)
					(Say pInset 55 1) ; "I'll wait here for you Sonny."
					(= seconds 4)
				else
					(pInset init:)
					(Say pInset 55 2) ; "I got the back, Sonny. Keep your head down."
					(= seconds 4)
					(+= state 1)
				)
			)
			(6
				(= local1 0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pInset dispose:)
				(HandsOn)
				(self dispose:)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pInset dispose:)
				(sfx1 number: 900 play:)
				(= cycles 1)
			)
			(8
				(yourDoor setCycle: End self)
			)
			(9
				(if (gEgo has: 9) ; judicialOrder
					(yourDoor addToPic:)
				)
				(pat setCycle: Beg self)
			)
			(10
				(yourCar setPri: 15)
				(yourDoor setPri: 15)
				(pat
					view: 20
					loop: 3
					setCycle: SyncWalk
					cycleSpeed: 4
					moveSpeed: 4
					setMotion: MoveTo 65 240 self
				)
			)
			(11
				(if (gCast contains: halfTrack)
					(= cycles 1)
				else
					(pat setMotion: PolyPath 134 189 self)
				)
			)
			(12
				(if (gCast contains: halfTrack)
					(= cycles 1)
				else
					(pat setPri: -1 setMotion: PolyPath 340 145 self)
				)
			)
			(13
				(= local1 0)
				(HandsOn)
				(pat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance enterCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 36 178 self)
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(- (yourCar x:) 15)
						(- (yourCar y:) 25)
						self
				)
			)
			(2
				(sfx1 number: 900 play:)
				(gEgo
					normal: 0
					view: 17
					posn: (- (yourCar x:) 15) (- (yourCar y:) 25)
					loop: 3
					cel: 8
					setCycle: Beg self
				)
			)
			(3
				(sfx1 number: 901 play:)
				(gEgo setPri: -1 dispose:)
				(= cycles 1)
			)
			(4
				(if (pat script:)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(gCurRoom newRoom: 25)
			)
		)
	)
)

(instance enterCarP of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pat
					setMotion: PolyPath 65 240 self
					setPri: 15
					setCycle: Walk
					init:
				)
			)
			(1
				(pat
					setMotion:
						PolyPath
						(+ (yourCar x:) 15)
						(- (yourCar y:) 6)
						self
				)
			)
			(2
				(pat view: 457 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance knockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normal: 0 view: 575 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gEgo loop: 1 cel: 0 setCycle: Fwd)
				(sfx1 number: 552 loop: 1 play: self)
			)
			(2
				(gEgo loop: 2 cel: 0 setCycle: End self)
				(sfx1 stop:)
			)
			(3
				(shadowWindow setCycle: End self)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (gEgo has: 8) ; warrant
					(Print 55 3) ; "Obviously there IS somebody home."
					(Print 55 4) ; "You'll have to find some other way to serve that search warrant."
					(SetScore 188 5)
				else
					(Print 55 5) ; "You can hear movement inside the house, but no one answers."
					(SetScore 185 5)
				)
				(gEgo normal: 1 setCycle: Walk view: 5 loop: 6)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance ramScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(sInset init:)
				(Say sInset 55 6) ; "Wait until I'm in position then take out the door."
				(= seconds 6)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sInset dispose:)
				(gEgo setMotion: PolyPath 102 96 self)
			)
			(2
				(if ((gInventory at: 1) state:) ; gun
					(gEgo
						normal: 0
						view: 15
						loop: 0
						cel: 3
						posn: 110 95
						setCycle: Beg self
					)
				else
					(gEgo loop: 2)
					(= cycles 2)
				)
				(if (== (officer cel:) 0)
					(officer setCycle: End)
				)
			)
			(3
				(ramForwardSound play:)
				(halfTrack setMotion: MoveTo 73 142 self)
				(frontWheel setCycle: Fwd)
				(backWheel setCycle: Fwd)
			)
			(4
				(dog loop: 1 cel: 0 setCycle: End)
				(halfTrack setScript: jiggle)
				(= seconds 2)
			)
			(5
				(ramForwardSound stop:)
				(dog stopUpd:)
				(frontDoor setCycle: End self)
				(halfTrack
					setPri: 6
					setScript: 0
					moveSpeed: 2
					setMotion: MoveTo 89 134 self
				)
				(sfx1 number: 558 loop: 1 play:)
			)
			(6)
			(7
				(ramBackSound play:)
				(frontDoor stopUpd:)
				(halfTrack setMotion: MoveTo 73 142 self)
			)
			(8
				(halfTrack setPri: -1 moveSpeed: 1 setMotion: MoveTo 0 171 self)
			)
			(9
				(frontWheel setCycle: 0)
				(backWheel setCycle: 0)
				(ramBackSound fade:)
				(halfTrack addToPic:)
				(bSound fade: self)
			)
			(10
				(gCurRoom newRoom: 56)
			)
		)
	)
)

(instance jiggle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(halfTrack posn: 73 144)
				(= cycles 1)
			)
			(1
				(halfTrack posn: 73 142)
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance stairScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo
					normal: 0
					view: 576
					setLoop: 0
					setMotion: MoveTo 278 90 self
				)
			)
			(2
				(sfx1 number: 561 loop: 1 play:)
				(theStair dispose:)
				(gEgo normal: 0 loop: 1 cel: 0 posn: 296 79 setCycle: End)
				(= seconds 7)
			)
			(3
				(EgoDead 30) ; "Looks like not all of the house was fortified."
			)
		)
	)

	(method (doit)
		(if
			(and
				(or (== (gEgo cel:) 1) (== (gEgo cel:) 5))
				(== (self state:) 1)
			)
			(sfx1 number: 554 play:)
		)
		(super doit:)
	)
)

(instance readyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say officer 55 7) ; "Just give the boys the word, Sarge, and the ram will take er down!."
				(= seconds 6)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(officer setCycle: End self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dogScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: exitScript self)
				(proc0_17 10)
			)
			(1
				(HandsOff)
				(handler setCycle: End self)
			)
			(2
				(= save1 1)
				(Say handler 55 8) ; "Hey, Sonny."
				(= seconds 3)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo setMotion: PolyPath 59 126 self)
			)
			(4
				(Say handler 55 9) ; "Dispatch radioed that you might need the K9 unit, so I brought Spike over."
				(handler setCycle: End)
				(= seconds 5)
			)
			(5
				(Say handler 55 10) ; "He's got the scent of something big in there. He's about to pull my arm off if I don't let go."
				(handler setCycle: End)
				(= seconds 5)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(handler loop: 1 cel: 0 setCycle: End self)
				(Say handler 55 11) ; "Seek!"
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(handler loop: 3 stopUpd:)
				(pDog
					setCycle: Walk
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 157 96 self
					init:
				)
				(dogSniff play:)
			)
			(8
				(dogSniff dispose:)
				(SetFlag 52)
				(pDog dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance barkDogScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 7))
			)
			(1
				(dogSound loop: (Random 1 4) play:)
				(= seconds 1)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance pCar of PicView
	(properties
		x 165
		y 226
		lookStr {Your back-up's patrol car is parked next to yours in the yard.}
		view 208
		priority 15
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 55 12) ; "If you want to leave, take your own car."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance officer of Actor
	(properties
		x 192
		y 163
		lookStr {Your back-up officer is in position.}
		view 588
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(cond
					((IsFlag 52)
						(Print 55 13) ; "Better find out what the dog's found instead of wasting time out here."
					)
					(local0
						(Print 55 14) ; "Things are too precarious right now to chit chat with your fellow officers."
					)
					(else
						(HandsOff)
						(gCurRoom setScript: readyScript)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance handler of Prop
	(properties
		x 22
		y 115
		lookStr {Officer Parks is with the K9 unit.}
		view 583
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 55 15) ; "I wonder what Spike's all upset about?"
			)
			(3 ; Do
				(Print 55 16) ; "This is a slightly higher species than Officer Parks is used to handling."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pDog of Actor
	(properties
		x 41
		y 110
		view 583
		loop 2
		signal 18432
		cycleSpeed 8
		moveSpeed 8
	)
)

(instance halfTrack of Actor
	(properties
		y 171
		lookStr {The ram is a fortified military vehicle that's been converted for police work and fitted with a steel hydraulic boom. It can get through just about anything.}
		view 581
		loop 1
		signal 18433
		moveSpeed 1
	)

	(method (init)
		(super init:)
		(frontWheel posn: (+ (self x:) 30) (- (self y:) 16) init:)
		(backWheel posn: (- (self x:) 12) (self y:) init:)
	)

	(method (addToPic)
		(frontWheel addToPic:)
		(backWheel addToPic:)
		(super addToPic:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 17) ; "If you want the officers to use the ram, you'll need to give the order."
			)
			(5 ; Talk
				(HandsOff)
				(Print 55 18) ; "You give the order for the ram to proceed."
				(gCurRoom setScript: ramScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance frontWheel of Actor
	(properties
		x 29
		y 159
		view 581
		loop 2
		signal 18433
		cycleSpeed 9
	)

	(method (doit)
		(super doit:)
		(self x: (+ (halfTrack x:) 30) y: (- (halfTrack y:) 16))
	)
)

(instance backWheel of Actor
	(properties
		x 29
		y 159
		view 581
		loop 2
		cel 2
		signal 18433
		cycleSpeed 9
	)

	(method (doit)
		(super doit:)
		(self x: (- (halfTrack x:) 12) y: (halfTrack y:))
	)
)

(instance frontDoor of Prop
	(properties
		x 144
		y 84
		approachX 127
		approachY 104
		view 581
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if cel
					(Print 55 19) ; "The ram really did a number on that steel door."
				else
					(Print 55 20) ; "The front door is made of steel. It would look more at home on a military installation than on this run-down shack."
				)
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: knockDoor)
			)
			(4 ; Inventory
				(switch invItem
					(16 ; nightStick
						(Print 55 21) ; "That nightstick wouldn't make a dent in the door."
					)
					(1 ; gun
						(Print 55 22) ; "That door could take more bullets than you have."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dog of Prop
	(properties
		x 31
		y 59
		lookStr {Looks like a happy little mutt.}
		view 579
		signal 18432
		cycleSpeed 8
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 55 23) ; "You've got more important animals to worry about today."
			)
			(4 ; Inventory
				(switch invItem
					(16 ; nightStick
						(Print 55 24) ; "The dog isn't any threat to you."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shadowWindow of Prop
	(properties
		x 182
		y 87
		description {window}
		lookStr {The windows have been partially boarded over. Underneath the boards you can see thick metal bars.}
		view 580
		priority 7
		signal 17
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 25) ; "Those metal bars aren't going to budge."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sInset of Prop
	(properties
		x 144
		y 107
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(sMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(sShirt posn: (+ (self x:) 3) (+ (self y:) 61) init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(sMouth dispose:)
		(sShirt dispose:)
	)
)

(instance sMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sShirt of View
	(properties
		description {Sonny}
		view 25
		cel 1
		priority 15
		signal 16401
	)
)

(instance pat of Actor
	(properties
		description {pat}
		lookStr {Your partner, Pat Morales.}
		view 457
		cel 8
		priority 15
		signal 17
		cycleSpeed 3
		moveSpeed 3
	)
)

(instance pInset of Prop
	(properties
		x 262
		y 120
		description {Pat Morales}
		view 27
		priority 15
		signal 16401
	)

	(method (init)
		(pMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(pShirt posn: (+ (self x:) 2) (+ (self y:) 62) init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(pMouth dispose:)
		(pShirt dispose:)
	)
)

(instance pMouth of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance pShirt of View
	(properties
		description {pat}
		view 27
		cel 1
		priority 15
		signal 16401
	)
)

(instance yourDoor of Prop
	(properties
		description {car door}
		lookStr {That's the passenger car door.}
		view 353
		loop 1
		priority 15
		signal 16401
	)

	(method (init)
		(self posn: (+ (yourCar x:) 34) (yourCar y:) 32)
		(super init:)
	)
)

(instance yourCar of Prop
	(properties
		x 40
		y 217
		description {car}
		lookStr {You look fondly at your car.}
		view 353
		priority 15
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (gEgo has: 9) ; judicialOrder
					(Print 55 26) ; "Your job here is not done yet, Bonds!"
				else
					(HandsOff)
					(gCurRoom setScript: enterCar)
					(if (gEgo has: 8) ; warrant
						(pat setScript: enterCarP)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theStair of View
	(properties
		x 286
		y 95
		lookStr {A rickety flight of stairs lead to the second floor.}
		view 576
		loop 2
		priority 3
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 27) ; "Carpentry never was your strong point."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		lookStr {The front lawn is unkempt and neglected. Obviously, the people that live here aren't gardeners.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 28) ; "There's nothing you can do with the lawn."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theHouse of Feature
	(properties
		onMeCheck 4096
		lookStr {The house looks like a shack but, judging by the barred windows and heavy front door, it's well fortified.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 29) ; "You can't force your way in with your bare hands."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wreak of Feature
	(properties
		x 236
		y 178
		onMeCheck 16384
		lookStr {The old car reminds you of the car you had while you were in college - except this one is in better condition.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 30) ; "Not even the auto club could get this heap started."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stairs of Feature
	(properties
		onMeCheck 8192
		lookStr {A rickety flight of stairs leads to the second floor.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 31) ; "Carpentry was never your strong point."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barrel of Feature
	(properties
		onMeCheck 2048
		lookStr {Discarded junk in the yard adds to the house's air of neglect.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 32) ; "That old junk doesn't interest you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance porch of Feature
	(properties
		onMeCheck 128
		lookStr {The porch looks like it's about ready to collapse.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 33) ; "Carpentry was never your strong suit."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance meter of Feature
	(properties
		x 245
		y 117
		onMeCheck 32
		approachX 247
		approachY 130
		lookStr {There's an electric meter on the side of the house.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 34) ; "The occupant's electric usage does not interest you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance windows of Feature
	(properties
		onMeCheck 64
		lookStr {The windows have been partially boarded over. Underneath the boards you can see thick metal bars.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 55 25) ; "Those metal bars aren't going to budge."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 55 35) ; "Shooting at the bars won't help."
					)
					(16 ; nightStick
						(Print 55 36) ; "That nightstick is not quite up to prying apart steel."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dogSound of Sound
	(properties
		flags 1
		number 559
	)

	(method (check)
		(DoSound sndUPDATE_CUES self)
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(cond
				((> (self loop:) 1)
					(self loop: (- (self loop:) 1))
					(DoSound sndPLAY self 0)
				)
				((IsObject client)
					(client cue: self)
				)
			)
		)
	)
)

(instance dogSniff of Sound
	(properties
		number 560
		loop -1
	)
)

(instance bSound of Sound
	(properties
		flags 1
		number 551
		priority 1
		loop -1
	)
)

(instance sfx1 of Sound
	(properties
		priority 2
	)
)

(instance sfx2 of Sound ; UNUSED
	(properties
		priority 3
	)
)

(instance ramForwardSound of Sound
	(properties
		number 556
		loop -1
	)
)

(instance ramBackSound of Sound
	(properties
		number 557
		loop -1
	)
)

(instance erieSound of Sound
	(properties
		flags 1
		number 550
		loop -1
	)
)

