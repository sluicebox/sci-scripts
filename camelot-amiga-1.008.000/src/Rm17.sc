;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm17 0
)

(synonyms
	(boulder slab)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12 = 10
	[local13 3] = [1 0 3]
	[local16 3] = [310 10 150]
	[local19 3] = [100 80 186]
	[local22 3] = [290 40 150]
	[local25 3] = [100 100 160]
	[local28 3] = [310 40 130]
	[local31 3] = [80 84 189]
	[local34 3] = [290 40 130]
	[local37 3] = [80 84 160]
	local40
)

(procedure (localproc_0 &tmp temp0)
	(if (== global116 1)
		(= local9 20)
	else
		(= local9 0)
	)
	(= temp0
		(cond
			((gEgo inRect: 65 113 (+ 115 local9) 130) 1)
			((gEgo inRect: 105 97 (+ 165 local9) 112) 2)
			((gEgo inRect: 150 76 (+ 200 local9) 96) 3)
			((gEgo inRect: 180 57 (+ 230 local9) 75) 4)
			((gEgo inRect: 160 40 (+ 210 local9) 56) 5)
			(else 0)
		)
	)
)

(procedure (localproc_1 param1)
	(if (== (param1 loop:) 6)
		(Print 17 45) ; "There are five of these stones, each roughly man-sized. Perhaps they WERE men once."
	else
		(Print 17 46) ; "The magical glow around this stone means that you have solved its riddle."
	)
)

(procedure (localproc_2)
	(= local7 1)
	(if local0
		(SetFlag 75)
		(gTObj noTimer: 1 noWidth: 1)
		(Talk 804 local0)
	else
		(Print 17 46) ; "The magical glow around this stone means that you have solved its riddle."
	)
)

(procedure (localproc_3)
	(gTObj noWidth: 1 noTimer: 0)
	(Talk 804 (Random 26 29))
	(ClearFlag 75)
	(= local1 0)
	(= local0 0)
)

(procedure (localproc_4)
	(switch local1
		(1
			(= local2 0)
			(stone1 loop: 1 posn: 83 117 setCycle: Fwd)
		)
		(2
			(= local3 0)
			(stone2 loop: 2 posn: 131 107 setCycle: Fwd)
		)
		(3
			(= local4 0)
			(stone3 loop: 3 posn: 171 86 setCycle: Fwd)
		)
		(4
			(= local5 0)
			(stone4 loop: 4 posn: 188 65 setCycle: Fwd)
		)
		(5
			(= local6 0)
			(stone5 loop: 5 posn: 171 54 setCycle: Fwd)
		)
	)
	(++ local8)
	(ClearFlag 75)
	(= global213 0)
	(switch local8
		(1
			(= global213 41)
			(SetScore 251 1 3)
		)
		(2
			(= global213 42)
			(SetScore 252 1 3)
		)
		(3
			(= global213 43)
			(SetScore 253 1 3)
		)
		(4
			(= global213 44)
			(SetScore 254 1 3)
		)
		(5
			(= global213 45)
			(SetScore 255 1 3)
		)
	)
	(if global213
		(gRmMusic number: global213 loop: -1 play:)
	)
	(gTObj noTimer: 0 endTalk:)
	(if (== local8 1)
		(HandsOff)
		(SetFlag 326)
	)
	(= local0 0)
)

(instance riddleWindow of SysWindow
	(properties
		color 15
		back 6
		title {Riddle Stone}
		brLeft 115
		brBottom 300
		brRight 315
	)
)

(instance stone1 of Prop
	(properties
		y 117
		x 65
		view 117
		loop 6
		signal 16384
	)
)

(instance stone2 of Prop
	(properties
		y 107
		x 116
		view 117
		loop 6
		cel 1
		signal 16384
	)
)

(instance stone3 of Prop
	(properties
		y 86
		x 160
		view 117
		loop 6
		cel 2
		signal 16384
	)
)

(instance stone4 of Prop
	(properties
		y 65
		x 180
		view 117
		loop 6
		cel 3
		signal 16384
	)
)

(instance stone5 of Prop
	(properties
		y 54
		x 163
		view 117
		loop 6
		cel 4
		signal 16384
	)
)

