;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	theJoust 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 6] = [-2 -1 -3 -3 -3 -6]
	[local13 6] = [-3 -2 -2 -2 -3 -1]
	[local19 6] = [6 6 6 6 6 8]
	[local25 6] = [5 5 4 5 6 6]
	local31
	local32
	local33
	local34
	local35
	local36
)

(procedure (localproc_0 param1)
	(return (- param1 (* (and (>= param1 97) (<= param1 122)) 32)))
)

(instance cor1 of PV
	(properties
		view 550
		cel 2
		priority 15
	)
)

(instance cor2 of PV
	(properties
		y 170
		view 550
		loop 3
		cel 1
		priority 15
	)
)

(instance cor3 of PV
	(properties
		x 295
		view 550
		loop 3
		cel 1
		priority 15
	)
)

(instance cor4 of PV
	(properties
		y 170
		x 295
		view 550
		cel 3
		priority 15
	)
)

(instance bkHorse of Act
	(properties)
)

(instance blackKnight of Act
	(properties
		view 301
	)
)

(instance arthurIcon of PV
	(properties
		y 176
		x 263
		view 305
		priority 15
		signal 16384
	)
)

(instance blackKnightIcon of PV
	(properties
		y 176
		x 58
		view 305
		cel 1
		priority 15
		signal 16384
	)
)

(instance shieldIcon of PV
	(properties
		y 44
		x 56
		view 302
		loop 1
		priority 15
	)
)

(instance lanceIcon of PV
	(properties
		y 44
		x 264
		view 302
		loop 1
		cel 1
		priority 15
	)
)

(instance skull of Act
	(properties
		view 302
		loop 1
		cel 4
		priority 14
		signal 16
	)
)

(instance sGallop of Sound
	(properties
		number 26
		priority 10
		loop -1
	)
)

(instance sEgosBeenHit of Sound
	(properties
		priority 15
	)
)

(instance sBKBeenHit of Sound
	(properties
		priority 14
	)
)

