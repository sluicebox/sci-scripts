;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 106)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	otMoor 0
	footSnow 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(gSFX number: (proc0_20 49) loop: 1 play:)
	(= temp2 (gEgo x:))
	(= temp3 (gEgo y:))
	(= temp4 5)
	(= temp5 (gEgo loop:))
	(while 1
		(= temp0 (= temp1 0))
		(switch temp5
			(0
				(= temp0 temp4)
			)
			(1
				(= temp0 (- 0 temp4))
			)
			(2
				(= temp1 temp4)
			)
			(3
				(= temp1 (- 0 temp4))
			)
			(else
				(+= temp4 5)
				(= temp5 0)
			)
		)
		(if
			(or
				global119
				(& (OnControl CONTROL (+ temp2 temp0) (+ temp3 temp1)) $0400)
			)
			(= temp0 (- (+= temp0 temp2) 14))
			(= temp1 (- (+= temp1 temp3) 5))
			(break)
		else
			(++ temp5)
		)
	)
	(cond
		((> temp1 175)
			(= temp1 175)
		)
		((> temp0 305)
			(= temp0 305)
		)
		((< temp0 15)
			(= temp0 15)
		)
	)
	(DrawCel 26 5 (Random 0 3) temp0 temp1 0)
)

(instance iceBreak of Prop
	(properties
		view 26
		loop 4
	)
)

(instance footSnow of Prop
	(properties
		view 25
	)

	(method (doit)
		(self posn: (gEgo x:) (gEgo y:) setCel: (gEgo cel:))
		(super doit:)
	)
)

(instance horseSnow of Prop
	(properties
		view 411
	)

	(method (doit)
		(self posn: (gEgo x:) (gEgo y:) setCel: (gEgo cel:))
		(if (== (gEgo view:) 30)
			(if (< (gEgo loop:) 2)
				(self setLoop: 4)
			else
				(self setLoop: 5)
			)
		else
			(self setLoop: (gEgo loop:))
		)
		(super doit:)
	)
)

(instance hoofSnow of Prop
	(properties
		view 411
	)

	(method (doit)
		(self posn: (gMuleObj x:) (gMuleObj y:) setCel: (gMuleObj cel:))
		(if (== (gMuleObj view:) 412)
			(if (< (gMuleObj loop:) 2)
				(self setLoop: 4)
			else
				(self setLoop: 5)
			)
		else
			(self setLoop: (gMuleObj loop:))
		)
		(super doit:)
	)
)

