;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room38 0
)

(synonyms
	(parrot bird)
	(room parlor)
)

(local
	local0
	[local1 2]
	local3
	local4
	local5
	local6
)

(instance Room38 of Rm
	(properties
		picture 38
	)

	(method (init)
		(super init:)
		(= west 37)
		(= local0 0)
		(= local6 (IsFirstTimeInRoom))
		(if (>= gAct 5)
			(gAddToPics add: glass)
			(self setFeatures: glass)
			(Load rsVIEW 638)
		)
		(if (and (!= gAct 0) (!= gAct 4))
			(gAddToPics add: stool1)
		)
		(if (< gAct 2)
			(decantar init: stopUpd:)
		)
		(gAddToPics
			add:
				bar
				statue
				sofa1
				sofa2
				table1
				table2
				table3
				portrait
				horse
				chair1
				chair2
				chair3
				stand
				stool2
				couch
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures:
				sofa1
				sofa2
				table1
				table2
				table3
				portrait
				chair1
				chair2
				chair3
				couch
				horse
				statue
				bar
		)
		(chair4 init: stopUpd:)
		(if gDetailLevel
			(lamp1 setCycle: Fwd init:)
			(lamp2 setPri: 4 setCycle: Fwd init:)
			(parrot cycleSpeed: 1 setPri: 6 setCycle: Fwd init:)
		else
			(parrot cycleSpeed: 1 setPri: 6 init: stopUpd:)
			(lamp1 init: stopUpd:)
			(lamp2 setPri: 4 init: stopUpd:)
		)
		(Fdoor
			cel: (if (== gPrevRoomNum 17) 2 else 0)
			ignoreActors: 1
			init:
			stopUpd:
		)
		(Bdoor
			cel: (if (== gPrevRoomNum 17) 2 else 0)
			ignoreActors: 1
			init:
			stopUpd:
		)
		(Door
			setLoop: 4
			illegalBits: 0
			x: (if (== gPrevRoomNum 50) 175 else 180)
			setPri: 4
			init:
			stopUpd:
		)
		(switch gAct
			(0
				(= local3 1)
				(if (not (& gSpyFlags $0002))
					(if (== [gCycleTimers 1] 1)
						(|= gSpyFlags $0002)
						(= [gCycleTimers 1] 0)
						(self setRegions: 378) ; ClarSit
					else
						(self setRegions: 217) ; GertieClarArgue
					)
				else
					(self setRegions: 378) ; ClarSit
				)
			)
			(1
				(self setRegions: 238) ; etheparr
			)
			(3
				(if (and (< gMinute 3) (< gFifiState 2))
					(self setRegions: 267) ; dusting
				)
			)
			(4
				(self setRegions: 272) ; clardrink
			)
		)
		(if (!= gPrevRoomNum 50)
			(if (== gPrevRoomNum 37)
				(gEgo posn: 15 98)
			else
				(gEgo posn: 261 120)
				(if (not local6)
					(Fdoor cycleSpeed: 1 setCycle: Beg)
					(Bdoor cycleSpeed: 1 setCycle: Beg)
					(gEgo setMotion: MoveTo 247 120)
					(soundFX number: 44 play:)
				)
			)
			(gEgo view: 0 illegalBits: -32732 setPri: -1 init:)
		else
			(gEgo
				view: 0
				illegalBits: -32768
				setPri: 2
				posn: 188 80
				loop: 2
				init:
			)
			(if (== local3 0)
				(gEgo posn: 179 80)
				(self setScript: enterPanel)
			)
		)
	)

	(method (doit)
		(if local6
			(Print 38 0) ; "You have entered the parlor of the old mansion. Against the back wall you notice a sculpted, marble bar, and in the corner a parrot swings from its bird stand."
			(if (== gPrevRoomNum 17)
				(Fdoor cycleSpeed: 1 setCycle: Beg)
				(Bdoor cycleSpeed: 1 setCycle: Beg)
				(gEgo setMotion: MoveTo 250 120)
				(soundFX number: 44 play:)
			)
			(= local6 0)
		)
		(if
			(and
				(== gPrevRoomNum 17)
				(not local5)
				(== (Fdoor cel:) 0)
				(== (Bdoor cel:) 0)
			)
			(= local5 1)
			(Fdoor stopUpd:)
			(Bdoor stopUpd:)
		)
		(if (gEgo inRect: 265 122 290 130)
			(gEgo setPri: 10)
			(chair4 startUpd:)
		else
			(chair4 stopUpd:)
			(cond
				((& (gEgo onControl: 0) $0008)
					(if (and (not script) (== (gEgo loop:) 0))
						(HandsOff)
						(self setScript: myDoor)
					)
					(gEgo setPri: 8)
				)
				((or (!= script exiting) (!= script enterPanel))
					(gEgo setPri: -1)
				)
			)
		)
		(if (& (gEgo onControl: 1) $0004)
			(gCurRoom newRoom: 17)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0020)
				(== local3 0)
				(== global204 0)
			)
			(gCurRoom newRoom: 50)
		)
		(if (< (gEgo x:) 140)
			(= vertAngle 163)
		else
			(= vertAngle 137)
		)
		(super doit:)
	)

	(method (dispose)
		(cls)
		(DisposeScript 985)
		(DisposeScript 204)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(DisposeScript 990)
			(if
				(and
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return 1)
				)
			)
			(cond
				((Said '/panel,(door<hidden)>')
					(cond
						((and (& global175 $0008) (Said 'open,move'))
							(if (not local3)
								(if (& (gEgo onControl: 0) $0010)
									(HandsOff)
									(self setScript: exiting)
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(Print 38 1) ; "You better not while others are in the room."
							)
						)
						((Said 'look')
							(if (& global175 $0008)
								(Print 38 2) ; "Even though you know where it is, you can't see it."
							else
								(Print 38 3) ; "You don't see one."
							)
						)
					)
				)
				((Said 'look[<around,at][/room]')
					(Print 38 0) ; "You have entered the parlor of the old mansion. Against the back wall you notice a sculpted, marble bar, and in the corner a parrot swings from its bird stand."
				)
				((Said 'sit/bar,barstool')
					(Print 38 4) ; "You feel uncomfortable sitting at bars, especially considering prohibition."
				)
				((Said 'press,(look<below)/monument')
					(Print 38 5) ; "There is nothing there."
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance exiting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global204 1)
				(Door setMotion: MoveTo 140 84 self)
				(soundFX number: 74 play:)
			)
			(1
				(if (gEgo inRect: 179 87 181 89)
					(= cycles 1)
				else
					(gEgo illegalBits: -32768 setMotion: MoveTo 180 88 self)
				)
			)
			(2
				(gEgo illegalBits: -32768 setMotion: MoveTo 180 82 self)
			)
			(3
				(gEgo setPri: 2)
				(Door setMotion: MoveTo 180 84 self)
				(soundFX number: 75 play:)
			)
			(4
				(HandsOn)
				(= global204 0)
				(client setScript: 0)
			)
		)
	)
)