(instance theJoust of Rm
	(properties
		picture 89
	)

	(method (init)
		(Load rsVIEW 302)
		(Load rsVIEW 301)
		(Load rsVIEW 306)
		(Load rsVIEW 305)
		(SetFlag 27)
		(SetFlag 28)
		(super init:)
		(if (== gPrevRoomNum 0)
			(= local36 1)
			(= global108
				(Print 110 0 #button {Hard} 1 #button {Normal} 2 #button {Easy} 3) ; "What difficulty:"
			)
		)
		(HandsOff)
		(= global109 6)
		(MenuBar state: 0)
		(egoLance
			view: 302
			setLoop: 0
			setCel: 0
			posn: 190 175
			ignoreActors: 1
			setStep: 2 2
			setPri: 12
			init:
		)
		(egoShield
			view: 302
			setLoop: 1
			cel: 2
			posn: 180 188
			setPri: 13
			setStep: 4 4
			ignoreActors: 1
			illegalBits: $0002
			init:
		)
		(blackLance init:)
		(blackShield init:)
		(blackKnight view: 301 setPri: 8 init: ignoreActors:)
		(skull posn: 1000 1000 init:)
		(gAddToPics
			add:
				cor1
				cor2
				cor3
				cor4
				shieldIcon
				lanceIcon
				arthurIcon
				blackKnightIcon
			doit:
		)
		(gCurRoom setScript: talkScript)
		(RedrawCast)
	)

	(method (doit &tmp [temp0 40] temp40 temp41 temp42 temp43 temp44)
		(super doit:)
		(if (== (self script:) blackRiding)
			(switch (++ local0)
				(25
					(if (and (== global108 1) (< (egoLance x:) 187))
						(= local5 (- 0 (Random 4 8)))
					)
				)
				(26
					(if
						(and
							(> (egoShield y:) 184)
							(or
								(== (blackLance cel:) 1)
								(== (blackLance cel:) 3)
							)
						)
						(blackLance setPri: 14)
						(= local32 1)
					)
				)
				(27
					(switch (blackLance cel:)
						(0
							(if (< (egoShield x:) 173)
								(= local32 1)
							)
						)
						(1
							(if (> (egoShield y:) 184)
								(= local32 1)
							)
						)
						(2
							(if (> (egoShield x:) 173)
								(= local32 1)
							)
						)
						(3
							(if (> (egoShield y:) 184)
								(= local32 1)
							)
						)
					)
					(if local32
						(egoShield setScript: egosBeenHit)
					)
					(skull
						setLoop: 1
						setCel: 4
						posn: (- (egoLance x:) 51) (- (egoLance y:) 72)
					)
					(sBKBeenHit number: (proc0_20 14) loop: 1 play:)
				)
				(28
					(= temp40 (- (egoLance x:) 49))
					(= temp41 (- (egoLance y:) 74))
					(if
						(and
							(<=
								(- (blackShield x:) 9)
								temp40
								(+ (blackShield x:) 9)
							)
							(<= (- (blackShield y:) 30) temp41 (blackShield y:))
						)
						(= temp44 0)
					else
						(= temp44 1)
					)
					(= temp42 (blackKnight x:))
					(= temp43 (blackKnight y:))
					(if (== (blackKnight view:) 306)
						(+= temp42 6)
					)
					(if
						(and
							temp44
							(<= (- temp42 12) temp40 (+ temp42 12))
							(<= (- temp43 22) temp41 (- temp43 5))
						)
						(blackKnight setScript: blackKnightHit)
					)
					(skull posn: (- (skull x:) 5) (+ (skull y:) 6))
				)
				(29
					(skull posn: (- (skull x:) 5) (+ (skull y:) 6))
				)
				(30
					(skull posn: 1000 1000)
				)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 2] temp2)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(event message: (localproc_0 (event message:)) claimed: 1)
				(switch (event message:)
					(KEY_CONTROL
						(= gQuit 1)
					)
					(KEY_S
						(= local1 1)
					)
					(KEY_D
						(= local1 4)
					)
					(KEY_E
						(= local1 3)
					)
					(KEY_F
						(= local1 2)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			($0040 ; direction
				(event claimed: 1)
				(switch (event message:)
					(JOY_UP
						(= local4 -3)
						(= local3 0)
					)
					(JOY_DOWN
						(= local4 3)
						(= local3 0)
					)
					(JOY_RIGHT
						(= local3 3)
						(= local4 0)
					)
					(JOY_LEFT
						(= local3 -3)
						(= local4 0)
					)
					(JOY_NULL
						(= local3 0)
						(= local4 0)
					)
				)
				(while
					(and
						(== ((= temp2 (Event new:)) type:) $0040) ; direction
						(== (temp2 message:) (event message:))
					)
					(temp2 dispose:)
				)
				(temp2 dispose:)
			)
		)
	)
)

(instance blackWindow of SysWindow
	(properties
		color 12
		back 0
		title {The Black Knight}
		brTop 10
		brLeft 200
		brBottom 100
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(blackKnight setLoop: 2 setCel: 4 posn: 178 58 setPri: 8)
				(blackLance
					setLoop: 4
					setCel: 2
					posn: (+ 178 [local7 0]) (+ 58 [local13 0])
					setPri: 11
				)
				(blackShield setLoop: 5 setCel: 4 doit: setPri: 9)
				(gTObj tWindow: blackWindow talkCue: self)
				(Talk 110 1) ; "The joust will continue until either you or I have been unhorsed three times. Let it begin!"
			)
			(1
				(= seconds 1)
			)
			(2
				(client setScript: 0 setScript: blackRiding)
			)
		)
	)
)

(instance egoShield of Act
	(properties
		view 302
	)

	(method (doit)
		(super doit:)
		(if (and local2 local1)
			(switch local1
				(1
					(self posn: 166 (self y:))
				)
				(2
					(self posn: 180 (self y:))
				)
				(3
					(self posn: (self x:) 180)
				)
				(4
					(self posn: (self x:) 188)
				)
			)
			(= local1 0)
		)
	)
)

(instance egoLance of Act
	(properties
		view 302
	)

	(method (doit)
		(cond
			((and (& signal $0004) (not (& signal $0002)))
				(return)
			)
			(local31 0)
			(else
				(if (and local3 (> 200 (+ x local3) 175))
					(+= x local3)
					(self forceUpd:)
				else
					(= local3 0)
				)
				(if (and local4 (> 190 (+ y local4) 174))
					(+= y local4)
					(self forceUpd:)
				else
					(= local4 0)
				)
			)
		)
		(super doit:)
	)
)

(instance blackLance of Act
	(properties
		view 302
	)

	(method (init)
		(super init:)
		(self setLoop: 4 setPri: 11 ignoreActors:)
	)
)

(instance blackShield of Act
	(properties
		view 302
	)

	(method (init)
		(super init:)
		(self setLoop: 5 setPri: 9 ignoreActors:)
	)

	(method (doit)
		(super doit:)
		(if (not local33)
			(self
				posn:
					(+ (blackKnight x:) [local19 0] local5)
					(+ (blackKnight y:) [local25 0] local6)
			)
		)
	)
)

