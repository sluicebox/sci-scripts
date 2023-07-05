;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Chase)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm76 0
)

(local
	local0
)

(instance rm76 of Rm
	(properties
		picture 76
		east 75
		west 77
	)

	(method (dispose)
		(DisposeScript 985)
		(DisposeScript 972)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 55 276)
		(if (gEgo has: 6) ; Four-leaf_Clover
			(Load rsVIEW 170)
		)
		(self
			style:
				(switch gPrevRoomNum
					(west 3)
					(east 2)
				)
		)
		(super init:)
		(gEgo init:)
		(proc0_1)
		(gAddToPics add: door eachElementDo: #init doit:)
		(statue init: stopUpd:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 3 (proc0_17 187 (gEgo x:) 154))
			)
			(else
				(gEgo posn: 279 118)
				(if (not (IsFlag 33))
					(LoadMany rsSOUND 47 42 27)
					(gCurRoom setScript: getHim_)
				)
			)
		)
		(= local0 (IsFlag 1))
	)

	(method (doit &tmp temp0)
		(cond
			((and (== script getHim_) (IsFlag 1) (not local0))
				(= local0 1)
				(Print 76 0) ; "The leprechauns' magical powers detect your unseen presence."
			)
			((and script (!= script getHim_))
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(self newRoom: temp0)
			)
			(script
				(script doit:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'eat,eat/mushroom')
				(if (gEgo has: 19) ; Mushroom
					(if (gCurRoom script:)
						(Print 76 1) ; "This is one tight squeeze the mushroom will not get you out of."
					else
						(event claimed: 0)
					)
				else
					(event claimed: 0)
				)
			)
			(
				(or
					(Said 'look,look/lep,guard')
					(MousedOn g1 event 3)
					(MousedOn g2 event 3)
				)
				(if (IsFlag 33)
					(Print 76 2) ; "There are no leprechauns here."
				else
					(Print 76 3) ; "They are tiny people dressed all in green."
				)
			)
			((or (Said 'look,look/door') (MousedOn door event 3))
				(Print 76 4) ; "This door separates the rat's warren from the domain of the Leprechaun King."
			)
			((Said 'look,look>')
				(if (Said '[<at,around][/room,cave]')
					(Print 76 5) ; "You are in the antechamber of the Hall of the Leprechaun King."
					(if (not (IsFlag 33))
						(Print 76 6) ; "There are leprechauns in the room with you."
					)
				)
			)
			((Said 'close,close/door')
				(Print 76 7) ; "Leave the door open. Perhaps a draft will clear out some of the musty old rat smell."
			)
			((or (Said 'talk,talk/lep,guard') (Said 'hello') (Said 'say/hello'))
				(if (IsFlag 33)
					(Print 76 8) ; "There is no one to talk to here."
				else
					(Print 76 9) ; "Unfortunately, you don't speak the language of the little folk."
				)
			)
			((Said 'kill/lep,guard')
				(if (IsFlag 33)
					(Print 76 2) ; "There are no leprechauns here."
				else
					(Print 76 10) ; "Don't even try it. They're more agile than you are, and they outnumber you."
				)
			)
			(
				(and
					(== (event type:) evMOUSEBUTTON)
					(& (event modifiers:) emSHIFT)
					(== (OnControl PRIORITY (event x:) (event y:)) -32768)
				)
				(Print 76 11) ; "These rock formations were slowly created over thousands of years."
			)
			((Said '/stalactite,stalactite>')
				(cond
					((Said 'get,bend')
						(Print 76 12) ; "These are of no use to you, Sir Graham."
					)
					((Said 'look,look')
						(Print 76 11) ; "These rock formations were slowly created over thousands of years."
					)
				)
			)
			((and (gCurRoom script:) (Said 'use/shot'))
				(if (Random 0 1)
					(Print 76 13) ; "The Leprechaun King absolutely, positively forbids violence or weapons of any sort in his throne room. With thoughts of the sling in your mind, you seem unable to turn those thoughts into movement."
				else
					(Print 76 14) ; "The Leprechaun King's magic does not permit you to use weapons in the Throne Room. Thus, while the sling is still in your pocket, you seem entirely unable to put it in your hand."
				)
			)
		)
	)
)

