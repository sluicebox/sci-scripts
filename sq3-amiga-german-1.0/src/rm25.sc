;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm25 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm25 of Rm
	(properties
		picture 25
	)

	(method (init &tmp [temp0 50])
		(gUser canInput: 1 canControl: 1)
		(Load rsVIEW (LangSwitch 38 305))
		(gameEyes init: setScript: BoredEyes)
		(gameMouth init: setScript: BoredMouth)
		(super init:)
		(gAddToPics add: sine eachElementDo: #init)
		(gAddToPics doit:)
		(= local0 (LangSwitch 119 90))
		(= local1 (LangSwitch 195 225))
		(SaveSubLang)
		(Display 25 0 dsCOORD local0 182 dsFONT 600 dsWIDTH local1 dsCOLOR 0) ; "PRESS F6 TO EXIT"
		(RestoreSubLang)
		(switch gPrevRoomNum
			(29
				(gCurRoom setScript: Welcome)
			)
			(280
				(if (> global244 0)
					(gCurRoom setScript: PayUp)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event &tmp [temp0 50])
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					(
						(or
							(Said 'pay,pay[/dinner,alien,man,clerk,him,bill]')
							(Said 'give/bill')
						)
						(cond
							((or (!= gPrevRoomNum 280) (not global244))
								(Print 25 1) ; "You haven't even ordered."
							)
							((>= global154 global244)
								(if (not (-= global154 global244))
									(gEgo put: 8 -1) ; Buckazoids
								)
								(= global247 1)
								(= global244 0)
								(= global248 1)
								(if global249
									(gGame changeScore: 10)
								)
								(= global193 0)
								(gCurRoom setScript: LeaveRoom)
							)
							(else
								(gCurRoom setScript: noMoney)
							)
						)
					)
					((Said 'give,trade/crystal[/dinner]')
						(Print 25 2) ; "Cash only, please."
					)
					((or (Said 'disembark,disembark[/area]') (Said '/bye'))
						(= global244 0)
						(= global248 0)
						(= global193 0)
						(= global101 0)
						(gCurRoom newRoom: 29)
					)
					((Said 'look,look[/area]')
						(Print 25 3) ; "The more you look at the food, the less like food it looks.  You can't help wondering how long some of this stuff has been sitting out here just waiting for a sucker like you to come along and eat it."
					)
					((Said 'look,look/up,down,deck,ceiling')
						(Print 25 4) ; "The ceiling above, the floor below, the physical laws of the universe are unchanging. Suspended above you is a menu."
					)
					((Said 'look,look,read/sign,sign')
						(Print 25 5) ; "You think the sign should be titled `Employee With the Most Facial Orifices.'"
					)
					((Said 'look,look/attire,cap')
						(Print 25 6) ; "The clerk is wearing the crisply starched uniform that you've come to know and love in Monolith Burgers everywhere. It looks like it's made from the same substance as the food."
					)
					((Said '/woman,her')
						(Print 25 7) ; "The clerk is offended that you would think he's a female. Any idiot should be able to tell the difference."
					)
					((Said 'look,look/man,clerk,alien,him,bystander,creature')
						(Print 25 8) ; "The clerk looks like he'd rather be doing anything besides waiting on you."
					)
					((Said 'look,look/eye')
						(Print 25 9) ; "The huge, alien eyes seem to exude a vast intelligence.  But, you're not fooled."
					)
					((Said 'look,look/lip')
						(Print 25 10) ; "A dental hygienist's nightmare."
					)
					((Said 'look,look/cavity')
						(Print 25 11) ; "When this guy gets a cold, tissue company stocks rise dramatically."
					)
					((Said 'talk,talk[/man,clerk,alien,him,bystander,creature]')
						(Print 25 12) ; ""I don't have all day, sir," he says in a mock-polite tone of voice."
					)
					((Said 'kiss,kiss/man,clerk,alien,him,bystander,creature')
						(Print 25 13) ; "Not being sure what he might do with his many orifices, you decide against it."
					)
					(
						(Said
							'smell,smell,smell[/man,clerk,alien,him,bystander,creature]'
						)
						(Print 25 14) ; "The only thing you can smell is the aroma of home-cooked food. Obviously a piped-in smell to mask the odor of the real food."
					)
					((Said 'eat,eat')
						(Print 25 15) ; "You'll have to go sit down for that."
					)
					(
						(or
							(Said 'look,look,read/menu')
							(Said 'order,order')
							(Said 'order,order,buy,buy/dinner')
							(Said 'talk,talk/clerk')
						)
						(gCurRoom newRoom: 280)
					)
				)
			)
			(evKEYBOARD
				(if (== (event message:) KEY_F6)
					(event claimed: 1)
					(= global193 0)
					(= global101 0)
					(gCurRoom setScript: LeaveRoom)
				)
			)
			(evMOUSEBUTTON
				(if (and (<= 119 (event x:) 202) (<= 163 (event y:) 190))
					(event claimed: 1)
					(= global193 0)
					(= global101 0)
					(gCurRoom setScript: LeaveRoom)
				)
			)
		)
	)
)