(instance enterPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global204 1)
				(Door setMotion: MoveTo 140 84 self)
				(soundFX number: 74 play:)
			)
			(1
				(gEgo setMotion: MoveTo 179 90 self)
			)
			(2
				(gEgo setPri: -1 illegalBits: -32732)
				(Door setMotion: MoveTo 180 84 self)
				(soundFX number: 75 play:)
			)
			(3
				(HandsOn)
				(Print 38 6) ; "The secret panel closes behind you and leaves no trace!"
				(= global204 0)
				(client setScript: 0)
			)
		)
	)
)

(instance feedParrot of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((not local4)
				(if (and (== state 2) (== (parrot cel:) 2))
					(gEgo loop: 4 cel: 0 cycleSpeed: 1 setCycle: End self)
				)
			)
			((and (== state 4) (== (parrot cel:) 3))
				(gEgo loop: 2 cel: (gEgo lastCel:) setCycle: Beg)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or (!= (gEgo x:) 198) (!= (gEgo y:) 89))
					(gEgo
						setAvoider: (Avoid new:)
						setMotion: MoveTo 198 89 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: 57
					loop: (- 2 (<< local4 $0001))
					cel: 0
					illegalBits: 0
					setAvoider: 0
					setCycle: End self
				)
			)
			(2
				(soundFX number: 111 play:)
				(parrot loop: (- 3 (<< local4 $0001)) cel: 0 setCycle: End)
				(if local4
					(Print 38 7 #at 80 160 #dispose) ; "You give a cracker to the parrot."
					(-- global136)
					(= state 4)
					(= cycles 15)
				)
			)
			(3
				(Print 38 8 #at 80 160 #dispose) ; "Ouch!! It bit you!"
				(= cycles 14)
			)
			(4
				(= local4 0)
				(cls)
				(parrot loop: 0 setCycle: Fwd)
				(gEgo
					view: 11
					loop: 0
					illegalBits: -32732
					cycleSpeed: 0
					setCycle: Walk
				)
				(HandsOn)
				(client setScript: 0)
			)
			(5
				(cls)
				(parrot loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(if global116
					(Print 38 9) ; "AWWKK! Cracker!"
				else
					(switch gAct
						(1
							(Print 38 10) ; "AWWKK! Gonna tell him...tell him. Racehorse scam. AWWKK!"
						)
						(2
							(Print 38 11) ; "She's after me! AWWKK! So afraid!"
						)
						(3
							(Print 38 12) ; "AWWKK! I'll teach her! AWWKK! She can't break up with me!"
						)
						(4
							(Print 38 13) ; "Jeeves! Kiss me again! AWWKK!"
						)
						(5
							(Print 38 14) ; "AWWKK! I can't find her! AWWKK! Where's Gloria?"
						)
						(6
							(Print 38 15) ; "AWWKK! Sleep tight, my pretties. AWWKK! In the basement...the basement."
						)
						(7
							(Print 38 16) ; "Gotta get the gun...get the gun! AWWKK!"
						)
					)
					(= global116 1)
				)
				(= state 3)
				(= cycles 1)
			)
		)
	)
)

