;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 271)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)

(public
	rm271 0
)

(local
	obeyState = 1
	obeyTimer
	canGetIn
)

(procedure (DoTheObedienceThing)
	(switch obeyState
		(3
			(HighPrint 271 0 80 {That Voice Again:}) ; "The Eternal Order of Fighters has no need for fools who can't obey a simple order. Go away! You'll never be a real Hero!"
			(= obeyState 4)
			(= canGetIn 0)
			(theDoor cel: 0)
			(= gWimpyHero 1)
		)
		(2
			(HighPrint 271 1 80 {Still The Same Voice:}) ; "You were given an order. Obey!"
			(= obeyState 3)
			(= obeyTimer 50)
		)
		(1
			(LowPrint 271 2) ; "You hear a voice from inside..."
			(HighPrint 271 3 80 {A Voice From Within:}) ; "You do not need the light. Put it away."
			(= obeyState 2)
			(= obeyTimer 50)
		)
	)
)

(instance rm271 of Rm
	(properties
		style 7
		horizon 88
		vanishingY 50
	)

	(method (init)
		(LoadMany rsVIEW 0 22 700 702)
		(Load rsPIC 700)
		(if (or (== gPrevRoomNum 270) (== gPrevRoomNum 275))
			(Load rsPIC 2)
		)
		(= canGetIn
			(if (and (== gDay 15) (not gWimpyHero))
				(or (== gTimeODay 5) (== gTimeODay 4))
			)
		)
		(NormalEgo)
		(if (or (== gPrevRoomNum 270) (== gPrevRoomNum 275))
			(gEgo
				view: 22
				x: 164
				y: 90
				setLoop: (if (or (== gWimpyHero 2) (== gWimpyHero 3)) 1 else 0)
				cel: 0
				init:
				hide:
				setScript: thrownOut
			)
			(self picture: 2)
		else
			(gEgo
				loop: 3
				illegalBits: -384
				posn: 160 181
				init:
				setMotion: MoveTo 160 147
			)
			(theDoor
				cel:
					(cond
						(
							(and
								(or (== gPrevRoomNum 270) (== gPrevRoomNum 275))
								gWimpyHero
							)
							3
						)
						(canGetIn 1)
						(else 0)
					)
				init:
			)
			(self picture: 700)
		)
		(super init:)
		(if (not (or (== gPrevRoomNum 270) (== gPrevRoomNum 275)))
			(InitAddToPics backWall flame)
			(InitFeatures thisAlley theDark)
		)
	)

	(method (doit)
		(if (> (gEgo y:) 181)
			(if gWimpyHero
				(= gWimpyHero 5)
			)
			(gCurRoom newRoom: 704) ; alleyRoom
		)
		(if
			(and
				canGetIn
				(not obeyTimer)
				(< (gEgo distanceTo: theDoor) 40)
				(not (gEgo script:))
			)
			(= obeyTimer 50)
			(= obeyState 2)
			(gEgo setMotion: 0)
			(HighPrint 271 4 80 {Voice}) ; "Enter the darkness!"
		)
		(if
			(and
				canGetIn
				obeyTimer
				(< (gEgo distanceTo: theDoor) 15)
				(not (gEgo script:))
			)
			(= obeyTimer 0)
			(if (== gEgoGait 4) ; holdingLamp
				(gEgo setMotion: 0)
				(= obeyState 3)
				(DoTheObedienceThing)
			else
				(gEgo setScript: openDoor)
			)
		)
		(cond
			((not obeyTimer))
			((-- obeyTimer))
			(else
				(DoTheObedienceThing)
			)
		)
	)

	(method (dispose)
		(if (== gEgoGait 4) ; holdingLamp
			(HighPrint 271 5) ; "You extinquish your lamp."
			(EgoGait 0 0) ; walking
			(NormalEgo)
			(RedrawCast)
		)
		(= gRoomExitDir 1)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 271 6) ; "You're in a blind alley. There's a door at the end. The street sign reads 'Saif Darb.'"
			)
			((Said 'knock[/door]')
				(gEgo setScript: knockDoor)
			)
		)
	)
)

(instance backWall of PicView
	(properties
		x 160
		y 80
		noun '/door'
		description {the door}
		view 702
		cel 3
		priority 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond
					((or (== gPrevRoomNum 270) (== gPrevRoomNum 275))
						(HighPrint 271 7) ; "You've been locked out."
					)
					(canGetIn
						(HighPrint 271 8) ; "The door is partly open. It is very, very dark on the other side."
					)
					(else
						(HighPrint 271 9) ; "The door looks like it's locked and barred."
					)
				)
			)
			(2
				(gEgo setScript: openDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flame of PicView
	(properties
		x 215
		y 66
		noun '/flame,torch,lamp,light'
		description {the torch}
		lookStr {A torch lights up the alleyway.}
		view 701
		loop 5
		priority 9
	)
)

(instance theDoor of Prop
	(properties
		x 174
		y 78
		noun '/door'
		description {the door}
		view 702
		loop 4
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond
					((or (== gPrevRoomNum 270) (== gPrevRoomNum 275))
						(HighPrint 271 7) ; "You've been locked out."
					)
					(canGetIn
						(HighPrint 271 8) ; "The door is partly open. It is very, very dark on the other side."
					)
					(else
						(HighPrint 271 9) ; "The door looks like it's locked and barred."
					)
				)
			)
			(2
				(gEgo setScript: openDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'listen[/door]')
				(if canGetIn
					(LowPrint 271 10) ; "You hear no sounds coming from inside the building."
				else
					(LowPrint 271 11) ; "All you hear is a ringing in your own ears."
				)
			)
			((Said 'use,light/lamp,light')
				(if (and (gEgo has: 33) (!= gEgoGait 4)) ; BrassLamp, holdingLamp
					(EgoGait 4 0) ; holdingLamp
					(NormalEgo)
					(RedrawCast)
				)
				(if canGetIn
					(TrySkill 25 1) ; flameDartSpell
					(DoTheObedienceThing)
				)
			)
			((Said 'douse,(put<away,out)/lamp,light')
				(if (== gEgoGait 4) ; holdingLamp
					(EgoGait 0 0) ; walking
					(NormalEgo)
					(HighPrint 271 5) ; "You extinquish your lamp."
					(RedrawCast)
				)
				(if obeyTimer
					(= obeyTimer 30)
					(= obeyState 2)
					(HighPrint 271 12 80 {The Same Voice:}) ; "That's good. You obeyed at least one order. Now walk through the door."
				)
			)
			((and (gEgo has: 33) (Said 'drop,(put<down)/light,lamp')) ; BrassLamp
				(if (== gEgoGait 4) ; holdingLamp
					(EgoGait 0 0) ; walking
					(NormalEgo)
					(RedrawCast)
				)
				(gEgo use: 33) ; BrassLamp
				(HighPrint 271 13) ; "Ok, you drop it."
			)
		)
	)
)

