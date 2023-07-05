;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n316)
(use n824)
(use n828)
(use n954)
(use LoadMany)
(use RFeature)
(use Sight)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	egosQuartersRm 0
)

(local
	[local0 8]
	[local8 32] = [{} {DESTROY} {COONTZ} {DEGREE} {COURSE} {SHIP} {LATITUDE} {RUSSIAN} {REDWOOD} {4100} {TACTIC} {WAR} {STEER} {DIRECTLY} {ARIZONA} {OCEAN} {} {destroy} {coontz} {degree} {course} {ship} {latitude} {russian} {redwood} {4100} {tactic} {war} {steer} {directly} {arizona} {ocean}]
	[local40 12]
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65
	local66
	local67
	local68
	local69
)

(procedure (localproc_0 param1 param2 param3 &tmp [temp0 30])
	(Format @temp0 &rest)
	(Display @temp0 dsCOORD param1 param2 dsCOLOR param3 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		(if [local58 temp0]
			(Display 31 49 dsRESTOREPIXELS [local58 temp0])
			(= [local58 temp0] 0)
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(Format @local0 31 49)
	(if (GetInput @local0 15)
		(for ((= temp0 0)) (< temp0 12) ((+= temp0 2))
			(if (and [local40 temp0] (localproc_4 [local40 temp0]))
				(= local52 temp0)
				(return 1)
			)
		)
		(return 0)
	else
		(return 0)
	)
)

(procedure (localproc_3)
	(Format @local0 31 49)
	(if (GetInput @local0 15)
		(if (localproc_4 [local40 (+ local52 1)])
			(return 1)
		)
		(return 0)
	else
		(return 0)
	)
)

(procedure (localproc_4 param1)
	(cond
		((== (StrCmp @local0 [local8 (+ param1 0)]) 0)
			(return 1)
		)
		((== (StrCmp @local0 [local8 (+ param1 16)]) 0)
			(return 1)
		)
		(else
			(return 0)
		)
	)
)

(procedure (localproc_5 &tmp temp0)
	(Format @local0 31 49)
	(if (GetInput @local0 2)
		(cond
			((== (StrCmp @local0 {Y}) 0)
				(return 1)
			)
			((== (StrCmp @local0 {y}) 0)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	else
		(return 0)
	)
)

(instance egosQuartersRm of Rm
	(properties
		picture 31
		west 25
		vanishingX 150
		vanishingY 10
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gEgo init: view: 232 setPri: -1)
		(if (== gPrevRoomNum 23) ; pierRm
			(gEgo
				posn: 295 115
				heading: 270
				loop: 1
				setScript: justGotOnSubScript
			)
		else
			(gEgo posn: 23 119 heading: 90 loop: 0 setMotion: MoveTo 72 119)
		)
		(LoadMany rsVIEW 31 431)
		(bookShelf init:)
		(map init:)
		(wallPic init:)
		(gAddToPics doit:)
		(entryDoor init: ignoreActors: 1 stopUpd:)
		(bathDoor init: cel: 0 stopUpd: ignoreActors: 1)
		(proc316_0 gCurRoomNum 14 13)
		(computer init:)
		(codeBook init: cel: (if (gEgo has: 14) 1 else 0)) ; Sub: Code_Book | Tunisia: Note
		(microMeterView init:)
		(drawerView init: hide:)
		(credenza init: setPri: 5 stopUpd:)
		(self
			setRegions: 314 ; subMarine
			setFeatures:
				bunk
				purpleThing
				desk
				drawer
				closet
				couch
				table
				nightstand
				((Clone couch)
					x: 129
					y: 130
					z: 0
					nsLeft: 113
					nsTop: 120
					nsRight: 145
					nsBottom: 140
					yourself:
				)
		)
		(proc824_0)
		(= [local40 0] (>> (subMarine msg12:) $000c))
		(= [local40 1] (& (>> (subMarine msg12:) $0008) $000f))
		(= [local40 2] (& (>> (subMarine msg12:) $0004) $000f))
		(= [local40 3] (& (subMarine msg12:) $000f))
		(= [local40 4] (>> (subMarine msg34:) $000c))
		(= [local40 5] (& (>> (subMarine msg34:) $0008) $000f))
		(= [local40 6] (& (>> (subMarine msg34:) $0004) $000f))
		(= [local40 7] (& (subMarine msg34:) $000f))
		(= [local40 8] (>> (subMarine msg56:) $000c))
		(= [local40 9] (& (>> (subMarine msg56:) $0008) $000f))
		(= [local40 10] (& (>> (subMarine msg56:) $0004) $000f))
		(= [local40 11] (& (subMarine msg56:) $000f))
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene]')
				(if (> (gEgo x:) (bathDoor x:))
					(Print 31 0) ; "You are in the bathroom."
				else
					(Print 31 1) ; "This is the Executive Officers cabin which happens to be assigned to Commander John Westland."
					(Print 31 2) ; "The cabin is equipped with a bunk, closet, desk and bookshelf."
				)
			)
			((Said 'look[<at]/book')
				(if (gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
					(event claimed: 0)
				else
					(proc0_40) ; "You don't see that."
				)
			)
			((Said 'sit[<down][/couch]')
				(proc0_39) ; "You don't need to do that."
			)
			((Said 'look[/couch]')
				(Print 31 3) ; "It's just an ordinary couch."
			)
		)
	)
)

(instance justGotOnSubScript of Script
	(properties
		seconds 3
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(Print 31 4 #time 5 #at -1 20 #dispose) ; "You go to your quarters and change clothes."
				(gEgo setMotion: MoveTo 245 115 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance entryDoor of Prop
	(properties
		y 114
		x 36
		view 31
		loop 2
	)

	(method (doit)
		(super doit:)
		(if (and (== (gEgo onControl: 1) 4) (not script))
			(HandsOff)
			(self setScript: entryDoorScript)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 31 5) ; "The door to this cabin."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
					((> (gEgo x:) (bathDoor x:)))
					((GoToIfSaid self event 55 123 'open' 31 6))
					((Said 'open')
						(HandsOff)
						(self setScript: entryDoorScript)
					)
				)
			)
		)
	)
)

(instance entryDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(if (> (gEgo x:) (client x:))
					(= register -1)
				else
					(= register 1)
				)
				(gEgo
					setAvoider: Avoid
					setPri: 8
					setMotion:
						MoveTo
						(+ (gEgo x:) (* 35 register))
						(gEgo y:)
						self
				)
			)
			(2
				(client setCycle: Beg self)
				(HandsOn)
			)
			(3
				(gEgo setPri: -1)
				(if (< (gEgo x:) (client x:))
					(proc0_3)
					(gCurRoom newRoom: (gCurRoom west:))
				else
					(client stopUpd:)
					(self dispose:)
				)
			)
		)
	)
)

