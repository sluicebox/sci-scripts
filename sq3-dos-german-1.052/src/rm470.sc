;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm470 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(= global193 1)
	(rHand setCycle: 0)
	(= local2 1)
	(balloon setCel: 1)
	(ArmUp changeState: 0)
	(mouth setCycle: Fwd)
)

(procedure (localproc_1 param1 param2 param3 param4 param5)
	(lHand hide:)
	(lArm setCel: 0)
	(RedrawCast)
	(= local2 1)
	(head cel: 1)
	(eyes posn: 150 58 setCel: 2)
	(lArm view: 81 setLoop: 0 setCel: 0)
	(lHand
		view: 81
		setLoop: param1
		setCel: param2
		posn: param3 param4
		setCycle: param5
		show:
	)
)

(procedure (localproc_2)
	(if local0
		(balloon setCel: 3)
		(cls)
		(= local0 0)
	)
	(head cel: 0)
	(eyes posn: 140 55 setLoop: 1 setCel: 0)
	(lHand view: 80 setLoop: 6 setCel: 0 posn: 166 80 hide:)
	(lArm view: 80 setLoop: 5 setCel: 0)
	(rHand show: setCycle: Fwd)
	(mouth setCel: 6 setCycle: 0)
	(= local2 0)
	(= global193 0)
)

(procedure (localproc_3 param1)
	(switch
		(Print
			(Format @global402 470 47 param1 param1) ; ""I'll take it off your hands for %d buckazoids. Whaddya say?"%"
			#icon
			81
			0
			2
			#mode
			1
			#title
			{Haggle Interface}
			#button
			{ Yes }
			1
			#button
			{ No }
			2
		)
		(1
			(return 1)
		)
		(2
			(return 0)
		)
	)
)

