;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use n117)
(use eRoom)
(use Interface)
(use Sound)
(use Save)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	Rm8 0
)

(synonyms
	(charger charger charger charger)
	(guard guard man)
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	[local5 5] = [0 50 70 50 80]
	[local10 5] = [0 100 120 100 130]
	[local15 5] = [0 60 15 120 170]
	[local20 5] = [0 190 125 230 280]
	local25
	local26
	local27
)

(instance guard1 of Act
	(properties
		y 143
		x 89
		view 334
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
				(Print 8 0) ; "The guards stand at attention in your presence."
			)
		)
	)
)

(instance guard2 of Act
	(properties
		y 165
		x 45
		view 334
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
				(if (and (gEgo inRect: 32 156 91 185) (== local1 0))
					(Print 8 1) ; "The guard has the air of a man who wants to speak, but is afraid to speak without permission."
				else
					(Print 8 0) ; "The guards stand at attention in your presence."
				)
			)
		)
	)
)

(instance guard3 of Act
	(properties
		y 174
		x 255
		view 334
		loop 1
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
				(Print 8 0) ; "The guards stand at attention in your presence."
			)
		)
	)
)

(instance guard4 of Act
	(properties
		y 143
		x 198
		view 334
		loop 1
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
				(Print 8 0) ; "The guards stand at attention in your presence."
			)
		)
	)
)

(instance guardWindow of SysWindow
	(properties
		color 15
		back 1
		title {Guard}
		brTop 50
		brLeft 45
		brBottom 80
		brRight 310
	)
)