(instance bathDoor of Prop
	(properties
		y 117
		x 279
		view 31
		loop 1
	)

	(method (doit)
		(super doit:)
		(if (and (== (gEgo onControl: 1) 2) (not script))
			(if (gEgo mover:)
				(= local67 ((gEgo mover:) x:))
				(= local68 ((gEgo mover:) y:))
				(= local69 ((gEgo mover:) caller:))
			)
			(HandsOff)
			(self setScript: bathDoorScript)
		)
	)

	(method (cue)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door<bathroom]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 31 7) ; "The bathroom door."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
					(
						(and
							(< (gEgo x:) x)
							(GoToIfSaid self event 260 117 'open' 31 6)
						))
					(
						(and
							(> (gEgo x:) x)
							(GoToIfSaid self event 291 117 'open' 31 6)
						))
					((Said 'open')
						(HandsOff)
						(self setScript: bathDoorScript)
					)
				)
			)
			((< (gEgo x:) (self x:)))
			((Said 'look[<at,around][/room]')
				(Print 31 8) ; "You look around the small but adequate bathroom facility."
				(Print 31 9) ; "It is equipped with a small sink, mirror, shower and marine toilet. There is a small warning light above the toilet."
			)
			((Said 'look/sink')
				(Print 31 10) ; "It's small and made of stainless steel."
			)
			((or (Said 'use/sink') (Said 'wash/hand') (Said 'turn<on/water'))
				(Print 31 11) ; "In an effort to conserve the water supply, you quickly wash your hands then turn off the water."
			)
			((Said 'look/mirror')
				(Print 31 12) ; "You look into the mirror and think, "Yep, I still look the same.""
			)
			((Said 'comb/hair')
				(Print 31 13) ; "Since cleanliness and grooming are part of Navy life, you look into the mirror and comb your hair."
			)
			((Said 'look/shower')
				(Print 31 14) ; "The only thing special about this shower is that it's small."
			)
			((Said '(turn<on),use,get/shower')
				(Print 31 15) ; "In record time you take a hot shower."
			)
			((Said 'look/light')
				(Print 31 16) ; "This is a typical marine toilet that dumps waste into the ship's holding tanks."
				(Print 31 17) ; "When the holding tanks are full, they are pressurized to force the waste into the open ocean."
				(Print 31 18) ; "If you flush the toilet when this light is on, the pressure will cause the contents of the holding tanks to be forcibly expelled through your toilet."
			)
			((Said 'look/toilet')
				(Print 31 16) ; "This is a typical marine toilet that dumps waste into the ship's holding tanks."
				(Print 31 17) ; "When the holding tanks are full, they are pressurized to force the waste into the open ocean."
				(Print 31 19) ; "It is highly recommended that the toilet not be flushed when the tanks are pressurized."
			)
			((Said 'flush/toilet')
				(cond
					(local55
						(= local55 0)
						(flushNoise play:)
						(Print 31 20) ; "Your failure to follow explicit instruction has left you a stinking mess."
						(Print 31 21) ; "As you hurriedly clean the enormous amount of human waste off your body, we are busy deducting 3 points from your score."
						(gGame changeScore: -3)
					)
					(local56
						(Print 31 22) ; "The holding tanks are pressurized. Flushing is not recommended."
						(= local56 (Random 0 1))
						(= local55 1)
					)
					(else
						(Print 31 23) ; "You flush the toilet."
						(= local56 (Random 0 1))
					)
				)
			)
			((or (Said 'leak') (Said 'get/leak'))
				(Print 31 24) ; "Step closer Johnny, it's shorter than you think."
			)
			((or (Said 'shit') (Said 'get/shit'))
				(Print 31 25) ; "The human process of waste elimination has made you two pounds lighter."
			)
			((Said 'get/*')
				(Print 31 26) ; "You don't need it."
			)
		)
	)
)

