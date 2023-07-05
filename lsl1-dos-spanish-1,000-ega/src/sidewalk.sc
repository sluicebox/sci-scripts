;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	sidewalk 0
	dog 1
	taxi 2
	sTaxiScript 3
)

(local
	flatY
	[taxiPts 8]
	[dogPts 8]
	dogTimer
	taxiY
	carView
	beenPissedOn
)

(procedure (PolyTaxi &tmp rL rT rR rB)
	(= rL (- (taxi brLeft:) 8))
	(= rT (- (taxi brTop:) 8))
	(= rR (+ (taxi brRight:) 8))
	(= rB (+ (taxi brBottom:) 5))
	(= [taxiPts 0] (= [taxiPts 6] rL))
	(= [taxiPts 1] (= [taxiPts 3] rT))
	(= [taxiPts 2] (= [taxiPts 4] rR))
	(= [taxiPts 5] (= [taxiPts 7] rB))
	(taxiPoly points: @taxiPts size: 4)
	(gCurRoom addObstacle: taxiPoly)
)

(procedure (PolyDog &tmp rL rT rR rB)
	(= rL (- (dog brLeft:) 8))
	(= rT (- (dog brTop:) 4))
	(= rR (+ (dog brRight:) 8))
	(= rB (dog brBottom:))
	(= [dogPts 0] (= [dogPts 6] rL))
	(= [dogPts 1] (= [dogPts 3] rT))
	(= [dogPts 2] (= [dogPts 4] rR))
	(= [dogPts 5] (= [dogPts 7] rB))
	(dogPoly points: @dogPts size: 4)
	(gCurRoom addObstacle: dogPoly)
)

(instance sidewalk of Rgn
	(properties)

	(method (init)
		(= carView (Random 822 827))
		(LoadMany rsVIEW carView 806 810 811 820 821 200)
		(LoadMany rsSOUND 800 810 811 812 103 102 200 202 203 204 205 206)
		(if
			(and
				(or
					(!= (gTheMusic2 number:) 800)
					(== (gTheMusic2 prevSignal:) -1)
				)
				(not (IsFlag 38))
			)
			(gTheMusic2 number: 800 loop: -1 vol: 127 play:)
		)
		(super init:)
		(streetF init:)
		(= taxiY
			(= flatY
				(switch gCurRoomNum
					(100 169)
					(300 165)
					(400 159)
					(500 170)
					(600 167)
				)
			)
		)
		(if (<= 710 gPrevRoomNum 720)
			(gTheMusic fade: 0 30 1 1)
		)
		(= dogTimer 1000)
		(if (== gPrevRoomNum 200)
			(HandsOff)
			(if (IsFlag 38)
				(Load rsVIEW 171)
			)
			(gCurRoom setScript: sDropoff)
		)
		(if (> (LarryHours) 7)
			(self setScript: virginScript)
		)
		(if (!= gCurRoomNum 100)
			(taxiSignProp
				x:
					(switch gCurRoomNum
						(300 74)
						(400 294)
						(500 200)
						(600 246)
					)
				y:
					(switch gCurRoomNum
						(300 178)
						(400 181)
						(500 175)
						(600 172)
					)
				approachX: (gEgo x:)
				approachY: (- flatY 10)
				approachVerbs: 3 5 ; Do, Talk
				init:
				setPri: 14
				stopUpd:
			)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 100 300 400 500 600))
		(= initialized 0)
		(if (and (not (OneOf newRoomNumber 100 300 400 500 600)) (!= newRoomNumber 160))
			(gTheMusic2 fade:)
		)
		(if (and (!= newRoomNumber 200) (== (gTheMusic3 number:) 205))
			(gTheMusic3 stop:)
		)
		(if (and (== newRoomNumber 160) (== (gTheMusic number:) 700))
			(gTheMusic fade:)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doit)
		(super doit: &rest)
		(taxiSignProp approachX: (gEgo x:))
		(if (and dogTimer (not (dog script:)))
			(-- dogTimer)
		)
		(if (gEgo mover:)
			(= dogTimer 1000)
		)
		(cond
			((== (gCurRoom script:) sFlattenLarry)
				(gEgo setMotion: 0)
			)
			((> (gEgo y:) flatY)
				(cond
					((not (gCast contains: taxi))
						(HandsOff)
						(gCurRoom setScript: sFlattenLarry)
					)
					((> (gEgo y:) (+ (taxi y:) 5))
						(HandsOff)
						(gCurRoom setScript: sFlattenLarry)
					)
				)
			)
			(
				(and
					(not dogTimer)
					(not beenPissedOn)
					(!= gCurRoomNum 500)
					(!= (gCurRoom curPic:) 245)
				)
				(= dogTimer -1)
				(dog
					init:
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setCycle: Walk
					z: 0
					setScript: sFindLarry
				)
			)
		)
	)
)