(instance Rm8 of eRoom
	(properties
		picture 8
	)

	(method (init)
		(Load rsVIEW 334)
		(Load rsVIEW 401)
		(Load rsVIEW 405)
		(Load rsVIEW 9)
		(Load rsVIEW 31)
		(Load rsVIEW 412)
		(Load rsSOUND 10)
		(Load rsSOUND 11)
		(super init:)
		(= global112 5)
		(proc0_13 258)
		(gAddToPics doit:)
		(HandsOn)
		(gTObj tWindow: guardWindow init:)
		(User blocks: 1)
		(guard1 init: setPri: 0 setScript: SnapTo)
		(guard2 init:)
		(guard3 init:)
		(guard4 init: setPri: 0)
		(self setFeatures: leftArchGuard guards)
		(gRmMusic number: 10 loop: -1)
		(if (IsFlag 3)
			(if (or (!= global116 1) (== gPrevRoomNum 1))
				(= global116 2)
				(= global115 8)
				(gHorseObj
					view: 401
					loop: 1
					cel: 0
					illegalBits: $8000
					ignoreActors: 0
					posn: 133 174
				)
			)
			(self setRegions: 113 115) ; horseReg, muleReg
			(gMuleObj
				posn: 200 181
				setLoop: 1
				setScript: 0
				setScript: muleActions
			)
			(SetFlag 20)
			(gHorseObj stopUpd:)
		)
		(switch gPrevRoomNum
			(9
				(gEgo
					view:
						(cond
							((== global116 1) 9)
							((IsFlag 3) 3)
							(else 1)
						)
					setPri: -1
					init:
				)
				(self enterRoom: 30 148 65 148 0)
				(if (and gMuleObj (== global116 1))
					(self muleEnterRoom: 40 144 56 144 0)
				)
			)
			(else
				(gEgo view: (if (IsFlag 3) 3 else 1) setStep: 3 2 init:)
				(self enterRoom: 285 130 258 130 1)
				(gMuleObj stopUpd:)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(User blocks: 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(cond
			((!= global116 1)
				(if (and (User canControl:) (== (gEgo onControl: 1) 4))
					(gEgo setScript: walkStairs)
				)
			)
			(
				(and
					(== local2 (gEgo x:))
					(== local3 (gEgo y:))
					(!= (gEgo view:) 31)
				)
				(if (== (gRmMusic state:) 3)
					(gRmMusic stop:)
				)
			)
			((and (== (gEgo view:) 31) (== (gRmMusic number:) 10))
				(gRmMusic number: 11 play:)
			)
			(
				(or
					(and (!= (gEgo view:) 31) (== (gRmMusic number:) 11))
					(!= (gRmMusic state:) 3)
				)
				(gRmMusic number: 10 play:)
			)
		)
		(= local2 (gEgo x:))
		(= local3 (gEgo y:))
		(cond
			(
				(and
					(== global116 1)
					(& (gEgo onControl:) $0004)
					(not local0)
					(== (gEgo view:) 9)
					(or (== (gEgo loop:) 0) (== (gEgo loop:) 3))
				)
				(Sound pause: 1)
				(Print 8 2) ; "You can't take your horse in the castle."
				(Sound pause: 0)
				(gEgo setMotion: MoveTo 170 (gEgo y:))
			)
			((or (> (gEgo x:) 299) (< (gEgo y:) 127))
				(gCurRoom newRoom: 1)
			)
			((and (& (gEgo onControl: 1) $4000) (not global80))
				(if (== global116 1)
					(SetFlag 20)
				)
				(self leaveRoom: 9 20 (gEgo y:))
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
			((Said 'look,enter,go,find/stable')
				(Print 8 3) ; "The stables are nearby, but your servants tend to all your needs there. You have other, more important concerns."
			)
			((and (== global116 0) (or (Said '/ass,pack') (Said '//ass')))
				(Print 8 4) ; "Your mule is not yet here."
			)
			((Said 'thank')
				(if local27
					(= local27 0)
					(Talk 8 5) ; "My pleasure, m'lord."
				else
					(Talk 8 6) ; "Beggin' your pardon, m'lord?"
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((or (Said '<up[/!*]') (Said '/sky'))
						(Print 8 7) ; "The skies are clear. 'Tis a good day to begin your search."
					)
					(
						(or
							(Said '<down[/!*]')
							(Said '/floor,dirt,cobblestones,slab')
						)
						(Print 8 8) ; "Considering how much of Camelot is made of this grey stone, there must have been a great deal of it around at one time."
					)
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/courtyard')
							(Said '//courtyard')
						)
						(Print 8 9) ; "The inner courtyard is guarded by your loyal men."
						(if (IsFlag 3)
							(Print 8 10) ; "Your warhorse and a pack mule have been prepared for your journey."
						)
					)
					(
						(or
							(Said '/ass')
							(Said '//ass')
							(and
								(gCast contains: gMuleObj)
								(MouseClaimed gMuleObj event)
							)
						)
						(if (gCast contains: gMuleObj)
							(Print 8 11) ; "It does not look happy about being chosen for this mission, nor about carrying your pack of provisions."
						else
							(Print 8 12) ; "Your mule is being prepared for the journey."
						)
					)
					(
						(or
							(Said '/stair')
							(Said '//stair')
							(and
								(== (OnControl CONTROL (event x:) (event y:)) 4)
								(event claimed: 1)
							)
						)
						(Print 8 13) ; "Aye, those are stairs."
					)
					(
						(or
							(Said '/camelot,stronghold,castle,home')
							(Said '//camelot,stronghold,castle,home')
							(OnButton event 218 0 320 190)
						)
						(Print 8 14) ; "I can sense the mingling of pride and despair that fills you as you look upon your stronghold and home."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 8 15) ; "The thick, stone walls make Camelot virtually impregnable against normal attack."
						(Print 8 16) ; "Against this curse of plague and drought, however, the thickest of stone walls is no defense."
					)
					(
						(or
							(Said '/door')
							(Said '//door')
							(OnButton event 261 34 288 126)
						)
						(Print 8 17) ; "It is the main entrance to your castle proper."
					)
					(
						(or
							(Said '/window')
							(Said '//window')
							(OnButton event 100 45 105 67)
							(OnButton event 66 47 70 67)
						)
						(Print 8 18) ; "The window in the tower is a lookout."
					)
					(
						(or
							(Said '/arch,tunnel,portal')
							(Said '//arch,tunnel,portal')
							(OnButton event 49 87 73 144)
						)
						(Print 8 19) ; "This tunnel leads to the portcullis which is your outside gate."
					)
					(
						(or
							(Said '/tower,turret')
							(Said '//tower,turret')
							(OnButton event 63 5 110 85)
						)
						(Print 8 20) ; "It is part of the defensive system of Camelot."
					)
					(
						(or
							(Said '/charger')
							(Said '//charger')
							(and
								(gCast contains: gHorseObj)
								(MouseClaimed gHorseObj event)
							)
							(and (== global116 1) (MouseClaimed gEgo event))
						)
						(if (!= global116 0)
							(Print 8 21) ; "Your horse is a sturdy and well-trained stallion, bred to be steady in danger and battle."
						else
							(Print 8 22) ; "Your grooms prepare the horse and pack mule. When you are ready, they will be here."
						)
					)
					((or (Said '/mare') (Said '//mare'))
						(if (IsFlag 3)
							(Print 8 23) ; "You should know your horse better than that, Arthur. He is a stallion."
						else
							(Print 8 22) ; "Your grooms prepare the horse and pack mule. When you are ready, they will be here."
						)
					)
					((or (Said '/shield') (Said '//shield'))
						(if (not (IsFlag 3))
							(Print 8 24) ; "Your guards bear the Royal shields of Camelot."
						else
							(Print 8 25) ; "Your own shield is familiar to you. Your guards, of course, bear the Royal shields of Camelot."
						)
					)
					((or (Said '/lance') (Said '//lance'))
						(Print 8 26) ; "Your guards have little need for their lances these days."
					)
					((or (Said '/pack,pack') (Said '//pack,pack'))
						(if (gCast contains: gMuleObj)
							(Print 8 27) ; "It contains water, food, blankets, extra clothing and such things as you may want on a long journey."
						else
							(Print 8 28) ; "Your servants are preparing a pack for your trip. It will be ready to go when you are."
						)
					)
					((or (Said '/gear,bridle,gear') (Said '//gear,bridle,gear'))
						(if (!= global116 0)
							(Print 8 29) ; "Your own special tack has been used."
						else
							(Print 8 30) ; "There is no tack here."
						)
					)
					((Said '//galahad')
						(Print 8 31) ; "Galahad is well liked amongst the guards. They would be most likely to have news of him."
					)
				)
			)
			((Said 'get/lance')
				(Print 8 32) ; "A clumsy weapon for a long trip. Excaliber is the best weapon you could want."
			)
			((Said 'dismount,(get<off)[/charger]')
				(if (and (== global116 1) (gEgo inRect: 230 168 310 185))
					(gEgo setScript: moveAwayFromBadArea)
				else
					(gRmMusic stop:)
					(event claimed: 0)
				)
			)
			((Said 'get/water,food,blanket,clothes')
				(if (gCast contains: gMuleObj)
					(Print 8 33) ; "There will be time enough for that on the journey."
				else
					(Print 8 34) ; "That is not here."
				)
			)
			((Said 'unpack,remove/pack')
				(if (gCast contains: gMuleObj)
					(Print 8 35) ; "What the devil for? Have you lost all common sense?"
				else
					(Print 8 36) ; "There is no pack here."
				)
			)
			((Said 'fetch,(get[<!*])/>')
				(cond
					((and (!= global116 0) (Said '/charger'))
						(Print 8 37) ; "Your horse is already here."
					)
					((and (gCast contains: gMuleObj) (Said '/ass'))
						(Print 8 38) ; "Your mule is already here."
					)
					((not (gCast contains: gMuleObj))
						(event claimed: 1)
						(Talk 8 39) ; "It is being prepared. When your own preparations are complete, it will surely be ready and waiting for you."
					)
				)
			)
			((Said 'climb/wall')
				(Print 8 40) ; "It is not only difficult, but pointless."
			)
			((Said 'guide,pull,get/ass')
				(if (gCast contains: gMuleObj)
					(Print 8 41) ; "Lead and it will follow."
				else
					(Print 8 34) ; "That is not here."
				)
			)
			((Said 'check/hoof,feet')
				(if (gCast contains: gMuleObj)
					(Print 8 42) ; "Your grooms have seen to such details, though you are wise to think of it."
				else
					(Print 8 34) ; "That is not here."
				)
			)
			((Said 'guide,pull,guide/charger')
				(Print 8 43) ; "A horse is for riding."
			)
			((Said 'ride,mount/ass')
				(if (gCast contains: gMuleObj)
					(Print 8 44) ; "Why would you want to ride a bony little mule when you have your fine stallion?"
				else
					(Print 8 34) ; "That is not here."
				)
			)
			((Said 'follow/ass')
				(if (gCast contains: gMuleObj)
					(Print 8 45) ; "Nay, 'tis the other way around. The mule follows you."
				else
					(Print 8 34) ; "That is not here."
				)
			)
			((Said 'draw/blade')
				(if (IsFlag 3)
					(switch (Random 0 1)
						(0
							(Print 8 46) ; "Why do you draw your sword here? You are safely surrounded by your own men."
						)
						(1
							(Print 8 47) ; "This is no time for sword practice with your men."
						)
					)
					(= global125 2)
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'kill,cut,hit,hit/*')
				(Print 8 48) ; "The legend says that a man with violence in his soul will be destroyed if he touches the Grail."
			)
		)
	)
)

(instance SnapTo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(guard2 setCel: 1 stopUpd:)
				(= cycles (Random 3 6))
			)
			(2
				(guard4 setCel: 1 stopUpd:)
				(= cycles (Random 3 6))
			)
			(3
				(guard3 setCel: 1 stopUpd:)
				(= cycles (Random 3 6))
			)
			(4
				(guard1 setCel: 1 stopUpd: setScript: 0)
			)
		)
	)
)