(instance flushNoise of Sound
	(properties
		number 49
		priority 2
	)
)

(instance bathDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(if (> (gEgo x:) (client x:))
					(= register -1)
				else
					(= register 1)
				)
				(gEgo
					illegalBits: (if (== register 1) 0 else -32768)
					setMotion:
						MoveTo
						(+ (gEgo x:) (* 35 register))
						(gEgo y:)
						self
				)
			)
			(2
				(gEgo illegalBits: -32768)
				(client setCycle: Beg self)
			)
			(3
				(HandsOn)
				(if local67
					(gEgo setMotion: MoveTo local67 local68 local69)
				)
				(client stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance bookShelf of RPicView
	(properties
		y 71
		x 240
		view 431
		loop 1
		cel 1
	)
)

(instance codeBook of View
	(properties
		y 71
		x 240
		view 431
		loop 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((gEgo has: 14)) ; Sub: Code_Book | Tunisia: Note
			((Said '[/book]>')
				(cond
					((Said 'read,look')
						(if (gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
							(Print 31 27 #icon 431 0 0) ; "A code book."
							(SetScore subMarine 406 2 2)
						else
							(Print 31 28) ; "You don't have one."
						)
					)
					((not (credenza cel:)))
					(
						(and
							(not (& signal $0008))
							(TurnIfSaid self event 'look[<at]/*')
						))
					((GoToIfSaid self event 235 115 0 31 6))
					((Said 'get')
						(if (proc316_1 gCurRoomNum 14)
							(gEgo setScript: getBookScript)
						else
							(proc0_35) ; "You already took that."
						)
					)
				)
			)
		)
	)
)

(instance getBookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 131 loop: 0 setCycle: End self)
			)
			(1
				(Print 31 29) ; "You remove the "Decoding" book from the shelf."
				(gEgo get: 14) ; Sub: Code_Book | Tunisia: Note
				(codeBook hide:)
				(gEgo setCycle: Beg self)
			)
			(2
				(HandsOn)
				(gEgo view: 232 loop: 3 setCycle: Walk)
			)
		)
	)
)

