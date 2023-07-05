;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use PPath)
(use eRS)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm042 0
)

(local
	local0
	[local1 8] = [283 111 297 115 297 125 283 120]
	[local9 8] = [203 68 223 44 222 116 203 109]
	[local17 8] = [75 2 167 20 167 49 75 26]
	[local25 8] = [236 40 248 42 248 52 236 50]
	[local33 8] = [210 0 238 0 238 14 210 7]
	[local41 27] = [43 151 27 142 30 148 16 150 27 158 43 158 49 167 63 168 68 175 90 177 85 180 79 172 86 176 -32768]
	local68
	local69
	local70
	local71
	local72
	local73
	local74
	local75
	local76
	local77 = 1
)

(instance rm042 of PQRoom
	(properties
		noun 1
		picture 42
	)

	(method (init)
		(if (== gPrevRoomNum 1)
			(gEgo get: 2 0 5 1 9) ; Extender
		)
		(= global206 0)
		(= global207 914)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 86 0 88 55 86 89 94 129 110 154 132 95 165 42 148 0 148 0 189 163 189 108 168 122 151 161 135 211 141 251 150 303 180 284 189 319 189 319 168 277 150 299 143 286 141 269 149 196 125 212 120 196 115 176 120 160 116 157 115 44 77 52 75 42 72 35 73 0 65
					yourself:
				)
		)
		(keepOutPoly points: @local1 size: 4)
		(alarmSysPoly points: @local25 size: 4)
		(alSignPoly points: @local17 size: 4)
		(upWindowPoly points: @local33 size: 4)
		(doorPoly points: @local9 size: 4)
		(street init:)
		(upperWindows init: onMeCheck: upWindowPoly)
		(sideWalk init:)
		(alarmSystem init: onMeCheck: alarmSysPoly)
		(alarmBell init:)
		(alley init:)
		(windows init:)
		(ammoSign init:)
		(alSign init: onMeCheck: alSignPoly)
		(pigeons init:)
		(leftBuilding init:)
		(middleBuilding init:)
		(rightBuilding init:)
		(fly init:)
		(birdCrapOne init:)
		(birdCrapTwo init:)
		(lightPole init:)
		(garbage init:)
		(keepOutSign init: onMeCheck: keepOutPoly)
		(door init: onMeCheck: doorPoly)
		(patrolCar
			init:
			signal: (| (patrolCar signal:) $1000)
			ignoreActors: 1
			addToPic:
		)
		(frontDoor
			init:
			setPri: 12
			posn: (- (patrolCar x:) 5) (+ (patrolCar y:) 67) 50
			signal: (| (frontDoor signal:) $1000)
			stopUpd:
		)
		(backDoor
			init:
			setPri: 11
			posn: (+ (patrolCar x:) 15) (+ (patrolCar y:) 22)
			stopUpd:
		)
		(sirenLights
			init:
			posn: (+ (patrolCar x:) 19) (+ (patrolCar y:) 10)
			ignoreActors:
			setCycle: Fwd
		)
		(redLight
			init:
			posn: (+ (patrolCar x:) 48) (+ (patrolCar y:) 27)
			setCycle: Fwd
		)
		(blueLight
			init:
			posn: (+ (patrolCar x:) 52) (+ (patrolCar y:) 26)
			setCycle: Fwd
		)
		(drunkCar
			init:
			ignoreActors:
			illegalBits: 0
			signal: (| (drunkCar signal:) $1000)
			stopUpd:
			setPri: 6
		)
		(drunkCarDoor
			init:
			illegalBits: 0
			ignoreActors:
			posn: (+ (drunkCar x:) 29) (+ (drunkCar y:) 13)
			stopUpd:
		)
		(drunk
			init:
			illegalBits: 0
			posn: (+ (drunkCar x:) 49) (+ (drunkCar y:) 48)
			stopUpd:
			ignoreActors:
		)
		PPath
		(super init:)
		(gEgo
			init:
			view: 7
			setLoop: 4
			cel: 0
			setPri: 11
			posn: (+ (patrolCar x:) 9) (+ (patrolCar y:) 58)
			actions: egoUseRadio
			ignoreControl: -32768
		)
		(self setScript: startUpRoom)
	)

	(method (dispose)
		(DisposeScript 310)
		(DisposeScript 315)
		(gEgo put: 8 gCurRoom onMeCheck: 26505) ; Ticket
		(super dispose: &rest)
	)
)