(instance guards of Feature
	(properties)

	(method (handleEvent event &tmp temp0 temp1)
		(if
			(= temp0
				(cond
					((gEgo inRect: 68 134 120 155) 1)
					((gEgo inRect: 32 160 91 185) 2)
					((gEgo inRect: 165 134 220 155) 3)
					((gEgo inRect: 205 160 260 185) 4)
					(else 0)
				)
			)
			((gTObj tWindow:)
				brTop: [local5 temp0]
				brBottom: [local10 temp0]
				brLeft: [local15 temp0]
				brRight: [local20 temp0]
			)
		)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((Said 'look/guard')
				(if (and (gEgo inRect: 32 156 91 185) (== local1 0))
					(Print 8 1) ; "The guard has the air of a man who wants to speak, but is afraid to speak without permission."
				else
					(Print 8 0) ; "The guards stand at attention in your presence."
				)
			)
			((Said 'look/shield<guard')
				(Print 8 49) ; "It is a rather ordinary shield."
			)
			((Said 'look/spear<guard')
				(Print 8 50) ; "It is a rather ordinary spear."
			)
			((and temp0 (or (Said 'yes,no') (Said '/yes,no')))
				(Talk 8 51) ; "Forgive me, sire, I do not understand."
			)
			((or (Said '(are<where)>') (Said 'ask[/guard]/>'))
				(cond
					((not temp0)
						(event claimed: 1)
						(Print 8 52) ; "Standing closer to a guard would help."
					)
					((or (Said '/self,arthur,king') (Said '//self,arthur,king'))
						(Talk 8 53) ; "You are my king, sire."
					)
					((or (Said '/name') (Said '//name'))
						(Talk 8 54) ; "I am your faithful and loyal servant, my liege."
					)
					((or (Said '/charger,ass,pack') (Said '//charger,ass,pack'))
						(if (not (IsFlag 3))
							(Talk 8 55) ; "Your horse, mule and pack are being prepared."
						else
							(Talk 8 56) ; "Your horse is saddled and ready. The mule bears your pack of provisions."
						)
					)
					(
						(or
							(Said '/galahad,gawain,lancelot')
							(Said '//galahad,gawain,lancelot')
						)
						(Talk 8 57) ; "I have no news of him, m'lord."
						(= local27 1)
					)
					((or (Said '/guenevere') (Said '//guenevere'))
						(Talk 8 58) ; "She should be in the castle, m'lord."
						(= local27 1)
					)
					(else
						(event claimed: 1)
						(if (gEgo inRect: 32 160 91 185)
							(Talk 8 59) ; "I am sure you know more than me about that, sire, me being only a guard and all."
						else
							(Talk 8 60) ; "The man yonder, to the left of the arch, is the smartest of all of us, m'lord."
						)
					)
				)
			)
			(
				(or
					(Said 'talk[/guard]')
					(Said '(talk,talk)<to<permission<give')
					(Said '(talk,talk)<to<permission<guard<give')
				)
				(if (not temp0)
					(Print 8 52) ; "Standing closer to a guard would help."
				else
					(= local27 1)
					(switch (Random 0 3)
						(0
							(Talk 8 61) ; "May God protect you, m'lord."
						)
						(1
							(Talk 8 62) ; "May God lead you to the Grail, my King."
						)
						(2
							(Talk 8 63) ; "We pray for your success, King Arthur."
						)
						(3
							(Talk 8 64) ; "Mithras guide and protect you."
						)
					)
				)
			)
			((Said 'get,get/coin,dinar,dirham,copper')
				(Print 8 65) ; "Such miserliness does not become a king."
			)
			((Said 'hug/guard')
				(Print 8 66) ; "All the armour gets in the way, fortunately."
			)
			((Said 'give,tip/*[/guard]>')
				(cond
					((not temp0)
						(event claimed: 1)
						(Print 8 52) ; "Standing closer to a guard would help."
						(if global132
							(proc0_18)
						)
					)
					((Said '/pack')
						(Print 8 67) ; "They have no use for it."
					)
					((Said '/rose')
						(if (gEgo has: 4) ; rose | apple | green_apple
							(Talk 8 68) ; "Very sweet of you, m'lord."
							(= local4 temp0)
							(PutItem 4) ; rose | apple | green_apple
						else
							(event claimed: 0)
						)
					)
					((Said '/dinar,dirham,copper,coin')
						(cond
							((not (gEgo has: 3)) ; purse
								(Print 8 69) ; "You don't have any money."
							)
							((not (DoPurse)) 0)
							(else
								(= global132 0)
								(switch (Random 0 2)
									(0
										(Talk 8 70) ; "Bless you, m'lord!"
									)
									(1
										(Talk 8 71) ; "Thank'ee most kindly, m'lord!"
									)
									(2
										(Talk 8 72) ; "Praise be your generosity, King Arthur!"
									)
								)
								(SetScore 305 2 1)
							)
						)
					)
					((Said '/blade,shield,armor,armor,charger,ass')
						(Print 8 73) ; "Arthur, will you please stop trying to give away your most valuable possessions."
					)
					((Said '/*')
						(Print 8 67) ; "They have no use for it."
					)
				)
			)
			((Said 'get/rose')
				(cond
					((gEgo has: 4) ; rose | apple | green_apple
						(event claimed: 0)
					)
					((not temp0)
						(Print 8 52) ; "Standing closer to a guard would help."
					)
					((not local4)
						(Print 8 34) ; "That is not here."
					)
					((== local4 temp0)
						(Talk 8 74) ; "As you command."
						(gEgo get: 4) ; rose | apple | green_apple
						(= local4 0)
					)
					(else
						(Talk 8 6) ; "Beggin' your pardon, m'lord?"
					)
				)
			)
			((Said 'get/weapon,blade[/guard]')
				(Print 8 75) ; "Their weapons are inferior to Excaliber."
				(Print 8 76) ; "Besides which, they need them to defend Camelot in your absence."
			)
			((Said 'get/shield,spear,crest')
				(Print 8 77) ; "You guard needs it."
			)
			((Said 'open<command<guard<to/gate')
				(Print 8 78) ; "They are unable to do that."
			)
			((Said '(follow,come)<command<guard<to')
				(Print 8 79) ; "Their place is here, guarding Camelot."
			)
			((Said 'hello')
				(Talk 8 80) ; "Is this some odd Celtic word, m'lord?"
			)
			((Said 'greet')
				(Talk 8 81) ; "Greetings, my liege."
			)
			((Said 'kiss/guard')
				(Talk 8 82) ; "Uh....no, thank you, m'lord."
			)
			((Said 'kiss/charger,ass')
				(if (gCast contains: gMuleObj)
					(Print 8 83) ; "What a thoroughly disgusting idea."
				else
					(Print 8 34) ; "That is not here."
				)
			)
			((Said 'fuck')
				(Print 8 84) ; "These are not the thoughts of a pure man."
			)
			((Said 'rob/*')
				(Print 8 85) ; "The Christians say that stealing is a sin and no sinner may lay hands upon the Grail and live."
			)
			((Said 'help/guard')
				(Talk 8 86) ; "You can only help us by bringing back the Grail before it is too late."
			)
			((Said 'ride<above/guard')
				(if (== global116 1)
					(Print 8 87) ; "Your horse is trained only to fight your enemies, not your friends."
				else
					(Print 8 88) ; "You're not on the horse."
				)
			)
			((Said 'salute')
				(Print 8 89) ; "That is not becoming of a king."
			)
		)
	)
)