(instance putBookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (credenza cel:))
					(credenza setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOff)
				(gEgo view: 131 loop: 0 setCycle: End self)
			)
			(2
				(Print 31 30) ; "You replace the "Decoding" book on the shelf."
				(gEgo put: 14 gCurRoomNum) ; Sub: Code_Book | Tunisia: Note
				(codeBook show:)
				(gEgo setCycle: Beg self)
			)
			(3
				(HandsOn)
				(gEgo view: 232 loop: 3 setCycle: Walk)
			)
		)
	)
)

(instance wallPic of RPicView
	(properties
		y 113
		x 298
		view 31
		cel 1
		priority 9
		signal 16
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look[<at]/picture'))
			((Said 'look[<at][/wall,picture]')
				(Print 31 31) ; "A decorative picture of a submarine."
			)
		)
	)
)

(instance map of RPicView
	(properties
		y 90
		x 102
		view 31
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look[<at]/map'))
			((Said 'look[<at][/map]')
				(Print 31 32) ; "A map of the world"
			)
		)
	)
)

(instance purpleThing of RFeature
	(properties
		y 81
		x 249
		nsTop 78
		nsLeft 243
		nsBottom 84
		nsRight 256
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look[<at]/thing[<purple]'))
			((Said 'look[<at]/thing<purple')
				(Print 31 33) ; "It is very purple, and "thing-like.""
			)
			((Said 'look[<at][/thing]')
				(Print 31 34) ; "The purple thing on the wall is the result of an artist with too much free time."
			)
		)
	)
)

(instance desk of RFeature
	(properties
		y 81
		x 249
		nsTop 89
		nsLeft 214
		nsBottom 111
		nsRight 265
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look[<at]/desk'))
			((Said 'look[<at][/desk]')
				(Print 31 35) ; "The desk is equipped with a drawer. On the desk is a small computer."
			)
		)
	)
)

(instance bunk of RFeature
	(properties
		y 155
		x 256
		nsTop 138
		nsLeft 207
		nsBottom 169
		nsRight 312
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look[<at]/bunk,bed'))
			((Said 'look[<at][/bunk,bed]')
				(Print 31 36) ; "It's the latest in submarine slumber."
			)
		)
	)
)

