;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use n128)
(use eRoom)
(use Interface)
(use Motion)
(use Menu)
(use Actor)
(use System)

(public
	Rm50 0
)

(local
	local0
	local1
	local2
	[local3 11] = [13 27 72 106 143 186 203 279 308 227 242]
	local14
)

(instance topDrip of Prop
	(properties
		y 61
		x 1000
		view 150
	)
)

(instance botDrip of Prop
	(properties
		y 120
		x 1000
		view 150
		loop 1
	)
)

(instance ripple of Prop
	(properties
		y 128
		x 263
		view 150
		loop 3
	)
)

(instance Rm50 of eRoom
	(properties
		picture 50
	)

	(method (init)
		(if (== gPrevRoomNum 41)
			(= global61 1)
			(self style: 2)
		else
			(self style: 16)
		)
		(if (== gPrevRoomNum 65)
			(Load rsVIEW 75)
		)
		(Load rsSOUND (proc0_20 59))
		(Load rsSOUND (proc0_20 65))
		(Load rsSOUND (proc0_20 25))
		(super init:)
		(SetMenu 1283 112 0)
		(self setRegions: 146) ; aqueduct
		(= global112 2)
		(switch gPrevRoomNum
			(41
				(gEgo view: 41 init:)
				(gRmMusic number: (proc0_20 59) loop: -1 priority: 1 play:)
				(self enterRoom: 320 120 290 120)
			)
			(else
				(gEgo view: 75)
				(self setScript: fallIn)
				(SetFlag 106)
			)
		)
		(proc0_13 80)
		(gAddToPics doit:)
		(topDrip ignoreActors: 1 init:)
		(botDrip ignoreActors: 1 init:)
		(ripple ignoreActors: 1 setPri: 0 init: cycleSpeed: 3 setCycle: Fwd)
	)

	(method (doit)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((== (gRmMusic prevSignal:) 10)
					(gRmMusic prevSignal: 0)
					(= local14
						(if (== global61 0)
							(Random 0 8)
						else
							(Random 0 10)
						)
					)
					(if
						(and
							(not
								(<
									(- (gEgo x:) 25)
									local14
									(+ (gEgo x:) 25)
								)
							)
							(!= global61 3)
						)
						(topDrip setScript: doTheDrip)
					)
				)
				(local2
					(= local2 0)
					(if (IsFlag 327)
						(Print 50 0 #at -1 110) ; "I hope you will pay more attention to Fatima's warnings when you return to pass her Test, as you must yet do."
					else
						(Print 50 1) ; "By my beard! This is a cold lesson to learn. Next time, you must deal more carefully with Fatima before you attempt to leave."
					)
					(HandsOn)
				)
				((and (== local1 3) (not local0) (< (gEgo x:) 280))
					(= local0 1)
					(gEgo setScript: heDies)
				)
				((and (< (gEgo x:) 10) (not local0))
					(= local0 1)
					(self setScript: deeperIn)
				)
				((and (> (gEgo x:) 310) (not local0))
					(if (== local1 0)
						(= global61 0)
						(self leaveRoom: 41 320 (gEgo y:))
						(gRmMusic stop:)
					else
						(= local0 1)
						(self setScript: comingOut)
					)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'look<down')
				(if (== local1 3)
					(Print 50 2) ; "It is too dark to see anything."
				else
					(Print 50 3) ; "The water is dark, but not deep."
				)
			)
			((Said 'look<up')
				(if (> local1 0)
					(Print 50 4) ; "It is too dark to see anything above you."
				else
					(Print 50 5) ; "Above you it is solid rock."
				)
			)
			((Said 'draw/blade')
				(Print 50 6) ; "I see nothing dangerous in here other than the dark."
			)
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/tunnel,cave,aquaduct')
							(Said '//tunnel,cave,aquaduct')
						)
						(switch local1
							(0
								(Print 50 7) ; "The tunnel is small and carved from solid rock, as you can see in the light reflected from the tunnel's mouth."
							)
							(1
								(Print 50 8) ; "The light of the entrance is but a distant point that can barely illuminate this gloom."
							)
							(2
								(Print 50 9) ; "The tunnel is quite dark here. If you go any further into it, it will be pitch black and dangerous to stumble about in."
							)
							(3
								(Print 50 10) ; "You cannot see a thing, and you are stumbling dangerously on the roughly hewn rock."
							)
						)
					)
					((== local1 3)
						(if (or (Said '/*') (Said '//*') (Said '<*'))
							(Print 50 11) ; "It is pitch black here."
						)
					)
					((or (Said '/water') (Said '//water'))
						(Print 50 12) ; "It is pure and cold, flowing through this aqueduct from the Spring of Gihon."
					)
					((or (Said '/wall,boulder') (Said '//wall,boulder'))
						(Print 50 13) ; "The walls of the tunnel are carved from solid rock."
					)
				)
			)
			((== local1 3)
				(if (Said '*')
					(Print 50 14) ; "It is too dark to think of doing anything."
				)
			)
			((Said 'drip')
				(= local14 (Random 0 10))
				(topDrip setScript: doTheDrip)
			)
			((Said 'climb')
				(if (== global61 0)
					(Print 50 15) ; "The tunnel walls offer no grip and the way back up to Fatima is nearly vertical."
				else
					(Print 50 16) ; "You are in a tunnel carved of rock. There is nothing to climb."
				)
			)
			((Said 'draw/blade')
				(= global125 0)
				(event claimed: 1)
			)
			((or (Said 'look,get,find/ass') (Said 'ask[/merlin]/ass'))
				(if (IsFlag 106)
					(Print 50 17) ; "Mohammed has your mule."
				else
					(Print 50 18) ; "Your mule prudently waits for you at the Pool of Siloam."
				)
			)
			((or (Said 'drink[/water]') (Said 'get/drink'))
				(if (== local1 3)
					(gEgo setScript: heDies)
				else
					(gEgo setScript: (ScriptID 146 1)) ; drink
				)
			)
			((or (Said 'are<where/pool') (Said 'get,ask[/merlin]/direction'))
				(Print 50 19) ; "That is simple. The further into the tunnel you go, the darker it will get."
			)
		)
	)
)

