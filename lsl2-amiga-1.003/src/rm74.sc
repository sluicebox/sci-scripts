;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm74 0
)

(local
	vineHere
	seenCreekMessage
	seenMessage
	grabbedVine
)

(instance rm74 of Rm
	(properties
		picture 74
		horizon 66
		east 75
		west 73
	)

	(method (init)
		(Load rsVIEW 178)
		(Load rsVIEW 729)
		(super init:)
		(if ((gInventory at: 29) ownedBy: gCurRoomNum) ; Vine
			(= vineHere 1)
			(aTHEvine stopUpd: init:)
		)
		(gAddToPics
			add: aVineA aVineB aVineC aVineD aVineE aVineF aVineG aVineH
			doit:
		)
		(aRapids setCycle: Fwd init:)
		(aVine1 setPri: 8 stopUpd: init:)
		(aVine2 setPri: 8 stopUpd: init:)
		(aVine3 setPri: 8 stopUpd: init:)
		(if (and (== gPastPiranha 0) (!= gPrevRoomNum 75))
			(Load rsVIEW 177)
			(Load rsVIEW 176)
			(Load rsVIEW 110)
			(aBigEgo init:)
			(aBigEgoFace setPri: 15 cycleSpeed: 1 init:)
		)
		(NormalEgo)
		(if (== gPrevRoomNum 75)
			(gEgo posn: 288 78 observeControl: 2 16)
		else
			(gEgo posn: 2 76)
		)
		(gEgo init:)
		(self setRegions: 700 setScript: rm74Script) ; rm700
	)
)