(instance rm470 of Rm
	(properties
		picture 470
		style 7
	)

	(method (init)
		(= picture (LangSwitch 470 320))
		(User canInput: 1 canControl: 1)
		(Load rsVIEW 80)
		(Load rsVIEW 81)
		(Load rsSOUND 13)
		(super init:)
		(gAddToPics add: bones robots)
		(gAddToPics doit:)
		(head init: stopUpd:)
		(eyes init: setScript: EyeBlink)
		(rArm init: stopUpd: setScript: ArmUp)
		(rHand init: setCycle: Fwd setScript: MoveEye)
		(lArm init: stopUpd:)
		(lHand init: stopUpd: hide: setScript: EarWax)
		(mouth init:)
		(balloon init: setCel: 3)
		(if (or (== (gLongSong state:) 0) (== (gLongSong number:) 22))
			(gLongSong number: 13 priority: 3 loop: -1 play:)
		)
		(= local0 0)
		(self setScript: Howdy)
	)

	(method (doit &tmp [temp0 30])
		(super doit:)
		(if (and (== (balloon cel:) 1) (not gModelessDialog))
			(localproc_2)
		)
	)

	(method (newRoom newRoomNumber)
		(= global193 0)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if local0
			(cls)
		)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 [temp1 50])
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(if (and (== (event message:) KEY_RETURN) local0)
					(localproc_2)
					(script cue:)
				)
			)
			(evSAID
				(cond
					((Said 'look,look[/area,store,store]')
						(Print 470 0) ; "The cast-off refuse of a dozen worlds clings to every available surface of the store. You're astonished at the diversity. You're even more astonished that someone would buy this stuff."
					)
					((Said 'look,look/counter,box,show,display,cabinet')
						(PrintSplit 470 1) ; "The glass counter, smeared with the fingerprints (and who knows what else) of countless off-world species, covers an impressive array of over-priced rocks and gems. Atop the counter is a rack of colorful post cards from all corners of the galaxy."
						(= local1 1)
					)
					(
						(Said
							'look,look/head,face,face,man,blatz,alien,creature,owner'
						)
						(PrintSplit 470 2) ; "Imagine, if you will, a sleazy tourist trap in the middle of the howling desert on Phleebhut.  The proprietor looks like the unfortunate offspring of a union between a squid and a Vorlian gas beast. His keen business mind and utter lack of scruples afford him a comfortable living here on the backside of civilization."
					)
					((Said 'look,look/mouth')
						(Print 470 3) ; "A mouth whose favorite word is 'money' grins at you between sales pitches."
					)
					((Said 'look,look/eye')
						(Print 470 4) ; "The bulging, reptilian eyes scan you greedily."
					)
					((Said 'look,look/finger')
						(Print 470 5) ; "This is not Police Quest."
					)
					((Said 'look,look/skull,head')
						(Print 470 6) ; "The skull of a horned Phleebeast hangs from the rafters."
					)
					((Said 'look,look/rock,crystal')
						(if (gEgo has: 0) ; Glowing_Gem
							(Print 470 7) ; "Many colorful gems are proudly displayed.  Why.. Those green gems at the end there look just like the orium in your pocket."
						else
							(Print 470 8) ; "Many colorful gems are proudly displayed.  Why.. Those green gems at the end there look just like the orium you found in the swamp on Labion."
						)
					)
					(
						(or
							(Said 'look,look/deck,ceiling')
							(Said 'look,look<up,down')
						)
						(Print 470 9) ; "The floor below, the ceiling above. The physical laws of the universe are unchanging."
					)
					((Said 'look,look/pane')
						(Print 470 10) ; "The pleasant landscape of Phleebhut stretches to the horizon."
					)
					((Said 'look,look/partition')
						(Print 470 11) ; "The walls keep the ceiling and the floor from slamming into each other."
					)
					((Said 'look,look/glass')
						(Print 470 12) ; "The glass is, as usual, transparent."
					)
					((Said 'look,look/rack')
						(Print 470 13) ; "The rack holds many interesting postcards."
					)
					((Said 'look,look/shirt')
						(Print 470 14) ; "Mercifully, it covers his somewhat repulsive body."
					)
					(
						(Said
							'look,look/shelf,jar,bone,banner,android,junk,debris,domino'
						)
						(Print 470 15) ; "The shelves are arrayed with some fine examples of the natural wonders of this planet. Also some worthless junk that can only be found in a fine tourist establishment such as this."
					)
					((Said 'look,look,read/postcard,card')
						(if (== global600 6)
							(= global600 1)
						else
							(++ global600)
						)
						((ScriptID 471 0) doit:) ; postCard
					)
					(
						(or
							(Said
								'disembark,disembark[/area,blatz,store,store,shop,shop]'
							)
							(Said '/bye')
							(Said 'go<out')
						)
						(gCurRoom setScript: ByeScript)
					)
					((Said 'ask,talk,talk>')
						(cond
							(
								(or
									(Said '/scumsoft,(soft<scum)')
									(Said '/blatz/scumsoft,(soft<scum)')
								)
								(gCurRoom setScript: ScumScript)
							)
							((or (Said '/pestulon') (Said '/blatz/pestulon'))
								(gCurRoom setScript: PestScript)
							)
							(else
								(event claimed: 1)
								(Print 470 16) ; "He's not listening to you, he likes the sound of his own voice too much."
							)
						)
					)
					((Said 'break,hit')
						(Print 470 17) ; "Come on, don't tear the place up!"
					)
					((Said 'rob,kill')
						(Print 470 18) ; "You've come this far without resorting to crime; don't start now."
					)
					((Said 'kiss,kiss')
						(Print 470 19) ; "Not a real appealing thought."
					)
					((Said 'wear,(drop<on)/cap')
						(if (gEgo has: 6) ; Astro_Chicken_Flight_Hat
							(= global130 1)
							(Print 470 20) ; "You don the jaunty hat. You feel more sporty already!"
						else
							(DontHave) ; "You don't have it."
						)
					)
					((Said 'remove,(get<off)/cap')
						(cond
							((not (gEgo has: 6)) ; Astro_Chicken_Flight_Hat
								(DontHave) ; "You don't have it."
							)
							(global130
								(= global130 0)
								(Print 470 21) ; "OK"
							)
							(else
								(Print 470 22) ; "You're not wearing the hat."
							)
						)
					)
					(
						(Said
							'get,get/jar,bone,android,banner,skull,junk,debris,head'
						)
						(Print 470 23) ; "Everything has a price around here. You'll have to try buying it."
					)
					((Said 'get,get>')
						(if (= temp0 (gInventory firstTrue: #saidMe))
							(cond
								((temp0 ownedBy: 470)
									(Print 470 23) ; "Everything has a price around here. You'll have to try buying it."
								)
								((temp0 ownedBy: gEgo)
									(Print 470 24) ; "Admittedly, they're very nice, but you already own one."
								)
								(else
									(Print 470 25) ; "That doesn't seem to be available."
								)
							)
						)
					)
					(
						(Said
							'buy,buy/jar,bone,android,banner,skull,junk,debris,head'
						)
						(Print 470 26) ; "Come on, noboby buys that stuff!"
					)
					((Said 'buy,buy/crystal,rock')
						(if (gEgo has: 0) ; Glowing_Gem
							(Print 470 27) ; "Sorry friend, these gems are just for gawkin'at. They're quite valuable don'tcha know."
						else
							(Print 470 28) ; "If you wanted Orium, you shouldn't have sold your only piece!"
						)
					)
					((Said 'buy,buy/postcard')
						(Print 470 29) ; "You almost buy one, then realize that you don't have any friends to send one to."
					)
					((Said 'buy,buy>')
						(if (= temp0 (gInventory firstTrue: #saidMe))
							(cond
								((temp0 ownedBy: 470)
									(if (>= global154 25)
										(Print 470 30) ; "A wise choice. I'm sure you'll be very, very pleased!"
										(temp0 moveTo: gEgo)
										(gGame changeScore: 5)
										(-= global154 25)
									else
										(Print 470 31) ; "Everything here costs 25 buckazoids, and you don't have that much!"
									)
								)
								((temp0 ownedBy: gEgo)
									(Print 470 24) ; "Admittedly, they're very nice, but you already own one."
								)
								(else
									(Print 470 32) ; "That doesn't seem to be available."
								)
							)
						)
					)
					(
						(Said
							'give,drop,sell,show,trade/crystal,crystal[<glowing]'
						)
						(if (gEgo has: 0) ; Glowing_Gem
							(if (not global103)
								(gCurRoom setScript: Orium)
							else
								(gCurRoom setScript: Orium2)
							)
						else
							(Print 470 33) ; "You don't have one."
						)
					)
				)
			)
		)
	)
)

(instance Howdy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(localproc_0)
				(= local0
					(PrintSplit ; "Howdy, stranger! The name's Blatz, Fester Blatz. Welcome to World o' Wonders. Go ahead, have a look at some of the trendiest items in the known universe. Make the most of your vacation buckazoid!"
						470
						34
						67
						-1
						1
						70
						280
						33
						600
						(and (not (gGame subtitleLang:)) 93)
					)
				)
				(= seconds 15)
			)
			(2
				(localproc_2)
				(= seconds 8)
			)
			(3
				(client setScript: SalesPitch)
			)
		)
	)
)

