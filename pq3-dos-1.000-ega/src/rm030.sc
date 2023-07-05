;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use PChase)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm030 0
)

(local
	local0
	[local1 8] = [90 270 180 0 135 225 45 315]
	local9
)

(procedure (localproc_0)
	(JHead cel: 0 setCycle: 0)
	(JOpenHand cel: 0)
)

(instance rm030 of PQRoom
	(properties
		picture 30
		north -1
		east -1
		south -1
		west -1
	)

	(method (init)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 121 0 0 319 0 319 35 110 21
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 217 108 182 178 159 186 132 182 122 175 114 181 99 182 90 189 0 189 60 159 95 174 100 167 112 163 125 159 168 96 213 99
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 136 300 141 277 139 261 123 252 107 319 85
					yourself:
				)
		)
		(keyShop init:)
		(armyShop init:)
		(sidewalk init:)
		(otherStores init:)
		(blacktop init:)
		(lamp init:)
		(mariesCar init:)
		(theRoom init:)
		(gEgo view: 1 setStep: 3 2 init:)
		(if (not (IsFlag 39))
			(ambulence init:)
			(headLight init:)
			(lDoor init:)
			(rDoor init:)
			(redLight setCycle: Fwd init:)
			(medics init:)
		else
			(searchMusic play:)
		)
		(pCar init:)
		(pCar2 init:)
		(switch gPrevRoomNum
			(32
				(HandsOff)
				(gEgo
					normal: 0
					view: 374
					posn: 261 165
					cel: 0
					setLoop: 1
					init:
				)
				(SetFlag 39)
				(self setScript: getInAmbulance)
			)
			(36
				(sFX number: 901 play:)
				(HandsOff)
				(gEgo
					normal: 1
					posn: 120 200
					setCycle: Walk
					setLoop: -1
					cycleSpeed: (gGame egoMoveSpeed:)
					moveSpeed: (gGame egoMoveSpeed:)
					loop: 0
					init:
				)
				(Face gEgo reporter)
				(officer
					setStep: 2 1
					setCycle: Walk
					setScript: searchGrid
					init:
				)
				(star init:)
				(= global105 22)
				(= global106 0)
				(self setScript: reporterScript)
			)
			(else
				(if (not (IsFlag 39))
					(HandsOff)
					(self setScript: goToMarie)
					(gEgo
						normal: 0
						view: 374
						posn: 340 150
						setPri: -1
						setLoop: 0
						setCycle: Walk
						init:
					)
					(gLongSong number: 320 flags: 1 loop: -1 play:)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $4000)
				(HandsOff)
				(gCurRoom setScript: goBack)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 930)
		(DisposeScript 951)
		(super dispose:)
	)
)

(instance goBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(officer setMotion: 0 setScript: 0)
				(Say officer 30 0) ; "Better stay clear of this area, Sonny, we're sweeping for evidence."
				(= seconds 5)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(officer setScript: searchGrid)
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo setMotion: MoveFwd 10 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goToMarie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX number: 472 play:)
				(= cycles 10)
			)
			(1
				(Print 30 1) ; "The first thing that strikes you is that the car belongs to Marie. Then you see the paramedics working over a body. Panic begins to overwhelm you as you race to the ambulance."
				(sFX number: 901 play:)
				(gEgo xStep: 7 setMotion: PolyPath 240 160 self)
			)
			(2
				(gEgo cel: 0 loop: 1)
				(= cycles 10)
			)
			(3
				(gCurRoom newRoom: 32)
			)
		)
	)
)

