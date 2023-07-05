;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 880)
(include sci.sh)
(use Main)
(use Interface)
(use trunk)
(use n882)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Chase)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	crash 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance crash of PQRoom
	(properties
		picture 29
		east -1
		south -1
		west -1
	)

	(method (init)
		(super init:)
		(deadbodySting play:)
		(proc0_17 10)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 249 48 241 55 221 67 196 71 176 98 122 86 129 46 0 91 0 0 319 0 319 27 267 45
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 290 135 258 147 260 155 249 161 229 158 187 172 171 166 155 171 138 166 146 156 132 150 237 112
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 26 118 20 126 3 129 2 123 9 117
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 36 118 51 110 66 111 60 119 42 122
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 111 94 111 104 90 108 82 103 91 98
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 193 189 235 187 319 160 319 189
					yourself:
				)
		)
		(gEgo get: 15) ; flares
		(SetFlag 88)
		(if (not (IsFlag 88))
			(= local0 1)
			(ambulence setPri: 0 posn: 307 34 stopUpd: 1 init:)
			(traffic init:)
			(attendent init:)
			(coroner approachVerbs: 5 init:) ; Talk
			(aDoor cel: 4 init:)
			(flares1 setCycle: Fwd init:)
			(flares2 cel: 1 setCycle: Fwd init:)
			(flares3 cel: 3 setCycle: Fwd init:)
		else
			(SetScore 168 5)
		)
		(pat setScript: exitCarP init:)
		(theCar init:)
		(body init:)
		(theRoom init:)
		(hisTrunk approachVerbs: 4 init:) ; Inventory
		(yourCar init:)
		(gAddToPics add: yourCar doit:)
		(gEgo
			normal: 0
			view: 17
			loop: 3
			cel: 10
			posn: (- (yourCar x:) 15) (- (yourCar y:) 25)
			setPri: 3
			setStep: 3 2
			init:
		)
		(wreckSound play:)
		(HandsOff)
		(self setScript: exitCar)
		(ScriptID 882)
		(self overlay: 80)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			((== script runOver) 0)
			((or (& temp0 $2000) (& temp0 $0040))
				(gEgo priority: 13 signal: (| (gEgo signal:) $0010))
			)
			((& temp0 $4000)
				(gEgo priority: 14 signal: (| (gEgo signal:) $0010))
			)
			((and (== global127 1) (& temp0 $0200))
				(gEgo priority: 9 signal: (| (gEgo signal:) $0010))
			)
			((& temp0 $0001)
				(gEgo signal: (& (gEgo signal:) $ffef))
			)
			((> (gEgo y:) 200)
				(gEgo priority: 15 signal: (| (gEgo signal:) $0010))
			)
		)
		(cond
			(script 0)
			((and (& temp0 $0002) (not local0))
				(HandsOff)
				(Load rsVIEW 333 320)
				(self setScript: runOver)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(= gUseSortedFeatures local3)
		(DisposeScript 972)
		(DisposeScript 882)
		(super dispose:)
		(DisposeScript 881)
	)
)