(instance PestScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2)
				(RedrawCast)
				(localproc_0)
				(= local0
					(PrintSplit ; "Pestulon, Pestulon. Isn't that a deodorant? No, no, that's PestBeGone. Hmmmm, I think Pestulon's just south of the Lungfish Nebula. Yeah, I'm sure that's where it is."
						470
						35
						67
						-1
						1
						70
						280
						33
						600
						(and (not (gGame subtitleLang:)) 93)
					)
				)
				(= local2 0)
				(EarWax changeState: 2)
				(= seconds 15)
			)
			(1
				(localproc_2)
				(gCurRoom setScript: SalesPitch)
			)
		)
	)
)

(instance ScumScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2)
				(RedrawCast)
				(localproc_0)
				(= local0
					(PrintSplit ; "They make Astro Chicken, don't they? Kind of a hush hush operation from what I hear. I've heard rumors that they're involved in the Two Guys From Andromeda kidnapping."
						470
						36
						67
						-1
						1
						70
						280
						33
						600
						(and (not (gGame subtitleLang:)) 93)
					)
				)
				(= local2 0)
				(EarWax changeState: 2)
				(= seconds 15)
			)
			(1
				(localproc_2)
				(gCurRoom setScript: SalesPitch)
			)
		)
	)
)