(instance Rm17 of Rm
	(properties
		picture 17
	)

	(method (init &tmp temp0)
		(Load rsVIEW 117)
		(Load rsVIEW 61)
		(Load rsSCRIPT 969)
		(Load rsSCRIPT 205)
		(Load rsSOUND 40)
		(super init:)
		(ClearFlag 326)
		(ClearFlag 319)
		(= temp0 0)
		(if (and (>= 21 gPrevRoomNum 18) (== global115 gCurRoomNum))
			(= global115 0)
			(= global116 0)
			(= temp0 1)
		)
		(if (and (== global115 15) (!= global116 1))
			(= global115 0)
			(= global116 0)
		)
		(if (< 17 gPrevRoomNum 23)
			(= global124 0)
		)
		(if (IsFlag 20)
			(self setRegions: 102) ; forestPerilous
			(gMuleObj setScript: muleActions)
		else
			(SetFlag 20)
			(self setRegions: 102) ; forestPerilous
			(gMuleObj
				view: 410
				loop: 3
				cycleSpeed: 3
				posn: 130 74
				setCycle: Fwd
				setScript: muleHeadsUp
			)
			(= local11 1)
		)
		(proc0_13 32)
		(= local2 (Random 1 5))
		(= local3 (Random 6 10))
		(= local4 (Random 11 15))
		(= local5 (Random 16 20))
		(= local6 (Random 21 25))
		(stone1 init: stopUpd:)
		(stone2 init: stopUpd:)
		(stone3 init: stopUpd:)
		(stone4 init: stopUpd:)
		(stone5 init: stopUpd:)
		(switch gPrevRoomNum
			(19
				(= local10 1)
			)
			(20
				(= local10 1)
			)
			(21
				(= local10 1)
			)
			(22
				(= local10 1)
			)
			(103
				(= local10 2)
			)
		)
		(gEgo
			loop: [local13 local10]
			posn: [local16 local10] [local19 local10]
			init:
			setMotion: MoveTo [local22 local10] [local25 local10]
		)
		(if (and (IsFlag 20) (not local11))
			(gMuleObj
				view: 405
				loop: [local13 local10]
				posn: [local28 local10] [local31 local10]
				cycleSpeed: 0
				setCycle: Walk
				setMotion: MoveTo [local34 local10] [local37 local10]
			)
		)
		(gTObj tWindow: riddleWindow)
		(proc0_13 32)
		(gAddToPics doit:)
		(if temp0
			(Print 17 0) ; "Your sudden disappearance was too much for even your well-trained horse. He has run all the way back to Camelot."
		)
	)

	(method (newRoom newRoomNumber)
		(ClearFlag 75)
		(if (not (IsFlag 50))
			(ClearFlag 20)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (and (IsFlag 326) (not (-- local12)))
			(ClearFlag 326)
			(Print 17 1) ; "The eerie glow must mean that you have solved this stone's riddle."
			(HandsOn)
		)
		(cond
			((gEgo script:) 0)
			(
				(and
					(& (gEgo onControl:) $4000)
					(!= local8 5)
					(not (IsFlag 50))
				)
				(gEgo setScript: (ScriptID 205 0)) ; wallFlash
			)
			((and (& (gEgo onControl:) $0002) (not (IsFlag 50)))
				(gEgo setScript: egoDisappear)
			)
			(
				(and
					(IsFlag 50)
					(gMuleObj script:)
					(> (gEgo x:) 280)
					(!= gPrevRoomNum 16)
				)
				(gEgo setScript: leaveTheRoom)
			)
			((> (gEgo x:) 310)
				(SetFlag 43)
				(gCurRoom newRoom: 16)
			)
			(
				(and
					(IsFlag 50)
					(gMuleObj script:)
					(> (gEgo y:) 175)
					(!= gPrevRoomNum 103)
				)
				(= local40 1)
				(gEgo setScript: leaveTheRoom)
			)
			((> (gEgo y:) 186)
				(SetFlag 43)
				(gCurRoom newRoom: 103)
			)
			((< (gEgo x:) 5)
				(SetFlag 43)
				(gCurRoom newRoom: (Random 19 22))
			)
		)
		(if gModelessDialog
			(= local9 (if (== global116 1) 20 else 0))
			(if (not (localproc_0))
				(= local1 0)
				(= local0 0)
				(ClearFlag 75)
				(gTObj endTalk:)
			)
		)
	)

	(method (notify)
		(if (not local0)
			(return 0)
		else
			(localproc_3)
			(return 1)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
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
			((Said 'ask/boulder/*<about')
				(gEgo setScript: StoneTalk)
			)
			((Said 'ask/merlin/riddle<about')
				(if local7
					(Print 17 2) ; "I cannot help you here."
				else
					(Print 17 3) ; "What riddle? Your request is a riddle to me."
				)
			)
			(
				(or
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(cond
					(local7
						(Print 17 4) ; "Only so much help can I give. This is your test and yours alone."
					)
					((IsFlag 319)
						(Print 17 5) ; "There is some sort of sorcerous barrier barring you from the Tor."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'read,look/boulder')
				(Print 17 6) ; "There are no markings or carvings upon them. They are quite plain."
			)
			((Said 'read,look,find/riddle')
				(Print 17 7) ; "The only riddle to read here is that there is no riddle here to read."
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look[<around][/room,forest]')
							(Said '//room,forest')
						)
						(if (IsFlag 43)
							(Print 17 8) ; "You are once more at the base of Glastonbury Tor."
						else
							(Print 17 9 #at 100 120) ; "You have reached the base of Glastonbury Tor on the edge of the Forest Perilous."
							(Print 17 10 #at 100 120) ; "And I see your mule grazes as it waits for you. She must have found her way safely through the forest on her own."
						)
					)
					((Said '<below/boulder')
						(Print 17 11) ; "These stones were placed here by magick. You will not move them by human means."
					)
					((Said '<above/boulder')
						(Print 17 12) ; "Easy to do, but to little purpose."
					)
					((Said '<up')
						(Print 17 13) ; "You are out of the Forest Perilous with an open sky overhead."
					)
					(
						(or
							(and
								(gCast contains: gMuleObj)
								(MouseClaimed gMuleObj event)
							)
							(Said '/ass')
							(Said '//ass')
						)
						(Print 17 14) ; "I suspect your mule is more intelligent than she appears."
					)
					((MouseClaimed stone1 event)
						(localproc_1 stone1)
					)
					((MouseClaimed stone2 event)
						(localproc_1 stone2)
					)
					((MouseClaimed stone3 event)
						(localproc_1 stone3)
					)
					((MouseClaimed stone4 event)
						(localproc_1 stone4)
					)
					((MouseClaimed stone5 event)
						(localproc_1 stone5)
					)
					(
						(or
							(OnButton event 240 80 285 180)
							(OnButton event 180 130 311 189)
							(OnButton event 0 100 70 189)
							(OnButton event 87 69 113 87)
							(OnButton event 122 7 295 45)
							(Said '/tree')
							(Said '//tree')
						)
						(Print 17 15) ; "The larger trees have been left behind in the forest. These are mere shrubs in comparison."
					)
					(
						(or
							(Said '/barrier,enchantment,light,glimmer,effect')
							(Said '//barrier,enchantment,light,glimmer,effect')
						)
						(cond
							(local8
								(Print 17 16) ; "The magical glow around the stone must mean that you have solved its riddle."
							)
							((IsFlag 319)
								(Print 17 17) ; "That effect is the mystical barrier which prevents you from climbing the Tor."
							)
							(else
								(Print 17 18) ; "Where? I see nothing."
							)
						)
					)
					((OnButton event 283 22 311 45)
						(Print 17 19) ; "This clump of rock looks quite ordinary."
					)
					((or (Said '/boulder') (Said '//boulder'))
						(if (gEgo inRect: 270 0 320 70)
							(Print 17 19) ; "This clump of rock looks quite ordinary."
						else
							(Print 17 20) ; "There are five of these standing stones."
						)
					)
					((or (Said '/riddle') (Said '//riddle'))
						(Print 17 7) ; "The only riddle to read here is that there is no riddle here to read."
					)
					((or (Said '/poet') (Said '//poet'))
						(if (IsFlag 38)
							(Print 17 21) ; "As you have cleverly realized, these five stones were once men. Their riddles mark them as poets."
						else
							(Print 17 22) ; "I see no other human being here."
						)
					)
					((or (Said '/charger') (Said '//charger'))
						(cond
							((== global200 2)
								(Print 17 23) ; "Have you forgotten already? You sent Gawaine back to Camelot upon it."
							)
							((>= 21 gPrevRoomNum 18)
								(Print 17 24) ; "I would hazard that your sudden disappearance spooked it, and that it is halfway home by now."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					(
						(or
							(Said '/glastenbury,glastenbury')
							(Said '//glastenbury,glastenbury')
						)
						(Print 17 25) ; "Beyond the standing stones the base of the tor rises steeply."
					)
				)
			)
			((Said 'get/boulder')
				(Print 17 26) ; "You have neither the time or tools for such a venture."
			)
			((Said 'draw/blade')
				(if (== local8 5)
					(event claimed: 0)
				else
					(Print 17 27) ; "This is not a barrier that you can hack your way through with Excaliber."
					(= global125 2)
				)
			)
			((or (Said 'give/coin,dinar,dirham,copper') (Said 'give/moneybag'))
				(if (not (DoPurse))
					0
				else
					(Print 17 28) ; "I doubt a stone has much use for it."
					(proc0_18)
				)
			)
			((Said 'find/ass')
				(Print 17 29) ; "She looks content grazing her way through a goodly section of Glastonbury Tor."
			)
			((Said 'call,whistle,cajole/ass')
				(if (IsFlag 50)
					(Print 17 30) ; "No need. She will follow now, I think."
				else
					(Print 17 31) ; "She does not seem to pay much attention."
				)
			)
			((Said 'get,pull,carry,force/ass')
				(Print 17 32) ; "Mules are obstinate creatures. At best, you can hope she will follow of her own will."
			)
			((or (Said 'get,drink/water') (Said 'get,eat/food,pack'))
				(if (IsFlag 49)
					(event claimed: 0)
				else
					(Print 17 33) ; "Bend your will to your mission. Everything else can wait for the time being."
				)
			)
			((Said 'smell')
				(Print 17 34) ; "There is the smell of grass and fresh air."
			)
			((Said 'piss<on/boulder')
				(Print 17 35) ; "Had you been turned to stone, would you appreciate such a thing?"
			)
			(
				(and
					(not (IsFlag 38))
					(or (Said 'ask/poet') (Said 'get/riddle/poet'))
				)
				(if local1
					(Print 17 36) ; "I see no poet, unless you perceive something that I do not."
				else
					(Print 17 37) ; "Nothing happens. Perhaps you are not close enough to one of the stoned poets."
				)
			)
			(
				(or
					(Said 'talk/boulder,poet')
					(Said 'ask/boulder/riddle')
					(Said 'get/riddle/boulder')
					(and
						(IsFlag 38)
						(or (Said 'get/riddle/poet') (Said 'ask/poet/riddle'))
					)
				)
				(if (IsFlag 50)
					(Print 17 38) ; "With the spell broken, the stones maintain a sullen silence."
				else
					(SetFlag 38)
					(if (= local1 (localproc_0))
						(= local0
							(switch local1
								(1 local2)
								(2 local3)
								(3 local4)
								(4 local5)
								(5 local6)
							)
						)
						(localproc_2)
					else
						(Print 17 39) ; "Move closer to a stone."
					)
				)
			)
			((or (Said 'get,ask/riddle') (Said 'give/riddle<me'))
				(Print 17 40) ; "Arthur, this is no time to ask me for something as frivolous as a riddle."
			)
			((Said 'talk/man')
				(Print 17 41) ; "There is no man here."
			)
			((and local0 (== (event type:) evSAID))
				(if
					(= temp0
						(switch local0
							(1
								(Said 'water')
							)
							(2
								(Said '/iceberg')
							)
							(3
								(Said '/gauntlet')
							)
							(4
								(Said '/snail')
							)
							(5
								(Said '/candelabra')
							)
							(6
								(Said '/riddle')
							)
							(7
								(Said '/boat')
							)
							(8
								(Said '/heart')
							)
							(9
								(Said '/key,lock')
							)
							(10
								(Said '/net')
							)
							(11
								(Said '/mirror')
							)
							(12
								(Said '/dinar')
							)
							(13
								(Said '/icicle')
							)
							(14
								(Said '/arrow,arrow')
							)
							(15
								(Said '/wine,grape')
							)
							(16
								(Said '/fire')
							)
							(17
								(Said '/shade')
							)
							(18
								(Said '/waterfall,ocean,breaker')
							)
							(19
								(Said '/echo')
							)
							(20
								(Said '/pearl')
							)
							(21
								(Said '/time')
							)
							(22
								(Said '/air')
							)
							(23
								(Said '/blue')
							)
							(24
								(Said '/wheel,lodestone')
							)
							(25
								(Said '/music')
							)
							(26
								(Said '/tortoise')
							)
						)
					)
					(clr)
					(localproc_4)
				else
					(event claimed: 1)
					(localproc_3)
				)
			)
		)
	)
)

(instance egoDisappear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== global116 1)
					(if (!= (gEgo loop:) 1)
						(gEgo
							setMotion: MoveTo (- (gEgo x:) 1) (gEgo y:)
						)
					)
					(gEgo loop: 2)
				else
					(gEgo loop: 0)
				)
				(gEgo view: 20 setCycle: End self)
				(gRmMusic number: (proc0_20 51) loop: 1 play:)
			)
			(1
				(= seconds 3)
			)
			(2
				(Print 17 42 #at 70 140) ; "Arthur? Arthur! Where are you?"
				(= seconds 3)
			)
			(3
				(SetFlag 43)
				(if (== global116 1)
					(= global116 0)
				)
				(gCurRoom newRoom: 18)
			)
		)
	)
)