(instance rm74Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (gEgo inRect: 261 72 321 77) (== gCurrentStatus 0))
				(gCurRoom newRoom: 75)
			)
			((and (== gCurrentStatus 1016) (& (gEgo onControl:) $0010))
				(self changeState: 3)
			)
			((and (== gCurrentStatus 1016) (& (gEgo onControl:) $0400))
				(if (== seenMessage 0)
					(= seenMessage 1)
					(Print 74 0) ; "The bank here is too steep and slippery for you to climb out."
				)
			)
			((and (== gCurrentStatus 1016) (& (gEgo onControl:) $2000))
				(if (== seenCreekMessage 0)
					(= seenCreekMessage 1)
					(Print 74 1) ; "Don't go that way, Larry! There's no game over there!!"
				)
			)
			((and (== gCurrentStatus 0) (== (gEgo onControl:) 2))
				(self changeState: 1)
			)
			(else
				(= seenCreekMessage 0)
				(= seenMessage 0)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/lagoon,beach')
				(Print 74 2) ; "The ocean appears to be just beyond that clump of trees near the beach."
			)
			(if (Said '/brook,water')
				(Print 74 3) ; "A swift river cascades down from the island's volcano behind the jungle, splashing its way over some extremely dangerous rapids before becoming more placid and tranquil here in the jungle."
			)
			(if (Said '/fish')
				(if (!= gCurrentStatus 1016)
					(Print 74 4) ; "You can only see a few vague shapes from here."
				else
					(Print 74 5) ; "They are presently feasting. Looks like dinner is on you, Larry!"
				)
			)
			(if (Said '/palm,landscape,bush')
				(Print 74 6) ; "Many vines hang down from the jungle canopy overhead."
				(if (== vineHere 1)
					(Print 74 7) ; "One in particular attracts your eye: although it appears sturdy, it has been weakened near its top by excessive swinging!"
				)
			)
			(if (Said '/boulder,cascade')
				(Print 74 8) ; "The slippery rocks are far too treacherous for you to traverse."
			)
			(if (Said '[/airport,forest]')
				(Print 74 9) ; "A quiet brook babbles nearby. Vines hang from the jungle canopy, which thins as it reaches the beach just visible ahead."
			)
		)
		(if (Said 'pull,get/landscape')
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not vineHere)
					(Print 74 10) ; "All the other vines are out of your reach."
				)
				((gEgo inRect: 59 91 78 98)
					(Print 74 11) ; "You tug as hard as you can, but this vine is securely attached to that big branch above you."
				)
				((not (gEgo inRect: 149 100 195 129))
					(NotClose) ; "You're not close enough."
				)
				(else
					(= vineHere 0)
					(gEgo get: 29) ; Vine
					(gGame changeScore: 4)
					(aTHEvine dispose:)
					(Print 74 12 #draw) ; "You reach up, grasp the vine firmly, and give it a sharp jerk, yanking it from the tree branch above you!"
					(Print 74 13) ; "You carefully coil it up and insert it into your left front pants pocket."
				)
			)
		)
		(if (Said 'bathing')
			(Print 74 14) ; "Not in that water!"
		)
		(if (Said '*/boulder')
			(if (== gCurrentStatus 1016)
				(Print 74 15) ; "The bank is too steep and too slippery here. Keep looking for a spot."
			else
				(Print 74 16) ; "The rocks are too slippery and steep for you to climb."
			)
		)
		(if
			(or
				(Said 'hop,(let<board)')
				(Said 'free,carry,apply,swing,alter/landscape')
				(Said 'swing/brook,water')
				(Said 'swing<on/landscape')
			)
			(cond
				((and (>= gCurrentStatus 1013) (<= gCurrentStatus 1015))
					(= grabbedVine 1)
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not (gEgo inRect: 59 91 78 98))
					(NotClose) ; "You're not close enough."
				)
				(else
					(self changeState: 10)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= gCurrentStatus 1016)
				(User canControl: 1 canInput: 1)
				(gEgo
					view: 176
					observeControl: 1 -32768
					setLoop: -1
					setStep: 3 2
					setCycle: Walk
					setPri: -1
				)
				(= cycles 8)
			)
			(2
				(Print 74 17 #draw) ; "You feel a tickling sensation around your toes. Boy, this adventuring life is sure fun!"
			)
			(3
				(Print 74 18) ; "This seems a safe place to climb out."
				(gEgo
					view: 177
					setPri: -1
					illegalBits: $8000
					observeControl: 16 2 16384
				)
				(User canInput: 0)
				(= gCurrentStatus 1000)
				(gCurRoom east: 0)
				(= cycles 0)
				(= seconds 6)
			)
			(4
				(User canControl: 0)
				(gEgo setMotion: 0 setLoop: 2)
				(aBigEgo posn: (gEgo x:) 87 stopUpd:)
				(aBigEgoFace posn: (gEgo x:) 87 cel: 0 setCycle: End self)
			)
			(5
				(= cycles 7)
			)
			(6
				(aBigEgoFace setCycle: Beg self)
			)
			(7
				(aBigEgoFace loop: 5 setCycle: End)
				(= seconds 3)
			)
			(8
				(Print 74 19 #at -1 20) ; "Gee. Those piranha really work fast!"
				(aBigEgoFace dispose:)
				(aBigEgo dispose:)
				(= seconds 3)
			)
			(9
				(Print 74 20) ; "For some reason, your heart just isn't in the game any more..."
				(Print 74 21) ; "...not to mention several other organs!"
				(= gCurrentStatus 1001)
			)
			(10
				(Ok) ; "Ok."
				(gEgo hide:)
				(User canControl: 0)
				(= gCurrentStatus 1013)
				(aVine1 cel: 1 setCycle: CT 7 1 self)
			)
			(11
				(if grabbedVine
					(= grabbedVine 0)
					(self changeState: 14)
				else
					(aVine1 cel: 8 setCycle: End)
					(gEgo
						view: 178
						illegalBits: 0
						ignoreActors:
						ignoreHorizon:
						setLoop: 2
						setPri: 8
						setStep: 3 4
						cel: 0
						posn: 106 85
						show:
						setCycle: End
						setMotion: MoveTo 106 102 self
					)
				)
			)
			(12
				(gEgo setLoop: 4 posn: 106 103 cel: 0 setCycle: End self)
			)
			(13
				(Print 74 22 #at -1 20 #draw) ; "Next time, you may want to consider using the next vine as well!"
				(self changeState: 1)
			)
			(14
				(aVine1 setCel: 8 setCycle: End)
				(aVine2 setCel: 1 setCycle: CT 6 1 self)
			)
			(15
				(if grabbedVine
					(= grabbedVine 0)
					(self changeState: 18)
				else
					(aVine2 cel: 7 setCycle: End)
					(gEgo
						view: 178
						illegalBits: 0
						ignoreActors:
						ignoreHorizon:
						setLoop: 2
						setPri: 8
						setStep: 3 7
						cel: 0
						posn: 131 73
						show:
						setCycle: End
						setMotion: MoveTo 131 102 self
					)
				)
			)
			(16
				(gEgo setLoop: 4 posn: 131 103 cel: 0 setCycle: End self)
			)
			(17
				(Print 74 23 #at -1 20 #draw) ; "Next time, you may want to grab that third vine!"
				(self changeState: 1)
			)
			(18
				(aVine1 stopUpd:)
				(aVine2 setCel: 7 setCycle: End)
				(aVine3 cel: 1 setCycle: CT 6 1 self)
			)
			(19
				(aVine2 stopUpd:)
				(if grabbedVine
					(= grabbedVine 0)
					(aVine3 setCel: 6)
					(self changeState: 23)
				else
					(aVine3 setCycle: Beg self)
				)
			)
			(20
				(gEgo
					view: 178
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					setLoop: 2
					setPri: 8
					setStep: 3 7
					cel: 0
					posn: 131 73
					show:
					setCycle: End
					setMotion: MoveTo 131 102 self
				)
			)
			(21
				(gEgo setLoop: 4 posn: 131 103 cel: 0 setCycle: End self)
			)
			(22
				(Print 74 24 #at -1 20 #draw) ; "Next time, you may want to release the third vine when you believe your trajectory will carry you safely over land!"
				(self changeState: 1)
			)
			(23
				(aVine3 setCel: 7 setCycle: End)
				(gEgo
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					view: 178
					setLoop: 3
					setPri: 9
					setCel: 0
					posn: 158 61
					show:
					setCycle: CT 5 1
					setStep: 1 10
					setMotion: MoveTo 167 122 self
				)
			)
			(24
				(aVine3 stopUpd:)
				(gEgo setCycle: End self)
			)
			(25
				(NormalEgo 0)
				(if (== gPastPiranha 0)
					(= gPastPiranha 1)
					(gGame changeScore: 6)
					(Print 74 25 #at -1 130 #draw) ; "(You knew all along you were a swinger!)"
				)
			)
		)
	)
)

(instance aTHEvine of View
	(properties
		y 37
		x 184
		view 178
		loop 5
		priority 9
		signal 16384
	)
)

(instance aVineA of PV
	(properties
		y 40
		x 18
		view 178
		loop 5
		cel 1
		priority 12
		signal 16384
	)
)

(instance aVineB of PV
	(properties
		y 55
		x 37
		view 178
		loop 5
		priority 12
		signal 16384
	)
)

(instance aVineC of PV
	(properties
		y 27
		x 223
		view 178
		loop 5
		priority 12
		signal 16384
	)
)

(instance aVineD of PV
	(properties
		y 10
		x 202
		view 178
		loop 5
		cel 1
		priority 12
		signal 16384
	)
)

(instance aVineE of PV
	(properties
		y 40
		x 44
		view 178
		loop 5
		cel 1
		priority 12
		signal 16384
	)
)

(instance aVineF of PV
	(properties
		y 32
		x 192
		view 178
		loop 5
		priority 12
		signal 16384
	)
)

(instance aVineG of PV
	(properties
		y 51
		x 23
		view 178
		loop 5
		priority 7
		signal 16384
	)
)

(instance aVineH of PV
	(properties
		y 42
		x 11
		view 178
		loop 1
		priority 7
		signal 16384
	)
)

(instance aBigEgo of View
	(properties
		y 1098
		x 243
		view 110
		priority 14
		signal 16384
	)
)

(instance aRapids of Prop
	(properties
		y 67
		x 124
		view 729
	)
)

(instance aVine1 of Prop
	(properties
		y 44
		x 85
		view 178
		signal 16384
	)
)

(instance aVine2 of Prop
	(properties
		y 32
		x 111
		view 178
		loop 1
		signal 16384
	)
)

(instance aVine3 of Prop
	(properties
		y 20
		x 136
		view 178
		loop 1
		signal 16384
	)
)

(instance aBigEgoFace of Prop
	(properties
		y 1098
		x 243
		view 177
		loop 4
		signal 16384
	)
)

