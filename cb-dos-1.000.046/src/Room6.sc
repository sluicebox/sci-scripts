;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Interface)
(use Wander)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room6 0
)

(local
	local0
	local1
)

(instance Room6 of Rm
	(properties
		picture 6
	)

	(method (init)
		(= south 18)
		(= west 12)
		(= east 7)
		(super init:)
		(if (and (not (& gMustDos $0001)) (== gAct 5))
			(Load rsFONT 41)
			(Load rsVIEW 642)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
		)
		(if gDetailLevel
			(chick1
				illegalBits: 4
				ignoreActors: 1
				moveSpeed: 2
				setMotion: Wander 1
				setPri: 7
				init:
			)
			(chick2
				illegalBits: 4
				ignoreActors: 1
				moveSpeed: 2
				setMotion: Wander 1
				setPri: 7
				init:
			)
		else
			(chick1 illegalBits: 4 ignoreActors: 1 setPri: 7 init: stopUpd:)
			(chick2 illegalBits: 4 ignoreActors: 1 setPri: 7 init: stopUpd:)
		)
		(gAddToPics add: coop eachElementDo: #init doit:)
		(Door cel: (if (== gPrevRoomNum 59) 3 else 0) init: stopUpd:)
		(= global373 Door)
		(LoadMany rsSOUND 43 44 48)
		(Load rsVIEW 56)
		(self setFeatures: coop Window1 Window2)
		(if (>= gAct 2)
			(light1 init: stopUpd:)
			(light2 init: stopUpd:)
		)
		(if (and (== gAct 3) (not (== gPrevRoomNum 59)))
			(self setRegions: 266) ; celirock
		else
			(Chair init: stopUpd:)
			(Celie view: 480)
		)
		(if (and (== gAct 3) (< gJeevesChoresState 2))
			(self setRegions: 203) ; clarwand
		)
		(switch gPrevRoomNum
			(7
				(gEgo posn: 310 151)
			)
			(12
				(gEgo posn: 1 182)
			)
			(59
				(gEgo posn: 238 101)
				(Door setScript: closeDoor)
			)
			(18
				(gEgo posn: 148 185)
			)
		)
		(gEgo illegalBits: -32768 view: 0 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 6 0) ; "There is a poor, but clean, shack here at the edge of the old sugar cane fields. Nearby, you see a small chicken coop."
		)
		(if (& (gEgo onControl: 0) $4000)
			(gEgo setPri: 6)
		else
			(gEgo setPri: -1)
		)
		(super doit:)
		(if (and (== global191 1) (not local0))
			(= local0 1)
			(Door show:)
		)
	)

	(method (dispose)
		(DisposeScript 976)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 59)
			(gConMusic stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
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
					(return)
				)
			)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 6 0) ; "There is a poor, but clean, shack here at the edge of the old sugar cane fields. Nearby, you see a small chicken coop."
						)
						((Said '/field')
							(Print 6 1) ; "Behind a weather-beaten fence, you see the old, unused sugar cane fields. The fields look as if they haven't been planted in years."
						)
						((Said '/fence')
							(Print 6 2) ; "An old, weather-beaten fence partitions off the remaining vestiges of the plantation's once-vast sugar cane fields. Now, all that's left are long-ago plowed furrows and old dead stalks."
						)
						((Said '/archway')
							(Print 6 3) ; "You don't see a gate here."
						)
						((Said '/path')
							(Print 6 4) ; "The path leads to a small shack."
						)
						((Said '/cabin')
							(Print 6 5) ; "In spite of its poor condition, the shack looks homey enough."
						)
						((Said '/gallery')
							(if (== gAct 3)
								(Print 6 6) ; "You see Celie rocking on her porch on this warm May night."
							else
								(Print 6 7) ; "Celie's old rocking chair waits for her on the little porch."
							)
						)
					)
				)
				((Said 'bang[/door]')
					(cond
						((and (== gAct 3) (not (== gPrevRoomNum 59)))
							(Print 6 8) ; "There's no need to do that; she's right here!"
						)
						((& (gEgo onControl: 0) $0010)
							(if (not local1)
								(= local1 1)
								(gEgo setScript: knockDoor)
							)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
				((Said 'climb/fence')
					(Print 6 9) ; "The fence is too difficult to climb. Besides, you don't care about those old fields."
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance firstGreet of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				(
					(or
						(Said 'show,give/necklace[/celie]')
						(Said 'show,give/necklace<celie')
					)
					(if (gEgo has: 0) ; necklace
						(if (== state 2)
							(= state 4)
							(= cycles 1)
						else
							(Print 6 10) ; "There is nobody here."
						)
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said '*')
					(event claimed: 1)
					(= seconds 0)
					(= cycles 1)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(= global195 2)
				(Print 6 11) ; "Jest a secon'."
				(= seconds 4)
			)
			(1
				(Celie setPri: 4 loop: 2 posn: 239 93 init:)
				(Door setCycle: End self)
				(myMusic number: 43 loop: 1 play:)
			)
			(2
				(User canInput: 1)
				(Print 6 12) ; "Whut you want, Missy?!"
				(= seconds 8)
			)
			(3
				(HandsOff)
				(Print 6 13) ; "I ain't got time fer you right now, Missy. 'Scuse me."
				(Door setCycle: Beg self)
				(myMusic number: 44 loop: 1 play:)
			)
			(4
				(User canControl: 1 canInput: 1)
				(= local1 0)
				(Celie dispose:)
				(client setScript: 0)
			)
			(5
				(Print 6 14) ; "My necklace! I wuz wunderin' where it got to! Well, Missy Laura, why don' you come in an' visit wid me awhile?"
				(gEgo put: 0) ; necklace
				(= global135 1)
				(gCurRoom newRoom: 59)
			)
		)
	)
)

(instance secondGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global195 2)
				(Celie setPri: 4 loop: 2 posn: 239 90 init:)
				(Door setCycle: End self)
				(myMusic number: 43 loop: 1 play:)
			)
			(1
				(Print 6 15) ; "Nice ta see you agin, Missy Laura. Won'cha come in?"
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: 59)
			)
		)
	)
)