(instance drawer of RFeature
	(properties
		y 100
		x 239
		nsTop 89
		nsLeft 214
		nsBottom 111
		nsRight 265
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/drawer]>')
				(cond
					((TurnIfSaid self event 'look[<at,in]/*'))
					((Said 'look[<at,in]')
						(Print 31 37) ; "A typical desk drawer."
						(cond
							(
								(or
									(> (gEgo distanceTo: self) 40)
									(not local57)
								)
								0
							)
							((& (drawerView signal:) $0008)
								(drawerView show:)
								(if (proc316_1 gCurRoomNum 13)
									(Print 31 38) ; "In the drawer you see a vernier caliper."
								else
									(Print 31 39) ; "The drawer is currently empty."
								)
							)
							((proc316_1 gCurRoomNum 13)
								(Print 31 38) ; "In the drawer you see a vernier caliper."
							)
							(else
								(Print 31 39) ; "The drawer is currently empty."
							)
						)
					)
					((GoToIfSaid self event 239 120 0 31 6))
					((Said 'open')
						(gEgo heading: 0)
						((gEgo looper:) doit: gEgo (gEgo heading:))
						(drawerView show:)
						(if (proc316_1 gCurRoomNum 13)
							(Print 31 40) ; "You open the drawer and see a vernier caliper."
						else
							(Print 31 41) ; "You open the drawer."
						)
						(= local57 1)
					)
					((Said 'close')
						(gEgo heading: 0)
						((gEgo looper:) doit: gEgo (gEgo heading:))
						(drawerView hide:)
						(= local57 0)
					)
				)
			)
		)
	)
)

(instance drawerView of View
	(properties
		y 38
		x 238
		view 431
		cel 1
	)

	(method (show)
		(super show: &rest)
		(&= signal $feff)
		(if (proc316_1 gCurRoomNum 13)
			(microMeterView show:)
		)
	)

	(method (hide)
		(super hide: &rest)
		(|= signal $0100)
		(if (proc316_1 gCurRoomNum 13)
			(microMeterView hide:)
		)
	)

	(method (doit)
		(if (CantBeSeen self gEgo)
			(self hide:)
		)
		(super doit:)
	)
)

(instance microMeterView of View
	(properties
		y 79
		x 239
		z 52
		view 431
		cel 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((not local57))
			((TurnIfSaid self event 'look/caliper'))
			((GoToIfSaid self event 239 120 'get,place/caliper' 31 6))
			((Said 'get/caliper')
				(if (proc316_1 gCurRoomNum 13)
					(self hide:)
					(gEgo get: 13) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					(SetScore subMarine 406 1 1)
				else
					(proc0_35) ; "You already took that."
				)
			)
			((Said 'place/caliper[<in][/drawer]')
				(if (gEgo has: 13) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					(gEgo put: 13 gCurRoomNum) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					(if (not (& (drawerView signal:) $0008))
						(self show:)
					)
				else
					(proc0_38) ; "You don't have that."
				)
			)
		)
	)
)

(instance credenza of Prop
	(properties
		y 94
		x 214
		z 40
		view 31
		loop 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bookcase,bookcase,shelf,briefcase<[book]]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if cel
							(if (gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
								(Print 31 42) ; "Most of the books consist of boring governmental directives."
							else
								(Print 31 43) ; "Most of the books consist of boring governmental directives. However, one that catches your eye is entitled, "Decoding.""
							)
						else
							(Print 31 44) ; "You see your bookshelf on the wall."
						)
					)
					((GoToIfSaid self event 235 115 0 31 6))
					((Said 'open')
						(if cel
							(proc0_31) ; "It is."
						else
							(self setCycle: End self)
						)
					)
					((Said 'close')
						(if cel
							(self setCycle: Beg self)
						else
							(proc0_31) ; "It is."
						)
					)
				)
			)
			((Said '/book>')
				(cond
					((not (gEgo has: 14))) ; Sub: Code_Book | Tunisia: Note
					((TurnIfSaid self event 'place'))
					((GoToIfSaid self event 235 115 'place' 31 6))
					((Said 'place')
						(gEgo setScript: putBookScript)
					)
				)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance computer of Prop
	(properties
		y 91
		x 232
		view 31
		cel 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/computer]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 31 45) ; "This computer is used for decoding messages."
					)
					((GoToIfSaid self event 232 115 0 31 6))
					((Said 'use,(turn<on)/*')
						(if script
							(Print 31 46) ; "It's on!"
						else
							(computer setScript: computerOn)
						)
					)
				)
			)
		)
	)
)