(instance myDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo illegalBits: 0)
				(if (> (gEgo x:) 250)
					(gEgo setMotion: MoveTo 250 (gEgo y:) self)
				else
					(= cycles 1)
				)
			)
			(2
				(Bdoor cycleSpeed: 1 ignoreActors: 1 setCycle: End)
				(Fdoor cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(soundFX number: 43 play:)
			)
			(3
				(gEgo setMotion: MoveTo (+ (gEgo x:) 50) 118)
			)
		)
	)
)

(instance bar of RPicView
	(properties
		y 98
		x 147
		view 138
		loop 1
		priority 6
		signal 16384
	)

	(method (handleEvent event &tmp [temp0 75])
		(cond
			((Said 'look<below,behind,in/bar')
				(Print 38 17) ; "There is nothing you would be interested in behind the bar."
			)
			((or (MousedOn self event 3) (Said 'look/bar'))
				(event claimed: 1)
				(cond
					((>= gAct 5)
						(Print (Format @temp0 38 18 38 19 38 20)) ; "%s %s"
					)
					((< gAct 2)
						(Print (Format @temp0 38 18 38 19 38 21)) ; "%s %s"
					)
					(else
						(Print 38 19) ; "The sculpted, marble bar sports a beautifully finished, ebony countertop."
					)
				)
			)
		)
	)
)

(instance table3 of RPicView
	(properties
		y 167
		x 185
		view 138
		loop 1
		cel 1
		priority 12
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance statue of RPicView
	(properties
		y 90
		x 19
		view 138
		loop 1
		cel 2
		priority 5
	)

	(method (handleEvent event)
		(cond
			((Said 'get,move,rotate/monument')
				(Print 38 22) ; "It's much too heavy for you to move."
			)
			((or (MousedOn self event 3) (Said 'look/monument'))
				(event claimed: 1)
				(if (< (gEgo distanceTo: statue) 100)
					(Print 38 23) ; "A marble statue of a lovely, Greek maiden stands in the corner."
				else
					(DoLook {horse})
				)
			)
		)
	)
)

(instance sofa1 of RPicView
	(properties
		y 166
		x 112
		view 138
		loop 3
		priority 12
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {sofa})
		)
	)
)