(instance fallIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					posn: 275 0
					setLoop: 0
					init:
					yStep: 9
					cycleSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 240 59 self
				)
			)
			(1
				(gRegMusic stop:)
				(gEgo yStep: 13 setMotion: MoveTo 227 123 self)
			)
			(2
				(gSFX number: (proc0_20 65) priority: 3 loop: 1 play:)
				(gEgo
					yStep: 2
					setLoop: 1
					cel: 0
					x: (+ (gEgo x:) 2)
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 2 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(gRmMusic number: (proc0_20 59) loop: -1 priority: 1 play:)
				(gEgo setLoop: 3 cel: 0 cycleSpeed: 1 setCycle: End)
				(= cycles 18)
			)
			(5
				(Print 50 20) ; "After a long and dizzying slide you have landed in the cold waters of Hezekiah's Aqueduct."
				(gEgo
					setLoop: 4
					cel: 0
					posn: (+ (gEgo x:) 3) (+ (gEgo y:) 2)
					setCycle: End self
				)
			)
			(6
				(gEgo
					view: 41
					setLoop: 2
					cel: 0
					posn: (- (gEgo x:) 2) (- (gEgo y:) 5)
				)
				(= cycles 1)
			)
			(7
				(gEgo
					illegalBits: -32768
					setLoop: -1
					cycleSpeed: 0
					setCycle: Walk
				)
				(= local2 1)
				(client comingIn: 0 setScript: 0)
			)
		)
	)
)

(instance deeperIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -10 (gEgo y:) self)
			)
			(1
				(= global61 (+ (++ local1) 1))
				(ripple hide:)
				(topDrip setCycle: 0 x: 1000 cel: 0 setScript: 0)
				(botDrip setCycle: 0 x: 1000 cel: 0)
				(gCurRoom style: 2 drawPic: (if (== local1 3) 112 else 50))
				(if (== local1 3)
					(gEgo hide:)
					(topDrip hide:)
					(botDrip hide:)
					(MenuBar state: 0)
				else
					(proc0_13 80)
					(gAddToPics doit:)
				)
				(= cycles 1)
			)
			(2
				(gEgo posn: 320 120 setMotion: MoveTo 290 120 self)
			)
			(3
				(if (== local1 3)
					(= seconds 2)
				else
					(HandsOn)
					(= local0 0)
					(client setScript: 0)
				)
			)
			(4
				(Print 50 21) ; "It is now pitch black, deep inside the aqueduct. You are stumbling about dangerously on the roughly hewn floor."
				(HandsOn)
				(= local0 0)
				(client setScript: 0)
			)
		)
	)
)

(instance comingOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 325 (gEgo y:) self)
			)
			(1
				(= global61 (+ (-- local1) 1))
				(topDrip setCycle: 0 x: 1000 cel: 0 setScript: 0)
				(botDrip setCycle: 0 x: 1000 cel: 0)
				(gCurRoom style: 3 drawPic: 50)
				(proc0_13 80)
				(gAddToPics doit:)
				(= cycles 1)
			)
			(2
				(if (== local1 2)
					(topDrip show:)
					(botDrip show:)
					(MenuBar state: 1)
				)
				(if (== local1 0)
					(ripple show:)
				)
				(gEgo show: posn: -10 120 setMotion: MoveTo 25 120 self)
			)
			(3
				(HandsOn)
				(= local0 0)
				(client setScript: 0)
			)
		)
	)
)

(instance heDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gRmMusic stop:)
				(gSFX number: (proc0_20 25) priority: 3 loop: 1 play:)
				(Print 50 22 #dispose) ; "Arthur! What was that sound?"
				(= seconds 3)
			)
			(1
				(clr)
				(gSFX number: (proc0_20 65) priority: 3 loop: 1 play:)
				(= seconds 3)
			)
			(2
				(EgoDead 50 23) ; "Ah. As I feared. You have struck your head upon a low spot in the tunnel, knocked yourself out, fallen forward into the water and drowned. Not a very glorious end for the King of all the Britons."
			)
		)
	)
)

(instance doTheDrip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(topDrip x: [local3 local14] setCycle: CT 6 1 self)
			)
			(1
				(topDrip setCycle: End)
				(botDrip
					x: [local3 local14]
					loop: (if (< global61 2) 1 else 2)
					setCycle: End self
				)
			)
			(2
				(topDrip cel: 0)
				(botDrip cel: 0)
				(client setScript: 0)
			)
		)
	)
)