(instance keepOutPoly of Polygon
	(properties)
)

(instance alarmSysPoly of Polygon
	(properties)
)

(instance alSignPoly of Polygon
	(properties)
)

(instance upWindowPoly of Polygon
	(properties)
)

(instance doorPoly of Polygon
	(properties)
)

(instance egoUseRadio of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Extender
				(if local68
					(if local71
						(gMessager say: 24 11 3 1) ; "Dispatch, this is 83-32. I'm still at the scene of a DUI stop. 83-32 out."
					else
						(if local77
							(SetScore 148 1)
						)
						(= local71 1)
						(gEgo onMeCheck: 0)
						(gMessager say: 24 11 2 0) ; "Dispatch, this is 83-32. Run wants on plate number BSOTD1."
					)
				else
					(gMessager say: 24 11 12 1) ; "Perhaps knowing the license plate number would make the call to dispatch more productive."
				)
				(return 1)
			)
			(9 ; Service_Revolver
				(gMessager say: 24 9 0 1) ; "If you're so scared of this pathetic gentleman that you feel the need to draw your gun, perhaps you should get into a less frightening line of work. How about potato farming? Accounting? Maybe you could become a professional golfer..."
				(return 1)
			)
		)
		(return 0)
	)
)

(instance patrolCar of View
	(properties
		x 169
		y 141
		noun 26
		view 103
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local77
						(gCurRoom setScript: getOutOfCar)
					)
					(local76
						(gEgo setScript: getInCar)
					)
					(else
						(gMessager say: 26 4 23 1) ; "Are you attempting to abandon your duties, Bonds?"
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frontDoor of Prop
	(properties
		noun 26
		view 103
		loop 2
		priority 12
		signal 4112
	)

	(method (init)
		(super init: &rest)
		(self posn: (- (patrolCar x:) 5) (+ (patrolCar y:) 67) 50 stopUpd:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 11) ; Extender
			(egoUseRadio doVerb: theVerb &rest)
		else
			(patrolCar doVerb: theVerb &rest)
		)
	)
)