(instance timeScript of rmnScript
	(properties)

	(method (doit)
		(if (not local4)
			(super doit: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pat view: 457 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(= seconds 6)
			)
			(2
				(pat setCycle: Beg self)
			)
			(3
				(self setScript: patTrunk self)
			)
			(4
				(pat view: 355 loop: 3 setCycle: SyncWalk init:)
				(= seconds (+ 90 (* (- 2 gHowFast) 15)))
			)
			(5
				(if (or (not local0) (gCurRoom script:) local4)
					(-- state)
				)
				(= cycles 10)
			)
			(6
				(cond
					(
						(or
							(gCast contains: cocaine)
							(== (gCurRoom script:) openTrunk)
						)
						(self dispose:)
					)
					((proc882_2 4)
						(= save1 1)
						(pInset init:)
						(Say pInset 880 0) ; "Hey Sonny. Do those keys fit anything?"
						(= seconds 2)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(7
				(HandsOff)
				(if (gEgo inRect: 108 124 183 190)
					(gEgo setMotion: PolyPath 128 184 self ignoreActors: 1)
				else
					(= seconds 4)
				)
			)
			(8
				(pInset dispose:)
				(pat view: 20 ignoreActors: 0 setMotion: PolyPath 223 61 self)
				(if (gEgo inRect: 128 0 320 138)
					(gEgo setMotion: PolyPath 243 61)
					(= register 1)
				)
			)
			(9
				(if (not register)
					(gEgo setMotion: PolyPath 243 74 self)
				else
					(= cycles 1)
				)
			)
			(10
				(if local4
					(-- state)
				)
				(= cycles 20)
			)
			(11
				(if (proc882_2 4)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(pInset dispose:)
					(HandsOn)
					(self dispose:)
				else
					(Face gEgo pat)
					(Print 880 1) ; "It appears that your partner has taken something out of the suspect car."
					(pat
						setMotion:
							PolyPath
							(- (cocaine x:) 4)
							(+ (cocaine y:) 7)
							self
					)
				)
			)
			(12
				(hisTrunk setCycle: End self)
				(gEgo ignoreActors: 0)
			)
			(13
				(hisTrunk loop: 1 cel: 0 stopUpd:)
				(cocaine init:)
				(Print 880 2) ; "Five packets of cocaine fall from the trunk of the car."
				(gCurRoom setScript: getCoke)
				(self dispose:)
			)
		)
	)
)

(instance exitCarP of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(yourDoor setCycle: End self)
			)
			(2
				(pat setCycle: Beg self)
			)
			(3
				(yourDoor priority: 13)
				(pat view: 355 loop: 3 setCycle: SyncWalk init:)
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
				(= cycles 5)
			)
			(1
				(= seconds 3)
				(ShowClock 1)
			)
			(2
				(gEgo
					normal: 0
					view: 17
					loop: 3
					cel: 0
					posn: (- (yourCar x:) 15) (- (yourCar y:) 25)
					setPri: 3
					setCycle: End self
					init:
				)
			)
			(3
				(gEgo
					normal: 1
					view: 5
					setCycle: Walk
					posn: (- (gEgo x:) 7) (+ (gEgo y:) 2)
					setPri: -1
					setMotion: MoveTo 177 133 self
				)
			)
			(4
				(= save1 1)
				(pInset init:)
				(Say pInset 880 3) ; "Holy Mother of God, look at this mess!"
				(= seconds 4)
			)
			(5
				(ShowClock 0)
				(= save1 1)
				(if (IsFlag 88)
					(Say pInset 880 4) ; "I'll get on the radio and call for support, Sonny."
				else
					(Say pInset 880 5) ; "I'll get on the radio and let dispatch know what's going on, Sonny."
				)
				(= seconds 5)
			)
			(6
				(= save1 1)
				(pat setScript: timeScript)
				(pInset dispose:)
				(sInset init:)
				(Say sInset 880 6) ; "Go ahead. I'll take care of things out here."
				(= seconds 4)
				(if (IsFlag 88)
					(+= state 3)
				)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sInset dispose:)
				(gEgo setMotion: PolyPath 87 172 self)
			)
			(8
				(= save1 1)
				(Say traffic 880 7) ; "Go ahead and look around. I'll take care of directing traffic."
				(= seconds 5)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(hisTrunk stopUpd:)
				(traffic
					view: 376
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -20 170 self
				)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sInset dispose:)
				(traffic dispose:)
				(UnLoad 129 79)
				(UnLoad 129 29)
				(UnLoad 128 17)
				(HandsOn)
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
				(gEgo setMotion: PolyPath 177 133 self)
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(- (yourCar x:) 17)
						(- (yourCar y:) 24)
						self
				)
			)
			(2
				(gEgo
					normal: 0
					view: 17
					posn: (+ (gEgo x:) 4) (- (gEgo y:) 2)
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(3
				(= gUseSortedFeatures 0)
				(gEgo setPri: -1 hide:)
				(wreckSound fade:)
				(gCurRoom newRoom: 25)
			)
		)
	)
)

