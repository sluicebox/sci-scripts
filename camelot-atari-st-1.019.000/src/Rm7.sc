;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Rm7 0
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
	local12
	local13
	local14
	local15
	local16
)

(procedure (localproc_0 param1)
	(switch param1
		(0 0)
		(1
			(Print 7 0) ; "Arthur, the gods are jealous of their gold. It would be the greatest sacrilege, one which cannot be undone. Think again before you try this."
		)
		(2
			(Print 7 1) ; "Since you are determined to commit this sacrilege, I will say nothing more. Your doom is your own."
			(localproc_3 local1 0)
		)
		(else
			(Print 7 2) ; "Fool."
		)
	)
)

(procedure (localproc_1 param1)
	(switch param1
		(0 0)
		(1
			(Print 7 3) ; "Arthur, it is not wise to insult a god. Think before you do this."
		)
		(2
			(Print 7 4) ; "Alas, I fear you bring much evil upon yourself by such an unwise act."
			(localproc_3 local1 0)
		)
		(else
			(Print 7 5) ; "Unwise, Arthur, unwise."
		)
	)
)

(procedure (localproc_2)
	(clr)
	(Print &rest #font 4 #window SysWindow #at 140 30 #width 160 #dispose)
)

(procedure (localproc_3 param1 param2)
	(switch param1
		(1
			(switch param2
				(1
					(leftCandle cue: 1 setScript: flameMsgDelay)
					(SetFlag 7)
				)
				(0
					(leftCandle cue: 0)
				)
			)
		)
		(2
			(switch param2
				(1
					(rightCandle cue: 1 setScript: flameMsgDelay)
					(SetFlag 8)
				)
				(0
					(rightCandle cue: 0)
				)
			)
		)
	)
)

(instance leftCandle of Prop
	(properties
		y 123
		x 92
		z 5
		view 107
		loop 1
		cycleSpeed 2
	)

	(method (cue param1)
		(if (== argc 0)
			(= param1 (if (== (leftCandle x:) 500) 1 else 0))
		)
		(switch param1
			(0
				(self posn: 500 500)
			)
			(1
				(self posn: 92 123)
			)
		)
	)

	(method (handleEvent event)
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
			((MouseClaimed self event)
				(if (self cycler:)
					(Print 7 6) ; "The sacred fire of Mithras is lit. The blessing has been given."
				else
					(Print 7 7) ; "Only the blessing of Mithras can light this candle."
				)
			)
		)
	)
)

(instance rightCandle of Prop
	(properties
		y 122
		x 207
		z 5
		view 107
		loop 1
		cycleSpeed 2
	)

	(method (cue param1)
		(if (== argc 0)
			(= param1 (if (== (rightCandle x:) 500) 1 else 0))
		)
		(switch param1
			(0
				(self posn: 500 500)
			)
			(1
				(self posn: 207 122)
			)
		)
	)

	(method (handleEvent event)
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
			((MouseClaimed self event)
				(if (self cycler:)
					(Print 7 8) ; "The sacred fire of Christ is lit. The blessing has been given."
				else
					(Print 7 9) ; "Only the blessing of Christ can light this candle."
				)
			)
		)
	)
)

(instance grailVision of Prop
	(properties
		y 61
		x 183
		view 330
		loop 4
		cycleSpeed 2
	)
)

(instance knightVision of Prop
	(properties
		y 80
		x 110
		view 330
		loop 4
	)

	(method (init)
		(super init:)
		(= cycleSpeed global103)
	)
)

(instance flash of Prop
	(properties
		y 73
		x 110
		view 330
		loop 3
	)
)

(instance mithraSymbol of PV
	(properties
		y 113
		x 115
		view 107
		loop 2
		priority 1
	)
)

(instance christSymbol of PV
	(properties
		y 107
		x 180
		view 107
		cel 1
		priority 1
	)
)

(instance leftBase of PV
	(properties
		y 123
		x 92
		view 107
	)
)

(instance rightBase of PV
	(properties
		y 122
		x 207
		view 107
	)
)