(instance terminal of View
	(properties
		y 79
		x 73
		view 31
		loop 4
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance computerOn of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD) script)
				(script cue:)
			)
			((Said 'turn<off/computer')
				(if (OneOf state 2 3 4 6)
					(self changeState: 10)
				else
					(Print 31 47) ; "Read your messages!"
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(if (== (gIceKeyDownHandler indexOf: self) -1)
			(gIceKeyDownHandler addToFront: self)
		)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(= start 0)
		(HandsOn)
		(terminal dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gEgo loop: 3)
				(= seconds 2)
			)
			(1
				(terminal init: setPri: 12)
				(= seconds 1)
			)
			(2
				(= register
					(Display 31 48 dsCOORD 15 10 dsCOLOR 11 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS) ; "US NAVY DECODING COMPUTER"
				)
				(= seconds 4)
			)
			(3
				(Display 31 49 dsRESTOREPIXELS register)
				(= register
					(Display 31 50 dsCOORD 15 10 dsCOLOR 15 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS) ; "Enter primary word key"
				)
				(if (not (localproc_2))
					(++ local53)
					(++ local54)
				)
				(= cycles 15)
			)
			(4
				(Display 31 49 dsRESTOREPIXELS register)
				(= register
					(Display 31 51 dsCOORD 15 10 dsCOLOR 14 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS) ; "Enter secondary word key"
				)
				(if (not (localproc_3 local52))
					(++ local53)
					(++ local54)
				)
				(= cycles 15)
			)
			(5
				(Display 31 49 dsRESTOREPIXELS register)
				(Print 31 52) ; "Having entered the primary and secondary word keys you then type in the coded message."
				(= cycles 2)
			)
			(6
				(= register
					(Display 31 53 dsCOORD 15 10 dsCOLOR 2 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS) ; "Decoded message is..."
				)
				(Print 31 54) ; "The computer deciphers the message."
				(= seconds 2)
			)
			(7
				(Display 31 49 dsRESTOREPIXELS register)
				(if local53
					(switch (mod local54 3)
						(0
							(self setScript: MSG7Script self)
						)
						(1
							(self setScript: MSG8Script self)
						)
						(2
							(self setScript: MSG9Script self)
						)
					)
					(= local53 0)
				else
					(switch (>> local52 $0001)
						(0
							(SetScore subMarine 407 1 3)
							(self setScript: MSG1Script self)
						)
						(1
							(SetScore subMarine 407 2 3)
							(self setScript: MSG2Script self)
						)
						(2
							(SetScore subMarine 407 4 3)
							(self setScript: MSG3Script self)
						)
						(3
							(SetScore subMarine 407 8 3)
							(self setScript: MSG4Script self)
						)
						(4
							(SetScore subMarine 407 16 3)
							(self setScript: MSG5Script self)
						)
						(5
							(SetScore subMarine 407 32 3)
							(self setScript: MSG6Script self)
						)
					)
				)
			)
			(8
				(= register
					(Display 31 55 dsCOORD 15 10 dsCOLOR 2 dsALIGN alLEFT dsWIDTH 115 dsFONT 30 dsSAVEPIXELS) ; "Decode another message? Y or N"
				)
				(= start 3)
				(if (localproc_5)
					(self init:)
				else
					(= cycles 2)
				)
			)
			(9
				(Display 31 49 dsRESTOREPIXELS register)
				(= seconds 2)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance MSG1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local58 (localproc_0 15 10 13 31 56))
				(= local59 (localproc_0 15 16 13 31 57))
				(= local60 (localproc_0 15 22 13 31 58))
				(= local61 (localproc_0 20 28 13 31 59))
				(= local62 (localproc_0 15 34 13 31 60))
				(= local63 (localproc_0 20 40 13 31 61))
				(= local64 (localproc_0 15 46 13 31 62))
				(= local65 (localproc_0 15 52 13 31 63))
				(= local66 (localproc_0 20 58 13 31 64))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local58 (localproc_0 15 10 10 31 65))
				(= local59 (localproc_0 15 16 10 31 66))
				(= local60 (localproc_0 20 22 10 31 67))
				(= local61 (localproc_0 15 28 10 31 68))
				(= local62 (localproc_0 20 34 10 31 69))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local58 (localproc_0 15 10 13 31 56))
				(= local59 (localproc_0 16 16 13 31 70))
				(= local60 (localproc_0 20 22 13 31 71))
				(= local61 (localproc_0 20 28 13 31 72))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG4Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local58 (localproc_0 15 10 10 31 73))
				(= local59 (localproc_0 20 16 10 31 74))
				(= local60 (localproc_0 15 22 10 31 75))
				(= local61 (localproc_0 20 28 10 31 76))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG5Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local58 (localproc_0 15 10 13 31 77))
				(= local59 (localproc_0 15 16 13 31 78))
				(= local60 (localproc_0 20 22 13 31 79))
				(= local61 (localproc_0 15 28 13 31 80))
				(= local62 (localproc_0 15 34 13 31 81))
				(= local63 (localproc_0 20 40 13 31 82))
				(= local64 (localproc_0 15 46 13 31 83))
				(= local65 (localproc_0 20 52 13 31 84))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG6Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local58 (localproc_0 15 10 10 31 85))
				(= local59 (localproc_0 15 16 10 31 86))
				(= local60 (localproc_0 20 22 10 31 87))
				(= local61 (localproc_0 15 28 10 31 88))
				(= local62 (localproc_0 20 34 10 31 89))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG7Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local58 (localproc_0 15 10 12 31 90))
				(= local59 (localproc_0 15 16 12 31 91))
				(= local60 (localproc_0 15 22 12 31 92))
				(= local61 (localproc_0 20 28 12 31 93))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG8Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local58 (localproc_0 15 10 12 31 94))
				(= local59 (localproc_0 20 16 12 31 95))
				(= local60 (localproc_0 15 22 12 31 92))
				(= local61 (localproc_0 20 28 12 31 96))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance MSG9Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local58 (localproc_0 15 10 12 31 97))
				(= local59 (localproc_0 20 16 12 31 98))
				(= local60 (localproc_0 20 22 12 31 99))
				(= local61 (localproc_0 15 28 12 31 100))
				(= local62 (localproc_0 20 34 12 31 101))
				(= local63 (localproc_0 20 40 12 31 102))
				(= local64 (localproc_0 20 46 12 31 103))
			)
			(1
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance closet of RFeature
	(properties
		y 83
		x 190
		nsTop 54
		nsLeft 167
		nsBottom 113
		nsRight 214
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/closet,cabinet]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 31 104) ; "A storage closet."
					)
					((Said 'open')
						(Print 31 105) ; "There's nothing of interest in there."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
		)
	)
)

(instance couch of RFeature
	(properties
		y 158
		x 103
		nsTop 141
		nsLeft 61
		nsBottom 176
		nsRight 145
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/couch]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 31 106) ; "A plush couch like this is only found in officer's quarters."
					)
					((Said 'sit')
						(Print 31 107) ; "This is no time for a break."
					)
				)
			)
		)
	)
)

(instance table of RFeature
	(properties
		y 132
		x 76
		nsTop 124
		nsLeft 56
		nsBottom 140
		nsRight 96
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/table]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 31 108) ; "A table."
					)
				)
			)
		)
	)
)

(instance nightstand of RFeature
	(properties
		y 127
		x 277
		nsTop 117
		nsLeft 261
		nsBottom 137
		nsRight 294
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/dresser]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 31 109) ; "The captain's nightstand."
					)
					((Said 'open')
						(Print 31 110) ; "No, it's private."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
		)
	)
)