(instance enterCarP of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pat setMotion: PolyPath 224 155 self)
			)
			(1
				(pat setMotion: MoveTo 224 155 self)
			)
			(2
				(pat view: 457 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(aDoor setCycle: Beg)
			)
		)
	)
)

(instance runOver of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (< (hitAndRun distanceTo: gEgo) 110))
			(Face gEgo hitAndRun self)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sfx number: 287 loop: 1 play:)
				(hitAndRun posn: -66 206 init:)
				(hitAndRun setMotion: Chase gEgo 80 self)
			)
			(1
				(sfx number: 293 loop: 1 play: self)
				(gEgo
					normal: 0
					view: 333
					loop: 3
					cel: 0
					setPri: 1
					setCycle: End
				)
				(hitAndRun setMotion: MoveTo 388 50 self)
			)
			(2 0)
			(3
				(EgoDead 6) ; "You have to take care of that oncoming traffic. Check that manual!"
			)
		)
	)
)

(instance dropFlares of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(trunk dispose:)
				(= local0 1)
				(gEgo setMotion: PolyPath -40 135 self)
			)
			(1
				(= seconds 5)
			)
			(2
				(gEgo setMotion: PolyPath 6 128 self)
			)
			(3
				(gEgo
					normal: 0
					view: 339
					loop: 1
					cel: 0
					setCycle: CT 6 1 self
				)
			)
			(4
				(flares1 setCycle: Fwd init:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					normal: 1
					view: 5
					setCycle: Walk
					loop: 0
					setMotion: PolyPath 41 120 self
				)
			)
			(6
				(gEgo
					normal: 0
					view: 339
					loop: 1
					cel: 0
					setCycle: CT 6 1 self
				)
			)
			(7
				(flares2 setCycle: Fwd init:)
				(gEgo setCycle: End self)
			)
			(8
				(gEgo
					normal: 1
					view: 5
					setCycle: Walk
					loop: 0
					setMotion: PolyPath 89 107 self
				)
			)
			(9
				(gEgo
					normal: 0
					view: 339
					loop: 1
					cel: 0
					setCycle: CT 6 1 self
				)
			)
			(10
				(flares3 setCycle: Fwd init:)
				(gEgo setCycle: End self)
			)
			(11
				(gEgo normal: 1 view: 5 setCycle: Walk loop: 0 put: 15 15) ; flares
				(SetScore 169 5)
				(Print 880 8) ; "You lay a flare pattern on the road to block traffic until the accident has been cleaned up."
				(= cycles 1)
			)
			(12
				(gEgo setMotion: PolyPath 87 171 self)
				(traffic
					view: 376
					setLoop: 0
					posn: -20 170
					setCycle: Walk
					setMotion: MoveTo 57 172 self
					init:
				)
			)
			(13)
			(14
				(= save1 1)
				(Say traffic 880 9) ; "I'll take care of directing traffic."
				(= seconds 4)
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(traffic
					view: 376
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -20 170 self
				)
			)
			(16
				(UnLoad 128 339)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance showBody of Script
	(properties)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				(= local3 gUseSortedFeatures)
				(= gUseSortedFeatures 1)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 223 61 self
				)
			)
			(1
				(Face gEgo body)
				(bodyInset init:)
				(= cycles 5)
			)
			(2
				(Print
					(Format ; "It's the guy from the bar alright. He won't be doing any talking though. But then, he'll never stab another man's wife in a parking lot again, either%s"
						@temp0
						880
						10
						(if (proc882_2 4)
							{.}
						else
							{. The keys are still in the ignition.}
						)
						(if (proc882_2 4)
							{.}
						else
							{. Die Schl\81ssel stecken immer noch im Z\81ndschloss.}
						)
					)
				)
				(gEgo ignoreActors: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterMeatWagon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ambulence setMotion: MoveTo 388 50 self)
			)
			(1
				(= seconds 3)
			)
			(2
				(ambulence
					setStep: 3 3
					posn: 367 8
					setMotion: MoveTo 307 34 self
				)
			)
			(3
				(aDoor init:)
				(ambulence setPri: 0 stopUpd: 1)
				(gEgo setMotion: PolyPath 230 75 self)
			)
			(4
				(Face gEgo body)
				(coroner
					view: 347
					setLoop: 1
					setCycle: SyncWalk
					posn: 340 40
					setMotion: PolyPath 235 53 self
					approachVerbs: 5 ; Talk
					init:
				)
				(attendent
					view: 347
					setLoop: 3
					setCycle: SyncWalk
					posn: 340 50
					setMotion: PolyPath 197 70 self
					init:
				)
			)
			(5)
			(6
				(Face gEgo coroner)
				(attendent view: 342 loop: 1 cel: 5 posn: 197 70)
				(coroner view: 342 loop: 1 cel: 6 posn: 235 53)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(attendent view: 350 loop: 0 cel: 0 setCycle: End)
				(gEgo
					normal: 0
					view: 340
					cel: 0
					loop: 0
					setCycle: CT 6 1 self
				)
			)
			(1
				(hisTrunk setCycle: End self)
			)
			(2
				(hisTrunk loop: 1 cel: 0 stopUpd:)
				(cocaine init:)
				(gEgo setCycle: End self)
			)
			(3
				(Print 880 11 #at 160 5 #width 100 #dispose) ; "Upon opening the trunk of the car, several packets of cocaine fall to the ground. Apparently this guy had several bad vices."
				(= seconds 8)
				(ambulence setScript: loadBody)
				(aDoor cel: 4)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(hisTrunk stopUpd:)
				(loadBody cycles: 5)
				(gEgo normal: 1 view: 5 loop: 6 setCycle: Walk)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getCoke of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 30)
					(gEgo
						setMotion:
							PolyPath
							(+ (gEgo x:) 20)
							(gEgo y:)
							self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if (> (gEgo y:) 170)
					(gEgo setMotion: PolyPath (gEgo x:) 150 self)
				else
					(= cycles 1)
				)
			)
			(2
				(= global105 14)
				(= global106 30)
				(traffic
					view: 376
					setLoop: 0
					posn: -20 170
					setCycle: Walk
					setMotion: MoveTo 7 172 self
					init:
				)
			)
			(3
				(= save1 1)
				(Say traffic 880 12) ; "Hey, Sergeant!"
				(= seconds 3)
			)
			(4
				(= save1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(traffic setMotion: MoveTo 57 172)
				(pInset init:)
				(Say pInset 880 13) ; "Go ahead, I'll round up the evidence, Sonny."
				(= seconds 5)
			)
			(5
				(pInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo setMotion: PolyPath 80 163 self)
			)
			(6
				(pat setScript: patCoke)
				(= save1 1)
				(Say traffic 880 14) ; "Thanks, Sergeant Bonds. I'll stay for the cleanup. You and Officer Morales can take off now."
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(yourTrunk stopUpd:)
				(= global150 2)
				(SetFlag 31)
				(ClearFlag 51)
				(self setScript: enterCar)
			)
		)
	)
)