(instance virginScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(if (gCurRoom script:)
					(= cycles 60)
					(-- state)
				else
					(HandsOff)
					(gEgo setHeading: 180 self)
				)
			)
			(2
				(= cycles 3)
			)
			(3
				(LoadMany rsFONT global312)
				(Print 700 0 #at 15 -1 #width 280) ; "Oh, no! What's that? In the east! It's... it's... it's the sun!"
				(Print 700 1 #at 15 -1 #width 280) ; "Glancing at your watch, you realize the terrible truth. Your night in Lost Wages is over, and (technically speaking) you're still..."
				(Print 700 2 #at 15 -1 #width 280) ; "a"
				(Print 700 3 #at 15 -1 #width 280 #font global312) ; "VIRGIN!!!"
				(= seconds 3)
			)
			(4
				(gEgo
					egoSpeed:
					normal: 0
					view: 811
					setLoop: (if register 0 else 1)
					setCel: 8
					setCycle: End self
				)
			)
			(5
				(= seconds 3)
			)
			(6
				(Death 807 1)
				(Format @gYourPart 700 4) ; "Larry-cakes anyone?"
				(GameOver 700 5)
			)
		)
	)
)

(instance sDropoff of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (or (== state 1) (== state 5))
			(taxi x: (- 150 register))
			(gTheMusic3 send: 9 255 (+ (* (- 150 (taxi x:)) 10) 3000))
			(if (< (taxi x:) -800)
				(= cycles 1)
			)
			(*= register 2)
			(if (== register 4)
				(soundFX number: 202 setLoop: 1 flags: 1 play:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(taxi
					init:
					setCel: 1
					cycleSpeed: gHowFast
					moveSpeed: gHowFast
					x: 150
					y: taxiY
				)
				(gEgo x: 150 y: (- flatY 10) z: 0)
				(if (IsFlag 38)
					(gEgo egoSpeed: view: 171 loop: 0 setCycle: Fwd)
					(++ state)
					(= cycles 1)
				else
					(gEgo setHeading: 180 self)
				)
			)
			(1
				(= register 1)
			)
			(2
				(if (IsFlag 38)
					(gTheMusic number: 171 loop: -1 vol: 127 flags: 1 play:)
					(gEgo setCycle: Fwd)
					(= seconds 5)
				else
					(taxi dispose:)
					(gTheMusic3 fade:)
					(HandsOn)
					(self dispose:)
				)
			)
			(3
				(gEgo setLoop: 1)
				(= cycles 3)
			)
			(4
				(gEgo setLoop: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(5
				(gTheMusic stop:)
				(= register 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 700 6) ; "You'll never ride with me again!"
				(gEgo
					view: 806
					loop: 1
					x: (- (gEgo x:) 0)
					y: (+ (gEgo y:) 5)
					setCycle: 0
				)
				(mCar2 play:)
			)
			(6
				(gTheMusic3 fade:)
				(Death 171 3 1)
				(Format @gYourPart 700 7) ; "Larry-cakes anyone?"
				(GameOver 700 8)
			)
		)
	)
)

(instance sFindLarry of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (gEgo mover:)
			(sPiss stop:)
			(dog setScript: sRunOff 0 register)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic number: 103 loop: 1 vol: 127 flags: 1 play:)
				(dog
					x: (if (= register (Random 0 1)) 330 else -10)
					y: 155
					setCycle: Walk
					setMotion:
						PolyPath
						(if register
							(+ (gEgo x:) 17)
						else
							(- (gEgo x:) 15)
						)
						(+ (gEgo y:) 1)
						self
				)
			)
			(1
				(PolyDog)
				(dog view: 821 loop: (+ 0 register) cel: 0 setCycle: End self)
			)
			(2
				(dog loop: (+ 2 register) cel: 0 setCycle: End self)
			)
			(3
				(sPiss play:)
				(dog loop: (+ 4 register) setCycle: Fwd)
				(SetFlag 37)
				(= beenPissedOn 1)
				(= seconds 3)
			)
			(4
				(sPiss stop:)
				(if (or (== (gEgo view:) 800) (== (gEgo view:) 809))
					(HandsOff)
					(gCurRoom setScript: sShakeLeg 0 register)
				)
				(dog setScript: sRunOff 0 register)
			)
		)
	)
)