(instance sofa2 of RPicView
	(properties
		y 167
		x 257
		view 138
		loop 3
		priority 12
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {sofa})
		)
	)
)

(instance portrait of RPicView
	(properties
		y 54
		x 137
		view 138
		loop 2
		priority 5
	)

	(method (handleEvent event)
		(cond
			((Said 'look<behind,below/painting')
				(Print 38 24) ; "You can't see behind the picture."
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/painting')
					(Said 'look/gertie,woman/painting')
				)
				(event claimed: 1)
				(Print 38 25) ; "You see a beautiful girl and casually wonder who she might be. Funny...her eyes have a strange, hollow look to them."
			)
			((Said '/painting>')
				(cond
					((Said 'get')
						(Print 38 26) ; "The picture is firmly attached to the wall."
					)
					((Said 'open')
						(Print 38 27) ; "It doesn't open."
					)
				)
			)
			(
				(or
					(and (Said 'look/eye>') (Said 'look/gertie,woman'))
					(Said 'look/eye[<gertie,woman,painting]')
					(Said 'look/eye/gertie,woman')
				)
				(Print 38 28) ; "The eyes in the picture have a strange, hollow look to them."
			)
		)
	)
)

(instance horse of RPicView
	(properties
		y 147
		x 186
		view 138
		loop 1
		cel 3
		priority 13
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said 'get/blaze')
				(Print 38 29) ; "You don't need it."
			)
			((or (MousedOn self event 3) (Said 'look/blaze'))
				(event claimed: 1)
				(Print 38 30) ; "A delicate figure of a horse decorates a small table."
			)
		)
	)
)

