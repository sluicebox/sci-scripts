;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Door)
(use airplaneScript)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm53 0
)

(local
	work
)

(instance theSound of Sound
	(properties
		number 5
		loop -1
	)
)

(instance rm53 of Rm
	(properties
		picture 53
		horizon 5
		east 54
		west 52
	)

	(method (init)
		(Load rsVIEW 513)
		(Load rsVIEW 514)
		(Load rsVIEW 511)
		(super init:)
		(gAddToPics add: aAd aPlant aPainting doit:)
		(aConveyor4 cycleSpeed: 1 setPri: 3 setCycle: Fwd isExtra: 1 init:)
		(aConveyor3 cycleSpeed: 1 setPri: 4 setCycle: Fwd isExtra: 1 init:)
		(aConveyor2 cycleSpeed: 1 setPri: 4 setCycle: Fwd isExtra: 1 init:)
		(aConveyor1 cycleSpeed: 1 setCycle: Fwd setPri: 10 isExtra: 1 init:)
		(aAgentNear setPri: 10 stopUpd: init:)
		(aAgentFar setPri: 1 stopUpd: init:)
		(aTraveler setStep: 1 1 setPri: 2 illegalBits: 0 init: hide:)
		(aPlane startX: 208 startY: 23 endX: 1 endY: 23 init:)
		(cond
			((== gPrevRoomNum 54)
				(gEgo posn: 316 153)
			)
			((== gPrevRoomNum 52)
				(gEgo posn: 51 119)
			)
			(else
				(gEgo posn: 51 119)
			)
		)
		(self setRegions: 500 setScript: rm53Script) ; rm500
		(if (!= gBombStatus 1)
			(NormalEgo)
		else
			(Load rsSOUND 5)
			(theSound play:)
			(HandsOff)
			(= gCurrentStatus 7)
			(rm53Script changeState: 9)
		)
		(gEgo init:)
		(aDoor
			setPri: 11
			roomCtrl: 0
			locked: (if (== gPrevRoomNum 54) 0 else 1)
			msgLook:
				{There is a barely perceptible, blue gate in the east wall under that painting.}
			msgLookLock:
				{The gate is controlled by the Customs Official standing behind the counter.}
			msgLocked:
				{The gate is locked. Try talking to the friendly looking gentleman behind the counter.}
			msgExcept: {...except it's locked!}
			msgFunny: {Most people never knock on a gate!}
			msgCloser:
				{When the man releases the gate, it opens just by walking near it.}
			init:
		)
	)

	(procedure (localproc_0) ; UNUSED
		(DisposeScript travelerScript)
		(super dispose:)
	)

	(method (dispose)
		(DisposeScript 992)
		(super dispose:)
	)
)

(instance rm53Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 1) $0004)
			(gCurRoom newRoom: 52)
		)
	)

	(method (handleEvent event &tmp obj)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'give,look,throw,drop,drop>')
			(cond
				(
					(or
						(not (= obj (gInventory saidMe:)))
						(not (gEgo has: (gInventory indexOf: obj)))
					)
					(event claimed: 0)
				)
				((not (gEgo inRect: 171 143 198 149))
					(NotClose) ; "You're not close enough."
				)
				((== (gInventory indexOf: obj) 17)
					(Print 53 0) ; "You'd better not let him see that!"
				)
				((!= (gInventory indexOf: obj) 7)
					(Print 53 1) ; "That won't help you with this guy."
				)
				((== gCurrentEgoView 149)
					(Print 53 2) ; "Here ya go, buddy," you tell him, "but remember: this picture was taken before my recent hair rejuvenation."
					(Print 53 3) ; "I'm sorry, Senor," he responds, "but this is not your passport. I'm afraid I cannot allow you to pass this point."
				)
				((not gSeenCustomsJoke)
					(= gSeenCustomsJoke 1)
					(gGame changeScore: 5)
					(self changeState: 1)
				)
				(else
					(if (gEgo has: 17) ; Knife
						(Print 53 4) ; "You again?! Did you get rid of that knife?"
						(Print 53 5) ; ""Of course, would I lie to you?" you say unabashed."
						(Print (Format @gString 53 6 gTritePhrase)) ; "Ok, I've seen enough of your stuff! Go on through, but please remember: %s"
					else
						(Print (Format @gString 53 7 gTritePhrase)) ; "You again?! I've seen enough of your stuff! Just go on through; and remember: %s"
					)
					(aDoor locked: 0)
				)
			)
		)
		(if (Said 'look>')
			(if (Said '/man,agent')
				(Print 53 8) ; "A gentleman with a pleasant appearance and friendly smile waits by the only open Customs Inspection counter."
			)
			(if (Said '/art')
				(Print 53 9) ; "Those damned dancin' raisins are EVERYWHERE!"
			)
			(if (Said '/belt,open,hole')
				(Print 53 10) ; "The conveyor belts disappear through the wall to the next room, where they are thoroughly inspected by sharp-eyed Customs Agents."
			)
			(if (Said '[/airport,building,belt]')
				(Print 53 11) ; "For such a small airport, they certainly have an impressive Customs Inspection station."
				(Print 53 12) ; "There is a barely perceptible gate in the far wall."
			)
		)
		(if
			(or
				(Said '(crawl<in),board/open,hole,belt')
				(Said 'apply,(climb<on),board/belt')
			)
			(Print 53 13) ; "You can't. The conveyor belts are for luggage only!"
		)
		(if (Said '/bathing')
			(Print 53 14) ; "The rope is firmly affixed, and won't help you get by here."
		)
		(if (Said 'open/door,door')
			(Print 53 15) ; "You can't. It's controlled by the Customs Agent behind the counter."
		)
		(if (Said 'talk/man,agent')
			(Print (Format @gString 53 16 gLaffer)) ; ""Good day, Senor," you say to the man. %s"
			(Print 53 17) ; "Good day, Sir," he replies in like fashion. "May I please see your passport?"
		)
	)

	(method (changeState newState &tmp i theObj)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo setLoop: 3)
				(Print 53 18) ; "You hand the agent your passport."
				(= seconds 3)
			)
			(2
				(aAgentNear setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(aAgentNear setCel: 0)
				(Print 53 19 #draw) ; "This picture is an excellent likeness," says the Customs Agent. "It must be printed on photographic paper by Kodork!"
				(= seconds 3)
			)
			(4
				(aAgentNear setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(aAgentNear setCel: 0)
				(Print 53 20 #draw) ; "Now, I must inspect your possessions," he says. "Please show me everything you are carrying."
				(= seconds 3)
			)
			(6
				(Print 53 21) ; "Well, ok, I guess," you reply, "although this is highly unusual in an adventure game..."
				(for
					((= i (gInventory first:)))
					i
					((= i (gInventory next: i)))
					
					(= theObj (NodeValue i))
					(if (theObj ownedBy: gEgo)
						(theObj showSelf:)
					)
				)
				(Print 53 22) ; ""There. Are you satisfied?" you ask."
				(= seconds 3)
			)
			(7
				(aAgentNear setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(User canControl: 1 canInput: 1)
				(aAgentNear setCel: 0 stopUpd:)
				(gEgo setLoop: -1)
				(if (gEgo has: 17) ; Knife
					(Print 53 23) ; "Yes, but I must warn you about carrying that knife on board any aircraft."
					(Print 53 24) ; "Ok," you lie. "You have my word on it!"
				)
				(Print 53 25 #draw) ; "All right," he says, unlocking the gate in the east wall, "you may pass."
				(Print 53 26) ; "Hey, thanks a lot, buddy," you say, peeling a hundred off your wad of bills, "and here's a little something for you and the missus!"
				(Print (Format @gString 53 27 gTritePhrase)) ; "I'm not your buddy, you ugly Americano. %s"
				(aDoor locked: 0)
			)
			(9
				(gEgo setStep: 4 3 setLoop: 1 setMotion: MoveTo 222 154 self)
			)
			(10
				(Print 53 28) ; ""LOOK OUT, I'VE GOT A BOMB!!!" you shout."
				(gEgo setMotion: MoveTo 157 150 self)
			)
			(11
				(Print (Format @gString 53 29 gTritePhrase)) ; "Of course, the agent casually replies, "%s""
				(gEgo setMotion: MoveTo 43 127 self)
			)
		)
	)
)

(instance travelerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(aTraveler
					posn: 128 36
					show:
					setCycle: Walk
					setMotion: MoveTo 182 37 self
				)
			)
			(2
				(aTraveler
					setLoop: (+ (aTraveler loop:) 1)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(aAgentFar setCycle: End self)
			)
			(4
				(aAgentFar setLoop: 2 setCycle: Fwd)
				(= seconds 10)
			)
			(5
				(aAgentFar setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(6
				(aAgentFar stopUpd:)
				(aTraveler setCycle: Beg self)
			)
			(7
				(aTraveler
					setLoop: (- (aTraveler loop:) 1)
					setCycle: Walk
					setMotion: MoveTo 203 37 self
				)
			)
			(8
				(aTraveler setLoop: (if (== (aTraveler loop:) 3) 5 else 3))
				(self changeState: 0)
			)
		)
	)
)

(instance aAd of PV
	(properties
		y 157
		x 25
		view 513
		loop 1
		priority 12
	)
)

(instance aPlant of PV
	(properties
		y 57
		x 73
		view 513
		loop 1
		cel 1
		priority 10
	)
)

(instance aPainting of PV
	(properties
		y 117
		x 301
		view 513
		loop 6
		priority 11
	)
)

(instance aConveyor4 of Prop
	(properties
		y 59
		x 198
		view 513
		loop 5
	)
)

(instance aConveyor3 of Prop
	(properties
		y 69
		x 206
		view 513
		loop 4
	)
)

(instance aConveyor2 of Prop
	(properties
		y 96
		x 218
		view 513
		loop 3
	)
)

(instance aConveyor1 of Prop
	(properties
		y 131
		x 239
		view 513
		loop 2
	)
)

(instance aAgentNear of Prop
	(properties
		y 123
		x 187
		view 514
	)
)

(instance aAgentFar of Prop
	(properties
		y 46
		x 184
		view 514
		loop 1
	)
)

(instance aTraveler of Act
	(properties
		y 36
		x 128
		view 514
		loop 3
		signal 16384
	)
)

(instance aDoor of AutoDoor
	(properties
		y 156
		x 293
		view 513
		msgLook 0
		msgLookLock 18
		msgLocked 38
		msgExcept 59
		msgFunny 82
		msgCloser 102
	)
)

(instance aPlane of Airplane
	(properties)
)