(instance otMoor of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 26)
		(Load rsVIEW 25)
		(Load rsVIEW 0)
		(Load rsVIEW 411)
		(Load rsVIEW 502)
		(if (gEgo has: 7) ; crystal_heart | charcoal | helm
			(Load rsVIEW 127)
		)
		(Load rsSCRIPT 971)
		(if (gEgo has: 4) ; rose | apple | green_apple
			(Load rsSCRIPT 124)
		)
		(super init:)
		(gEgo view: 0 looper: 0 init:)
		(if (== global116 1)
			(horseSnow ignoreActors: init:)
		else
			(footSnow
				setLoop: (if (or (== gCurRoomNum 24) (== gCurRoomNum 25)) 0 else 1)
				ignoreActors:
				init:
			)
		)
		(if (and (IsFlag 20) (or (== gCurRoomNum 24) (== gCurRoomNum 25)))
			(gCurRoom setRegions: 115) ; muleReg
			(gMuleObj setScript: muleActions)
			(hoofSnow ignoreActors: init:)
		)
		(if (and global119 (>= 29 gCurRoomNum 23))
			(gCurRoom setRegions: 124) ; WhirlWind
		)
		(if global118
			(heart init: setScript: heartGlow)
		)
		(if (or (!= (gRegMusic number:) 48) (== (gRegMusic state:) 0))
			(gRegMusic number: 48 loop: -1 play:)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 124)
		(DisposeScript 106)
		(DisposeScript 113)
		(DisposeScript 116)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (gCast contains: horseSnow) (== global116 2))
				(horseSnow dispose:)
				(footSnow ignoreActors: init:)
			)
			((and (gCast contains: footSnow) (== global116 1))
				(footSnow dispose:)
				(horseSnow ignoreActors: init:)
			)
		)
		(cond
			((or global119 (and (== gCurRoomNum 26) (not global118))) 0)
			(
				(and
					(& (gEgo onControl:) $0200)
					(not (& (gEgo onControl: 1) $0400))
				)
				(= local1 0)
			)
			((and (& (gEgo onControl: 1) $0400) (< local2 6))
				(if (or (!= (gEgo x:) local3) (!= (gEgo y:) local4))
					(= local3 (gEgo x:))
					(= local4 (gEgo y:))
					(if (> (++ local1) 2)
						(= local1 0)
						(++ local2)
						(localproc_0)
					)
				)
			)
			(
				(or
					(& (gEgo onControl: 1) $0800)
					(and (& (gEgo onControl: 1) $0400) (>= local2 6))
				)
				(if (!= (gEgo script:) fallThruIce)
					(gEgo setScript: fallThruIce)
				)
			)
			(else
				(= local1 0)
			)
		)
	)

	(method (notify param1)
		(switch param1
			(0
				(localproc_0)
			)
			(1
				(if (!= (gEgo script:) fallThruIce)
					(gEgo setScript: fallThruIce)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(Said 'ask/merlin[/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(if (not (IsFlag 66))
					(Print 106 0) ; "There is but one explanation for this unnatural siege of winter upon the lake -- the mood of the Lady of the Lake has turned cold, and her power affects all that is around her."
				else
					(Print 106 1) ; "Though the Lady now has her heart and has turned once more to warmth and the natural seasons, it will take some time for the deep cold she laid upon this lake to pass away."
				)
			)
			((Said 'get/branch,stick')
				(Print 106 2) ; "There would be no purpose in that."
			)
			((Said 'talk,call/woman')
				(Print 106 3) ; "She is beyond your voice, Arthur."
			)
			((Said 'listen')
				(Print 106 4) ; "All is quiet here, as though nature itself is frozen into silence."
			)
			((Said 'look/ice')
				(Print 106 5) ; "The glare and sparkle of the ice dazzles your eyes."
			)
			((or (Said 'look/maze,path') (Said 'find,walk/path,maze'))
				(Print 106 6) ; "No such thing can be seen."
			)
			((Said 'look<across/lake,moor,ot')
				(Print 106 7 #icon 502 0 0) ; "A glittering palace of ice rises from the center of the lake."
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
			((or (Said 'talk,ask[/merlin]>') (Said 'tell[/me]>') (Said 'look>'))
				(cond
					((and global118 (or (Said '/heart') (Said '//heart')))
						(Print 106 8) ; "The heart glows with colour as power flows through it. Study it carefully."
					)
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/moor,ot')
							(Said '//moor,ot')
						)
						(Print 106 9) ; "You are surrounded by what looks like solid ice, but it could break beneath your feet at any moment. Ridges of ice have been thrust up in places."
					)
					((or (Said '/woman') (Said '//woman'))
						(Print 106 10) ; "As an elemental enchantress, she can have more than one form. In her usual watery form, she is known as the Lady of the Lake."
						(Print 106 11) ; "And since her form usually reflects her mood, I would say that something is seriously wrong."
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(Print 106 12) ; "He has always had the special favour of the Lady of the Lake. Yet she is possessive and surely is not pleased with his love for Gwenhyver."
					)
					((or (Said '/lake') (Said '//lake'))
						(Print 106 13) ; "The lake which forms Ot Moor is frozen over."
					)
					((or (Said '/castle') (Said '//castle'))
						(Print 106 14 #icon 502 0 0) ; "The spires and peaks of this cold palace have grown from the ice by the power of the Lady of the Lake. It lies north and slightly west of the shore in the center of the lake."
					)
					((or (Said '/north,west') (Said '//north,west'))
						(Print 106 15) ; "A glittering Palace made of ice has been created from the lake itself."
					)
					((or (Said '/east,south') (Said '//east,south'))
						(Print 106 16) ; "There is naught but glaring ice and bitter cold."
					)
					((or (Said '/ice') (Said '//ice'))
						(Print 106 17) ; "It is made of frozen water. I thought you knew that."
					)
					((or (Said '/chunk,mesa') (Said '//chunk,mesa'))
						(Print 106 18) ; "It is simply ice pushed upward into a ridge by the pressure of freezing too quickly."
					)
					((or (Said '/snow') (Said '//snow'))
						(Print 106 19) ; "The area immediately around Ot Moor is blanketed with snow, which is quite unusual, considering that it is summer."
					)
					((or (Said '/tree,bush') (Said '//tree,bush'))
						(Print 106 20) ; "Everything is covered with snow and ice."
					)
					((or (Said '/slab,boulder') (Said '//slab,boulder'))
						(Print 106 21) ; "None can be seen with all this snow and ice."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'use/rose')
				(if (not (gEgo has: 4)) ; rose | apple | green_apple
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				else
					(Print 106 22) ; "Aye, I sense a spell of guidance upon the rose, but it was placed there by Gwenhyver. You must speak the Message of the Rose to invoke its spell."
				)
			)
			((Said 'get,find/message')
				(Print 106 23) ; "Perhaps you should consult your Liber ex Doctrina."
			)
			((Said 'invoke,talk/incantation')
				(if (gEgo has: 4) ; rose | apple | green_apple
					(Print 106 24) ; "Only the Message of the Rose can invoke the spell placed upon this flower. Perhaps you should consult your Liber ex Doctrina."
				else
					(Print 106 25) ; "I have no spells to offer you, Arthur, nothing save advice. This is your task alone."
				)
			)
			((Said 'love//shield<my<are')
				(cond
					((not (gEgo has: 4)) ; rose | apple | green_apple
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					(global119
						(Print 106 26) ; "The spell is in effect! Stay within the whirlwind of petals or you will lose its protection."
					)
					((or (== gCurRoomNum 24) (== gCurRoomNum 25) (== gCurRoomNum 29))
						(Print 106 27) ; "The rose trembles with the spell of the incantation, but the place is not quite right for it to work."
					)
					(else
						(if global118
							(= global118 0)
							(heart dispose:)
							(ClearFlag 68)
						)
						(SetScore 261 1 2)
						(gCurRoom setRegions: 124) ; WhirlWind
						((ScriptID 124) notify: 2) ; WhirlWind
					)
				)
			)
			((Said 'use/heart')
				(cond
					((not (gEgo has: 7)) ; crystal_heart | charcoal | helm
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((== gCurRoomNum 29)
						(Print 106 28) ; "It is cold as ice, clear as crystal in your hand. It pulls you toward the Ice Palace, as though eager to go within."
					)
					((or (== gCurRoomNum 24) (== gCurRoomNum 25))
						(Print 106 29) ; "There are faint stirrings of color within the heart, flashes of golden and purple light. I sense it is caused by the nearness of the frozen lake. The ice calls to it."
					)
					(global118
						(Print 106 30) ; "You ARE using it."
					)
					(else
						(if global119
							(= global119 0)
							(SetFlag 68)
							((ScriptID 124) notify: 3) ; WhirlWind
						)
						(SetScore 261 1 2)
						(= global118 1)
						(heart init: setScript: heartGlow)
					)
				)
			)
			(
				(and
					(IsFlag 20)
					(or
						(Said 'get/pack,water,food,clothes,blanket')
						(Said 'drink/water')
						(Said 'eat/food')
					)
				)
				(Print 106 31) ; "Fortunately, you had time on the journey here to eat, drink, rest, and don your warmer clothing as it grew colder."
			)
			((Said 'smell')
				(Print 106 32) ; "It is so cold, your nose aches too much to smell anything."
			)
			((Said 'light,make,make/fire')
				(Print 106 33) ; "Nothing here will burn. Better to do what you must as quickly as possible and be gone."
			)
		)
	)
)

(instance heart of Prop
	(properties
		y 182
		x 283
		view 127
		signal 16
	)
)

(instance heartGlow of Script
	(properties)

	(method (init)
		(super init:)
		(heart setPri: 15)
	)

	(method (doit)
		(cond
			((and (!= (heart loop:) 0) (== (& (gEgo onControl: 1) $0400) 0))
				(heart setLoop: 0)
			)
			((and (!= (heart loop:) 1) (& (gEgo onControl: 1) $0400))
				(heart setLoop: 1)
			)
			((and (!= (heart loop:) 2) (== (gEgo script:) fallThruIce))
				(heart setLoop: 2)
			)
		)
	)
)

(instance fallThruIce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 26 setCel: 0 setMotion: 0 setCycle: End)
				(iceBreak
					view: 26
					setLoop: 4
					setCel: 0
					posn: (gEgo x:) (+ (gEgo y:) 6)
					setPri: 0
					init:
					setCycle: End self
				)
				(gSFX stop: number: (proc0_20 50) loop: 1 play:)
			)
			(1
				(= cycles 10)
			)
			(2
				(EgoDead 106 34) ; "Across thin ice you dared to tread, 'tis no surprise that you are dead."
			)
		)
	)
)

(instance muleActions of Script
	(properties)

	(method (doit &tmp temp0)
		(= temp0 0)
		(cond
			((gMuleObj mover:) 0)
			((> (- (gMuleObj x:) (gEgo x:)) 70)
				(= temp0 50)
			)
			((> (- (gEgo x:) (gMuleObj x:)) 70)
				(= temp0 -50)
			)
		)
		(if temp0
			(gMuleObj setMotion: MoveTo (+ (gEgo x:) temp0) (gMuleObj y:))
		)
		(super doit:)
	)
)

