;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Door)
(use Airplane)
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
	aPlane
	aDoor
	aConveyor1
	aConveyor2
	aConveyor3
	aConveyor4
	aAgentFar
	aAgentNear
	aTraveler
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
		((View new:) view: 513 loop: 1 cel: 0 posn: 25 157 setPri: 12 addToPic:)
		((View new:) view: 513 loop: 1 cel: 1 posn: 73 57 setPri: 10 addToPic:)
		((View new:)
			view: 513
			loop: 6
			cel: 0
			posn: 301 117
			setPri: 11
			addToPic:
		)
		((= aConveyor4 (Prop new:))
			view: 513
			setLoop: 5
			setPri: 3
			posn: 198 59
			cycleSpeed: 1
			setCycle: Fwd
			isExtra: 1
			init:
		)
		((= aConveyor3 (Prop new:))
			view: 513
			setLoop: 4
			setPri: 4
			posn: 206 69
			cycleSpeed: 1
			setCycle: Fwd
			isExtra: 1
			init:
		)
		((= aConveyor2 (Prop new:))
			view: 513
			setLoop: 3
			setPri: 4
			posn: 218 96
			cycleSpeed: 1
			setCycle: Fwd
			isExtra: 1
			init:
		)
		((= aConveyor1 (Prop new:))
			view: 513
			setLoop: 2
			setPri: 10
			posn: 239 131
			cycleSpeed: 1
			setCycle: Fwd
			isExtra: 1
			init:
		)
		((= aAgentNear (Prop new:))
			view: 514
			setLoop: 0
			setCel: 0
			setPri: 10
			posn: 187 123
			stopUpd:
			init:
		)
		((= aAgentFar (Prop new:))
			view: 514
			setLoop: 1
			setCel: 0
			setPri: 1
			posn: 184 46
			stopUpd:
			init:
		)
		((= aTraveler (Act new:))
			view: 514
			setLoop: 3
			setPri: 2
			posn: 128 36
			setStep: 1 1
			illegalBits: 0
			ignoreActors:
			init:
			hide:
		)
		((= aPlane (Airplane new:))
			view: 511
			setCel: 0
			startX: 208
			startY: 23
			endX: 1
			endY: 23
			init:
		)
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
		((= aDoor (AutoDoor new:))
			view: 513
			setLoop: 0
			posn: 293 156
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

(instance travelerScript of Script ; UNUSED
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
				(aTraveler setLoop: (+ (aTraveler loop:) 1) cel: 0 setCycle: End self)
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