(instance patCoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pat
					view: 20
					ignoreActors: 1
					setMotion:
						PolyPath
						(- (cocaine x:) 4)
						(+ (cocaine y:) 7)
						self
				)
			)
			(1
				(pat view: 345 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(cocaine dispose:)
				(pat setCycle: End self)
			)
			(3
				(pat view: 20 setCycle: Walk setScript: patTrunk self)
			)
			(4
				(pat view: 355)
				(self dispose:)
			)
		)
	)
)

(instance patTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pat
					view: 20
					setCycle: SyncWalk
					setMotion: PolyPath 158 167 self
				)
			)
			(1
				(pat setMotion: MoveTo 158 167 self)
			)
			(2
				(Face pat yourTrunk self)
			)
			(3
				(pat
					view: 345
					cel: 0
					loop: 0
					ignoreActors: 1
					setCycle: End self
				)
				(yourTrunk setCycle: End)
			)
			(4
				(yourTrunk setCycle: Beg self)
			)
			(5
				(pat view: 355 loop: 6 setCycle: SyncWalk)
				(if (== (gCurRoom script:) getCoke)
					(getCoke cycles: 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance loadBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(body dispose:)
				(attendent dispose:)
				(coroner view: 351 posn: 259 23 cel: 0 setPri: 10 init:)
			)
			(1
				(coroner setCycle: End self)
			)
			(2
				(coroner dispose:)
				(aDoor setCycle: Beg self)
			)
			(3
				(aDoor dispose:)
				(ambulence setStep: 5 5 setMotion: MoveTo 367 8 self)
			)
			(4
				(ambulence dispose:)
				(self dispose:)
			)
		)
	)
)