(instance lastGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (& gMustDos $0001))
						(|= gMustDos $0001)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(HandsOff)
				(= global195 2)
				(Celie setPri: 4 loop: 2 ignoreActors: 1 posn: 239 90 init:)
				(Door setCycle: End self)
				(myMusic number: 43 loop: 1 play:)
			)
			(2
				(Print 6 16) ; "What you doin' here, girl?! Can't you feel the evil in the air?! There's somethin' real bad 'round here and I'm stayin' put in mah cabin behind locked doors. You git yourse'f on back to your room, hear?!"
				(= cycles 1)
			)
			(3
				(Door setCycle: Beg self)
				(myMusic number: 44 loop: 1 play:)
			)
			(4
				(HandsOn)
				(Door stopUpd:)
				(Celie stopUpd:)
				(= local1 (= global195 0))
				(client setScript: 0)
			)
		)
	)
)

(instance knockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 56 loop: 0 illegalBits: 0 setCycle: End self)
			)
			(1
				(myMusic number: 48 loop: 1 play:)
				(gEgo loop: 2 setCycle: Fwd)
				(= cycles 6)
			)
			(2
				(cls)
				(gEgo view: 56 loop: 0 cel: 3 setCycle: Beg self)
			)
			(3
				(HandsOn)
				(gEgo view: 0 setCycle: Walk illegalBits: -32768 loop: 3)
				(cond
					((and (>= gAct 2) (!= gAct 3) (< gAct 6))
						(cond
							((== gAct 5)
								(if (& global135 $0100)
									(Print 6 17) ; "Go away!! I'm not unlockin' this here door anymore!"
									(= local1 0)
								else
									(|= global135 $0100)
									(Room6 setScript: lastGreet)
								)
							)
							((== global135 1)
								(Room6 setScript: secondGreet)
							)
							(else
								(Room6 setScript: firstGreet)
							)
						)
					)
					((== gAct 7)
						(switch (Random 0 5)
							(0
								(Print 6 18) ; "Go 'way!! I ain't openin' this door!"
							)
							(1
								(Print 6 19) ; "Leave me 'lone!!"
							)
							(2
								(Print 6 20) ; "Get 'way from my door!! I ain't comin' near it!"
							)
							(3
								(Print 6 21) ; "Please!! Leave me outta this!"
							)
							(4
								(Print 6 22) ; "I ain't unlockin' this here door!!"
							)
							(5
								(Print 6 23) ; "Go 'way!!"
							)
						)
						(= local1 0)
					)
					(else
						(= local1 0)
						(Print 6 24) ; "You cautiously knock at the door of the old shack but receive no answer."
					)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 93
		x 227
		view 106
		priority 5
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'break,force/door')
				(Print 6 25) ; "This is not your house!"
			)
			((or (MousedOn self event 3) (Said 'look/door'))
				(event claimed: 1)
				(Print 6 26) ; "It's just a plain, wooden door."
			)
			((Said 'open/door')
				(if (gEgo inRect: 221 92 259 108)
					(if (and (>= gAct 2) (< gAct 6))
						(Print 6 27) ; "It's not nice to enter people's houses without being invited."
					else
						(Print 6 28) ; "You try opening the door, but discover it's locked."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance light1 of Prop
	(properties
		y 64
		x 198
		view 106
		loop 1
		cel 1
	)
)

(instance light2 of Prop
	(properties
		y 67
		x 283
		view 106
		loop 1
		cel 1
	)
)

(instance Chair of Prop
	(properties
		y 108
		x 270
		view 106
		loop 3
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'get/rocker,chair[<rocking]')
				(Print 6 29) ; "You can't get that."
			)
			((Said 'boulder,sit[/chair,rocker]')
				(if (and (== gAct 3) (!= gPrevRoomNum 59))
					(Print 6 30) ; "The rocking chair is already occupied!"
				else
					(Print 6 31) ; "You don't feel like sitting around."
				)
			)
			((or (Said 'look/rocker,chair[<rocking]') (MousedOn self event 3))
				(event claimed: 1)
				(if (== gAct 3)
					(Print 6 32) ; "Celie is sitting on her rocking chair enjoying the night air."
				else
					(Print 6 7) ; "Celie's old rocking chair waits for her on the little porch."
				)
			)
		)
	)
)