(instance sRunOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((or (== (dog view:) 820) (== (dog loop:) 0))
						(= cycles (= state 1))
					)
					((== (dog loop:) 2)
						(= cycles 1)
					)
					(else
						(dog loop: (+ 2 register) cel: 2 setCycle: Beg self)
					)
				)
			)
			(1
				(dog loop: (if register 0 else 1) cel: 2 setCycle: Beg self)
			)
			(2
				((gCurRoom obstacles:) delete: dogPoly)
				(dog
					view: 820
					setCycle: Walk
					setMotion:
						PolyPath
						(if (> (dog x:) (gEgo x:)) 350 else -30)
						155
						self
				)
			)
			(3
				(gTheMusic fade:)
				(dog z: 1000 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sTaxiScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== state 4)
			(gTheMusic3 send: 9 255 (* (- (taxi x:) 150) 50))
		)
		(if (== state 5)
			(taxi x: (+ 150 register))
			(gTheMusic3 send: 9 255 (* (- (taxi x:) 150) 30))
			(if (== register 0)
				(gTheMusic3 send: 9 255 0)
				(= cycles 1)
			)
			(if (== register 16)
				(soundFX number: 202 setLoop: 1 flags: 1 play:)
			)
			(/= register 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo
					egoSpeed:
					view: 810
					setLoop: 0
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(soundFX number: 200 loop: 1 flags: 0 vol: 127 play:)
				(= seconds 3)
			)
			(3
				(= seconds (Random 1 3))
			)
			(4
				(NormalEgo 2)
				(if (not (gCast contains: taxi))
					(taxi
						approachVerbs: 3 ; Do
						cycleSpeed: gHowFast
						moveSpeed: gHowFast
						init:
						x: 400
						y: taxiY
						setMotion: MoveTo 214 taxiY self
					)
					(= register 64)
					(gTheMusic3 number: 205 loop: -1 vol: 127 flags: 1 play:)
				else
					(cond
						((== (taxi x:) 150)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 700 9) ; "Stop whistling and get in the cab!"
						)
						((< (taxi x:) 150)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 700 10) ; "Too late now, Ace-(in-the)-hole!" shouts the rude cabbie, "I'm outta here!"
						)
						(else
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 700 11) ; "Hold your horses, he's on his way!"
						)
					)
					(HandsOn)
					(self dispose:)
				)
			)
			(5 0)
			(6
				(taxi setCycle: End self)
			)
			(7
				(HandsOn)
				(PolyTaxi)
				(taxi
					setScript: sTaxiWait
					approachX: (+ (taxi x:) 10)
					approachY: (- (taxi brTop:) 8)
				)
				(self dispose:)
			)
		)
	)
)

(instance sTaxiWait of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== state 7)
			(taxi startUpd: x: (- 150 (/ register 4)))
			(gTheMusic3 send: 9 255 (* (- 150 (taxi x:)) 10))
			(if (< (taxi x:) -120)
				(= cycles 1)
			)
			(*= register 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 14)
			)
			(1
				(taxi startUpd:)
				(= cycles 1)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 700 12 #dispose #time 4) ; ""I ain' gonna wait all day, bub!" yells the cabbie."
				(= cycles 9)
			)
			(3
				(if
					(and
						(< (gEgo x:) (- (taxi x:) 20))
						(> (gEgo y:) (- (taxi brTop:) 8))
					)
					(soundFX number: 810 play:)
					(= cycles 12)
				else
					(= state 6)
					(= cycles 1)
				)
			)
			(4
				(soundFX stop:)
				(= cycles 1)
			)
			(5
				(soundFX play:)
				(= cycles 12)
			)
			(6
				(soundFX stop:)
				(= state 2)
				(= seconds 5)
			)
			(7
				(= register 1)
				(if (!= (gCurRoom script:) sEnterTaxi)
					((gCurRoom obstacles:) delete: taxiPoly)
					(soundFX number: 202 setLoop: 1 flags: 1 play:)
				else
					(self dispose:)
				)
			)
			(8
				(if (< (taxi x:) -80)
					(taxi dispose:)
					(gTheMusic3 fade:)
					(self dispose:)
				else
					(-= state 1)
					(= cycles 1)
				)
			)
		)
	)
)

(instance sFlattenLarry of Script
	(properties)

	(method (doit &tmp dist)
		(super doit: &rest)
		(cond
			(
				(<
					(= dist
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(aCar x:)
							(aCar y:)
						)
					)
					0
				)
				(= dist 0)
			)
			((> dist 300)
				(= dist 300)
			)
		)
		(if (< state 2)
			(mCar setVol: (- 127 (/ dist 4)))
		)
		(if (or (== state 1) (== state 2))
			(++ register)
			(mCar send: 2 255 (- (* register 100)))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mCar play: 50)
				(gEgo view: 806 loop: 0 cel: 0)
				(aCar
					cycleSpeed: gHowFast
					moveSpeed: gHowFast
					init:
					view: carView
					x: 450
					setPri: (+ (gEgo priority:) 2)
					setMotion: MoveTo (+ (gEgo x:) 67) (aCar y:) self
				)
			)
			(1
				(mCar2 play:)
				(mCar3 play:)
				(gEgo
					setPri: (+ (aCar priority:) 1)
					x: (- (aCar x:) 67)
					setCel: 1
				)
				(aCar setMotion: MoveTo -50 (aCar y:) aCar)
				(= cycles 5)
			)
			(2
				(mCar fade: 0 5 8 1)
				(gEgo
					setPri: -1
					setLoop: 1
					setCel: 1
					x: (- (gEgo x:) 0)
					y: (+ (gEgo y:) 0)
				)
				(= seconds 3)
			)
			(3
				(= seconds 3)
			)
			(4
				(Death 806 2)
				(Format @gYourPart 700 13) ; "That's you all over!"
				(GameOver 700 14)
			)
		)
	)
)

