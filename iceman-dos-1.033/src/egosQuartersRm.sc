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
(use Actor)
(use System)

(public
	egosQuartersRm 0
)

(local
	[local0 55] = [0 0 0 0 0 0 0 0 {} {DESTROY} {COONTZ} {DEGREE} {COURSE} {SHIP} {LATITUDE} {RUSSIAN} {REDWOOD} {4100} {TACTIC} {WAR} {STEER} {DIRECTLY} {ARIZONA} {OCEAN} {} {destroy} {coontz} {degree} {course} {ship} {latitude} {russian} {redwood} {4100} {tactic} {war} {steer} {directly} {arizona} {ocean} 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
	local55
	local56
	local57
	[local58 15]
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
		(= local56 (Random 0 1))
		(gEgo init: observeControl: 2 view: 232 setPri: -1)
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
		(map init:)
		(wallPic init:)
		(gAddToPics doit:)
		(entryDoor init: ignoreActors: 1 stopUpd:)
		(bathDoor init: cel: 0 stopUpd: ignoreActors: 1)
		(proc316_0 gCurRoomNum 14 13)
		(computer init:)
		(credenza init: setPri: 5 stopUpd:)
		(codeBook init: cel: (if (gEgo has: 14) 1 else 0)) ; Sub: Code_Book | Tunisia: Note
		(microMeterView init:)
		(drawerView init: hide:)
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
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene]')
				(if (and (> (gEgo x:) (bathDoor x:)) (< (gEgo y:) 120))
					(Print 31 0) ; "You are in the bathroom."
				else
					(Print 31 1) ; "This is the Executive Officer's cabin, which happens to be assigned to Commander John Westland."
					(Print 31 2) ; "The cabin is equipped with a bunk, closet, desk and bookshelf."
				)
			)
		)
	)

	(method (dispose)
		(gEgo ignoreControl: 2)
		(super dispose:)
	)
)

(instance justGotOnSubScript of Script
	(properties
		seconds 3
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(bathDoor setCycle: End self)
			)
			(2
				(HandsOff)
				(Print 31 3 #time 5 #at -1 20 #dispose) ; "You go to your quarters and change clothes."
				(gEgo ignoreControl: 2 setMotion: MoveTo 245 115 self)
			)
			(3
				(bathDoor setCycle: Beg self)
			)
			(4
				(gEgo observeControl: 2)
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 31 4) ; "The door to this cabin."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
					((> (gEgo x:) (bathDoor x:)))
					((GoToIfSaid self event 55 123 'open' 31 5))
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

	(method (cue)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door<bathroom]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 31 6) ; "The bathroom door."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
					(
						(and
							(< (gEgo x:) x)
							(GoToIfSaid self event stupidAvoider 3 'open' 31 5)
						))
					((and (>= (gEgo x:) x) (Said 'open'))
						(self setScript: bathDoorScript)
					)
					((Said 'open')
						(self setScript: bathDoorScript)
					)
				)
			)
		)
	)
)

