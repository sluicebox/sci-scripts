;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room48 0
)

(local
	local0
	[local1 3]
	local4
	local5
)

(instance Room48 of Rm
	(properties
		picture 48
		style 16
	)

	(method (init)
		(super init:)
		(Load rsVIEW 501)
		(Load rsVIEW 2)
		(Load rsVIEW 647)
		(Load rsVIEW 245)
		(Load rsVIEW 48)
		(ogressChaseMusic init:)
		(ogressCatchMusic init:)
		(switch gPrevRoomNum
			(49
				(NormalEgo 0)
				(gEgo posn: 130 124 view: 2 loop: 0 setStep: 2 1 init:)
			)
			(else
				(NormalEgo 0)
				(gEgo posn: 135 135 view: 2 loop: 0 setStep: 2 1 init:)
			)
		)
		(self setRegions: 602) ; regOgreHouse
		(if gNight
			((View new:) view: 647 loop: 0 posn: 158 94 addToPic:)
			((View new:) view: 647 loop: 1 posn: 263 97 addToPic:)
			((Prop new:)
				view: 501
				loop: 1
				posn: 221 141
				setPri: 15
				init:
				setCycle: Fwd
			)
			((Prop new:)
				view: 501
				loop: 1
				posn: 101 141
				setPri: 15
				init:
				setCycle: Fwd
			)
		else
			((View new:)
				view: 501
				loop: 0
				cel: 2
				posn: 221 141
				setPri: 15
				ignoreActors: 1
				addToPic:
			)
			((View new:)
				view: 501
				loop: 0
				cel: 2
				posn: 101 141
				setPri: 15
				ignoreActors: 1
				addToPic:
			)
		)
		((View new:)
			view: 501
			loop: 0
			cel: 1
			posn: 267 129
			setPri: 11
			ignoreActors: 1
			addToPic:
		)
		(if (== ((gInventory at: 16) owner:) 48) ; Axe
			((= local0 (Prop new:))
				view: 501
				loop: 0
				cel: 0
				posn: 243 125
				init:
				stopUpd:
			)
		)
		((= local4 (Act new:)) setScript: ogressChase)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 49)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose 192)
		(ogressChaseMusic keep: 0)
		(ogressCatchMusic keep: 0)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '<under/bed')
							(Print 48 0) ; "There is nothing under the bed."
						)
						((Said '/bed')
							(Print 48 1) ; "The large bed occupies most of the room."
						)
						((Said '<in/chest,dresser,drawer')
							(Print 48 2) ; "No. It's private."
						)
						((Said '/chest,dresser,drawer')
							(Print 48 3) ; "It must hold the ogre's and ogress' clothes."
						)
						((Said '/carpet')
							(Print 48 4) ; "A bear rug lies on the floor by the bed."
						)
						((Said '/window')
							(if
								(or
									(gEgo inRect: 143 119 178 126)
									(gEgo inRect: 232 126 275 132)
								)
								(Print 48 5) ; "You see the forest out the window."
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((Said '/stair')
							(Print 48 6) ; "The stairs lead downward."
						)
						((Said '/barrel')
							(Print 48 7) ; "There is nothing of importance in the barrel."
						)
						((Said '/mirror')
							(if (gEgo inRect: 201 143 282 170)
								(Print 48 8) ; "You look in the mirror and see the reflection of a poor, but beautiful, peasant girl."
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((Said '/door')
							(if (== ((gInventory at: 33) owner:) 48) ; Magic_Hen
								(Print 48 9) ; "The door is closed. From behind it, you hear a soft clucking sound."
							else
								(Print 48 10) ; "You see a solid, wooden door."
							)
						)
						((Said '/wall')
							(Print 48 11) ; "There is nothing of importance on the walls."
						)
						((or (Said '/dirt') (Said '<down'))
							(Print 48 12) ; "There is nothing of interest on the floor."
						)
						((Said '[<around,at][/room,bedroom,cottage]')
							(Print
								(Format ; "You have entered the ogres' upstairs bedroom where a huge bed dominates the place. In the left wall, you notice a closed door. %s"
									@global300
									48
									13
									(if (== ((gInventory at: 16) owner:) 48) ; Axe
										{Against the right wall, leans the ogre's axe.}
									else
										{}
									)
								)
							)
						)
					)
				)
				((Said 'get/ax')
					(if (== ((gInventory at: 16) owner:) 48) ; Axe
						(if (< (gEgo distanceTo: local0) 20)
							(gEgo get: 16) ; Axe
							(= global182 1)
							(gGame changeScore: 2)
							(local0 dispose:)
						else
							(Print 800 1) ; "You're not close enough."
						)
					else
						(Print 48 14) ; "You already have it."
					)
				)
				(
					(or
						(Said 'sleep')
						(Said '(lay[<in,on,down]),(get[<in,in])[/bed]')
					)
					(Print 48 15) ; "You don't have time for that!"
				)
				((Said 'open/chest,dresser,drawer')
					(Print 48 2) ; "No. It's private."
				)
				((Said 'open/window')
					(if
						(or
							(gEgo inRect: 143 119 178 126)
							(gEgo inRect: 232 126 275 132)
						)
						(Print 48 16) ; "The windows don't open."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'open/door')
					(if (gEgo inRect: 25 137 60 154)
						(Print 48 17) ; "You can't. The door is locked."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'unlatch/door')
					(if (gEgo inRect: 25 137 60 154)
						(Print 48 18) ; "You can't. It's locked and you don't have the key."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'break/door')
					(if (gEgo inRect: 25 137 60 154)
						(Print 48 19) ; "You could never do that."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'bang/door')
					(if (gEgo inRect: 25 137 60 154)
						(if (== ((gInventory at: 33) owner:) 48) ; Magic_Hen
							(Print 48 20) ; "You knock on the door, but receive no answer. You hear a soft, clucking from behind the door."
						else
							(Print 48 21) ; "You knock on the door, but receive no answer."
						)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
			)
			(if (and (not (event claimed:)) (> (ogressChase state:) 0))
				(cond
					((Said 'look/giantess')
						(Print 48 22) ; "You don't want to mess with this ogress. You'd better get out of here!"
					)
					((Said 'talk[/giantess]')
						(Print 48 23) ; "This is no time for conversation!"
					)
					((Said 'kill[/giantess]')
						(Print 48 24) ; "You have no way of killing a giant ogress!"
					)
					((Said 'get,capture/giantess')
						(Print 48 25) ; "That's ridiculous!"
					)
					((Said 'give')
						(Print 48 26) ; "You don't want to get that close to the ogress!"
					)
				)
			)
		)
	)
)

(instance ogressChase of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 245
					posn: 0 0
					illegalBits: 0
					ignoreActors: 1
					setPri: 8
					setCycle: Walk
					init:
					hide:
				)
				(if (!= gDebugOn 0)
					(= seconds 10)
				else
					(= seconds 60)
				)
			)
			(1
				(= local5 10)
				(= global204 1)
				(User canInput: 0)
				(playMusic cue:)
				(client
					posn: 64 139
					show:
					setAvoider: Avoid
					setMotion: MoveTo 135 123 self
				)
			)
			(2
				(if (and (< (gEgo x:) 135) (> (gEgo y:) 128))
					(local4 setAvoider: Avoid setMotion: MoveTo 145 135 self)
				else
					(self cue:)
				)
			)
			(3
				(Print 48 27) ; "The ogress sees you! You'd better run as she'd like to have YOU for dinner!"
				(client
					illegalBits: $8000
					setPri: -1
					setAvoider: Avoid
					setMotion: Chase gEgo 15 self
				)
			)
			(4
				(HandsOff)
				(= local5 11)
				(playMusic cue:)
				(gEgo hide:)
				(gEgo hide:)
				(client view: 48 cycleSpeed: 2 cel: 0 setCycle: End self)
			)
			(5
				(Print 48 28 #at -1 20) ; "Poor Rosella! Looks like you'll join the deer in the stew pot tonight."
				(= seconds 4)
			)
			(6
				(= gDeathFlag 1)
			)
		)
	)
)

(instance ogressChaseMusic of Sound
	(properties
		number 10
		keep 1
	)
)

(instance ogressCatchMusic of Sound
	(properties
		number 11
		keep 1
	)
)

(instance playMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local5
					(10
						(ogressChaseMusic loop: 1 play: self)
					)
					(11
						(ogressCatchMusic loop: 1 play: self)
					)
				)
			)
			(1
				(if (!= local5 11)
					(= state -1)
					(self cue:)
				)
			)
		)
	)
)

