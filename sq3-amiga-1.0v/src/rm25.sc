;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm25 0
)

(local
	local0
	local1
	local2
)

(instance rm25 of Rm
	(properties
		picture 25
	)

	(method (init &tmp [temp0 50])
		(User canInput: 1 canControl: 1)
		(Load rsVIEW 38)
		(eyes init: setScript: BoredEyes)
		(mouth init: setScript: BoredMouth)
		(super init:)
		(gAddToPics add: sine)
		(gAddToPics doit:)
		(Display 25 0 dsCOORD 121 183 dsFONT 600 dsWIDTH 90 dsCOLOR 0) ; "PRESS F6 TO EXIT"
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
							(Said 'pay[/dinner,alien,man,clerk,him,bill]')
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
								(gCurRoom newRoom: 29)
							)
							(else
								(gCurRoom setScript: noMoney)
							)
						)
					)
					((Said 'give,trade/crystal[/dinner]')
						(Print 25 2) ; "Cash only, please."
					)
					((or (Said 'disembark[/area]') (Said '/bye'))
						(= global244 0)
						(= global248 0)
						(= global193 0)
						(= global101 0)
						(gCurRoom newRoom: 29)
					)
					((Said 'look[/area]')
						(Print 25 3) ; "The more you look at the food, the less like food it looks.  You can't help wondering how long some of this stuff has been sitting out here just waiting for a sucker like you to come along and eat it."
					)
					((Said 'look/up,down,deck,ceiling')
						(Print 25 4) ; "The ceiling above, the floor below, the physical laws of the universe are unchanging. Suspended above you is a menu."
					)
					((Said 'look,read/sign')
						(Print 25 5) ; "You think the sign should be titled `Employee With the Most Facial Orifices.'"
					)
					((Said 'look/attire,cap')
						(Print 25 6) ; "The clerk is wearing the crisply starched uniform that you've come to know and love in Monolith Burgers everywhere. It looks like it's made from the same substance as the food."
					)
					((Said '/woman,her')
						(Print 25 7) ; "The clerk is offended that you would think he's a female. Any idiot should be able to tell the difference."
					)
					((Said 'look/man,clerk,alien,him,bystander,animal')
						(Print 25 8) ; "The clerk looks like he'd rather be doing anything besides waiting on you."
					)
					((Said 'look/eye')
						(Print 25 9) ; "The huge, alien eyes seem to exude a vast intelligence.  But, you're not fooled."
					)
					((Said 'look/lip')
						(Print 25 10) ; "A dental hygienist's nightmare."
					)
					((Said 'look/cavity')
						(Print 25 11) ; "When this guy gets a cold, tissue company stocks rise dramatically."
					)
					((Said 'talk[/man,clerk,alien,him,bystander,animal]')
						(Print 25 12) ; ""I don't have all day, sir," he says in a mock-polite tone of voice."
					)
					((Said 'kiss/man,clerk,alien,him,bystander,animal')
						(Print 25 13) ; "Not being sure what he might do with his many orifices, you decide against it."
					)
					((Said 'smell[/man,clerk,alien,him,bystander,animal]')
						(Print 25 14) ; "The only thing you can smell is the aroma of home-cooked food. Obviously a piped-in smell to mask the odor of the real food."
					)
					((Said 'eat')
						(Print 25 15) ; "You'll have to go sit down for that."
					)
					(
						(or
							(Said 'look,read/menu')
							(Said 'order')
							(Said 'order,buy/dinner')
							(Said 'talk/clerk')
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
					(gCurRoom newRoom: 29)
				)
			)
			(evMOUSEBUTTON
				(if (and (<= 119 (event x:) 202) (<= 163 (event y:) 190))
					(event claimed: 1)
					(= global193 0)
					(= global101 0)
					(gCurRoom newRoom: 29)
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
				(mouth setLoop: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(1
				(balloon setCel: 2)
				(= seconds 4)
			)
			(2
				(mouth setCel: 0 stopUpd:)
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
				(if (== local0 1)
					(= local0 0)
					(eyes setMotion: MoveTo 155 74)
				)
				(balloon init: setCel: 4 stopUpd:)
				(mouth setLoop: 0 setCycle: Fwd)
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

(instance PayUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global193 1)
				(balloon init: setCel: 3 stopUpd:)
				(= local1
					(Display
						(Format @global402 25 16 global244) ; "%d"
						dsCOORD
						207
						98
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
				(mouth setLoop: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(1
				(mouth setCel: 0 stopUpd:)
				(balloon dispose:)
				(= cycles 2)
			)
			(2
				(Display 25 17 dsRESTOREPIXELS local1)
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
					(mouth setLoop: 1 setCel: (Random 0 2))
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
					((== local0 0)
						(= local0 1)
						(switch (Random 1 3)
							(1
								(eyes setMotion: MoveTo 155 61 self)
							)
							(2
								(eyes setMotion: MoveTo 172 71 self)
							)
							(3
								(eyes setMotion: MoveTo 139 71 self)
							)
						)
					)
					(else
						(= local0 0)
						(eyes setMotion: MoveTo 155 71 self)
					)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance eyes of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 38 setLoop: 2 posn: 155 71 ignoreActors: 1)
	)
)

(instance mouth of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 38
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
		(self view: 38 setLoop: 3 setCel: 3 posn: 206 119 setPri: 15)
	)
)

(instance sine of PV
	(properties
		y 89
		x 290
		view 38
		loop 3
		priority 15
		signal 16384
	)
)