(instance egosInBathRoom of Script
	(properties)

	(method (handleEvent event)
		(cond
			((Said 'look[<at,around][/room]')
				(Print 31 7) ; "You look around the small but adequate bathroom facility."
				(Print 31 8) ; "It is equipped with a small sink, mirror, shower and marine toilet. There is a small warning light above the toilet."
			)
			((Said 'look/sink')
				(Print 31 9) ; "It's small and made of stainless steel."
			)
			((or (Said 'use/sink') (Said 'wash[/hand]') (Said 'turn<on/water'))
				(Print 31 10) ; "In an effort to conserve the water supply, you quickly wash your hands then turn off the water."
			)
			((Said 'look/mirror')
				(Print 31 11) ; "You look into the mirror and think, "Yep, I still look the same.""
			)
			((Said 'comb/hair')
				(Print 31 12) ; "Since cleanliness and grooming are part of Navy life, you look into the mirror and comb your hair."
			)
			((Said 'look/shower')
				(Print 31 13) ; "The only thing special about this shower is that it's small."
			)
			((Said '(turn<on),use,get/shower')
				(Print 31 14) ; "In record time you take a hot shower."
			)
			((Said 'look/light')
				(Print 31 15) ; "This is a typical marine toilet that dumps waste into the ship's holding tanks."
				(Print 31 16) ; "When the holding tanks are full, they are pressurized to force the waste into the open ocean."
				(Print 31 17) ; "If you flush the toilet when this light is on, the pressure will cause the contents of the holding tanks to be forcibly expelled through your toilet."
				(if local56
					(Print 31 18) ; "The light is currently on."
				else
					(Print 31 19) ; "The light is currently not on."
				)
			)
			((Said 'look/toilet')
				(Print 31 15) ; "This is a typical marine toilet that dumps waste into the ship's holding tanks."
				(Print 31 16) ; "When the holding tanks are full, they are pressurized to force the waste into the open ocean."
				(Print 31 20) ; "It is highly recommended that the toilet not be flushed when the tanks are pressurized."
			)
			((Said 'flush[/toilet]')
				(cond
					(local55
						(= local55 0)
						(flushNoise play:)
						(Print 31 21) ; "Your failure to follow explicit instruction has left you a stinking mess."
						(Print 31 22) ; "As you hurriedly clean the enormous amount of human waste off your body, we are busy deducting 3 points from your score."
						(gGame changeScore: -3)
					)
					(local56
						(Print 31 23) ; "The holding tanks are pressurized. Flushing is not recommended."
						(= local56 (Random 0 1))
						(= local55 1)
					)
					(else
						(Print 31 24) ; "You flush the toilet."
						(= local56 (Random 0 1))
					)
				)
			)
			((Said 'sit,use/toilet,bathroom')
				(Print 31 25) ; "You use the toilet, flush it, then wash your hands."
			)
			((or (Said 'leak') (Said 'get//leak'))
				(Print 31 26) ; "Step closer, Johnny, it's shorter than you think."
			)
			((or (Said 'shit') (Said 'get//shit'))
				(Print 31 27) ; "The human process of waste elimination has made you two pounds lighter."
			)
			((Said 'get/*')
				(Print 31 28) ; "You don't need it."
			)
			((Said 'look/*')
				(Print 31 29) ; "That's not important to you now."
			)
			((Said 'open[/door]>')
				(bathDoor handleEvent: event)
			)
			((Said '*')
				(Print 31 30) ; "Not in here."
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
				(HandsOff)
				(client setCycle: End self)
			)
			(1
				(= register (< (gEgo x:) (client x:)))
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (if register 298 else 253) 117 self
				)
			)
			(2
				(client setCycle: Beg client)
				(HandsOn)
				(gEgo
					observeControl: 2 -32768
					setScript: (and (> (gEgo x:) (client x:)) egosInBathRoom)
				)
				(self dispose:)
			)
		)
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
			((Said '[/book[<code,decode]]>')
				(cond
					((Said 'read,open')
						(if (gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
							((gInventory at: 14) showSelf:) ; Sub: Code_Book | Tunisia: Note
						else
							(event claimed: 0)
						)
					)
					((not (credenza cel:)))
					((and cel (not (event modifiers:)) (Said 'look[<at]'))
						(event claimed: 0)
					)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if cel
							(Print 31 31) ; "Most of the books consist of boring governmental directives."
						else
							(Print 31 32) ; "Most of the books consist of boring governmental directives. However, one that catches your eye is entitled, "Decoding.""
						)
					)
					((GoToIfSaid self event 235 115 'get' 31 5))
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
				(Print 31 33) ; "You remove the "Decoding" book from the shelf."
				(gEgo get: 14) ; Sub: Code_Book | Tunisia: Note
				(codeBook cel: 1 forceUpd:)
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
				(Print 31 34) ; "You replace the "Decoding" book on the shelf."
				(gEgo put: 14 gCurRoomNum) ; Sub: Code_Book | Tunisia: Note
				(codeBook cel: 0 forceUpd:)
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
			((TurnIfSaid self event 'look[<at]/painting'))
			((Said 'look[<at][/wall,painting]')
				(Print 31 35) ; "A decorative picture of a submarine."
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
				(Print 31 36) ; "A map of the world."
			)
			((Said 'move/map,painting')
				(proc0_39) ; "You don't need to do that."
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
				(Print 31 37) ; "It is very purple and "thing-like.""
			)
			((Said 'look[<at][/thing]')
				(Print 31 38) ; "The purple thing on the wall is the result of an artist with too much free time."
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
				(Print 31 39) ; "The desk is equipped with a drawer. On the desk is a small computer."
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
				(Print 31 40) ; "It's the latest in submarine slumber."
			)
			((Said 'look<below/bunk,bed')
				(Print 31 41) ; "Hope the commander doesn't see this dirt."
			)
			((Said 'sit[<on,down][/bed,bunk]')
				(Print 31 42) ; "This is no time for a break."
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
						(Print 31 43) ; "A typical desk drawer."
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
									(Print 31 44) ; "In the drawer you see a vernier caliper."
								else
									(Print 31 45) ; "The drawer is currently empty."
								)
							)
							((proc316_1 gCurRoomNum 13)
								(Print 31 44) ; "In the drawer you see a vernier caliper."
							)
							(else
								(Print 31 45) ; "The drawer is currently empty."
							)
						)
					)
					((GoToIfSaid self event 239 120 0 31 5))
					((Said 'open')
						(gEgo heading: 0)
						((gEgo looper:) doit: gEgo (gEgo heading:))
						(drawerView show:)
						(if (proc316_1 gCurRoomNum 13)
							(Print 31 46) ; "You open the drawer and see a vernier caliper."
						else
							(Print 31 47) ; "You open the drawer."
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
		(microMeterView hide:)
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
			((TurnIfSaid self event 'look[<at]/caliper'))
			((GoToIfSaid self event 239 120 'get,adjust/caliper' 31 5))
			((Said 'get/caliper')
				(if (proc316_1 gCurRoomNum 13)
					(self hide:)
					(gEgo get: 13) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					(SetScore subMarine 406 1 1)
				else
					(proc0_35) ; "You already took that."
				)
			)
			((Said 'adjust/caliper[<in][/drawer]')
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
					((Said 'look[<at,in]')
						(cond
							((not cel)
								(Print 31 48) ; "You see your bookshelf on the wall."
							)
							((gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
								(Print 31 31) ; "Most of the books consist of boring governmental directives."
							)
							(else
								(Print 31 32) ; "Most of the books consist of boring governmental directives. However, one that catches your eye is entitled, "Decoding.""
							)
						)
					)
					((GoToIfSaid self event 235 115 0 31 5))
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
					((TurnIfSaid self event 'adjust'))
					((GoToIfSaid self event 235 115 'adjust' 31 5))
					((Said 'adjust')
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
						(Print 31 49) ; "This computer is used for decoding messages."
					)
					((GoToIfSaid self event 232 115 0 31 5))
					((Said 'use,(turn<on)/*')
						(if script
							(Print 31 50) ; "It's on!"
						else
							(computer setScript: (ScriptID 386)) ; computerOn
						)
					)
				)
			)
			((Said 'decode')
				(Print 31 51) ; "You must use the computer to do that."
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
						(Print 31 52) ; "A storage closet."
					)
					((Said 'unlock,open,(look<in)')
						(Print 31 53) ; "There's nothing of interest in there."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 31 54) ; "A plush couch like this is found only in officer's quarters."
					)
					((Said 'sit[<down,on][/couch]')
						(Print 31 42) ; "This is no time for a break."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 31 55) ; "A table."
					)
					((Said 'look<below')
						(Print 31 56) ; "Amazingly four legs hold up a table."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 31 57) ; "Your nightstand."
					)
					((Said 'open')
						(proc0_39) ; "You don't need to do that."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
		)
	)
)

(instance stupidAvoider of Feature
	(properties
		y 117
		x 253
	)
)