(instance blackRiding of Script
	(properties)

	(method (init)
		(super init:)
		(self changeState: 1)
	)

	(method (changeState newState &tmp temp0 temp1 [temp2 30])
		(switch (= state newState)
			(1
				(blackKnight
					view: 301
					setLoop: 2
					setCel: 4
					posn: 178 58
					setPri: 8
				)
				(blackLance
					setLoop: 4
					setCel: 2
					posn: (+ 178 [local7 0]) (+ 58 [local13 0])
					setPri: 11
				)
				(blackShield setLoop: 5 setCel: 4 doit: setPri: 9)
				(egoLance setCel: 0 setStep: 2 2 setPri: 12)
				(if (not (egoLance inRect: 100 100 210 200))
					(egoLance posn: 190 175)
				)
				(egoShield setStep: 4 4 setScript: 0 setMotion: 0)
				(if (not (egoShield inRect: 100 100 210 200))
					(egoShield posn: 180 180)
				)
				(= local5 (= local6 0))
				(= local33 (= local31 (= local32 0)))
				(= local2 1)
				(= local0 0)
				(= cycles 4)
			)
			(2
				(if (not (gSounds contains: sGallop))
					(sGallop play:)
				)
				(blackKnight
					setLoop: 2
					setCel: 4
					setStep: 1 1
					setCycle: CT 0 -1
					setMotion: MoveTo 174 62 self
				)
				(blackLance
					setStep: 1 1
					setMotion: MoveTo (+ 174 [local7 0]) (+ 62 [local13 0])
				)
				(blackShield doit:)
			)
			(3
				(blackKnight
					setLoop: 1
					setCel: 255
					setStep: 2 2
					setCycle: CT 5 -1
					posn: 174 63
					setMotion: MoveTo 166 71 self
				)
				(blackLance
					setStep: 2 2
					setLoop: 4
					setCel: 1
					posn: (+ 174 [local7 1]) (+ 63 [local7 1])
					setMotion: MoveTo (+ 166 [local7 1]) (+ 71 [local13 1])
				)
				(blackShield setCel: 3 doit:)
			)
			(4
				(blackKnight
					setStep: 2 3
					posn: 166 72
					setCycle: CT 0 -1
					setMotion: MoveTo 158 85 self
				)
				(blackLance
					setStep: 2 3
					setLoop: 4
					setCel: 0
					posn: (+ 166 [local7 2]) (+ 72 [local7 2])
					setMotion: MoveTo (+ 158 [local7 2]) (+ 85 [local13 2])
				)
				(blackShield setCel: 2 doit:)
			)
			(5
				(blackKnight
					setLoop: 0
					setStep: 1 3
					setCel: 9
					posn: 157 87
					setCycle: CT 5 -1
					setMotion: MoveTo 153 100 self
				)
				(= temp1
					(cond
						((>= global108 2)
							(Random 0 3)
						)
						((<= (egoShield y:) 184)
							(if (Random 0 1) 0 else 2)
						)
						((Random 0 1) 1)
						(else 3)
					)
				)
				(blackLance
					setStep: 1 3
					setLoop: 3
					setCel: temp1
					posn: (+ 157 [local7 3]) (+ 87 [local7 3])
					setMotion: MoveTo (+ 153 [local7 3]) (+ 100 [local13 3])
				)
				(= local5
					(cond
						((< (egoLance x:) 182) -8)
						((< (egoLance x:) 186) -6)
						((< (egoLance x:) 194)
							(- 0 (Random 2 6))
						)
						(else
							(- 2 (Random 0 6))
						)
					)
				)
				(if (== global108 1)
					(-= local5 (Random 2 6))
				)
				(= local6 (- 2 (Random 0 4)))
				(blackShield setCel: 1 doit:)
			)
			(6
				(if
					(and
						(< (egoLance x:) 185)
						(or (< global108 3) (< (Random 1 7) 4))
					)
					(blackKnight view: 306)
					(= local5 -8)
					(= local6 0)
				)
				(blackKnight
					setLoop: 0
					setStep: 3 4
					posn: 153 101
					setCycle: CT 0 -1
					setMotion: MoveTo 140 119 self
				)
				(blackLance
					setStep: 3 4
					setLoop: 2
					posn: (+ 153 [local7 4]) (+ 101 [local13 4])
					setMotion: MoveTo (+ 140 [local7 4]) (+ 119 [local13 4])
				)
				(blackShield setCel: 0 doit:)
			)
			(7
				(if (== (blackKnight view:) 301)
					(blackKnight setLoop: 3 setCycle: Fwd cycleSpeed: 1)
				)
				(blackKnight
					setStep: 5 6
					posn: 140 119
					setMotion: MoveTo 75 200 self
				)
				(blackLance
					setStep: 5 6
					posn: (+ 138 [local7 5]) (+ 112 [local13 5])
					setMotion: MoveTo (+ 85 [local7 5]) (+ 195 [local13 5])
				)
			)
			(8
				(blackKnight cycleSpeed: 0)
				(if (or local31 local33)
					(= state 7)
				)
				(= cycles 2)
			)
			(9
				(if (== (blackKnight view:) 306)
					(blackKnight view: 301)
				)
				(while ((= temp0 (Event new:)) type:)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(blackKnight setMotion: 0)
				(blackLance setMotion: 0)
				(= state 0)
				(= seconds 2)
			)
		)
	)
)

(instance blackKnightHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local33 1)
				(SetScore 0 0 (* 2 (- 4 global108)))
				(bkHorse
					view: 306
					loop: 1
					cel: 0
					ignoreActors:
					posn: (blackKnight x:) (blackKnight y:)
					setPri: 8
					init:
					setStep: 3 4
					setMotion: MoveTo 95 185
				)
				(blackKnight
					view: 306
					setLoop: 2
					setCel: 0
					setCycle: CT 1 1 self
					setPri: 8
					setStep: 8 15
					setMotion: 0
					setMotion:
						MoveTo
						(- (blackKnight x:) 5)
						(- (blackKnight y:) 20)
				)
				(blackShield
					setStep: 8 15
					setPri: 9
					setMotion:
						MoveTo
						(+ (blackShield x:) 2)
						(- (blackShield y:) 30)
				)
				(blackLance
					setStep: 12 16
					setMotion:
						MoveTo
						(- (blackLance x:) 30)
						(+ (blackLance y:) 68)
				)
			)
			(1
				(blackKnight
					setStep: 14 8
					setCel: 2
					setMotion:
						MoveTo
						(- (blackKnight x:) 5)
						(- (blackKnight y:) 15)
						self
				)
				(blackShield
					setStep: 14 10
					setMotion:
						MoveTo
						(+ (blackShield x:) 0)
						(- (blackShield y:) 15)
				)
			)
			(2
				(blackKnight
					setCel: 3
					setStep: 14 16
					setMotion:
						MoveTo
						(- (blackKnight x:) 5)
						(+ (blackKnight y:) 55)
				)
				(blackShield
					setStep: 14 16
					setMotion:
						MoveTo
						(- (blackShield x:) 0)
						(+ (blackShield y:) 65)
						self
					setCel: 5
					setCycle: End
				)
			)
			(3
				(= seconds 4)
			)
			(4
				(if (== (++ local34) 3)
					(sGallop fade:)
					(SetScore 0 0 (* 2 (- 4 global108)))
					(Print 110 2) ; "You have vanquished the Black Knight, King Arthur!"
					(= global109 0)
					(gCurRoom newRoom: 14)
				else
					(= local33 0)
					(blackKnight posn: 1000 1000 setPri: 8)
					(blackShield posn: 2000 1000)
					(blackLance posn: 3000 1000)
					(bkHorse dispose:)
					(blackKnight setScript: 0)
					(switch local34
						(1
							(Print 110 3) ; "You have struck your first successful blow against the Black Knight!"
						)
						(2
							(Print 110 4) ; "You have unhorsed the Black Knight for the second time! Once more and you have won!"
						)
					)
					(blackRiding changeState: 8)
				)
			)
		)
	)
)