(instance chair1 of RPicView
	(properties
		y 138
		x 87
		view 138
		loop 2
		cel 1
		priority 10
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance table1 of RPicView
	(properties
		y 137
		x 112
		view 138
		loop 2
		cel 3
		priority 10
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance chair2 of RPicView
	(properties
		y 138
		x 211
		view 138
		loop 2
		cel 2
		priority 10
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair3 of RPicView
	(properties
		y 137
		x 137
		view 138
		loop 2
		cel 1
		priority 10
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 138
		x 234
		view 138
		loop 2
		cel 3
		priority 10
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance chair4 of Prop
	(properties
		y 138
		x 265
		view 138
		loop 2
		cel 1
		priority 10
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance stand of RPicView
	(properties
		y 93
		x 222
		view 138
		loop 1
		cel 7
		priority 5
	)
)

(instance couch of RPicView
	(properties
		y 89
		x 67
		view 138
		loop 3
		cel 2
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance decantar of Prop
	(properties
		y 98
		x 116
		z 32
		view 138
		loop 1
		cel 5
		priority 6
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(cond
				(
					(or
						(Said 'drink/[<alcohol]')
						(Said 'drink,pour,get/decanter,alcohol,drink')
						(Said 'open/decanter,alcohol')
					)
					(Print 38 31) ; "You don't care for liquor...remember?"
				)
				((Said 'look<in/decanter')
					(Print 38 32) ; "The decanter is half-filled with cognac."
				)
				((Said 'look/alcohol')
					(Print 38 33) ; "Looks like fine cognac."
				)
				((or (MousedOn self event 3) (Said 'look/decanter'))
					(event claimed: 1)
					(Print 38 21) ; "Upon the countertop you see a decanter of cognac."
				)
			)
			(if (event claimed:)
				(SetFlag 29)
			)
		)
	)
)

(instance glass of RPicView
	(properties
		y 102
		x 167
		z 32
		view 138
		loop 1
		cel 4
		priority 6
	)

	(method (handleEvent event)
		(cond
			((Said 'look<in/glass')
				(Print 38 34) ; "The glass is empty."
			)
			((Said 'get/glass')
				(Print 38 35) ; "You don't need to carry around a glass."
			)
			(
				(or
					(Said 'look<use<monocle/glass')
					(Said 'look,look[<at]/glass/monocle<with')
				)
				(if (gEgo has: 1) ; monocle
					(if (gEgo inRect: 155 91 185 108)
						(Print 38 36 #icon 638 0 0) ; "Picking up the glass, you use Wilbur's monocle as a magnifying glass and notice a faint fingerprint."
						(SetFlag 10)
					else
						(NotClose) ; "You're not close enough."
					)
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'look/fingerprint/glass')
				(if (gEgo inRect: 155 91 185 105)
					(Print 38 37) ; "You can barely make out the fingerprint on the glass."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			(
				(or
					(MousedOn self event 3)
					(and (not (Said 'look/glass/monocle>')) (Said 'look/glass'))
				)
				(event claimed: 1)
				(if (gEgo inRect: 155 91 185 105)
					(Print 38 38) ; "As you look at the empty glass, you notice a faint fingerprint on it."
				else
					(Print 38 39) ; "You see an empty glass upon the bar."
				)
			)
		)
	)
)

(instance stool1 of RPicView
	(properties
		y 102
		x 168
		view 138
		loop 3
		cel 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance stool2 of RPicView
	(properties
		y 102
		x 138
		view 138
		loop 3
		cel 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance Fdoor of Prop
	(properties
		y 116
		x 267
		view 201
		loop 1
		priority 8
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(event claimed: 1)
			(Print 38 40) ; "The French doors lead outside."
		)
	)
)

(instance Bdoor of Prop
	(properties
		y 127
		x 277
		view 201
		loop 3
		priority 9
	)
)

(instance parrot of Prop
	(properties
		y 39
		x 221
		view 238
	)

	(method (handleEvent event)
		(cond
			((Said 'show,feed,give>')
				(cond
					(
						(or
							(Said '/parrot[/!*]')
							(and (Said '/food') (gEgo inRect: 197 88 240 98))
						)
						(Print 38 41) ; "Please specify what you would like to feed the parrot."
					)
					(
						(or
							(Said '/parrot/*>')
							(Said '/*/parrot>')
							(Said '/*<parrot>')
							(and
								(Said '/*/!*>')
								(gEgo inRect: 197 88 240 98)
							)
						)
						(cond
							((or (Said '/cracker') (Said '//cracker'))
								(if (gEgo has: 11) ; crackers
									(if (> global136 0)
										(if (gEgo inRect: 197 88 240 98)
											(= local4 1)
											(parrot setScript: feedParrot)
										else
											(NotClose) ; "You're not close enough."
										)
									else
										(Print 38 42) ; "The box of crackers is empty."
									)
								else
									(DontHave) ; "You don't have it."
								)
							)
							((and global219 global224)
								(Print 38 43) ; "The parrot doesn't seem too interested."
							)
							(else
								(DontHave) ; "You don't have it."
							)
						)
						(event claimed: 1)
					)
				)
			)
			((or (MousedOn self event 3) (Said 'look/parrot,birdstand,stand'))
				(Print 38 44) ; "A colorful parrot swings merrily on its perch."
				(event claimed: 1)
			)
			((Said '/parrot>')
				(cond
					((Said 'capture,get,pat')
						(if (gEgo inRect: 197 88 240 98)
							(= local4 0)
							(parrot setScript: feedParrot)
						else
							(NotClose) ; "You're not close enough."
						)
					)
					((Said 'talk')
						(switch (Random 0 3)
							(0
								(Print 38 45) ; "The parrot cocks its head quizzically."
							)
							(1
								(Print 38 46) ; "AWWKK!"
							)
							(2
								(Print 38 47) ; "Polly want a cracker!"
							)
							(3
								(Print 38 48) ; "Pretty Polly...AWWKK!"
							)
						)
					)
					((Said 'kiss')
						(Print 38 49) ; "That wouldn't be a good idea!"
					)
					((Said 'kill')
						(Print 38 50) ; "That's not a nice thought, Laura!"
					)
				)
			)
		)
	)
)

(instance closeUp of Prop ; UNUSED
	(properties
		y 58
		x 155
		view 638
	)
)

(instance lamp1 of Prop
	(properties
		y 41
		x 72
		view 138
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of Prop
	(properties
		y 41
		x 202
		view 138
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance Door of Act
	(properties
		y 84
		view 138
	)
)

(instance soundFX of Sound
	(properties
		priority 5
	)
)