(instance getInAmbulance of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(Print 30 2 #at 10 10 #dispose) ; "You jump in the ambulance and respond code three to the hospital."
				(medics cel: 0 setCycle: End self)
			)
			(2
				(sirenSound play:)
				(= cycles 1)
			)
			(3
				(medics loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo cycleSpeed: 8 setCycle: End self)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(lDoor setCycle: Beg self)
				(rDoor setCycle: Beg self)
			)
			(6)
			(7
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 98 6)
				(sirenSound fade:)
				(gLongSong play:)
				(= seconds 6)
			)
			(8
				(gCurRoom drawPic: 5 6)
				(jim init:)
				(= cycles 1)
			)
			(9
				(= save1 1)
				(JHead setCycle: RandCycle)
				(Display 30 3 dsRESTOREPIXELS local9)
				(= local9
					(Display 30 4 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "Marie is rushed to Lytton General Emergency where doctors begin the race to save her life."
				)
				(= seconds 7)
			)
			(10
				(localproc_0)
				(= seconds 2)
			)
			(11
				(= save1 1)
				(JHead setCycle: RandCycle)
				(Display 30 3 dsRESTOREPIXELS local9)
				(= local9
					(Display 30 5 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "They work through the night, fighting to stabilize Marie's condition. Sonny spends hours of agony in the waiting room. Although they manage to save her life, Marie remains in a coma."
				)
				(= seconds 12)
			)
			(12
				(localproc_0)
				(= seconds 2)
			)
			(13
				(= save1 1)
				(JHead setCycle: RandCycle)
				(Display 30 3 dsRESTOREPIXELS local9)
				(= local9
					(Display 30 6 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "When he's finally allowed to see her, Sonny holds her hand until the pre-dawn hours, hoping and searching for some sign that she'll come back to him."
				)
				(= seconds 10)
			)
			(14
				(gLongSong fade:)
				(JEye cel: 0 setScript: 0)
				(= cycles 1)
			)
			(15
				(localproc_0)
				(= seconds 2)
				(Display 30 3 dsRESTOREPIXELS local9)
				(= local9
					(Display 30 3 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS)
				)
				(= seconds 2)
			)
			(16
				(gCurRoom newRoom: 36)
			)
		)
	)
)

(instance goHome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 319 140 self)
			)
			(1
				(Print 30 7) ; "Physically and emotionally exhausted, you decide to go home and get some rest."
				(= global105 22)
				(gCurRoom newRoom: 38)
			)
		)
	)
)

(instance reporterScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 215 153 self)
				(reporter
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath 238 159 self
					init:
				)
			)
			(1 0)
			(2
				(Face gEgo reporter)
				(rInset init:)
				(= save1 1)
				(Say rInset 30 8) ; "Looks like another one bit the dust, eh?"
				(= seconds 4)
			)
			(3
				(= save1 1)
				(Say rInset 30 9) ; "I understand you were here before they removed the victim. Did you catch any dying words? Notice any signs of sexual assault? Anything at all?"
				(= seconds 10)
			)
			(4
				(User canInput: 1)
				(gTheIconBar enable: 3)
				(rInset dispose:)
				(= seconds 5)
			)
			(5
				(= save1 1)
				(Print 30 10 #at 10 10 #dispose) ; "Responding to your silence, the reporter says..."
				(= seconds 5)
			)
			(6
				(= save1 1)
				(rInset init:)
				(Say rInset 30 11) ; "Well, if YOU don't want to talk to me, I'll just get the information elsewhere!"
				(= seconds 8)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(rInset dispose:)
				(reporter setScript: walkAway)
				(self dispose:)
			)
		)
	)
)

(instance walkAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(reporter setLoop: 0 setMotion: PolyPath 340 160 self)
			)
			(2
				(HandsOn)
				(reporter dispose:)
				(self dispose:)
			)
		)
	)
)