(instance Rm7 of Rm
	(properties
		picture 7
	)

	(method (init)
		(Load rsSOUND 9)
		(super init:)
		(leftCandle init: setCycle: Fwd posn: 500 500)
		(rightCandle init: setCycle: Fwd posn: 500 500)
		(if (IsFlag 7)
			(leftCandle cue: 1)
		)
		(if (IsFlag 8)
			(rightCandle cue: 1)
		)
		(gEgo view: (if (IsFlag 3) 0 else 2) init: setScript: egoAction)
		(egoAction changeState: 1)
		(gRmMusic number: 9 loop: -1 play:)
		(leftCandle setScript: kneelingTime)
		(SetFlag 2)
		(gCurRoom setScript: vision)
		(gAddToPics add: christSymbol mithraSymbol leftBase rightBase)
		(proc0_13 258)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(if (and (> (gEgo y:) 185) (!= (egoAction state:) 1))
			(gCurRoom newRoom: 1)
		)
	)

	(method (newRoom newRoomNumber)
		(gRmMusic fade:)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0 [temp1 80] [temp81 40])
		(super handleEvent: event)
		(= local1
			(cond
				((gEgo inRect: 79 145 145 165) 1)
				((gEgo inRect: 145 145 220 165) 2)
				(else 0)
			)
		)
		(if (and local0 (event type:))
			(kneelingTime changeState: 0)
		)
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
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said '<up[/!*]')
							(Said '/ceiling,ceiling,arch')
							(Said '//ceiling,ceiling,arch')
							(OnButton event 0 0 320 43)
						)
						(Print 7 10) ; "The ceiling arches over your head like the great vaults of heaven."
					)
					((or (Said '<down[/!*]') (Said '/floor') (Said '//floor'))
						(Print 7 11) ; "The floor is made of inlaid stones."
					)
					(
						(or
							(Said '<between,behind/altar')
							(OnButton event 141 116 152 139)
						)
						(Print 7 12) ; "There is nothing but a dark space."
					)
					(
						(or
							(OnButton event 96 141 124 145)
							(OnButton event 168 140 199 145)
						)
						(Print 7 13) ; "Those are pads to kneel upon."
					)
					(
						(and
							(== local1 2)
							(or
								(Said '/altar<mithra')
								(Said '//altar<mithra')
								(Said '/altar/mithra')
							)
						)
						(Print 7 14) ; "Look again. Methinks you are confused."
					)
					(
						(and
							(== local1 1)
							(or
								(Said '/altar<christ')
								(Said '//altar<christ')
								(Said '/altar/christ')
							)
						)
						(Print 7 14) ; "Look again. Methinks you are confused."
					)
					(
						(or
							(Said '/god,christ,mithra')
							(Said '//god,christ,mithra')
						)
						(Print 7 15) ; "There is only one thing more deadly than offending a god."
						(Print 7 16) ; "Offending two gods."
					)
					(
						(or
							(Said '/cross')
							(Said '//cross')
							(OnButton event 169 82 186 110)
						)
						(SetScore 238 1 1)
						(Print 7 17) ; "The cross is an ancient symbol that has been adopted by the followers of the Christ god."
					)
					(
						(or
							(Said '/design<mithra')
							(Said '//design<mithra')
							(Said '/design<mithra')
							(Said '//design<mithra')
							(OnButton event 104 79 125 111)
						)
						(SetScore 238 1 1)
						(Print 7 18) ; "The symbol of Mithras has emblazoned many a warrior's shield, for he has been primarily a soldier's god."
					)
					(
						(or
							(Said '/design<(isis,vesta)')
							(Said '//design<(isis,vesta)')
							(OnButton event 277 36 311 49)
						)
						(SetScore 238 1 1)
						(Print 7 19) ; "Those are symbols of Isis and Vesta. What they are doing in this chapel, I do not know."
					)
					(
						(or
							(Said '/altar<christ')
							(Said '//altar<christ')
							(Said '/altar/christ')
							(OnButton event 155 68 207 138)
							(and
								(== local1 2)
								(or
									(Said '/altar')
									(Said '//altar')
									(Said '/altar')
								)
							)
						)
						(if (or local5 local4 local3)
							(= temp1 0)
							(StrCat @temp1 {You have left an offering of:\n})
							(if local5
								(Format @temp81 { %2d copper\n} local5)
								(StrCat @temp1 @temp81)
							)
							(if local4
								(Format @temp81 { %2d silver\n} local4)
								(StrCat @temp1 @temp81)
							)
							(if local3
								(Format @temp81 { %2d gold\n} local3)
								(StrCat @temp1 @temp81)
							)
							(StrCat @temp1 {to Christ.})
							(Print @temp1)
						else
							(Print 7 20) ; "This is a relatively new religion, but it has grown enormously in power over the last few centuries. Most of your people now worship the Christ god."
						)
					)
					(
						(or
							(Said '/altar<mithra')
							(Said '//altar<mithra')
							(Said '/altar/mithra')
							(OnButton event 89 77 140 140)
							(and
								(== local1 1)
								(or (Said '/altar') (Said '//altar'))
							)
						)
						(if (or local8 local7 local6)
							(= temp1 0)
							(StrCat @temp1 {You have left an offering of:\n})
							(if local8
								(Format @temp81 { %2d copper\n} local8)
								(StrCat @temp1 @temp81)
							)
							(if local7
								(Format @temp81 { %2d silver\n} local7)
								(StrCat @temp1 @temp81)
							)
							(if local6
								(Format @temp81 { %2d gold\n} local6)
								(StrCat @temp1 @temp81)
							)
							(StrCat @temp1 {to Mithras.})
							(Print @temp1)
						else
							(Print 7 21) ; "Mithras the warrior god has been worshipped for many, many centuries and was the favorite of Roman soldiers."
						)
					)
					((or (Said '/altar') (Said '//altar'))
						(Print 7 22) ; "On the right is the altar of Christ. On the left is the altar of Mithras."
					)
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/chapel')
							(Said '//chapel')
						)
						(Print 7 23) ; "The double altar in the Chapel of the Two Gods reflects the power struggle between an old and new religion."
					)
					((or (Said '/slab') (Said '//slab'))
						(Print 7 24) ; "Most of this room is made of stone: the altars, the floor, the pillars."
					)
					(
						(or
							(Said '/wall')
							(Said '//wall')
							(OnButton event 7 83 63 155)
							(OnButton event 231 85 276 157)
						)
						(Print 7 25) ; "The walls are lined with decorative columns."
					)
					((or (Said '/column') (Said '//column'))
						(Print 7 26) ; "They hold up the ceiling."
					)
					(
						(or
							(Said '/lattice,decoration,knotwork')
							(Said '//lattice,decoration,knotwork')
							(OnButton event 138 52 153 119)
						)
						(Print 7 27) ; "The intertwining lines upon the double altar is Celtic knotwork."
					)
					((OnButton event 276 7 310 184)
						(Print 7 28) ; "The highly decorative pillar is one of the main supports for the ceiling."
					)
					((or (Said '/vision') (Said '//vision'))
						(if (IsFlag 6)
							(Print 7 29) ; "The vision is sent to remind you that you must be morally pure to possess it. Every deed and decision in your mission will be weighed in judgement."
						)
						(if (IsFlag 5)
							(Print 7 30) ; "Mithras shows you perils that have befallen or will befall your three knights. He reminds you that, as king, you are responsible for their lives."
						)
						(if (not (or (IsFlag 6) (IsFlag 5)))
							(Print 7 31) ; "I hope you are not seeing something that I do not see. It would not bode well for your mission."
						)
					)
					((or (Said '/bowl') (Said '//bowl'))
						(Print 7 32) ; "They are not bowls. They are altar candles."
					)
					((or (Said '/design') (Said '//design'))
						(SetScore 238 1 1)
						(Print 7 33) ; "Upon the right is the cross, symbol of the Christ god who was crucified upon one."
						(Print 7 34) ; "Upon the left is the symbol of Mithras, formerly carried upon banners into battle."
					)
					((or (Said '/candelabra,fire') (Said '//candelabra,fire'))
						(cond
							((< (gEgo x:) 150)
								(if (not (== (leftCandle x:) 500))
									(Print 7 6) ; "The sacred fire of Mithras is lit. The blessing has been given."
								else
									(Print 7 35) ; "Only the blessing of Mithras can light the candle on the left."
								)
							)
							((not (== (rightCandle x:) 500))
								(Print 7 8) ; "The sacred fire of Christ is lit. The blessing has been given."
							)
							(else
								(Print 7 36) ; "Only the blessing of Christ can light the candle on the right."
							)
						)
					)
					((Said '//gift,offering')
						(Print 7 37) ; "I am sure you will think of something to offer the gods."
					)
					((or (Said '/labarum') (Said '//labarum'))
						(Print 7 38) ; "The labarum is the symbol of Mithras."
					)
					((or (Said '/skull') (Said '//skull'))
						(Print 7 39) ; "The skulls are reminders of the death that awaits us all."
					)
				)
			)
			((or (Said 'amen') (Said '/amen'))
				(Print 7 40) ; "And may the god of your choice protect you."
			)
			((Said 'kill,attack/god,christ,mithra')
				(Print 7 41) ; "That is beyond your powers. Or mine."
			)
			((Said 'go/hell')
				(Print 7 42) ; "That can be arranged."
			)
			((Said 'curse,fuck,fuck/god,christ,mithra')
				(Print 7 43) ; "Not in this place. You need all the help you can get."
			)
			((Said 'give,make/gift,offering')
				(Print 7 44) ; "The gods are always fond of offerings. Depending, of course, upon what it is you intend to offer."
			)
			((Said 'give/blood')
				(Print 7 45) ; "That is not the sort of offering the gods desire."
			)
			((Said 'give/shield,blade,armor')
				(if (IsFlag 3)
					(Print 7 45) ; "That is not the sort of offering the gods desire."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((or (Said 'poke,get/fire') (Said 'burn/finger'))
				(cond
					((not local1)
						(NotClose) ; "Perhaps you should move closer."
					)
					((== local1 2)
						(if (== (rightCandle x:) 500)
							(Print 7 46) ; "The candle is not lit."
						else
							(Print 7 47) ; "I do not understand what you hope to gain by having burnt fingers."
						)
					)
					((== local1 1)
						(if (== (leftCandle x:) 500)
							(Print 7 46) ; "The candle is not lit."
						else
							(Print 7 47) ; "I do not understand what you hope to gain by having burnt fingers."
						)
					)
				)
			)
			((or (Said 'talk,talk/god,christ,mithra') (Said 'get/help'))
				(cond
					((not local0)
						(Print 7 48) ; "It is said that the gods prefer prayers offered upon bended knee."
					)
					(
						(or
							(and (== local1 2) (not (IsFlag 8)))
							(and (== local1 1) (not (IsFlag 7)))
						)
						(Print 7 49) ; "Perhaps the gods need more tangible proof of your devotion before they will grant a blessing."
					)
					(else
						(Print 7 50) ; "The lighting of the sacred fire is the god's way of telling you that your prayers are heard."
					)
				)
			)
			((Said 'bow')
				(Print 7 51) ; "The gods prefer to hear prayers from bended knee."
			)
			((or (Said 'genuflect') (Said 'bend/knee') (Said 'show/reverence'))
				(cond
					(local0
						(Print 7 52) ; "Arthur, pay attention. You are already on your knees."
					)
					((== local1 2)
						(gEgo setScript: egoAction)
						(egoAction changeState: 5)
					)
					((== local1 1)
						(gEgo setScript: egoAction)
						(egoAction changeState: 5)
					)
					(else
						(NotClose) ; "Perhaps you should move closer."
					)
				)
			)
			((Said '(get<up),stand,rise')
				(if local0
					(gEgo setScript: egoAction)
					(egoAction changeState: 3)
				else
					(Print 7 53) ; "It does not require a wizard to see that you ARE standing."
				)
			)
			((or (Said 'pray') (Said 'say/prayer') (Said 'ask,get/benediction'))
				(cond
					((not local1)
						(NotClose) ; "Perhaps you should move closer."
					)
					((not local0)
						(Print 7 54) ; "Humbling yourself is the first step in dealing with any god."
					)
					((== local1 1)
						(cond
							((IsFlag 7)
								(Print 7 55) ; "Your prayers have been heard and the blessing given."
							)
							((IsFlag 9)
								(Print 7 56) ; "You have incurred Mithras' wrath. Nothing can help you now."
							)
							(else
								(Print 7 57) ; "I suspect that an earthly gift may help your prayers to reach the heavens."
							)
						)
					)
					((== local1 2)
						(cond
							((IsFlag 8)
								(Print 7 55) ; "Your prayers have been heard and the blessing given."
							)
							((IsFlag 10)
								(Print 7 58) ; "You have incurred Christ's wrath. Nothing can help you now."
							)
							(else
								(Print 7 57) ; "I suspect that an earthly gift may help your prayers to reach the heavens."
							)
						)
					)
				)
			)
			((Said 'drop,exit,give/coin,copper,dirham,dinar')
				(cond
					((not (gEgo has: 3)) ; purse
						(Print 7 59) ; "You have no money."
					)
					((not local1)
						(NotClose) ; "Perhaps you should move closer."
						(proc0_18)
					)
					((not local0)
						(event claimed: 1)
						(Print 7 60) ; "Before a god will accept money, he must be shown the proper reverence."
						(proc0_18)
					)
					((not (DoPurse))
						(event claimed: 1)
					)
					((== local1 1)
						(cond
							((>= global132 25)
								(SetScore 239 0 1 1 3)
								(cond
									((IsFlag 5)
										(Print 7 61) ; "The vision was a gift, not a purchase. It will not appear again."
									)
									((IsFlag 9)
										(Print 7 62) ; "You would not listen to warnings. Now you are under Mithras' curse and nothing can undo it."
									)
									(else
										(vision init: 1)
									)
								)
							)
							((>= global132 5)
								(SetScore 241 0 1)
								(cond
									((IsFlag 7)
										(Print 7 63) ; "You have already been blessed."
									)
									((IsFlag 9)
										(Print 7 62) ; "You would not listen to warnings. Now you are under Mithras' curse and nothing can undo it."
									)
									(else
										(localproc_3 1 1)
									)
								)
							)
							(global132
								(Print 7 64) ; "The dull clunk of a copper coin does not seem to excite much interest from the gods of this chapel."
							)
						)
						(+= local6 global129)
						(+= local7 global130)
						(+= local8 global131)
						(= global132
							(= global129 (= global130 (= global131 0)))
						)
					)
					((== local1 2)
						(cond
							((>= global132 25)
								(SetScore 240 0 1 1 3)
								(cond
									((IsFlag 6)
										(Print 7 65) ; "The vision was a gift, not a purchase. It will not appear again."
									)
									((IsFlag 10)
										(Print 7 66) ; "You would not listen to warnings. Now you are under Christ's curse and nothing can undo it."
									)
									(else
										(SetScore 241 0 1)
										(vision init: 13)
									)
								)
							)
							((>= global132 5)
								(SetScore 242 0 1)
								(cond
									((IsFlag 8)
										(Print 7 63) ; "You have already been blessed."
									)
									((IsFlag 10)
										(Print 7 66) ; "You would not listen to warnings. Now you are under Christ's curse and nothing can undo it."
									)
									(else
										(localproc_3 2 1)
									)
								)
							)
							(global132
								(Print 7 64) ; "The dull clunk of a copper coin does not seem to excite much interest from the gods of this chapel."
							)
						)
						(+= local3 global129)
						(+= local4 global130)
						(+= local5 global131)
						(= global132
							(= global129 (= global130 (= global131 0)))
						)
					)
				)
			)
			((or (Said 'perform/ritual') (Said 'say/mass'))
				(Print 7 67) ; "That would require preparations and priests and too much time. The blessing of the god is enough to ask for."
			)
			((or (Said 'deface,attack/altar') (Said 'use/blade/altar'))
				(cond
					((not local1)
						(NotClose) ; "Perhaps you should move closer."
					)
					((and (not (IsFlag 10)) (== local1 2) (not local11))
						(Print 7 68) ; "And bring down the curse of the god? Do not even think it!"
						(= local11 1)
					)
					((and (not (IsFlag 9)) (== local1 1) (not local12))
						(Print 7 68) ; "And bring down the curse of the god? Do not even think it!"
						(= local12 1)
					)
					(else
						(Print 7 69) ; "Your doom is now sealed."
						(if (== local1 1)
							(SetFlag 9)
							(ClearFlag 7)
						else
							(SetFlag 10)
							(ClearFlag 8)
						)
						(localproc_3 local1 0)
					)
				)
			)
			(
				(Said
					'get/copper,dirham,dinar,(coin<copper),(coin<dirham),(coin<dinar)>'
				)
				(cond
					((and (not local1) (Said '/altar'))
						(event claimed: 1)
						(NotClose) ; "Perhaps you should move closer."
					)
					(
						(or
							(Said '//mithra,(altar<mithra)')
							(and (Said '/altar>') (Said '/mithra'))
							(and (== local1 1) (Said '//altar'))
							(and (== local1 1) (Said '/[/!*]'))
						)
						(event claimed: 0)
						(cond
							(
								(or
									(!= local1 1)
									(Said '//christ,(altar<christ)')
									(and (Said '/altar>') (Said '/christ'))
								)
								(Print 7 14) ; "Look again. Methinks you are confused."
								(event claimed: 1)
								(return)
							)
							((Said '/dinar,(coin<dinar)>')
								(cond
									((not local6)
										(Print 7 70) ; "There are no gold coins upon the altar."
										(= local15 0)
									)
									((== local15 0)
										(= local15 1)
									)
									(else
										(++ local15)
										(-- local6)
										(++ gGold)
										(ClearFlag 7)
										(SetFlag 9)
									)
								)
								(localproc_0 local15)
							)
							((Said '/dirham,(coin<dirham)>')
								(cond
									((not local7)
										(Print 7 71) ; "There are no silver coins upon the altar."
										(= local16 0)
									)
									((== local16 0)
										(= local16 1)
									)
									(else
										(++ local16)
										(-- local7)
										(++ gSilver)
										(ClearFlag 7)
									)
								)
								(localproc_1 local16)
							)
							((Said '/copper,(coin<copper)>')
								(if local8
									(-- local8)
									(++ gCopper)
									(Print 7 72) ; "The gods may not notice the loss of a bit of copper."
								else
									(Print 7 73) ; "There are no copper coins upon the altar."
								)
							)
						)
						(event claimed: 1)
					)
					(
						(or
							(Said '//christ,(altar<christ)')
							(and (Said '/altar>') (Said '/christ'))
							(and (== local1 2) (Said '//altar'))
							(and (== local1 2) (Said '/[/!*]'))
						)
						(event claimed: 0)
						(cond
							(
								(or
									(!= local1 2)
									(Said '//mithra,(altar<mithra)')
									(and (Said '/altar>') (Said '/mithra'))
								)
								(Print 7 14) ; "Look again. Methinks you are confused."
								(event claimed: 1)
								(return)
							)
							((Said '/dinar,(coin<dinar)>')
								(cond
									((not local3)
										(Print 7 70) ; "There are no gold coins upon the altar."
										(= local13 0)
									)
									((== local13 0)
										(= local13 1)
									)
									(else
										(++ local13)
										(-- local3)
										(++ gGold)
										(ClearFlag 8)
										(SetFlag 10)
									)
								)
								(localproc_0 local13)
							)
							((Said '/dirham,(coin<dirham)>')
								(cond
									((not local4)
										(Print 7 71) ; "There are no silver coins upon the altar."
										(= local14 0)
									)
									((== local14 0)
										(= local14 1)
									)
									(else
										(++ local14)
										(-- local4)
										(++ gSilver)
										(ClearFlag 8)
									)
								)
								(localproc_1 local14)
							)
							((Said '/copper,(coin<copper)>')
								(if local5
									(-- local5)
									(++ gCopper)
									(Print 7 72) ; "The gods may not notice the loss of a bit of copper."
								else
									(Print 7 73) ; "There are no copper coins upon the altar."
								)
							)
						)
					)
					(else
						(Print 7 74) ; "If you wish to get more money, you must go to the Treasury. In this place, you should think only in terms of giving."
					)
				)
				(event claimed: 1)
			)
			((Said 'get/coin[/altar]')
				(Print 7 75) ; "Which coin do you want?"
			)
			((Said 'drop,exit,give/rose>')
				(if (gEgo has: 4) ; rose | apple | green_apple
					(Print 7 76) ; "It would make a lovely offering, but is not quite what the gods want."
					(event claimed: 1)
				)
			)
			((Said 'burn/rose')
				(cond
					((not (gEgo has: 4)) ; rose | apple | green_apple
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((== local1 0)
						(Print 7 77) ; "You're not close enough to a flame and you do not want to be. Trust me."
					)
					(
						(or
							(and (== local1 1) (not (leftCandle cycler:)))
							(and (== local1 2) (not (rightCandle cycler:)))
						)
						(Print 7 78) ; "The fire is not lit on this candle, Arthur"
					)
					((not local9)
						(Print 7 79) ; "Burn a gift of love from Gwenhyver? I would seriously reconsider."
						(= local9 1)
					)
					(else
						(PutItem 4 0) ; rose | apple | green_apple
						(localproc_3 1 0)
						(localproc_3 2 0)
						(ClearFlag 8)
						(ClearFlag 6)
						(ClearFlag 7)
						(ClearFlag 5)
						(= local10 1)
						(Print 7 80) ; "Nothing is left but ashes. I sense you have angered the gods and no good will come of this."
					)
				)
			)
			((Said 'douse,(drop<out)/fire,candelabra')
				(cond
					((not local1)
						(NotClose) ; "Perhaps you should move closer."
					)
					(
						(or
							(and (== local1 1) (== (leftCandle x:) 500))
							(and (== local1 2) (== (rightCandle x:) 500))
						)
						(Print 7 81) ; "You have not yet been given the blessing of the flame."
					)
					((not local2)
						(= local2 1)
						(if (== local1 2)
							(Print 7 82) ; "Are you mad? It is a sign that Christ has heard your prayers and given his blessing."
						else
							(Print 7 83) ; "Mithras has ways of punishing fools who tamper with his holy fire."
						)
					)
					(else
						(Print 7 84) ; "There. You have nothing better to show for it than burnt fingers."
						(= local2 0)
						(if (== local1 2)
							(localproc_3 2 0)
						else
							(localproc_3 1 0)
						)
					)
				)
			)
			((Said 'get/fire,candelabra')
				(Print 7 85) ; "That belongs here and is of no use to you."
			)
			((Said 'get/bowl')
				(Print 7 86) ; "Those are not bowls. Those are altar candles and must be left on the altars."
			)
			((Said 'light/candelabra,fire')
				(Print 7 87) ; "Only the blessing of a god can do that."
			)
			((Said 'make,give,do/sacrifice')
				(cond
					((not local1)
						(NotClose) ; "Perhaps you should move closer."
					)
					((== local1 2)
						(Print 7 88) ; "The Christ god does not approve of such things."
					)
					(else
						(Print 7 89) ; "Once, in very ancient times, the sacrifice of a white bull would have been proper. But there is no time for that now."
					)
				)
			)
			((Said 'draw/blade')
				(cond
					(local0
						(Print 7 90) ; "You cannot draw your sword from your knees."
					)
					((IsFlag 3)
						(Print 7 91) ; "You annoy the gods by brandishing a weapon in this sacred place."
						(= global125 2)
					)
					(else
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
				)
			)
			(
				(or
					(Said 'talk/merlin')
					(and
						(Said 'ask,(are<where)>')
						(or
							(Said '/god,christ,mithra')
							(Said '//god,christ,mithra')
						)
					)
				)
				(Print 7 15) ; "There is only one thing more deadly than offending a god."
				(Print 7 16) ; "Offending two gods."
			)
		)
	)
)

(instance kneelingTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (if local0 30 else 0))
			)
			(1
				(if (and (User canInput:) local0)
					(Print 7 92) ; "Your knees must be getting sore. Perhaps you should consider doing something."
				)
				(self changeState: 0)
			)
		)
	)
)