(instance Welcome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global193 1)
				(balloon init: setCel: 1 stopUpd:)
				(gameMouth setLoop: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(1
				(balloon setCel: 2)
				(= seconds 4)
			)
			(2
				(gameMouth setCel: 0 stopUpd:)
				(balloon dispose:)
				(gCurRoom setScript: 0)
				(= global193 0)
			)
		)
	)
)

(instance noMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global193 1)
				(if (== local2 1)
					(= local2 0)
					(gameEyes setMotion: MoveTo 155 74)
				)
				(balloon init: setCel: 4 stopUpd:)
				(gameMouth setLoop: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(1
				(= global244 0)
				(= global247 0)
				(= global193 0)
				(= global101 0)
				(gCurRoom newRoom: 29)
			)
		)
	)
)

(instance LeaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(balloon dispose:)
				(= cycles 1)
			)
			(1
				(Display 25 16 dsRESTOREPIXELS local3)
				(gCurRoom newRoom: 29)
			)
		)
	)
)

(instance PayUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global193 1)
				(balloon init: setCel: 3 stopUpd:)
				(= local3
					(Display
						(Format @global402 25 17 global244) ; "%d"
						dsCOORD
						207
						96
						dsWIDTH
						30
						dsCOLOR
						0
						dsBACKGROUND
						15
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(gameMouth setLoop: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(1
				(gameMouth setCel: 0 stopUpd:)
				(balloon dispose:)
				(= cycles 2)
			)
			(2
				(Display 25 16 dsRESTOREPIXELS local3)
				(= global193 0)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance BoredMouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(if (!= (rm25 script:) 0)
					(self changeState: 0)
				else
					(gameMouth setLoop: 1 setCel: (Random 0 2))
				)
				(self changeState: 0)
			)
		)
	)
)

(instance BoredEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 12))
			)
			(1
				(cond
					((!= (rm25 script:) 0)
						(self changeState: 0)
					)
					((== local2 0)
						(= local2 1)
						(switch (Random 1 3)
							(1
								(gameEyes setMotion: MoveTo 155 61 self)
							)
							(2
								(gameEyes setMotion: MoveTo 172 71 self)
							)
							(3
								(gameEyes setMotion: MoveTo 139 71 self)
							)
						)
					)
					(else
						(= local2 0)
						(gameEyes setMotion: MoveTo 155 71 self)
					)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance gameEyes of Actor
	(properties)

	(method (init)
		(super init:)
		(self view: (LangSwitch 38 305) setLoop: 2 posn: 155 71 ignoreActors: 1)
	)
)

(instance gameMouth of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: (LangSwitch 38 305)
			setLoop: 1
			setCel: 0
			posn: 155 137
			ignoreActors: 1
			cycleSpeed: 2
		)
	)
)

(instance balloon of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: (LangSwitch 38 305)
			setLoop: 3
			setCel: 3
			posn: 206 119
			setPri: 15
		)
	)
)

(instance sine of PicView
	(properties
		x 290
		y 89
		loop 3
		priority 15
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 38 305))
		(super init:)
	)
)