(instance corTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo coroner self)
			)
			(1
				(= save1 1)
				(cInset init:)
				(Say cInset 880 15) ; "Ah, Bonds! What brings a Sergeant to this minor little mishap?"
				(= seconds 5)
			)
			(2
				(= save1 1)
				(cInset dispose:)
				(sInset init:)
				(Say sInset 880 16) ; "The stiff was a suspect on a case of mine."
				(= seconds 5)
			)
			(3
				(= save1 1)
				(Say sInset 880 17) ; "He tried to pop me in a bar back in town. We were in hot pursuit when he rolled his vehicle."
				(= seconds 7)
			)
			(4
				(Say sInset 880 18) ; "He matches the description of one Steven Rocklin. But we can't be sure until we have a positive ID."
				(= seconds 7)
			)
			(5
				(= save1 1)
				(sInset dispose:)
				(cInset init:)
				(Say cInset 880 19) ; "I see! Well, he's road pizza now. I didn't see any ID on him. Well, I'll make a positive ID and call you when I have something."
				(= seconds 10)
			)
			(6
				(= save1 1)
				(cInset dispose:)
				(sInset init:)
				(Say sInset 880 20) ; "Thanks, Leon."
				(= seconds 3)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance body of Prop
	(properties
		x 202
		y 66
		description {car door}
		view 342
		loop 1
		cel 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(HandsOff)
				(self setScript: showBody)
			)
			(3 0) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bodyInset of Prop
	(properties
		x 162
		y 115
		view 356
		priority 14
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 880 21) ; "It's the punk who tried to blow you away at the Nugget. He fits the bag lady's description to a tee. You regret that you didn't get your hands on him before he died."
			)
			(3 ; Do
				(Print 880 22) ; "You search the battered body but find no identification."
				(self dispose:)
				(if (not (gCast contains: ambulence))
					(HandsOff)
					(ambulence setScript: enterMeatWagon init:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(if (not (proc882_2 4))
			(hisKeys init:)
		)
		(= local4 1)
		(super init:)
	)

	(method (dispose)
		(hisKeys dispose:)
		(= local4 0)
		(super dispose:)
	)

	(method (doit)
		(if (not (& (gEgo onControl: 0) $0100))
			(if (not (gCast contains: ambulence))
				(HandsOff)
				(ambulence setScript: enterMeatWagon init:)
			)
			(= gUseSortedFeatures local3)
			(hisKeys dispose:)
			(self dispose:)
		)
		(super doit:)
	)
)

(instance hisKeys of Prop
	(properties
		x 172
		y 120
		z 69
		view 356
		cel 1
		priority 15
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 880 23) ; "The car keys."
			)
			(3 ; Do
				(proc882_0 4)
				(self dispose:)
				(Print 880 24) ; "You remove the keys from the ignition."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hisTrunk of Prop
	(properties
		x 156
		y 78
		description {car trunk}
		approachX 152
		approachY 98
		view 342
		priority 2
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 880 25) ; "The car trunk."
			)
			(4 ; Inventory
				(switch invItem
					(3 ; theKeys
						(if (proc882_2 4)
							(if (not local2)
								(HandsOff)
								(= local2 1)
								(gCurRoom setScript: openTrunk)
							else
								(Print 880 26) ; "It's already open."
							)
						else
							(Print 880 27) ; "Your keys don't fit."
						)
					)
					(else
						(Print 880 28) ; "That won't do any good."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cocaine of Prop
	(properties
		x 157
		y 97
		description {car trunk}
		approachX 152
		approachY 98
		view 342
		loop 1
		cel 1
		priority 2
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 880 29) ; "The cocaine is packaged in five heavy-duty plastic bags. Apparently, murder wasn't this guy's only pastime."
			)
			(3 ; Do
				(HandsOff)
				(SetScore 170 5)
				(gCurRoom setScript: getCoke)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yourTrunk of Prop
	(properties
		description {car trunk}
		approachX 152
		approachY 162
		view 353
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 880 25) ; "The car trunk."
			)
			(3 ; Do
				(if local0
					(Print 880 30) ; "Pat has already gotten the rest of the equipment."
				else
					(UnLoad 128 700)
					(UnLoad 128 900)
					(trunk x: 160 y: 150 init: open:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yourDoor of Prop
	(properties
		description {car door}
		view 353
		loop 1
		priority 15
		signal 16401
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Print 880 31) ; "The passenger car door."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance yourCar of PicView
	(properties
		x 209
		y 161
		description {car}
		view 353
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 880 32) ; "Your car."
			)
			(3 ; Do
				(Print 880 33) ; "You haven't finished up here. Don't leave yet."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(yourDoor posn: (+ (self x:) 34) (self y:) 32 init:)
		(yourTrunk approachVerbs: 3 posn: (- (self x:) 40) (self y:) 12 init:) ; Do
		(super init:)
	)
)

(instance hitAndRun of Actor
	(properties
		yStep 20
		view 320
		cel 1
		signal 20480
		xStep 20
	)
)

(instance sInset of Prop
	(properties
		x 44
		y 107
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(sMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(sShirt posn: (+ (self x:) 3) (+ (self y:) 61) init:)
		(sEyes posn: (self x:) (self y:) setScript: egoBlink init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(sMouth dispose:)
		(sShirt dispose:)
		(sEyes dispose:)
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

(instance sEyes of Prop
	(properties
		description {Sonny}
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(sEyes cel: 1)
				(= cycles 2)
			)
			(2
				(sEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance pat of Actor
	(properties
		x 224
		y 155
		description {pat}
		view 457
		cel 8
		signal 1
	)

	(method (doit &tmp temp0)
		(cond
			((or (& (= temp0 (self onControl: 0)) $2000) (& temp0 $0040))
				(self priority: 13 signal: (| signal $0010))
			)
			((& temp0 $4000)
				(self priority: 14 signal: (| signal $0010))
			)
			((& temp0 $0001)
				(self priority: -1 signal: (& signal $ffef))
			)
			((> (self y:) 200)
				(self priority: 15 signal: (| signal $0010))
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 880 34) ; "Your partner, Pat Morales."
			)
			(5 ; Talk
				(Print 880 35) ; "Morales ignores you."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 880 36) ; "You can't shoot your partner in cold blood, Sonny."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pInset of Prop
	(properties
		x 72
		y 126
		description {Pat Morales}
		view 27
		priority 15
		signal 16401
	)

	(method (init)
		(pMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(pShirt posn: (+ (self x:) 2) (+ (self y:) 62) init:)
		(pEyes posn: (self x:) (self y:) setScript: patEyesBlink init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(pMouth dispose:)
		(pShirt dispose:)
		(pEyes setScript: 0 dispose:)
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

(instance pEyes of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 2
		priority 15
		signal 16401
	)
)

(instance patEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(pEyes cel: 1)
				(= cycles 4)
			)
			(2
				(pEyes cel: 0)
				(= cycles 1)
			)
			(3
				(= seconds 2)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance ambulence of Actor
	(properties
		x -66
		y 206
		yStep 20
		view 357
		signal 18432
		xStep 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 880 37) ; "The ambulance will remove any injured accident victims."
			)
			(3 ; Do
				(Print 880 38) ; "You've had one ambulance ride too many this week!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aDoor of Prop
	(properties
		x 250
		y -14
		view 357
		loop 1
		priority 1
		signal 18449
	)
)

(instance attendent of Actor
	(properties
		x 197
		y 70
		description {Leon}
		view 342
		loop 1
		cel 5
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 880 39) ; "The ambulance attendant is used to this kind of scene."
			)
			(5 ; Talk
				(Print 880 40) ; "The attendant is busy looking over the scene."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance coroner of Actor
	(properties
		x 235
		y 53
		description {Leon}
		approachX 241
		approachY 63
		view 342
		loop 1
		cel 6
		priority 1
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 880 41) ; "That's Leon, the county coroner. You see him all too frequently at accident scenes."
			)
			(5 ; Talk
				(if local1
					(Print 880 42) ; "Leon just looks at you and shakes his head."
				else
					(++ local1)
					(HandsOff)
					(gCurRoom setScript: corTalk)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cInset of Prop
	(properties
		x 229
		y 103
		description {Coroner}
		view 349
		priority 15
		signal 16401
	)

	(method (init)
		(cMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(cEyes posn: (self x:) (+ (self y:) 6) 6 setScript: cBlinkEyes init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(cMouth dispose:)
		(cEyes dispose:)
	)
)

(instance cMouth of Prop
	(properties
		description {mouth}
		view 349
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance cEyes of Prop
	(properties
		description {eyes}
		view 349
		loop 2
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance cBlinkEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(cEyes cel: 1)
				(= cycles 2)
			)
			(2
				(cEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance traffic of Actor
	(properties
		x 57
		y 172
		description {Leon}
		view 342
		loop 1
		cel 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Print 880 43) ; "It's a patrolman."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance flares1 of Prop
	(properties
		x 7
		y 125
		view 342
		loop 2
		signal 16384
		cycleSpeed 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Print 880 44) ; "The traffic on this road has been rerouted until the accident can be cleaned up."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance flares2 of Prop
	(properties
		x 42
		y 118
		view 342
		loop 2
		signal 16384
		cycleSpeed 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Print 880 44) ; "The traffic on this road has been rerouted until the accident can be cleaned up."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance flares3 of Prop
	(properties
		x 90
		y 104
		view 342
		loop 2
		signal 16384
		cycleSpeed 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Print 880 44) ; "The traffic on this road has been rerouted until the accident can be cleaned up."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theRoom of Feature
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(15 ; flares
						(HandsOff)
						(gCurRoom setScript: dropFlares)
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

(instance theRail of Feature ; UNUSED
	(properties
		onMeCheck 64
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 880 45) ; "The guardrail was smashed when the vehicle collided with it."
			)
			(4 ; Inventory
				(switch invItem
					(15 ; flares
						(HandsOff)
						(gCurRoom setScript: dropFlares)
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

(instance theCar of Feature
	(properties
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: body)
					(Print 880 46) ; "The car is overturned, smashed up, and generally mutilated.  A body slumps from the driver's side. So much for questioning the suspect."
				else
					(Print 880 47) ; "The car is overturned, smashed up, and generally mutilated."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wreckSound of Sound
	(properties
		flags 1
		number 880
		loop -1
	)
)

(instance deadbodySting of Sound
	(properties
		number 461
	)
)

(instance sfx of Sound
	(properties)
)