(instance leftArchGuard of Feature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(!= (event type:) evSAID)
				(not (gEgo inRect: 32 160 91 185))
			)
			(return 0)
		)
		((gTObj tWindow:)
			brTop: [local5 2]
			brBottom: [local10 2]
			brLeft: [local15 2]
			brRight: [local20 2]
		)
		(cond
			(
				(or
					(Said 'ask[/guard]/galahad')
					(and
						(== local1 1)
						(or
							(Said '/yes,talk,talk,continue')
							(Said 'talk,tell,talk,yes,continue')
						)
					)
				)
				(SetScore 243 1 2)
				(SetFlag 11)
				(Talk 8 90 8 91) ; "His horse was sent back to our care by the Harbourmaster of Southampton."
				(= local1 2)
			)
			((and (== local1 1) (Said 'no'))
				(Talk 8 92) ; "Very well, m'lord."
				(= local1 0)
			)
			(
				(or
					(Said 'talk[/guard]')
					(Said 'give,give/permission')
					(Said 'give,give//permission')
				)
				(if (<= local1 1)
					(if (IsFlag 11)
						(Talk 8 61) ; "May God protect you, m'lord."
					else
						(Talk 8 93) ; "My Lord King, I have news of Galahad, if you would care to hear it."
						(= local1 1)
					)
				else
					(= local27 1)
					(Talk 8 94) ; "That is all I know, m'lord. Godspeed you on your mission."
				)
			)
			((Said 'thank')
				(cond
					((== local1 2)
						(Talk 8 95) ; "My pleasure, m'lord. I only thought to mention in case no-one else had told you, sir."
						(= local1 3)
					)
					(local27
						(= local27 0)
						(Talk 8 5) ; "My pleasure, m'lord."
					)
					(else
						(Talk 8 6) ; "Beggin' your pardon, m'lord?"
					)
				)
			)
			((Said 'yes,no')
				(Talk 8 51) ; "Forgive me, sire, I do not understand."
			)
		)
	)
)

(instance muleActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					(== global116 1)
					(not (gMuleObj mover:))
					(> (gMuleObj x:) 100)
					(& (gEgo onControl: 1) $4000)
				)
				(gMuleObj setMotion: MoveTo 90 150)
			)
			((and (gMuleObj mover:) (> (gEgo x:) 140))
				(gMuleObj setMotion: 0)
			)
		)
	)
)

(instance walkStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 moveSpeed: 1 setPri: 11 setStep: 3 3)
				(if local25
					(= local26 0)
					(gEgo setLoop: 0 setMotion: MoveTo 259 130 self)
				else
					(= local26 1)
					(gEgo setLoop: 1 setMotion: MoveTo 217 157 self)
				)
			)
			(1
				(gEgo
					setStep: 3 2
					moveSpeed: 0
					setPri: -1
					setLoop: -1
					illegalBits: $8000
				)
				(= local25 local26)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance moveAwayFromBadArea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 210 176 self
				)
			)
			(1
				(gEgo illegalBits: $8000 ignoreActors: 0)
				(HandsOn)
				(gRmMusic stop:)
				(= global116 4)
				(client setScript: 0)
			)
		)
	)
)