(instance backDoor of Prop
	(properties
		x 183
		y 161
		noun 26
		view 103
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local75
					(gEgo setScript: putDrunkInCar)
				else
					(patrolCar doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sirenLights of Prop
	(properties
		noun 26
		view 103
		loop 4
	)

	(method (doVerb)
		(patrolCar doVerb: &rest)
	)
)

(instance blueLight of Prop
	(properties
		x 220
		y 165
		noun 26
		view 103
		loop 5
		cel 2
	)

	(method (doVerb)
		(patrolCar doVerb: &rest)
	)
)

(instance redLight of Prop
	(properties
		x 216
		y 166
		noun 26
		view 103
		loop 6
		cel 1
	)

	(method (doVerb)
		(patrolCar doVerb: &rest)
	)
)

(instance drunkCar of Actor
	(properties
		x -19
		y 89
		noun 27
		view 225
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local68 1)
				(gMessager say: 27 1 0 1) ; "You check out the white Chevy Beretta, noting its license plate number."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drunkCarDoor of Actor
	(properties
		noun 27
		view 225
		loop 1
		priority 7
		signal 16
	)

	(method (doVerb theVerb)
		(if (not local72)
			(drunk doVerb: theVerb)
		else
			(drunkCar doVerb: theVerb)
		)
	)
)

(instance stopGroop of Grooper
	(properties)

	(method (doit)
		(if
			(and
				(== (drunk loop:) (- (NumLoops drunk) 1))
				(not (& (drunk signal:) $0800))
			)
			(drunk loop: (drunk cel:))
		)
		(super doit: &rest)
	)
)

(instance giveDrunkSobrietyTest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local72 1)
				(gMessager say: 21 2 4 0 self) ; "You decide that this guy is about seven sheets to the wind. A field sobriety test is in order."
			)
			(1
				(drunkCarDoor setCycle: End)
				(sound3 number: 900 play:)
				(= ticks 30)
			)
			(2
				(drunk cel: 1 setCycle: End self)
			)
			(3
				(drunk
					view: 353
					cel: 0
					loop: 1
					posn: (- (drunk x:) 5) (- (drunk y:) 1)
				)
				(= cycles 1)
			)
			(4
				(gEgo setMotion: MoveTo 113 176 self)
			)
			(5
				(gEgo setHeading: 270 self)
			)
			(6
				(drunk
					setPri: 14
					setCycle: Walk
					setMotion: MoveTo (+ (drunk x:) 10) (+ (drunk y:) 10) self
				)
			)
			(7
				(drunkCarDoor setCycle: Beg self)
			)
			(8
				(sound3 number: 901 play:)
				(= ticks 30)
			)
			(9
				(gMessager say: 21 2 16 1 self) ; "Mr. Barnum, I'm going to conduct a field sobriety test to determine whether or not you are under the influence. I'd like you to stand on the line and walk toward me heel-to-toe."
			)
			(10
				(SetScore 149 3)
				(drunk setMotion: PPath @local41 self)
			)
			(11
				(drunk
					setLoop: -1
					setLoop: stopGroop
					setPri: -1
					approachX: 113
					approachY: 176
					ignoreActors: 0
				)
				(gMessager say: 21 2 15 1 self) ; "Mr. Barnum performs his field sobriety test with the grace of a crude-oil-coated waterfowl. (Actually, the waterfowl probably would have done better.)"
			)
			(12
				(= local73 1)
				(HandsOn)
			)
		)
	)
)