(instance sEnterTaxi of Script
	(properties)

	(method (doit &tmp maxVal)
		(super doit: &rest)
		(if (== state 3)
			(taxi startUpd: x: (- 150 register))
			(= maxVal (* (- 150 (taxi x:)) 10))
			(gTheMusic3 send: 9 255 (if (< maxVal 2000) maxVal else 2000))
			(if (< (taxi x:) -80)
				(= cycles 1)
			)
			(*= register 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(soundFX number: 203 loop: 1 flags: 0 vol: 127 play:)
				(gEgo setHeading: 180)
				(= cycles 10)
			)
			(2
				(soundFX number: 204 loop: 1 flags: 0 vol: 127 play:)
				(gEgo hide:)
				(= cycles 10)
			)
			(3
				(= register 1)
				(soundFX number: 202 setLoop: 1 flags: 1 play:)
			)
			(4
				(gTheMusic3 fade: 90 5 5 0)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance sShakeLeg of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (not state) (== (sRunOff state:) 2))
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(gEgo
					egoSpeed:
					normal: 0
					view: 811
					loop: (if register 0 else 1)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(NormalEgo 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance aCar of Actor
	(properties
		x 340
		y 170
		description {the car}
		lookStr {Crazy driver!}
		view 806
		signal 22528
		xStep 30
	)

	(method (cue)
		(super cue:)
		(= z 1000)
		(self dispose:)
	)
)

(instance taxi of Actor
	(properties
		description {the taxi}
		sightAngle 40
		view 200
		signal 22528
		xStep 20
	)

	(method (cue)
		(super cue:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(Print 700 15) ; "It's not very clean."
		(Print 700 16) ; "It's not very safe."
		(Print 700 17 #at -1 140) ; "(And those are its good points!)"
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gEgo
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) (self x:) (self y:))
						self
				)
			)
			(11 ; Taste/Smell
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 700 18) ; "It smells like an old cab."
			)
			(3 ; Do
				(if (< (taxi x:) 150)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 700 19) ; "It's too late now, Larry!"
				else
					(if (not (IsFlag 34))
						(SetFlag 34)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 700 20) ; "Vowing to hold your breath forever, you enter this miserable excuse for public transportation."
					)
					(HandsOff)
					(taxi setScript: 0)
					(soundFX stop:)
					(gCurRoom setScript: sEnterTaxi)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance dog of Actor
	(properties
		description {the dog}
		sightAngle 40
		view 820
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch theVerb
			(2 ; Look
				(cond
					((== (dog view:) 821)
						(Print 700 21) ; "Obviously, he thinks you're a fire plug."
					)
					((== (dog script:) sRunOff)
						(Print 700 22) ; "You hope he's soon a "Hmong" friends."
					)
					(else
						(Print 700 23) ; "Dogs like that make you want to keep moving."
					)
				)
			)
			(3 ; Do
				(Print 700 24) ; "As you bend over to show that dog who's boss, his bare teeth convince you there are worse things than damp trousers!"
			)
			(11 ; Taste/Smell
				(Print 700 25) ; "The dog smells quite bad, although still better than you."
			)
			(10 ; Zipper
				(Print 700 26) ; "It would seem turn-about would be fair play, but you just don't have it in you!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance taxiSignProp of View
	(properties
		z 100
		description {the taxi sign}
		sightAngle 40
		lookStr {High up that pole sits a lonely sign that reads, "Taxi Stand."}
		view 810
		loop 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 700 27) ; "You whistle loudly for a taxi."
				(HandsOff)
				(gCurRoom setScript: sTaxiScript)
			)
			(5 ; Talk
				(self doVerb: 3)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dogPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance taxiPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance streetF of Feature
	(properties
		x 160
		y 480
		description {the street}
		sightAngle 85
		onMeCheck 2048
		lookStr {Isn't it funny how there's so little traffic?}
	)
)

(instance mCar of Sound
	(properties
		number 810
		vol 50
	)
)

(instance mCar2 of Sound
	(properties
		number 811
	)
)

(instance mCar3 of Sound
	(properties
		number 812
	)
)

(instance sPiss of Sound
	(properties
		flags 1
		number 102
		loop -1
	)
)

(instance soundFX of Sound
	(properties
		flags 1
	)
)