(instance getHim_ of Script
	(properties
		name {getHim!}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(AmigaPauseBackSound 1)
				((ScriptID 0 21) number: 47 loop: 1 play:) ; gameSound
				(if (IsFlag 1)
					(Print 76 0) ; "The leprechauns' magical powers detect your unseen presence."
				)
				(gEgo loop: 1 setMotion: 0)
				(g1 setLoop: 2 setCycle: Walk setMotion: MoveTo 149 119 init:)
				(g2
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 200 148 self
					init:
				)
			)
			(1
				(if (gEgo has: 6) ; Four-leaf_Clover
					(Print 76 15) ; "Oh, no! Now what are you going to do?"
				else
					(Print 76 16) ; "This looks like a bad situation. Perhaps you should do something!"
				)
				(AmigaPauseBackSound 0)
				(User canControl: 1)
				(= seconds 2)
			)
			(2
				(g1
					setCycle: Walk
					setAvoider: Avoid
					setMotion:
						Chase
						gEgo
						(if (gEgo has: 6) 30 else 20) ; Four-leaf_Clover
						self
				)
				(g2
					setCycle: Walk
					setAvoider: Avoid
					setMotion:
						Chase
						gEgo
						(if (gEgo has: 6) 30 else 20) ; Four-leaf_Clover
						self
				)
			)
			(3
				(if (gEgo has: 6) ; Four-leaf_Clover
					(Print 76 17) ; "With a genuine four-leaf clover in your possession, the leprechauns fear and respect you. Rather than risk offending you, they decide to leave you entirely alone."
					(g1 stopUpd: setMotion: 0)
					(g2 stopUpd: setMotion: 0)
					(gCurRoom setScript: poofGuards)
				else
					((ScriptID 0 21) stop:) ; gameSound
					(EgoDead 76 18)
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'fiddle,play/fiddle,jig')
				(cond
					((IsFlag 1)
						(Print 76 19) ; "You can't play the fiddle while you're invisible."
					)
					((not (gEgo has: 17)) ; Fiddle
						(proc0_6) ; "You don't have anything that fits that description in your inventory."
					)
					(else
						(gCurRoom setScript: fiddler)
					)
				)
			)
		)
	)
)

(instance fiddler of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(AmigaPauseBackSound 1)
				((ScriptID 0 21) number: 42 loop: 1 play: self) ; gameSound
				(gEgo view: 55 cycleSpeed: 1 setCycle: Fwd)
				(g1 setMotion: 0)
				(g2 setMotion: 0)
				(= seconds 3)
			)
			(1
				(g1 loop: 3 setCycle: Fwd)
				(g2 loop: 4 setCycle: Fwd)
				(= seconds 5)
			)
			(2
				(Print 76 20) ; "Wonderful job! Leprechauns find fiddle music irresistible. The moment they hear the music, they begin dancing a frenzied jig."
				(= seconds 4)
			)
			(3
				(Print 76 21) ; "Finally, swept away by the snappy music, the Leprechaun guards poof right out of the room."
				(self setScript: poofGuards self)
			)
			(4
				(gEgo setCycle: Fwd)
			)
			(5
				(proc0_1)
				(AmigaPauseBackSound 0)
				(gEgo loop: 2)
				(HandsOn)
				(SetScore 103 3)
				(self dispose:)
			)
		)
	)
)

(instance poofGuards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo stopUpd:)
				(poof posn: (g1 x:) (g1 y:) init: setCycle: CT 7 1 self)
				(TempSound number: 27 loop: 1 init: play:)
			)
			(1
				(g1 dispose:)
				(poof setCycle: End self)
			)
			(2
				(poof cel: 0 posn: (g2 x:) (g2 y:) setCycle: CT 7 1 self)
				(TempSound number: 27 loop: 1 play:)
			)
			(3
				(g2 dispose:)
				(SetFlag 33)
				(poof setCycle: End self)
			)
			(4
				(poof dispose:)
				(self dispose:)
			)
		)
	)
)

(instance door of PicView
	(properties
		x 286
		y 109
		view 276
	)

	(method (handleEvent))
)

(instance statue of View
	(properties
		x 194
		y 128
		noun '/pillar,beam,clover,pillar'
		sightAngle 360
		longRangeDist 500
		shiftClick 1
		view 276
		cel 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/pillar,beam')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 76 22) ; "Carved into the top of this stone pillar is a huge four-leaf clover. Apparently the leprechauns who inhabit this underground sanctuary greatly fear and respect the power of the four-leaf clover!"
			)
		)
	)
)

(instance g1 of Actor
	(properties
		x 113
		y 157
		description {leprechaun}
		view 276
		cel 2
	)
)

(instance g2 of Actor
	(properties
		x 125
		y 183
		description {leprechaun}
		view 276
		cel 2
	)
)

(instance poof of Prop
	(properties
		view 170
		loop 2
	)

	(method (doVerb))
)

(instance TempSound of Sound
	(properties
		priority 6
	)
)