(instance egoAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo posn: 150 215 setMotion: MoveTo 150 185 self)
				(= local0 0)
			)
			(2
				(client setScript: 0)
				(HandsOn)
			)
			(3
				(HandsOff)
				(gEgo
					view: 16
					setLoop: (if (IsFlag 3) 1 else 0)
					setCel: 2
					setCycle: Beg self
				)
			)
			(4
				(gEgo
					view: (if (IsFlag 3) 0 else 2)
					setLoop: -1
					loop: 3
					setCel: -1
					setCycle: Walk
				)
				(gEgo illegalBits: $8000)
				(= local0 0)
				(kneelingTime changeState: 0)
				(client setScript: 0)
				(HandsOn)
			)
			(5
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (== local1 2)
					(gEgo setMotion: MoveTo 185 149 self)
				else
					(gEgo setMotion: MoveTo 110 149 self)
				)
			)
			(6
				(gEgo
					view: 16
					setLoop: (if (IsFlag 3) 1 else 0)
					setCel: 0
					setCycle: End self
				)
			)
			(7
				(= local0 1)
				(kneelingTime changeState: 0)
				(gGame setCursor: gNormalCursor (HaveMouse))
				(User canInput: 1)
			)
		)
	)
)

(instance vision of Script
	(properties)

	(method (init param1 &tmp temp0)
		(= temp0 (if (== argc 0) 0 else param1))
		(super init:)
		(self changeState: temp0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(Load rsVIEW 330)
				(SetFlag 5)
				(SetFlag 7)
				(leftCandle cue: 1)
				(Print 7 93 #at 120 30 #dispose) ; "The flame is lit and the blessing given, but wait...."
				(= seconds 4)
			)
			(2
				(clr)
				(Print 7 94 #at 120 30 #dispose) ; "Mithras sends you visions of your missing knights. And listen! Their voices call out to you in distress!"
				(= seconds 6)
			)
			(3
				(clr)
				(flash posn: 110 73 setCycle: Fwd init:)
				(knightVision init: setLoop: 2 setCel: 255 setCycle: Beg self)
			)
			(4
				(localproc_2 7 95 80 {Gawaine}) ; "Save me, most valiant king! I am injured unto the death by a black fiend. The green leaves will cover my bones unless you are quick."
				(= seconds 10)
			)
			(5
				(clr)
				(knightVision setCycle: End self)
			)
			(6
				(knightVision setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(7
				(localproc_2 7 96 80 {Launcelot}) ; "Arthur, I cannot move. I cannot escape. And I am so cold, so terribly cold. Ah, how can she be so heartless?!"
				(= seconds 10)
			)
			(8
				(clr)
				(knightVision setCycle: End self)
			)
			(9
				(knightVision setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(10
				(localproc_2 7 97 80 {Galahad}) ; "I am lost in the darkness, hidden from light and life, with only the rats to lust for my flesh and blood. I will die here unless you help me, my king."
				(= seconds 10)
			)
			(11
				(clr)
				(knightVision setCycle: End self)
			)
			(12
				(knightVision dispose:)
				(flash dispose:)
				(kneelingTime changeState: 0)
				(self changeState: 18)
			)
			(13
				(HandsOff)
				(SetFlag 6)
				(SetFlag 8)
				(rightCandle cue: 1)
				(Print 7 98 #at 10 20 #width 150 #dispose) ; "The flame is lit. You have been blessed, and now something shimmers in the air...."
				(= seconds 8)
			)
			(14
				(flash posn: 184 76 setCycle: Fwd init:)
				(grailVision init: setPri: 5 setCel: 255 setCycle: Beg)
				(clr)
				(Print 7 99 #at 10 20 #width 125 #dispose) ; "A vision of the Grail appears to you. Christ sends it to remind you that only a man of purity may attain this sacred cup."
				(= seconds 14)
			)
			(15
				(clr)
				(Print 7 100 #at 10 20 #width 125 #dispose) ; "Remember, the fate of Camelot rests not only upon your finding the Grail, but your worthiness to possess it."
				(= seconds 16)
			)
			(16
				(clr)
				(grailVision setCycle: End self)
			)
			(17
				(grailVision dispose:)
				(flash dispose:)
				(self changeState: 18)
			)
			(18
				(if (IsFlag 4)
					(SetFlag 2)
				else
					(SetFlag 4)
				)
				(gEgo illegalBits: $8000)
				(gGame setCursor: gNormalCursor (HaveMouse))
				(User canInput: 1)
				(kneelingTime changeState: 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((Said 'poke/vision')
				(Print 7 101) ; "That is quite impossible."
			)
			((Said 'get,repeat/vision')
				(if (and (IsFlag 5) (IsFlag 6))
					(Print 7 102) ; "The gods do not provide visions upon demand. Accept what you have been given or you will anger them."
				else
					(Print 7 103) ; "The gods give visions to those who please them."
				)
			)
			((Said 'talk/gawain,lancelot,galahad')
				(Print 7 104) ; "What you saw and heard may have happened or is yet to happen. To learn more, you must find the knights themselves."
			)
		)
	)
)

(instance flameMsgDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 10)
			)
			(1
				(HandsOn)
				(if local0
					(User canControl: 0)
				)
				(Print 7 105) ; "The sacred flame is lit. You and your mission have been blessed."
				(client setScript: 0)
			)
		)
	)
)