(instance thrownOut of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(if (or (== gWimpyHero 2) (== gWimpyHero 3))
					(HighPrint 271 14) ; "You speed to the door, throw it open, and head for the alley. You trip over the door's threshold and land sprawling on your face."
				else
					(HighPrint 271 15) ; "You are grabbed and roughly tossed through the door back into the alley."
				)
				(= cycles 3)
			)
			(2
				(theDoor
					cel:
						(cond
							(
								(and
									(or (== gPrevRoomNum 270) (== gPrevRoomNum 275))
									gWimpyHero
								)
								3
							)
							(canGetIn 1)
							(else 0)
						)
					init:
				)
				(gCurRoom drawPic: 700)
				(InitAddToPics backWall flame)
				(InitFeatures thisAlley theDark)
				(gEgo show:)
				(if (or (== gWimpyHero 2) (== gWimpyHero 3))
					(theDoor setCycle: Beg self)
				else
					(gEgo setCycle: End self)
					(theDoor setCycle: Beg)
				)
			)
			(3
				(cond
					((== gWimpyHero 6)
						(HighPrint 271 16 80 {The Same Voice As Before:}) ; "The Eternal Order of Fighters has no need for cheaters who try to pull dirty tricks in our combat test. You'll never be a real Hero!"
					)
					((> gWimpyHero 2)
						(= gTimeODay 6)
						(if (or (== gPrevRoomNum 270) (== gPrevRoomNum 275))
							(LowPrint 271 17) ; "Except for a major headache, along with some cuts and bruises, you seem to be all in one piece. You even have your equipment back."
							(LowPrint 271 18) ; "There is a message scrawled on the stone alley floor. It says: "The Eternal Order of Fighters does not want Wimps and Losers.""
						)
					)
					((== gWimpyHero 2)
						(HighPrint 271 0 80 {The Same Voice As Before:}) ; "The Eternal Order of Fighters has no need for fools who can't obey a simple order. Go away! You'll never be a real Hero!"
					)
					(gWimpyHero
						(HighPrint 271 19 80 {The Same Voice As Before:}) ; "Couldn't even break out of the chains. Whatta wimp!"
					)
				)
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: CT 4 1 self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					view: 0
					setLoop: 3
					heading: 0
					cycleSpeed: 0
					posn: (- (gEgo x:) 3) (+ (gEgo y:) 8)
				)
				(NormalEgo)
				(gEgo illegalBits: -384)
				(self dispose:)
			)
		)
	)
)

(instance knockDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo distanceTo: theDoor) 15)
					(gEgo setMotion: MoveTo 160 90 self)
				else
					(self cue:)
				)
			)
			(1
				(cond
					(canGetIn
						(LowPrint 271 20) ; "You knock three times."
						(theDoor setCycle: End self)
					)
					((and gWimpyHero (or (== gPrevRoomNum 270) (== gPrevRoomNum 275)))
						(HighPrint 271 21 80 {The Same Old Voice:}) ; "You can't come back in here. We just threw you out!"
						(self dispose:)
					)
					(else
						(LowPrint 271 22) ; "The door is locked tight, and the sound of your knocks echos hollowly in the alley, without response."
						(self dispose:)
					)
				)
			)
			(2
				(LowPrint 271 23) ; ""Oh, what the heck!" you say aloud."
				(gEgo illegalBits: 0 setPri: 3 setMotion: MoveTo 160 75 self)
			)
			(3
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance openDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo distanceTo: theDoor) 15)
					(gEgo setMotion: MoveTo 160 90 self)
				else
					(self cue:)
				)
			)
			(1
				(if canGetIn
					(theDoor setCycle: End self)
				else
					(LowPrint 271 24) ; "The door is locked tight."
					(self dispose:)
				)
			)
			(2
				(gEgo illegalBits: 0 setPri: 3 setMotion: MoveTo 160 75 self)
			)
			(3
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance thisAlley of Feature
	(properties
		x 159
		y 94
		noun '/alley'
		nsTop 15
		nsLeft 88
		nsBottom 173
		nsRight 230
		description {the alley}
		lookStr {The alleys of Shapeir are major arteries of transport.}
	)
)

(instance theDark of Feature
	(properties
		x 159
		y 93
		noun '/dark'
		nsTop -1
		nsBottom 187
		nsRight 318
		description {the dark}
		lookStr {All is darkness beyond the immediate alley.}
	)
)