(instance ByeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2)
				(RedrawCast)
				(localproc_0)
				(= local0
					(PrintSplit ; "Thanks for stop'n by! Hey, looks like that lightning is gettin' close, better be careful out there!"
						470
						37
						67
						-1
						1
						70
						280
						33
						600
						(and (not (gGame subtitleLang:)) 93)
					)
				)
				(= seconds 4)
			)
			(1
				(localproc_2)
				(RedrawCast)
				(gLongSong fade:)
				(gCurRoom newRoom: 43)
			)
		)
	)
)

(instance SalesPitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if ((gInventory at: 4) ownedBy: 470) ; Orat_on_a_Stick
					(localproc_1 1 0 210 93 Fwd)
					(= cycles 30)
				else
					(= cycles 2)
				)
			)
			(2
				(if ((gInventory at: 4) ownedBy: 470) ; Orat_on_a_Stick
					(localproc_0)
					(= local0
						(PrintSplit ; "How about a nice Orat on a Stick! The kids'll just love this! We're talkin' hours of fun for the whole family! Just look how cute this little guy is!"
							470
							38
							67
							-1
							1
							70
							280
							33
							600
							(and (not (gGame subtitleLang:)) 93)
						)
					)
					(= seconds 15)
				else
					(= cycles 2)
				)
			)
			(3
				(if local0
					(localproc_2)
					(= seconds 7)
				else
					(= cycles 2)
				)
			)
			(4
				(if ((gInventory at: 6) ownedBy: 470) ; Astro_Chicken_Flight_Hat
					(localproc_1 2 1 217 95 0)
					(= cycles 30)
				else
					(= cycles 2)
				)
			)
			(5
				(if ((gInventory at: 6) ownedBy: 470) ; Astro_Chicken_Flight_Hat
					(localproc_0)
					(= local0
						(PrintSplit ; "Now here's a red-hot item, the Official Astro Chicken Flight Hat! You'll really turn some heads in this sporty little number! It's modeled after the hot new arcade game that's sweeping the galaxy."
							470
							39
							67
							-1
							1
							70
							280
							33
							600
							(and (not (gGame subtitleLang:)) 93)
						)
					)
					(= seconds 15)
				else
					(= cycles 2)
				)
			)
			(6
				(if local0
					(localproc_2)
					(= seconds 7)
				else
					(= cycles 2)
				)
			)
			(7
				(if ((gInventory at: 5) ownedBy: 470) ; ThermoWeave_Underwear
					(localproc_1 2 0 215 94 0)
					(= cycles 30)
				else
					(= cycles 2)
				)
			)
			(8
				(if ((gInventory at: 5) ownedBy: 470) ; ThermoWeave_Underwear
					(localproc_0)
					(= local0
						(PrintSplit ; "Goin' to any high-temp planets? This nice pair of ThermoWeave underwear'll keep your internal environment pleasant on even the sweatiest worlds."
							470
							40
							67
							-1
							1
							70
							280
							33
							600
							(and (not (gGame subtitleLang:)) 93)
						)
					)
					(= seconds 15)
				else
					(= cycles 2)
				)
			)
			(9
				(if local0
					(localproc_2)
					(= seconds 7)
				else
					(= cycles 2)
				)
			)
			(10
				(localproc_0)
				(= local0
					(PrintSplit ; "You just take your time, ya hear? Don't feel pressured to buy anything."
						470
						41
						67
						-1
						1
						70
						280
						33
						600
						(and (not (gGame subtitleLang:)) 93)
					)
				)
				(= seconds 10)
			)
			(11
				(localproc_2)
				(= seconds 10)
			)
			(12
				(if (== local1 1)
					(localproc_0)
					(= local0
						(PrintSplit ; "I seen ya eyein' the display case. You'll notice a very nice collection of orium crystals. I think you'll agree that they're some of the highest quality gems on this hemisphere. And priced to sell, too!"
							470
							42
							67
							-1
							1
							70
							280
							33
							600
							(and (not (gGame subtitleLang:)) 93)
						)
					)
					(= seconds 15)
				else
					(= cycles 2)
				)
			)
			(13
				(if (== local1 1)
					(localproc_2)
					(= seconds 7)
				else
					(= cycles 2)
				)
			)
			(14
				(self init:)
			)
		)
	)
)