(instance drunk of Actor
	(properties
		x 38
		y 141
		noun 21
		view 351
		priority 6
		signal 16
	)

	(method (doVerb theVerb)
		(if local77
			(gMessager say: 26 0 25 1) ; "Perhaps exiting the patrol car would make that task possible."
		else
			(switch theVerb
				(2 ; Talk
					(if local70
						(if (not local0)
							(= local0 1)
							(gLongSong2 stop:)
							(gLongSong number: 420 loop: -1 flags: -1 play:)
						)
						(if local71
							(if local73
								(if (not local74)
									(gMessager say: 21 2 6 0) ; "I think you'd better come with me, Mr. Barnum."
									(= local74 1)
								)
							else
								(switch local69
									(0
										(gMessager say: 21 2 2 1) ; "I--I did'n do nothin' wrong, Oshifer. (belch). I'm a reshpectable man."
									)
									(1
										(gMessager say: 21 2 3 0) ; "May I see your license, please?"
										(gEgo get: 17) ; Hoffman_s_License
									)
									(2
										(self setScript: giveDrunkSobrietyTest)
									)
								)
								(++ local69)
							)
						else
							(gMessager say: 21 2 14 1) ; "Procedure, Bonds. Isn't there something you're forgetting?"
						)
					else
						(gMessager say: 21 2 1 1) ; "Shouldn't you look at the gentleman first?"
					)
				)
				(1 ; Look
					(= local70 1)
					(if local72
						(gMessager say: 21 1 18 1) ; "No doubt about it, this guy's truly hammered."
					else
						(gMessager say: 21 1 17 1) ; "The guy in the car rolls down his window, which seems to be a major effort for him. He looks up at you, trying to hold his head steady. You always find some amusement -- and disgust -- in the way hopelessly drunk people try so hard to look straight and nonchalant."
					)
				)
				(19 ; Ticket
					(cond
						((and (!= local69 0) (not local75))
							(self setScript: giveDrunkTicket)
						)
						(local75
							(gMessager say: 21 19 11 1) ; "There's no need to give a cuffed man a ticket."
						)
						(else
							(gMessager say: 21 19 13 1) ; "You should determine the man's physical state before ticketing him."
						)
					)
				)
				(21 ; Handcuffs
					(if local73
						(if local74
							(if (not local75)
								(self setScript: cuffDrunk)
							else
								(super doVerb: theVerb &rest)
							)
						else
							(gMessager say: 21 21 19 1) ; "You haven't placed that man under arrest yet, Bonds. You have no business cuffing him."
						)
					else
						(gMessager say: 21 21 5 1) ; "Arresting a suspected drunken driver before administering a field sobriety test? Your instructors back at the academy would be appalled."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance street of Feature
	(properties
		noun 17
		onMeCheck 64
	)
)

(instance upperWindows of Feature
	(properties
		noun 15
	)
)

(instance sideWalk of Feature
	(properties
		noun 16
		onMeCheck 128
	)
)

(instance alarmSystem of Feature
	(properties
		noun 9
	)
)

(instance alarmBell of Feature
	(properties
		noun 8
		onMeCheck 8192
	)
)

(instance alley of Feature
	(properties
		noun 11
		onMeCheck 4096
	)
)

(instance windows of Feature
	(properties
		noun 14
		onMeCheck 256
	)
)

(instance ammoSign of Feature
	(properties
		noun 6
		onMeCheck 2048
	)
)

(instance alSign of Feature
	(properties
		noun 5
	)
)

(instance pigeons of Feature
	(properties
		noun 25
		onMeCheck 32
	)
)

(instance fly of Feature
	(properties
		noun 7
		onMeCheck 1024
	)
)

(instance leftBuilding of Feature
	(properties
		noun 3
		onMeCheck 2
	)
)

(instance middleBuilding of Feature
	(properties
		noun 28
		onMeCheck 16384
	)
)

(instance rightBuilding of Feature
	(properties
		noun 2
		onMeCheck 512
	)
)

(instance birdCrapOne of Feature
	(properties
		noun 18
		onMeCheck 16384
	)
)

(instance birdCrapTwo of Feature
	(properties
		noun 19
		onMeCheck 8
	)
)

(instance lightPole of Feature
	(properties
		noun 12
		onMeCheck 4
	)
)

(instance garbage of Feature
	(properties
		noun 4
		onMeCheck 16
	)
)

(instance keepOutSign of Feature
	(properties
		noun 10
	)
)

(instance door of Feature
	(properties
		noun 13
	)
)

(instance getInCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(+ (patrolCar x:) 7)
						(+ (patrolCar y:) 46)
						self
				)
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(+ (patrolCar x:) 9)
						(+ (patrolCar y:) 58)
						self
				)
			)
			(2
				(frontDoor setCycle: End self)
			)
			(3
				(sound3 number: 900 loop: 1 flags: -1 play:)
				(gEgo
					view: 7
					loop: 4
					setPri: 11
					cel: (- (NumCels gEgo) 1)
					setCycle: Beg self
				)
			)
			(4
				(frontDoor setPri: 12 setCycle: Beg self)
			)
			(5
				(sound3 number: 901 loop: 1 flags: -1 play:)
				(= global211 24)
				(HandsOn)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance getOutOfCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(drunk
					approachVerbs: 1 2 18 19 ; Look, Talk, Hoffman_s_License, Ticket
					approachX: (+ (drunkCar x:) 50)
					approachY: (+ (drunkCar y:) 68)
				)
				(sound3 number: 900 loop: 1 flags: -1 play:)
				(frontDoor setCycle: End self)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(NormalEgo)
				(gEgo posn: (+ (gEgo x:) 5) (- (gEgo y:) 4))
				(= cycles 2)
			)
			(3
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 5) (+ (gEgo y:) 5) self
				)
			)
			(4
				(gEgo setHeading: 315 self)
			)
			(5
				(frontDoor setCycle: Beg self)
			)
			(6
				(sound3 number: 901 loop: 1 flags: -1 play:)
				(gEgo
					setMotion:
						MoveTo
						(- (patrolCar x:) 30)
						(+ (patrolCar y:) 45)
						self
				)
			)
			(7
				(gEgo onMeCheck: 26505)
				(= local77 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance startUpRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2 number: 911 loop: 1 play:)
				(gLongSong number: 250 loop: 1 play:)
				(= seconds 4)
			)
			(1
				(gLongSong fade:)
				(= seconds 2)
			)
			(2
				(gLongSong2 number: 915 loop: -1 play:)
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance putDrunkInCar of Script
	(properties)

	(method (doit)
		(if (and (not state) (& (gEgo signal:) $0400))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(- (patrolCar x:) 88)
						(+ (patrolCar y:) 23)
						self
				)
			)
			(1
				(drunk
					setLoop: -1
					loop: 6
					setCycle: Walk
					ignoreActors: 1
					setMotion:
						MoveTo
						(- (patrolCar x:) 41)
						(+ (patrolCar y:) 45)
						self
				)
			)
			(2
				(gEgo
					setMotion:
						MoveTo
						(- (patrolCar x:) 11)
						(+ (patrolCar y:) 45)
				)
				(drunk
					setMotion:
						MoveTo
						(- (patrolCar x:) 12)
						(+ (patrolCar y:) 69)
						self
				)
			)
			(3
				(drunk
					setMotion:
						MoveTo
						(+ (patrolCar x:) 26)
						(+ (patrolCar y:) 69)
						self
				)
			)
			(4
				(frontDoor setPri: 10)
				(backDoor setCycle: End self)
			)
			(5
				(drunk
					setMotion:
						MoveTo
						(+ (patrolCar x:) 22)
						(+ (patrolCar y:) 50)
						self
				)
			)
			(6
				(drunk
					view: 280
					setLoop: 3
					setPri: 11
					cel: (- (NumCels drunk) 1)
					setCycle: Beg self
				)
			)
			(7
				(drunk setPri: 10)
				(frontDoor setPri: 11)
				(backDoor setPri: 11 setCycle: Beg self)
			)
			(8
				(gMessager say: 20 4 11 1 self) ; "You open the door for Mr. Barnum, who gets in shakily. You truly hope he doesn't upchuck on your upholstery."
			)
			(9
				(drunk
					approachX: (- (patrolCar x:) 11)
					approachY: (+ (patrolCar y:) 45)
				)
				(= local76 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sound3 of Sound
	(properties)
)

(instance cuffDrunk of Script
	(properties)

	(method (changeState newState &tmp [temp0 110])
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 23 0 6 1 self) ; "Please step up to the car, sir."
			)
			(1
				(drunk
					ignoreActors:
					setMotion: MoveTo (drunk x:) (- (drunk y:) 17) self
				)
			)
			(2
				(drunk
					view: 352
					setLoop: 0
					cel: 5
					posn: (drunk x:) (- (drunk y:) 2)
				)
				(= cycles 1)
			)
			(3
				(drunk setCycle: End self)
			)
			(4
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 34)
						(- (gEgo y:) 15)
						self
				)
			)
			(5
				(drunk hide:)
				(gEgo view: 352 setCycle: 0 setLoop: 1 cel: 0)
				(= cycles 1)
			)
			(6
				(drunkCarDoor stopUpd:)
				(gEgo setCycle: ForwardCounter 2 self)
			)
			(7
				(gLongSong fade:)
				(gLongSong2 play:)
				(if
					(= register
						(Print
							addText: 21 21 6 1 0 0 42 ; "Hey, Oshifer, you don' need to cuff me! I'll be good, I shwear! Oh, arright, arright. Lishen, could you cuff me in the front? I'm not feelin' sho good. Be a shport, huh?"
							addButton: 1 23 0 22 1 50 50 42 ; "Yes"
							addButton: 0 23 0 21 1 100 50 42 ; "No"
							init:
						)
					)
					(gMessager say: 21 21 8 0 self) ; "All right, pard. I'll cuff you in the front."
				else
					(+= state 2)
					(gMessager say: 21 21 9 0 self) ; "I'm sorry, sir, but I have to follow departmental regulations."
				)
			)
			(8
				(gCurRoom drawPic: 99)
				(gCast eachElementDo: #hide)
				(gLongSong2 fade:)
				(gMessager say: 21 21 26 0 self) ; "Congratulations, Bonds. You let a sloppy drunk give you a double-fisted slammer to the back of the head. Maybe you should have cuffed him in the back, huh? Don't worry, the neck brace will be off in 8 or 9 months..."
			)
			(9
				(EgoDead 3)
			)
			(10
				(sound3 number: 919 loop: 1 flags: -1 play:)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(11
				(drunk
					view: 342
					setLoop: -1
					loop: 8
					cel: 6
					posn: (+ (drunk x:) 2) (+ (drunk y:) 4)
					ignoreActors: 0
					show:
				)
				(gEgo posn: (- (gEgo x:) 3) (+ (gEgo y:) 3))
				(NormalEgo)
				(= cycles 1)
			)
			(12
				(gEgo view: 0 loop: 8 cel: 6)
				(= cycles 1)
			)
			(13
				(= local75 1)
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance giveDrunkTicket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo put: 8 gCurRoom) ; Ticket
				(gMessager say: 21 19 7 0 self) ; "You give Mr. Barnum a citation for unsafe driving."
			)
			(1
				(if local72
					(drunk
						setMotion:
							MoveTo
							(+ (drunkCar x:) 62)
							(+ (drunkCar y:) 62)
							self
					)
				else
					(+= state 5)
					(= ticks 30)
				)
			)
			(2
				(drunkCarDoor setCycle: End self)
				(sound3 number: 900 play:)
			)
			(3
				(drunk
					setMotion: MoveTo (- (drunk x:) 15) (- (drunk y:) 9) self
				)
			)
			(4
				(drunk
					view: 351
					setPri: 6
					loop: 0
					cel: (- (NumCels drunk) 1)
					setCycle: Beg self
				)
			)
			(5
				(drunkCarDoor setCycle: Beg self)
			)
			(6
				(sound3 number: 901 loop: 1 flags: -1 play:)
				(= ticks 30)
			)
			(7
				(gMessager say: 21 19 20 1 self) ; "Drive carefully on your way home, Mr. Barnum."
			)
			(8
				(= ticks 30)
			)
			(9
				(gMessager say: 21 19 20 2 self) ; "Oh, I will, Oshifer. Ish time for Bowling for Pedesh--Pedesh--People! YAAAAAHOOOOOO!"
			)
			(10
				(gLongSong fade:)
				(= ticks 30)
			)
			(11
				(drunk
					signal: (| (drunk signal:) $0800)
					setCycle: 0
					moveSpeed: 7
					xStep: 7
					yStep: 2
					setMotion: MoveTo (- (drunk x:) 99) (- (drunk y:) 27)
				)
				(sound3 number: 910 loop: 1 flags: -1 play:)
				(drunkCarDoor
					signal: (| (drunkCarDoor signal:) $0800)
					setCycle: 0
					moveSpeed: (drunk moveSpeed:)
					xStep: (drunk xStep:)
					yStep: (drunk yStep:)
					setMotion:
						MoveTo
						(- (drunkCarDoor x:) 99)
						(- (drunkCarDoor y:) 27)
				)
				(drunkCar
					signal: (| (drunkCar signal:) $0800)
					setCycle: 0
					moveSpeed: (drunk moveSpeed:)
					xStep: (drunk xStep:)
					yStep: (drunk yStep:)
					onMeCheck: drunkCar
					setMotion:
						MoveTo
						(- (drunkCar x:) 99)
						(- (drunkCar y:) 27)
						self
				)
			)
			(12
				(drunkCar dispose:)
				(= seconds 2)
			)
			(13
				(gMessager say: 21 19 20 3 self) ; "Only a mile or two down the road, Mr. Barnum's car jumps the curb and hits five people at a bus stop. Two of them die, one of them becomes paralyzed for life, and the other two escape with minor injuries."
			)
			(14
				(EgoDead 3)
			)
		)
	)
)