(instance muleHeadsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== global103 0)
						(gMuleObj loop: 0 cel: 0 setCycle: 0 stopUpd:)
					)
					((== local8 5)
						(= cycles 1)
					)
					(else
						(= seconds (Random 3 10))
					)
				)
			)
			(1
				(gMuleObj loop: 1 cel: 4 cycleSpeed: 0 setCycle: Beg self)
			)
			(2
				(if (== local8 5)
					(= local11 0)
					(gMuleObj stopUpd: setScript: 0)
				else
					(= seconds 2)
				)
			)
			(3
				(gMuleObj setCycle: End self)
			)
			(4
				(gMuleObj loop: 3 cycleSpeed: 3 setCycle: Fwd)
				(self changeState: 0)
			)
		)
	)
)

(instance StoneTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTObj noWidth: 1 talkCue: self)
				(Talk 17 43) ; "Once we were poets, Men free and gay, The witch has left us Stony and grey, And now we pose riddles, To block the way."
			)
			(1
				(Print 17 44) ; "Hmmph. If that is a sample of their poetry, they deserve their fate."
				(gEgo setScript: 0)
			)
		)
	)
)

(instance muleMoveTo of MoveTo
	(properties)
)

(instance muleActions of Script
	(properties)

	(method (init)
		(super init:)
		(gMuleObj illegalBits: $8000)
	)

	(method (doit &tmp [temp0 2])
		(super doit:)
		(if
			(>
				(GetDistance
					(gMuleObj x:)
					(gMuleObj y:)
					(gEgo x:)
					(gEgo y:)
				)
				40
			)
			(gMuleObj setMotion: muleMoveTo (gEgo x:) (gEgo y:))
		else
			(gMuleObj setMotion: 0)
		)
	)
)

(instance leaveTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local8 0)
				(HandsOff)
				(gEgo illegalBits: 0)
				(gMuleObj
					setScript: 0
					view: 405
					setLoop: (if local40 2 else 0)
					cycleSpeed: 0
					setCycle: Walk
				)
				(if local40
					(gMuleObj setMotion: MoveTo (+ (gMuleObj x:) 75) 200)
					(gEgo setMotion: MoveTo (gEgo x:) 200 self)
				else
					(gMuleObj setMotion: MoveTo 320 (gMuleObj y:))
					(gEgo setMotion: MoveTo 320 (gEgo y:) self)
				)
			)
			(1
				(gEgo illegalBits: $8000)
				(gCurRoom newRoom: (if local40 103 else 16))
			)
		)
	)
)