(instance Orium of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_2)
				(= local2 1)
				(= cycles 2)
			)
			(1
				(rock init:)
				(head setCel: 0)
				(eyes setCel: 3 posn: 140 55)
				(mouth setCel: 7)
				(rArm setCel: 2)
				(rHand hide:)
				(lArm setCel: 2)
				(= seconds 2)
			)
			(2
				(rArm setCel: 0)
				(localproc_2)
				(localproc_0)
				(= local0
					(PrintSplit ; "My, my, that certainly is one fine hunk o' orium!"
						470
						43
						67
						-1
						1
						70
						280
						33
						600
						(and (not (gGame subtitleLang:)) 93)
					)
				)
				(= seconds 4)
			)
			(3
				(= global103 1)
				(localproc_2)
				(switch (localproc_3 350)
					(0
						(= cycles 2)
					)
					(1
						(gEgo get: 8 put: 0) ; Buckazoids, Glowing_Gem
						(+= global154 350)
						(rock dispose:)
						(gGame changeScore: 2)
						(HandsOn)
						(client setScript: SalesPitch)
					)
				)
			)
			(4
				(switch (localproc_3 400)
					(0
						(= cycles 2)
					)
					(1
						(gEgo get: 8 put: 0) ; Buckazoids, Glowing_Gem
						(+= global154 400)
						(rock dispose:)
						(gGame changeScore: 4)
						(HandsOn)
						(client setScript: SalesPitch)
					)
				)
			)
			(5
				(switch (localproc_3 425)
					(0
						(= cycles 2)
					)
					(1
						(gEgo get: 8 put: 0) ; Buckazoids, Glowing_Gem
						(+= global154 425)
						(rock dispose:)
						(gGame changeScore: 8)
						(HandsOn)
						(client setScript: SalesPitch)
					)
				)
			)
			(6
				(localproc_0)
				(= local0
					(PrintSplit ; "Well, 'fraid I can't go any higher. Maybe some other time, eh?"
						470
						44
						67
						-1
						1
						70
						280
						33
						600
						(and (not (gGame subtitleLang:)) 93)
					)
				)
				(= seconds 4)
			)
			(7
				(localproc_2)
				(rock dispose:)
				(HandsOn)
				(= local2 0)
				(client setScript: SalesPitch)
			)
		)
	)
)