(instance getCard of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo reporter)
				(reporter setLoop: 1 setMotion: PChase gEgo 20 self)
			)
			(1
				(= save1 1)
				(sInset init:)
				(Say sInset 30 12) ; "Listen, you little blood sucking piece of FILTH! The victim was my wife! You guys are all the same. Now get outta here before I forget that I'm wearing this badge!"
				(= seconds 10)
			)
			(2
				(= save1 1)
				(Say sInset 30 13) ; "I'll give your paper some details alright!... All about how I rearranged your face!"
				(= seconds 8)
			)
			(3
				(= save1 1)
				(sInset dispose:)
				(rInset init:)
				(Say rInset 30 14) ; "Oh, Geez! Look Officer I- I'm terribly sorry!"
				(= seconds 4)
			)
			(4
				(= save1 1)
				(Say rInset 30 15) ; "I'm just trying to get the facts. I thought you cops liked that kind of loose talk - helps keep things from getting too serious, know what I mean?"
				(= seconds 10)
			)
			(5
				(= save1 1)
				(Say rInset 30 16) ; "Here's my card. If there is anything I can ever help you with, Officer, give me a ring, huh? Again, sorry about your wife."
				(= seconds 10)
				(rCard setCycle: End init:)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(SetScore 126 3)
				(gEgo get: 38) ; busCard
				(rMouth setCycle: 0)
				(rCard dispose:)
				(= seconds 1)
			)
			(7
				(rInset dispose:)
				(walkAway start: 0)
				(reporter setScript: walkAway)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance searchGrid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(officer setLoop: 0 setMotion: MoveTo 25 145 self)
			)
			(1
				(officer setLoop: 1 setMotion: MoveTo 119 48 self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance reporter of Actor
	(properties
		x 340
		y 150
		lookStr {Uh-oh. It looks like one of those ambulance-chasing reporters.}
		view 381
		cycleSpeed 10
		moveSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(if (not (gEgo has: 38)) ; busCard
					(HandsOff)
					(gCurRoom setScript: getCard)
					(self setScript: 0)
				else
					(Print 30 17) ; "You feel a moment of remorse for your outburst, and almost say 'thanks', but fortunately the moment passes."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rInset of View
	(properties
		x 174
		y 130
		view 382
		priority 15
		signal 16401
	)

	(method (init)
		(rMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(rMouth dispose:)
	)
)

(instance rMouth of Prop
	(properties
		description {Reporter}
		view 382
		loop 1
		priority 15
		signal 16400
		cycleSpeed 9
	)
)

(instance rCard of Prop
	(properties
		x 138
		y 178
		description {Reporter}
		view 382
		loop 3
		priority 15
		signal 16400
		cycleSpeed 9
	)
)

(instance sInset of Prop
	(properties
		x 44
		y 127
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(sMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(sMouth dispose:)
	)
)

(instance sMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance officer of Actor
	(properties
		x 119
		y 48
		lookStr {One of the uniformed officers is busy searching the scene of the crime.}
		view 385
		cycleSpeed 8
		moveSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 30 18) ; "The officer is intent on his search and ignores you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ambulence of View
	(properties
		x 282
		y 189
		view 365
		priority 15
		signal 16401
	)
)

(instance headLight of View
	(properties
		x 230
		y 171
		view 365
		cel 1
		priority 1
		signal 16401
	)
)

(instance pCar of View
	(properties
		x 291
		y 137
		lookStr { It's a Lytton P.D. patrol car.}
		view 365
		cel 2
		priority 8
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: goHome)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pCar2 of View
	(properties
		x 44
		y 189
		lookStr { It's a Lytton P.D. patrol car.}
		view 365
		cel 3
		signal 16385
	)
)

(instance redLight of Prop
	(properties
		x 233
		y 170
		view 365
		loop 1
		cel 3
		priority 15
		signal 16400
		cycleSpeed 8
	)
)

(instance lDoor of Prop
	(properties
		x 237
		y 157
		view 365
		loop 2
		cel 4
		priority 15
		signal 16401
		cycleSpeed 8
	)
)

(instance rDoor of Prop
	(properties
		x 265
		y 144
		view 365
		loop 3
		cel 4
		priority 15
		signal 16401
		cycleSpeed 8
	)
)

(instance medics of Prop
	(properties
		x 240
		y 170
		view 377
		cycleSpeed 8
	)
)

(instance theRoom of Feature
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(4 ; flashlight
						(cond
							((== (gEgo view:) 380)
								(gEgo view: 1)
								(spot dispose:)
								(Print 30 19) ; "You turn your flashlight off."
							)
							((== ((gInventory at: 4) state:) 1) ; flashlight
								(gEgo view: 380)
								(spot init:)
								(Print 30 20) ; "You turn your flashlight on and begin a search of the scene."
							)
							(else
								(Print 30 21) ; "Your batteries appear to be dead."
							)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spot of Actor
	(properties
		view 378
		signal 22544
	)

	(method (doit)
		(super doit:)
		(if (< (gEgo loop:) 8)
			(self
				posn:
					(+ (gEgo x:) (SinMult [local1 (gEgo loop:)] 15))
					(- (gEgo y:) (CosMult [local1 (gEgo loop:)] 15))
			)
		else
			(self
				posn:
					(+ (gEgo x:) (SinMult [local1 (gEgo cel:)] 15))
					(- (gEgo y:) (CosMult [local1 (gEgo cel:)] 15))
			)
		)
	)

	(method (doVerb theVerb invItem)
		(blacktop doVerb: theVerb invItem)
	)
)

(instance star of Prop
	(properties
		x 181
		y 153
		view 378
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if local0
					(Print 30 22) ; "You catch the glint of an object lying just beneath Marie's car."
				else
					(super doVerb: theVerb)
				)
			)
			(3 ; Do
				(if local0
					(Print 30 23) ; "You pick up what appears to be a medallion. Upon closer inspection you recognize it to be a "Bronze Star" war medal."
					(gEgo get: 32) ; bronzeStar
					(SetScore 128 5)
					(self dispose:)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(cond
			((IsObject cycler) 0)
			(
				(and
					(> nsLeft (spot nsLeft:))
					(< nsRight (spot nsRight:))
					(> nsTop (spot nsTop:))
					(< nsBottom (spot nsBottom:))
				)
				(if (== cel 0)
					(self setCycle: End)
					(= local0 1)
				)
			)
			(cel
				(self cel: 0)
			)
		)
		(super doit:)
	)
)

(instance lamp of Feature
	(properties
		x 67
		y 120
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== (gEgo view:) 380)
					(Print 30 24) ; "It's a very LARGE streetlamp."
				else
					(Print 30 25) ; "You try to search the area, but it's just too dark to see anything. Perhaps you should come back when it's light."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance blacktop of Feature
	(properties
		x 165
		y 80
		onMeCheck 16512
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== (gEgo view:) 380)
					(Print 30 26) ; "The parking lot blacktop."
				else
					(Print 30 25) ; "You try to search the area, but it's just too dark to see anything. Perhaps you should come back when it's light."
				)
			)
			(4 ; Inventory
				(switch invItem
					(4 ; flashlight
						(cond
							((== (gEgo view:) 380)
								(gEgo view: 1)
								(spot dispose:)
								(Print 30 19) ; "You turn your flashlight off."
							)
							((== ((gInventory at: 4) state:) 1) ; flashlight
								(gEgo view: 380)
								(spot init:)
								(Print 30 20) ; "You turn your flashlight on and begin a search of the scene."
							)
							(else
								(Print 30 21) ; "Your batteries appear to be dead."
							)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance otherStores of Feature
	(properties
		onMeCheck 64
		lookStr {Some of the mall's stores are undergoing renovation.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== (gEgo view:) 380)
					(Print 30 27) ; "Some of the mall's stores are undergoing renovation."
				else
					(Print 30 25) ; "You try to search the area, but it's just too dark to see anything. Perhaps you should come back when it's light."
				)
			)
			(3 ; Do
				(Print 30 28) ; "That store is closed."
			)
			(4 ; Inventory
				(switch invItem
					(4 ; flashlight
						(cond
							((== (gEgo view:) 380)
								(gEgo view: 1)
								(spot dispose:)
								(Print 30 19) ; "You turn your flashlight off."
							)
							((== ((gInventory at: 4) state:) 1) ; flashlight
								(gEgo view: 380)
								(spot init:)
								(Print 30 20) ; "You turn your flashlight on and begin a search of the scene."
							)
							(else
								(Print 30 21) ; "Your batteries appear to be dead."
							)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sidewalk of Feature
	(properties
		x 107
		y 24
		onMeCheck 4096
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== (gEgo view:) 380)
					(Print 30 29) ; "Sidewalks connect the store fronts."
				else
					(Print 30 25) ; "You try to search the area, but it's just too dark to see anything. Perhaps you should come back when it's light."
				)
			)
			(4 ; Inventory
				(switch invItem
					(4 ; flashlight
						(cond
							((== (gEgo view:) 380)
								(Print 30 30) ; "The flashlight is already on."
							)
							((== ((gInventory at: 4) state:) 1) ; flashlight
								(gEgo view: 380)
								(spot init:)
								(Print 30 20) ; "You turn your flashlight on and begin a search of the scene."
							)
							(else
								(Print 30 21) ; "Your batteries appear to be dead."
							)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance armyShop of Feature
	(properties
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== (gEgo view:) 380)
					(Print 30 31) ; "That's the Army Recruiter's office."
				else
					(Print 30 25) ; "You try to search the area, but it's just too dark to see anything. Perhaps you should come back when it's light."
				)
			)
			(3 ; Do
				(Print 30 32) ; "The Army Recruiter's office is closed for the night."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyShop of Feature
	(properties
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== (gEgo view:) 380)
					(Print 30 33) ; "That's the shop of "Zak" the keymaker."
				else
					(Print 30 25) ; "You try to search the area, but it's just too dark to see anything. Perhaps you should come back when it's light."
				)
			)
			(3 ; Do
				(Print 30 34) ; "Zak's key shop is closed for the night."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mariesCar of Feature
	(properties
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 30 35) ; "Marie's Trans Am still sits in the poorly lit parking lot of the mall. You scan the car for clues... but find nothing."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jim of Code
	(properties)

	(method (init)
		(JHead init:)
		(JHand setScript: handScript init:)
		(JOpenHand setScript: openHandScript init:)
		(JArm setScript: armScript init:)
		(JEye setScript: eyeScript init:)
		(super init:)
	)

	(method (dispose)
		(JHead setScript: 0 dispose:)
		(JHand setScript: 0 dispose:)
		(JOpenHand setScript: 0 dispose:)
		(JArm setScript: 0 dispose:)
		(JEye setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance JHead of Prop
	(properties
		x 163
		y 40
		description {Jim's Mouth}
		view 100
		cycleSpeed 9
	)
)

(instance headScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(JHead setCycle: 0)
				(= seconds (Random 0 5))
			)
			(1
				(JHead setCycle: RandCycle)
				(= seconds (Random 1 8))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance JHand of Prop
	(properties
		x 189
		y 128
		description {Jim's Hand}
		view 100
		loop 2
		cycleSpeed 13
	)
)

(instance handScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 8 15))
			)
			(1
				(JHand setCycle: End self)
			)
			(2
				(= seconds 1)
			)
			(3
				(JHand setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance JOpenHand of Prop
	(properties
		x 193
		y 127
		description {Jim's Hand}
		view 100
		loop 3
		priority 15
		signal 16400
	)
)

(instance openHandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(JOpenHand setCycle: End)
				(= seconds (Random 3 6))
			)
			(2
				(JOpenHand cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance JEye of Prop
	(properties
		x 166
		y 25
		description {Jim's Eye}
		view 100
		loop 1
		cycleSpeed 12
	)
)

(instance eyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(JEye cel: 1)
				(= cycles 1)
			)
			(2
				(JEye cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance JArm of Prop
	(properties
		x 111
		y 100
		view 100
		loop 4
		cycleSpeed 13
	)
)

(instance armScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(JArm setCycle: 0)
				(= seconds (Random 20 30))
			)
			(1
				(JArm cycleSpeed: 14 setCycle: End self)
			)
			(2
				(JArm setCycle: Beg self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance searchMusic of Sound
	(properties
		flags 1
		number 302
		loop -1
	)
)

(instance sirenSound of Sound
	(properties
		number 936
		loop -1
	)
)

(instance sFX of Sound
	(properties)
)