(instance egosBeenHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local31 1)
				(SetScore 0 0 (- 0 (* 2 (- 4 global108))))
				(= local32 0)
				(= local2 0)
				(egoShield
					setStep: 5 2
					setMotion: MoveTo (+ (egoShield x:) 20) (+ (egoShield y:) 4)
				)
				(egoLance setCycle: End self)
				(sEgosBeenHit number: (proc0_20 14) loop: 1 play:)
				(ShakeScreen 4 ssFULL_SHAKE)
			)
			(1
				(egoShield
					setStep: 8 8
					setMotion:
						MoveTo
						(+ (egoShield x:) 24)
						(+ (egoShield y:) 24)
						self
				)
				(egoLance
					setStep: 10 5
					setMotion: MoveTo (+ (egoLance x:) 40) (+ (egoLance y:) 10)
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(= local31 0)
				(egoShield posn: 1000 1000 setMotion: 0)
				(egoLance posn: 1000 1000 setMotion: 0)
				(egoShield setScript: 0)
				(if (and (== (++ local35) 3) (!= local34 3))
					(sGallop fade:)
					(EgoDead 110 5) ; "Alas! All Camelot will grieve to hear that valiant King Arthur was slain by the Black Knight."
				else
					(switch local35
						(1
							(Print 110 6) ; "The Black Knight has unhorsed you for the first time, Arthur. Make it the last!"
						)
						(2
							(Print 110 7) ; "Beware! The Black Knight has struck a second telling blow against you."
						)
					)
					(= cycles 6)
				)
			)
			(4
				(blackRiding changeState: 8)
			)
		)
	)
)