(instance Orium2 of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_2)
				(= local2 1)
				(= cycles 2)
			)
			(1
				(rock init:)
				(head setCel: 0)
				(eyes setCel: 0 posn: 140 55)
				(localproc_0)
				(= local0
					(PrintSplit ; "Yessiree, that's one fine hunk o' orium! Course, the orium market's a little slow today..."
						470
						45
						67
						-1
						1
						70
						280
						33
						600
						(and (not (gGame subtitleLang:)) 93)
					)
				)
				(= seconds 4)
			)
			(2
				(localproc_2)
				(switch (localproc_3 100)
					(0
						(= cycles 2)
					)
					(1
						(gEgo get: 8 put: 0) ; Buckazoids, Glowing_Gem
						(+= global154 100)
						(rock dispose:)
						(gGame changeScore: 1)
						(HandsOn)
						(client setScript: SalesPitch)
					)
				)
			)
			(3
				(localproc_0)
				(= local0
					(PrintSplit ; "Well, OK. Ya drive a hard bargain, stranger. Maybe some other time, eh?"
						470
						46
						67
						-1
						1
						70
						280
						33
						600
						(and (not (gGame subtitleLang:)) 93)
					)
				)
				(= seconds 4)
			)
			(4
				(localproc_2)
				(rock dispose:)
				(HandsOn)
				(= local2 0)
				(client setScript: SalesPitch)
			)
		)
	)
)

(instance EyeBlink of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(= seconds (Random 4 7))
			)
			(1
				(if (!= (= local3 (eyes cel:)) 3)
					(eyes loop: 8 cel: 255 setCycle: End self)
				else
					(= cycles 2)
				)
			)
			(2
				(eyes loop: 1 cel: local3)
				(self init:)
			)
		)
	)
)

(instance MoveEye of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(= seconds (Random 3 5))
			)
			(1
				(cond
					((or local0 (== (eyes cel:) 3))
						(self init:)
					)
					((== (eyes cel:) 0)
						(eyes cel: 1)
					)
					(else
						(eyes cel: 0)
					)
				)
				(self init:)
			)
		)
	)
)

(instance EarWax of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(= seconds (Random 10 25))
			)
			(1
				(if local2
					(self init:)
				else
					(= cycles 2)
				)
			)
			(2
				(lArm setCel: 1)
				(lHand show: cycleSpeed: 3 setCycle: End self)
			)
			(3
				(lHand setCycle: Beg self)
			)
			(4
				(lHand hide:)
				(lArm setCel: 0)
				(= cycles 1)
			)
			(5
				(self init:)
			)
		)
	)
)

(instance ArmUp of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(if local0
					(= seconds (Random 4 12))
				)
			)
			(1
				(if local0
					(rHand hide:)
					(rArm setCel: 1)
					(= seconds 2)
				)
			)
			(2
				(rArm setCel: 0)
				(rHand show:)
				(self init:)
			)
		)
	)
)

(instance head of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setLoop: 0 setCel: 0 setPri: 13 posn: 141 121)
	)
)

(instance eyes of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setLoop: 1 setCel: 0 setPri: 14 posn: 140 55)
	)
)

(instance mouth of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 80
			setLoop: 2
			setCel: 6
			setPri: 14
			cycleSpeed: 0
			posn: 142 101
		)
	)
)

(instance rArm of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setLoop: 3 setCel: 0 setPri: 14 posn: 98 151)
	)
)

(instance rHand of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setLoop: 4 setCel: 0 setPri: 14 posn: 172 150)
	)
)

(instance lArm of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setLoop: 5 setCel: 0 setPri: 14 posn: 166 100)
	)
)

(instance lHand of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setLoop: 6 setCel: 0 setPri: 14 posn: 166 80)
	)
)

(instance balloon of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 81 setLoop: 0 setCel: 1 setPri: 15 posn: 100 62)
	)
)

(instance rock of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setLoop: 7 setCel: 0 setPri: 15 posn: 155 155)
	)
)

(instance bones of PV
	(properties
		y 70
		x 201
		view 74
		priority 3
		signal 16384
	)
)

(instance robots of PV
	(properties
		y 115
		x 208
		view 74
		cel 1
		priority 3
		signal 16384
	)
)