(instance chick1 of Act
	(properties
		y 106
		x 81
		view 259
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((or (MousedOn self event 3) (Said 'look/chicken'))
				(Print 6 33) ; "The two chickens scratch and peck within their chicken coop."
				(event claimed: 1)
			)
			(
				(or
					(Said 'feed,give/chicken')
					(Said 'feed,give/*/chicken')
					(Said 'feed,give/*<chicken')
				)
				(if global219
					(if global224
						(Print 6 34) ; "Celie has already fed the chickens."
					else
						(DontHave) ; "You don't have it."
					)
				else
					(Print 6 34) ; "Celie has already fed the chickens."
				)
			)
			((or (Said 'capture,get,detach/chicken') (Said 'open/coop'))
				(Print 6 35) ; "The chickens belong to Celie. Leave them alone."
			)
			((Said 'talk/chicken')
				(Print 6 36) ; "This isn't King's Quest III!"
			)
		)
	)
)

(instance chick2 of Act
	(properties
		y 102
		x 94
		view 259
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (MousedOn self event 3)
			(Print 6 33) ; "The two chickens scratch and peck within their chicken coop."
			(event claimed: 1)
		)
	)
)

(instance Celie of Prop
	(properties)
)

(instance coop of RPicView
	(properties
		y 126
		x 90
		view 106
		loop 2
		priority 8
		signal 16384
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'look<(below,behind)/(coop[<chicken]),(cabin<chicken)')
				(Print 6 37) ; "You see nothing there."
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/(coop[<chicken]),(cabin<chicken)')
				)
				(Print 6 38) ; "Through the rusted wire of the coop, you can see the feathered forms of the two chickens that Celie keeps."
				(event claimed: 1)
			)
		)
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 45
		nsLeft 183
		nsBottom 66
		nsRight 213
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'break/window')
				(Print 6 39) ; "That's not a nice thing to do!"
			)
			((Said 'look<(in,through)/window,(cabin[<celie])')
				(if
					(or
						(gEgo inRect: 179 92 221 103)
						(gEgo inRect: 259 95 305 108)
					)
					(Print 6 40) ; "You peek through the window, but can't make out any details."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'open/window')
				(Print 6 41) ; "The windows don't open."
			)
			((or (MousedOn self event 3) (Said 'look/window'))
				(event claimed: 1)
				(Print 6 42) ; "Two windows flank the front door."
			)
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 46
		nsLeft 266
		nsBottom 68
		nsRight 297
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 6 42) ; "Two windows flank the front door."
		)
	)
)

(instance myMusic of Sound
	(properties)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Door setCycle: Beg self)
				(myMusic number: 44 loop: 1 play:)
			)
			(1
				(Door stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

