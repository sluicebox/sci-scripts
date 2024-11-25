;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use CycleBet)
(use smell)
(use BalloonTalker)
(use invCode)
(use ADRoom)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm410 0
	offScreen 1
	butlerT 2
)

(local
	local0
	local1 = 1
	local2 = 1
	local3
	local4
	local5
	local6
	local7
)

(instance rm410 of ADRoom
	(properties
		noun 1
		picture 410
		horizon 103
		north 411
		east 420
		south 400
		vanishingY -60
	)

	(method (init)
		(gGame setEgo: (ScriptID 895 1)) ; lockjaw
		(gEgo init: normalize: setScale: 0)
		(LoadMany rsVIEW 413 410 415)
		(gWalkHandler addToFront: gCurRoom)
		(gWalkHandler addToFront: passage)
		(gWalkHandler addToFront: passageFea)
		(switch gPrevRoomNum
			(north
				(gCurRoom setScript: sEnterThruPassage)
				(song number: 411 loop: -1 flags: 1 play:)
			)
			(south
				(LoadMany rsVIEW 413)
				(gCurRoom setScript: sLockjawIsHere)
			)
			(east
				(song number: 411 loop: -1 flags: 1 play:)
				(gGame handsOn:)
			)
			(200
				(gEgo x: 216 y: 133)
				(song number: 411 loop: -1 flags: 1 play:)
				(gGame handsOn:)
			)
			(340
				(LoadMany rsVIEW 832 409 410 412 415 416 417 418)
				(LoadMany rsSOUND 410 411)
				(gEgo view: 411 loop: 1 cel: 0 x: 83 y: 128 setPri: 10)
				(ima init: setCycle: Fwd setSpeed: 8)
				(gCurRoom setScript: sImaCartoon)
			)
			(370
				(gEgo x: 160 y: 160)
				(song number: 411 loop: -1 flags: 1 play:)
				(gCurRoom setScript: sJustStandThere)
			)
			(else
				(gCurRoom setScript: sJustStandThere)
			)
		)
		(super init: &rest)
		(if (not (IsFlag 409))
			(farShroud init: addToPic:)
		)
		(cond
			((== gAct 6)
				(passage view: 424 cel: 0 ignoreActors: 0)
				(self
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 179 138 130 144 137 154 105 154 99 146 85 149 49 140 21 158 102 183 290 178 231 147 254 130 220 123 208 123 175 123
							yourself:
						)
				)
			)
			((IsFlag 403)
				(= local0 1)
				(passage cel: 2 ignoreActors: 1)
				(passageFea init:)
				(self
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 183 138 134 145 131 154 102 154 101 148 85 149 49 140 21 158 102 183 290 178 231 147 254 130 236 125 213 120 226 129 197 133 186 120 170 120
							yourself:
						)
				)
			)
			(else
				(passage view: 424 cel: 0 ignoreActors: 0)
				(self
					addObstacle:
						(= local7
							((Polygon new:)
								type: PContainedAccess
								init: 179 138 130 144 137 154 105 154 99 146 85 149 49 140 21 158 102 183 290 178 231 147 254 130 220 123 208 123 175 123
								yourself:
							)
						)
				)
			)
		)
		(passage init: stopUpd:)
		(gInventory addAfter: (gInventory at: 44) (invDoggieBone init: yourself:)) ; Wood_Cutting_c
		(dresser init:)
		(doggieBed init:)
		(if (not (IsFlag 393))
			(doggieBone init: stopUpd:)
		)
		(imaDoor init: stopUpd:)
		(imaDoorFeature init:)
		(fDoll init: setOnMeCheck: 1 16384)
		(fPillow init: setOnMeCheck: 1 8192)
		(dogBedPosts init: setOnMeCheck: 1 2048)
		(rug init: setOnMeCheck: 1 1024)
		(books init:)
		(bowl init:)
		(cuckoo_clock init:)
		(dresserDoll init:)
		(dress_dummy init:)
		(imaBed init:)
		(pitcher init:)
		(shelfDolls init:)
		(toys init:)
		(waterBowl init:)
		(imaWindow init:)
		(windowSill init:)
		(chamberPot init:)
		(clock init: stopUpd:)
		(if (and (== gAct 6) (not (IsFlag 399)))
			(imaKey view: 424 loop: 1 cel: 0 x: 236 y: 108 z: 20 init:)
		)
		(if (gEgo has: 28) ; King_s_Letter
			(pigeon init: setCycle: RandCycle)
		)
		(if (or (== gAct 4) (== gAct 6))
			(shredFrontPillow init: addToPic:)
			(shredEye init: addToPic:)
			(SetFlag 164)
			(SetFlag 159)
		else
			(restPillow init: addToPic:)
		)
		(if (IsFlag 164)
			(shredHoleBed init: addToPic:)
		)
		(if (IsFlag 159)
			(shreddummy init: addToPic:)
		)
		(if (IsFlag 33)
			(shredcornerChest init: addToPic:)
		)
		(if (and (IsFlag 396) (not (IsFlag 397)))
			(truffle init: stopUpd:)
			(boxFea init:)
		)
		(if
			(and
				(IsFlag 396)
				(not (gEgo has: 7)) ; Ima_s_Room_Key
				(!= ((gInventory at: 7) owner:) gCurRoomNum) ; Ima_s_Room_Key
			)
			(imaKey init: stopUpd:)
			(imaKeyFeature init:)
		)
	)

	(method (dispose)
		(gInventory delete: invDoggieBone)
		(if (IsObject local7)
			(local7 dispose:)
		)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((and (& temp0 $0002) local0 (== gPrevRoomNum 400)) ; Maze
				(gCurRoom setScript: sCantLeaveYet)
			)
			((and (& (gEgo onControl: -1) $0002) local0)
				(gCurRoom newRoom: 411)
			)
			(
				(and
					(& temp0 $0004)
					(gCast contains: butler)
					(> (gotchaTimer seconds:) 0)
				)
				(gotchaTimer cycleCnt: 1)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(86 ; Nose
				(= gDictionaryWord 76)
				(super doVerb: theVerb &rest)
			)
			(3 ; Walk
				(if
					(and
						(gCast contains: butler)
						(not local3)
						(not local4)
						(not local5)
						(> (gotchaTimer seconds:) 0)
					)
					(gotchaTimer cycleCnt: 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(6 ; Look
				(if (== gAct 4)
					(gMessager say: 1 6 33) ; "Lockjaw has been "decorating" Ima's room. He calls it the "Post-Nuclear Look"."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(89 ; Teeth
				(if (== gAct 4)
					(gMessager say: 1 89 33) ; "Lockjaw doesn't want to chew on any more things. He's afraid he might not have room for General Pugh and Percy."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(if (not (OneOf theVerb 85 7 30 84)) ; Talk, Do, Paw, Trivia
					(gMessager say: 1 90) ; "That wouldn't improve Ima's bedroom. Nothing would improve Ima's bedroom, short of a bulldozer."
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gWalkHandler delete: gCurRoom)
		(gWalkHandler delete: passage)
		(gWalkHandler delete: passageFea)
		(gotchaTimer dispose: delete:)
		(comeInTimer dispose: delete:)
		(hideKeyTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance sEnterThruPassage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 225 y: 125)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 236 131 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoSecretRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 227 125 self)
			)
			(2
				(if (or (gEgo has: 45) (gEgo has: 7)) ; Ima_s_Room_Key
					(self setScript: sPutBoneKeyDown self 2)
				else
					(= cycles 1)
				)
			)
			(3
				(gCurRoom newRoom: 411)
			)
		)
	)
)

(instance sGoToShelves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 182 123 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCantLeaveYet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 31 0 20 0 self) ; "Hurry, boy, HURRY!"
			)
			(2
				(gEgo setHeading: 180 setMotion: MoveFwd 20 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJustStandThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(gEgo x: 160 y: 160)
				(self dispose:)
			)
		)
	)
)

(instance sLJAwakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: End self)
			)
			(1
				(gEgo loop: 4 cel: 0 setSpeed: 6 setCycle: End self)
			)
			(2
				(= ticks 120)
			)
			(3
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sImaCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 30)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(self setScript: sLJAwakes)
				(LoadMany 0 417 416 415 418)
				(= cycles 1)
			)
			(1
				(song number: 410 loop: 1 play:)
			)
			(2
				(gNarrator keepWindow: 1)
				(gMessager say: 31 0 6 1) ; "My dad's rich and yours is not!"
				(= cycles 1)
			)
			(3
				(= ticks 1)
			)
			(4 0)
			(5
				(gMessager say: 31 0 6 2) ; "There's no toy I haven't got!"
				(= cycles 1)
			)
			(6 0)
			(7
				(gMessager say: 31 0 6 3) ; "Throw a tantrum, it gets bought!"
				(= cycles 1)
			)
			(8 0)
			(9
				(gMessager say: 31 0 6 4) ; "Ima is my name!"
				(= cycles 1)
			)
			(10 0)
			(11
				(gMessager say: 31 0 6 5) ; "Ima is my name!"
				(= cycles 1)
			)
			(12 0)
			(13
				(gMessager say: 31 0 6 6) ; "Nyeah nyeah nyeah nyeah nyeah nyeah!"
				(= cycles 1)
			)
			(14 0)
			(15
				(gMessager say: 31 0 6 7) ; "I am rich and I'm a snot, And I don't really care!"
				(= cycles 1)
			)
			(16 0)
			(17
				(gMessager say: 31 0 6 8) ; "Love all doggies, big and small!"
				(gEgo loop: 5 cel: 0 setSpeed: 6 setCycle: End self)
			)
			(18 0)
			(19
				(gMessager say: 31 0 6 9) ; "Shave 'em, dress 'em like a doll!"
				(= cycles 1)
			)
			(20 0)
			(21
				(gMessager say: 31 0 6 10) ; "Glue their paws to parasols!"
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(22 0)
			(23
				(gMessager say: 31 0 6 11) ; "Ima is my name!"
				(= cycles 1)
			)
			(24 0)
			(25
				(client setScript: sImaGetsLJ)
			)
		)
	)

	(method (doit)
		(cond
			((and (== state 1) (>= (song prevSignal:) 5))
				(self cue:)
			)
			((and (== state 4) (>= (song prevSignal:) 10))
				(self cue:)
			)
			((and (== state 6) (>= (song prevSignal:) 15))
				(self cue:)
			)
			((and (== state 8) (>= (song prevSignal:) 20))
				(self cue:)
			)
			((and (== state 10) (>= (song prevSignal:) 25))
				(self cue:)
			)
			((and (== state 12) (>= (song prevSignal:) 30))
				(self cue:)
			)
			((and (== state 14) (>= (song prevSignal:) 35))
				(self cue:)
			)
			((and (== state 16) (>= (song prevSignal:) 40))
				(self cue:)
			)
			((and (== state 18) (>= (song prevSignal:) 45))
				(self cue:)
			)
			((and (== state 20) (>= (song prevSignal:) 50))
				(self cue:)
			)
			((and (== state 22) (>= (song prevSignal:) 55))
				(self cue:)
			)
			((and (== state 24) (>= (song prevSignal:) -1))
				(song prevSignal: 0)
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance sImaGetsLJ of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gNarrator keepWindow: 0)
				(= local6 (gEgo cycleSpeed:))
				(ima
					view: 426
					loop: 6
					cel: 0
					x: (+ (ima x:) 6)
					y: (+ (ima y:) 4)
					setSpeed: 6
					init:
					setCycle: End self
				)
			)
			(1
				(ima
					view: 832
					posn: 134 142
					setPri: 10
					setCycle: Walk
					setMotion: MoveTo 96 142 self
				)
			)
			(2
				(ima
					view: 426
					loop: 7
					cel: 0
					posn: 97 140
					setCycle: CT 5 1 self
				)
			)
			(3
				(gEgo hide:)
				(ima setCycle: End self)
			)
			(4
				((ScriptID 2018 1) x: 100 y: 100) ; imaText
				(gMessager say: 31 0 30 1 self) ; "Oh, my little snookie-wookums!"
			)
			(5
				(sFX number: 4100 play:)
				(UnLoad 128 411)
				(ima view: 412 loop: 0 cel: 0 posn: 108 145 setCycle: End self)
			)
			(6
				(gMessager say: 31 0 30 2 self) ; "Mommy's naming you Fluffy! Does him like his new name? Hmm?"
			)
			(7
				(ima loop: 1 cel: 0 posn: 88 145 setPri: 10 setCycle: End self)
			)
			(8
				(gMessager say: 31 0 30 3 5 self) ; "Phew, Fluffums smells bad! Him's a dirty birdy, yes him is! Does Mommy's little sweetums want his bathy-wathy?"
			)
			(9
				(ima loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(sFX number: 4101 play:)
				(gEgo
					view: 412
					loop: 4
					cel: 0
					posn: 84 145
					setSpeed: 6
					show:
				)
				(ima
					view: 832
					loop: 0
					cel: 0
					posn: 105 147
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 247 132 self
				)
				(= ticks 30)
			)
			(11 0)
			(12
				(gEgo setCycle: End)
				(sFX number: 910 play:)
				(= cycles 1)
			)
			(13
				(ima
					view: 412
					loop: 3
					cel: 0
					setPri: 8
					posn: 251 131
					setCycle: End self
				)
			)
			(14
				(sFX number: 922 play: self)
			)
			(15
				(gEgo normalize: 807 0 setSpeed: local6 stopUpd:)
				(imaDoor hide:)
				(ima view: 832 setCycle: Walk setMotion: MoveTo 290 132 self)
			)
			(16
				(sFX number: 923 play:)
				(imaDoor show: stopUpd:)
				(ima dispose:)
				(song number: 411 loop: -1 flags: 1 play:)
				(gEgo setMotion: PolyPath 153 148 self)
			)
			(17
				(gGame handsOn:)
				(comeInTimer setReal: comeInTimer 120)
				(SetCursor 100 -1)
				(self dispose:)
			)
		)
	)
)

(instance sLockjawIsHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 160 y: 160)
				(= cycles 1)
			)
			(1
				(gMessager say: 31 0 20 0 self) ; "Hurry, boy, HURRY!"
			)
			(2
				(proc875_3 3 self)
			)
			(3
				(hideKeyTimer setReal: hideKeyTimer 60)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTeethOnDresser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 396 2)
				(Load rsVIEW 414)
				(= local6 (gEgo cycleSpeed:))
				(gTheIconBar disable:)
				(= cycles 1)
			)
			(1
				(gMessager say: 8 89 0 0 self) ; "Lockjaw's gonna get into the dresser! Nothing can stop him now!"
			)
			(2
				(gEgo
					view: 414
					loop: 1
					cel: 0
					posn: 180 143
					setSpeed: 6
					setCycle: CT 6 1 self
				)
				(sFX number: 4110 loop: 1 play: self)
			)
			(3
				(if (== (gEgo cel:) 6)
					(gEgo setCycle: CycleBet 6 14 -1)
				)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo setSpeed: local6 normalize: 807 1)
				(shredcornerChest init: addToPic:)
				(truffle init: stopUpd:)
				(boxFea init:)
				(if (not (IsFlag 399))
					(imaKeyFeature init:)
					(imaKey init:)
				)
				(SetFlag 33)
				(gTheIconBar enable:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChewDress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable:)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(sFX number: 4110 loop: 1 play: self)
				(gEgo
					view: 410
					setLoop: 5
					cel: 0
					posn: 256 146
					setPri: 14
					setSpeed: 6
					ignoreActors: 1
					setCycle: End self
				)
			)
			(2
				(if (== (gEgo cel:) 14)
					(gEgo setCycle: CycleBet 6 14 -1)
				)
			)
			(3
				(gGame handsOn:)
				(gEgo
					setCycle: 0
					normalize: 807 0
					setSpeed: local6
					posn: 220 144
				)
				(if (not (IsFlag 159))
					(shreddummy init: addToPic:)
				)
				(SetFlag 159)
				(gTheIconBar enable:)
				(self dispose:)
			)
		)
	)
)

(instance sHideKeyInBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 7 gCurRoomNum) ; Ima_s_Room_Key
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 54 136 self)
			)
			(2
				(gMessager say: 6 99 0 0 self) ; "Lockjaw buries Ima's room key in the cushions of the horrible doggie bed. He knows nobody will fight the fleas to get it back!"
			)
			(3
				(gEgo
					view: 415
					loop: 4
					cel: 0
					x: (+ (gEgo x:) 20)
					setSpeed: 6
					setCycle: End self
				)
			)
			(4
				(gEgo
					normalize: 807 6
					x: (- (gEgo x:) 20)
					setSpeed: local6
				)
				(gGame points: 399 2)
				(= cycles 1)
			)
			(5
				(if (IsFlag 97)
					(= cycles 1)
				else
					(client setScript: sBathTime self)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBathTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 97)
				(comeInTimer dispose: delete:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 1) setMotion: PolyPath 122 154 self) ; lockjaw
			)
			(2
				((ScriptID 895 1) setHeading: 90) ; lockjaw
				(butler
					init:
					setLoop: 0
					ignoreActors: 1
					setCycle: Fwd
					setHeading: 270
				)
				(imaDoor hide:)
				(sFX number: 922 play:)
				(= cycles 1)
			)
			(3
				(song number: 412 loop: -1 flags: 1 play:)
				(butler setMotion: MoveTo 227 130 self)
			)
			(4
				(sFX number: 926 play:)
				(imaDoor show: stopUpd:)
				(butler setMotion: MoveTo 185 138 self)
			)
			(5
				(butler setCycle: 0)
				(gMessager say: 31 0 16 1 self) ; "Nice doggy, good doggy! There's a good little flea-bitten mutt!"
			)
			(6
				(gMessager say: 31 0 16 2 self) ; "GRRRRRRR!!"
				(sFX number: 905 play:)
			)
			(7
				(butler
					view: 416
					loop: 1
					cel: 0
					x: 177
					y: 135
					setPri: 10
					setCycle: CT 3 1 self
				)
			)
			(8
				(butler cel: 4)
				(bucket init: stopUpd:)
				(gMessager say: 31 0 16 3 4 self) ; "Easy, now, easy, you ugly little hound..."
			)
			(9
				(gGame handsOn:)
				(gEgo normalize: 807 0 setSpeed: local6 stopUpd:)
				(gotchaTimer setReal: gotchaTimer 30)
				(SetCursor 100 -1)
				(self dispose:)
			)
		)
	)
)

(instance sButlerFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(butler
					view: 417
					loop: 1
					cel: 0
					posn: (+ (butler x:) 6) (- (butler y:) 1)
					setCycle: End self
				)
				(gMessager say: 31 0 17 4 self) ; "AAAAAH!"
				(sFX number: 4114 loop: 1 play:)
			)
			(1 0)
			(2
				(sFX number: 4115 loop: 1 play:)
				(passage hide:)
				(butler
					view: 409
					loop: 0
					cel: 0
					posn: (+ (butler x:) 7) (- (butler y:) 51)
					setPri: 9
					ignoreActors: 1
					setCycle: End self
				)
			)
			(3
				(gMessager say: 31 0 18 0 self) ; "Lockjaw doesn't believe his eyes! Did the bookcase just spin around?"
			)
			(4
				(song number: 413 loop: 1 play:)
				(passage show:)
				(butler
					view: 417
					loop: 4
					cel: 0
					illegalBits: 0
					setPri: -1
					posn: (+ (butler x:) 4) (+ (butler y:) 44)
					setCycle: Walk
					setMotion: MoveTo 237 130 self
				)
			)
			(5
				(sFX number: 922 play:)
				(imaDoor hide:)
				(= cycles 1)
			)
			(6
				(butler setPri: 6 setMotion: MoveTo 277 132 self)
			)
			(7
				(butler setCycle: 0 dispose:)
				(= cycles 1)
			)
			(8
				(sFX number: 923 play:)
				(imaDoor show: stopUpd:)
				(= cycles 1)
			)
			(9
				(song number: 411 loop: -1 flags: 1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sTeethOnFootman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 400 2)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(gotchaTimer dispose: delete:)
				(= cycles 2)
			)
			(1
				(gMessager say: 29 89 0 1 self) ; "Lockjaw decides to give the Butler an attitude adjustment!"
			)
			(2
				(butler
					loop: 2
					cel: 0
					posn: (+ (butler x:) 7) (- (butler y:) 1)
					setCycle: CT 7 1 self
				)
				((ScriptID 895 1) ; lockjaw
					view: 416
					loop: 3
					cel: 0
					posn:
						(+ ((ScriptID 895 1) x:) 8) ; lockjaw
						(+ ((ScriptID 895 1) y:) 3) ; lockjaw
					setSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(3 0)
			(4
				(sFX number: 900 play:)
				(= cycles 1)
			)
			(5
				((ScriptID 895 1) setCycle: End self) ; lockjaw
			)
			(6
				(gMessager say: 29 89 0 2 self) ; "AAAAAAH!"
				(sFX number: 4114 play:)
			)
			(7
				(butler setCycle: End self)
			)
			(8
				((ScriptID 895 1) cel: 0 setCycle: CT 4 1 self) ; lockjaw
			)
			(9
				((ScriptID 895 1) setCycle: End self) ; lockjaw
				(sFX number: 900 play:)
			)
			(10
				((ScriptID 895 1) stopUpd:) ; lockjaw
				(self setScript: sButlerFalls self)
			)
			(11
				((ScriptID 895 1) ; lockjaw
					posn:
						(- ((ScriptID 895 1) x:) 8) ; lockjaw
						(- ((ScriptID 895 1) y:) 3) ; lockjaw
					normalize: 807 0
					setSpeed: local6
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPawOnFootman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gotchaTimer dispose: delete:)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 182 145 self)
			)
			(2
				(gEgo
					view: 418
					loop: 0
					cel: 0
					x: (+ (gEgo x:) 4)
					y: (- (gEgo y:) 1)
					setSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(3
				(gEgo cel: 4 setPri: 11 setCycle: CT 0 -1 self)
			)
			(4
				(gEgo stopUpd:)
				(self setScript: sButlerFalls self)
			)
			(5
				(gEgo normalize: 807 6 setSpeed: local6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFleaOnFootman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gotchaTimer dispose: delete:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 167 144 self)
			)
			(2
				(sFX number: 910 play:)
				(gEgo
					view: 364
					loop: 5
					ignoreActors: 1
					setPri: 11
					posn: (- (gEgo x:) 3) (gEgo y:)
					setCycle: End self
				)
			)
			(3
				(sFX number: 910 play:)
				(butler
					view: 364
					loop: 4
					ignoreActors: 1
					posn: (- (butler x:) 7) (- (butler y:) 2)
					setCycle: Fwd
				)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					normalize: 807 4
					posn: (+ (gEgo x:) 3) (gEgo y:)
					setPri: 11
					stopUpd:
				)
				(butler
					view: 417
					loop: 1
					cel: 0
					posn: (+ (butler x:) 7) (+ (butler y:) 2)
					setCycle: 0
				)
				(= cycles 1)
			)
			(5
				(self setScript: sButlerFalls self)
			)
			(6
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGotcha of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gotchaTimer dispose: delete:)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 151 143 self)
			)
			(2
				(butler hide:)
				(gEgo
					view: 417
					loop: 2
					cel: 0
					posn: 147 141
					setSpeed: 6
					setCycle: CT 5 1 self
				)
				(gMessager say: 31 0 17 1 self) ; "All right... All right... GOTCHA!!!"
			)
			(3 0)
			(4
				(sFX number: 904 flags: 1 play:)
				(gEgo setCycle: End self)
				(gMessager say: 31 0 17 2 self) ; "In you go, you smelly hound!"
			)
			(5 0)
			(6
				(bucket hide:)
				(butler show: stopUpd:)
				(sFX number: 904 flags: 1 loop: -1 play:)
				(gEgo
					loop: 3
					cel: 0
					posn: 142 111
					setPri: 13
					setCycle: CT 10 1 self
				)
			)
			(7
				(gEgo setCycle: CycleBet 3 8 2 self)
			)
			(8
				(sFX stop:)
				(gMessager say: 31 0 17 3 self) ; "Here now! Stop it! Stop it, you little beast!"
			)
			(9
				(bucket show: stopUpd:)
				(gEgo normalize: 807 0 setPri: 10 posn: 124 104 stopUpd:)
				(self setScript: sButlerFalls self)
			)
			(10
				(gEgo
					view: 414
					loop: 3
					cel: 0
					posn: 167 120
					setPri: 13
					setCycle: End self
				)
			)
			(11
				(gEgo normalize: 807 0 posn: 203 132 setSpeed: local6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPutBoneKeyDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(1
						(gMessager say: 22 89 31 0 self) ; "Pepper always tells Lockjaw not to chew up clocks with his mouth full."
					)
					(2
						(gMessager say: 31 0 34 0 self) ; "Lockjaw doesn't like to travel with his mouth full. He might need bitin' room!"
					)
				)
			)
			(1
				(gEgo setMotion: PolyPath 220 137 self)
			)
			(2
				(if (gEgo has: 45)
					(gEgo put: 45 gCurRoomNum)
					(doggieBone x: 232 y: 135 init:)
				)
				(if (gEgo has: 7) ; Ima_s_Room_Key
					(gEgo put: 7) ; Ima_s_Room_Key
					(imaKeyFeature init:)
					(imaKey init:)
				)
				(= cycles 1)
			)
			(3
				(if (== register 1)
					(gEgo setMotion: MoveTo 200 127 self)
				else
					(Face gEgo passage self)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sOpenPassage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 403 4)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(if (or (gEgo has: 45) (gEgo has: 7)) ; Ima_s_Room_Key
					(self setScript: sPutBoneKeyDown self 1)
				else
					(= cycles 1)
				)
			)
			(2
				(gMessager say: 22 89 13 0 self) ; "Lockjaw decides to sample the brass pinecone on the cuckoo clock."
			)
			(3
				(song fade:)
				(gEgo
					view: 418
					loop: 0
					cel: 0
					posn: 217 128
					setSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(4
				(sFX number: 4120 loop: 1 play:)
				(gEgo setCycle: End self)
				(clock view: 418 loop: 1 cel: 0 setCycle: End self)
			)
			(5 0)
			(6
				(clock addToPic:)
				(passage view: 408 setCel: 0 ignoreActors: 1 setCycle: End self)
				((gCurRoom obstacles:) delete: local7)
			)
			(7
				(passage stopUpd:)
				(passageFea init:)
				(= local0 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 183 138 134 145 131 154 102 154 101 148 85 149 49 140 21 158 102 183 290 178 231 147 254 130 236 125 213 120 226 129 197 133 186 120 170 120
							yourself:
						)
				)
				(= cycles 1)
			)
			(8
				(gEgo x: 223 y: 129 loop: 3 normalize: setSpeed: local6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 405 2)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 45 143 self)
			)
			(2
				(gEgo
					view: 413
					loop: 4
					cel: 0
					x: (+ (gEgo x:) 29)
					setCycle: End self
				)
			)
			(3
				(gMessager say: 30 64 0 0 self) ; "Lockjaw gets an idea! He gives the letter to the pigeon."
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(pigeon loop: 5 setCycle: End self)
			)
			(6
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance sUseKeyDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 408 1)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(hideKeyTimer dispose: delete:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 236 131 self)
			)
			(2
				(gMessager say: 25 101 23 0 self) ; "Lockjaw tries to push the key under the door, but his paws are too stubby to push it very far."
			)
			(3
				(gEgo
					view: 429
					loop: 8
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(4
				(gEgo normalize: 807 0 put: 7 400 setSpeed: local6) ; Ima_s_Room_Key
				(gCurRoom newRoom: 400) ; Maze
			)
		)
	)
)

(instance sBuryBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 393 2)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 55 138 self)
			)
			(2
				(gEgo view: 413 loop: 1 setSpeed: 6 setCycle: End self)
			)
			(3
				(gEgo put: 45)
				(gMessager say: 6 31 0 0 self) ; "Lockjaw decides to bury the bone in the cushions of the doggie bed."
			)
			(4
				(gEgo normalize: 807 0 setSpeed: local6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX number: 904 play: self)
				(gEgo
					view: 413
					loop: 2
					cel: 0
					setPri: 11
					setSpeed: 6
					setCycle: End self
				)
			)
			(1
				(if (== (gEgo cel:) 8)
					(gEgo setCycle: CycleBet 4 8 -1)
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFirstDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gMessager say: 5 89 1 0 self) ; "Gritting his teeth against the nasty smell of the Butler, Lockjaw takes a drink."
			)
			(2
				(gGame points: 394 1)
				(= local1 0)
				(= cycles 1)
			)
			(3
				(self setScript: sGetDrink self)
			)
			(4
				(gGame handsOn:)
				(gEgo normalize: 807 1 setSpeed: local6)
				(self dispose:)
			)
		)
	)
)

(instance sSecondDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gMessager say: 5 89 2 1 self) ; "Lockjaw still feels thirsty. He takes another drink."
				(= local2 0)
				(= local1 1)
			)
			(2
				(self setScript: sGetDrink self)
			)
			(3
				(gEgo normalize: 807 1)
				(= cycles 1)
			)
			(4
				(gEgo setMotion: PolyPath 239 144 self)
			)
			(5
				(gEgo view: 413 loop: 3 cel: 0 setCycle: End self)
				(sFX number: 1226 play:)
			)
			(6
				(gMessager say: 5 89 2 2 self) ; "What's that sound off in the distance? Oh, it's the Call of Nature!"
			)
			(7
				(= seconds 2)
			)
			(8
				(gGame handsOn:)
				(gEgo normalize: 807 2 setSpeed: local6)
				(self dispose:)
			)
		)
	)
)

(instance sPawOnBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 406 2)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gEgo view: 801 loop: 1 setSpeed: 6 setCycle: End self)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gMessager say: 6 30 22 0 self) ; "Lockjaw uncovers the hidden key, and takes it into his mouth."
			)
			(4
				(gEgo normalize: 807 0 get: 7 setSpeed: local6) ; Ima_s_Room_Key
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetHangingKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 398 1)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(gEgo get: 7) ; Ima_s_Room_Key
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 230 135 self)
			)
			(2
				(gEgo
					view: 429
					loop: 5
					cel: 0
					setSpeed: 6
					setCycle: CT 3 1 self
				)
			)
			(3
				(imaKey dispose:)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gGame handsOn:)
				(gEgo normalize: 807 0 setSpeed: local6)
				(self dispose:)
			)
		)
	)
)

(instance sNoseDresser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 395 1)
				(= cycles 1)
			)
			(1
				(self setScript: sLJSmells self 17)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sSmellPigeon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 404 1)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 45 143 self)
			)
			(2
				(gEgo
					view: 413
					loop: 4
					cel: 0
					x: (+ (gEgo x:) 29)
					setCycle: End self
				)
			)
			(3
				(sFX number: 911 loop: 1 play: self)
			)
			(4
				(offScreen x: 41 y: 93 talkWidth: 75 tailPosn: 0)
				(proc875_3 18 self)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gMessager say: 30 86 0 0 self) ; "SQUAWK!"
			)
			(7
				(gEgo normalize: 807 1 x: (- (gEgo x:) 29))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShredTruffles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 397 1)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gMessager say: 9 89 0 0 self) ; "Lockjaw can't take it anymore! He's GOTTA have the goodies!"
			)
			(2
				(sFX number: 4110 loop: 1 play: self)
				(gEgo
					view: 415
					loop: 1
					posn: 190 154
					setSpeed: 6
					setCycle: CT 4 1 self
				)
				(truffle dispose:)
				(boxFea dispose:)
			)
			(3
				(if (== (gEgo cel:) 4)
					(gEgo setCycle: CycleBet 1 4 -1)
				)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo loop: 2 cel: 0 posn: 197 154 setCycle: End self)
				(sFX number: 949 play:)
			)
			(6
				(gEgo normalize: 807 1 posn: 186 147 setSpeed: local6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookOutWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 45 143 self)
			)
			(2
				(gEgo
					view: 413
					loop: 4
					cel: 0
					x: (+ (gEgo x:) 29)
					setSpeed: 6
					setCycle: End self
				)
			)
			(3
				(offScreen x: 41 y: 93 talkWidth: 75 tailPosn: 0)
				(switch register
					(1
						(proc875_3 3 self)
					)
					(6
						(proc875_3 4 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(= ticks 30)
			)
			(5
				(switch register
					(1
						(gMessager say: 14 86 0 0 self) ; "Lockjaw sniffs the glass. It just smells smooth and cold. He wishes he could smell his beloved Pepper."
					)
					(2
						(gMessager say: 14 30 0 0 self) ; "Lockjaw paws at the glass, but with no result. How he wishes he could get out of here!"
					)
					(3
						(gMessager say: 14 6 0 0 self) ; "Lockjaw looks out at the green hills of Philadelphia longingly, wishing he could see Pepper."
					)
					(4
						(gMessager say: 14 7 0 0 self) ; MISSING MESSAGE
					)
					(5
						(if (gCast contains: pigeon)
							(gMessager say: 30 86 0 0 self) ; "SQUAWK!"
						else
							(gMessager say: 16 30 0 0 self) ; "Lockjaw stands up on the sill for a better view."
						)
					)
					(6
						(if (gCast contains: pigeon)
							(gMessager say: 30 86 0 0 self) ; "SQUAWK!"
						else
							(gMessager say: 16 86 5 0 self) ; "Hmm, pigeon feathers. Lockjaw wishes the pigeon would come back. He's feeling a little hungry..."
						)
					)
				)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo
					normalize: 807 1
					x: (- (gEgo x:) 29)
					setSpeed: local6
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTeethOnKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 398 1)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 222 138 self)
			)
			(2
				(gEgo get: 7) ; Ima_s_Room_Key
				(imaKeyFeature dispose:)
				(imaKey dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTeethOnBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 392 1)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(gEgo get: 45)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 808
					loop: 4
					cel: 0
					posn: 228 137
					setSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(2
				(doggieBone dispose:)
				(gEgo cel: 4 setCycle: CT 0 -1 self)
			)
			(3
				(gEgo normalize: 807 0 posn: 223 137 setSpeed: local6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTeethOnBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable:)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(sFX number: 4110 loop: 1 play: self)
				(gEgo
					view: 414
					loop: 0
					cel: 0
					posn: 58 147
					setSpeed: 6
					setCycle: CT 6 1 self
				)
			)
			(2
				(if (== (gEgo cel:) 6)
					(gEgo setCycle: CycleBet 5 6 -1)
				)
			)
			(3
				(if (not (IsFlag 164))
					(shredHoleBed init: addToPic:)
				)
				(gEgo normalize: 807 6 setSpeed: local6)
				(= cycles 1)
			)
			(4
				(gMessager say: 6 89 0 0 self) ; "Lockjaw takes out his aggressions on the doggie bed."
			)
			(5
				(SetFlag 164)
				(gTheIconBar enable:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSmellKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 222 138 self)
			)
			(2
				(self setScript: sLJSmells self 19)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPawOnKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 222 138 self)
			)
			(2
				(gMessager say: 10 30 0 0 self) ; "Lockjaw can't seem to pick up the key in his paws."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLJSmells of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(if (OneOf (gEgo cel:) 0 2 3 4 6)
					(= temp0 4)
				else
					(= temp0 3)
				)
				(gEgo
					view: 808
					loop: temp0
					cel: 0
					setSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(2
				(sFX number: 911 play: self)
				(gEgo setCycle: CycleBet 4 5 -1)
			)
			(3
				(gEgo setCycle: 0 stopUpd:)
				(switch register
					(1
						(proc875_3 5 self)
					)
					(5
						(proc875_3 6 self)
					)
					(8
						(proc875_3 17 self)
					)
					(9
						(proc875_3 17 self)
					)
					(10
						(proc875_3 17 self)
					)
					(11
						(proc875_3 17 self)
					)
					(12
						(proc875_3 6 self)
					)
					(14
						(proc875_3 3 self)
					)
					(15
						(proc875_3 4 self)
					)
					(16
						(proc875_3 18 self)
					)
					(18
						(proc875_3 5 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(= ticks 30)
			)
			(5
				(switch register
					(1
						(gMessager say: 6 86 0 0 self) ; "The doggie bed smells like feathers, silk, icky-sweet perfume, and the Butler. He must have carried it in for Ima."
					)
					(2
						(gMessager say: 25 86 0 0 self) ; "Lockjaw can smell vague scents of cooking drifting under the door. MMM!"
					)
					(3
						(gMessager say: 2 86 0 0 self) ; "Lockjaw can't get that close to the doll, but he can smell it from here. He thinks it probably fell into a vat of cheap lilac cologne at some point in its miserable existence. YECH!"
					)
					(4
						(= gDictionaryWord 76)
						(gMessager say: 3 86 0 0 self) ; "The pillow is stuffed with vanilla and cinnamon |r||c0|potpourri|c||r|. The scent could knock a buzzard off a garbage truck!"
					)
					(5
						(gMessager say: 17 86 0 0 self) ; "General Pugh must have brought Ima the books. YECH!"
					)
					(6
						(gMessager say: 19 86 0 0 self) ; "There's no way Lockjaw's getting that close to a washing bowl! Besides, it would probably smell like nasty old rosewater anyway."
					)
					(7
						(gMessager say: 22 86 0 0 self) ; "Lockjaw can't reach up that high, but he doubts the clock would smell very good anyway."
					)
					(8
						(gMessager say: 11 86 0 0 self) ; "YUK! The doll smells like Ima's extra-stinky double-honeysuckle French foo-foo periwinkle-and-precious-posies perfume."
					)
					(9
						(gMessager say: 7 86 0 0 self) ; "The dummy smells like Ima. Does that mean Ima smells like a dummy?"
					)
					(10
						(gMessager say: 12 86 0 0 self) ; "Ima's bed smells like silk, goose down, yucchy perfume, and Ima."
					)
					(11
						(gMessager say: 18 86 0 0 self) ; "Just as he suspected, the pitcher smells like rose water and Ima. Nasty stuff!"
					)
					(12
						(gMessager say: 20 86 0 0 self) ; "Lockjaw can't get close to the dolls, but he can smell the General on them anyway. The scent of wig powder is overwhelming!"
					)
					(13
						(gMessager say: 21 86 0 0 self) ; "Lockjaw sniffs and sniffs, but the toys are just too far away to smell."
					)
					(14
						(gMessager say: 14 86 0 0 self) ; "Lockjaw sniffs the glass. It just smells smooth and cold. He wishes he could smell his beloved Pepper."
					)
					(15
						(gMessager say: 16 86 5 0 self) ; "Hmm, pigeon feathers. Lockjaw wishes the pigeon would come back. He's feeling a little hungry..."
					)
					(16
						(offScreen x: 41 y: 93 talkWidth: 75 tailPosn: 0)
						(gMessager say: 30 86 0 0 self) ; "SQUAWK!"
						(offScreen x: 138 y: 57 tailPosn: 1 talkWidth: 160)
					)
					(17
						(gMessager say: 8 86 0 0 self) ; "Lockjaw smells something DELICIOUS inside the dresser!"
					)
					(18
						(gMessager say: 27 86 0 0 self) ; "The bone smells pretty tasty, even if the Butler did bring it."
					)
					(19
						(gMessager say: 10 86 0 0 self) ; "The key smells like Ima. It must be hers."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gGame handsOn:)
				(if (== (gEgo loop:) 3)
					(gEgo normalize: 807 1 setSpeed: local6)
				else
					(gEgo normalize: 807 0 setSpeed: local6)
				)
				(self dispose:)
			)
		)
	)
)

(instance sLJPaws of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(if (OneOf (gEgo cel:) 0 2 3 4 6)
					(gEgo loop: 1)
				else
					(gEgo loop: 0)
				)
				(gEgo view: 801 setSpeed: 6 setCycle: End self)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(switch register
					(1
						(gMessager say: 7 30 0 0 self) ; "Lockjaw paws the dressmaker's dummy, but can't seem to move it."
					)
					(2
						(gMessager say: 4 30 0 0 self) ; "Lockjaw paws on the rug, but the silk is too slippery for his claws to shred."
					)
					(3
						(gMessager say: 12 30 26 0 self) ; "Lockjaw paws on Ima's bedsheets, but the silk is to slippery to shred."
					)
					(4
						(gMessager say: 8 30 0 0 self) ; "Lockjaw paws at the dresser, but he just can't seem to get the drawer open."
					)
					(5
						(gMessager say: 6 30 21 0 self) ; "Lockjaw tries to rip the silk sheets, but his paws just slide off."
					)
					(6
						(gMessager say: 25 30 11 0 self) ; "Lockjaw tries to claw his way out!"
					)
					(7
						(gMessager say: 9 30 0 0 self) ; "Lockjaw tries to paw the box open, but his paws are just too clumsy."
					)
				)
			)
			(4
				(if (== (gEgo loop:) 0)
					(gEgo normalize: 807 1 setSpeed: local6)
				else
					(gEgo normalize: 807 0 setSpeed: local6)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance butler of Actor
	(properties
		x 250
		y 140
		noun 29
		view 416
		signal 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(= local3 1)
				(gCurRoom setScript: sTeethOnFootman)
			)
			(30 ; Paw
				(gGame points: 401 3)
				(gCurRoom setScript: sPawOnFootman)
			)
			(34 ; Fleas
				(gGame points: 402 4)
				(gCurRoom setScript: sFleaOnFootman)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ima of Actor
	(properties
		x 134
		y 119
		view 426
		loop 2
		priority 12
		signal 16
	)
)

(instance pigeon of Prop
	(properties
		x 41
		y 103
		noun 30
		approachX 54
		approachY 138
		_approachVerbs -32647
		view 419
		priority 7
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; King_s_Letter
				(gCurRoom setScript: sGiveLetter)
			)
			(86 ; Nose
				(gCurRoom setScript: sSmellPigeon)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bucket of View
	(properties
		x 130
		y 95
		noun 1
		view 417
		priority 10
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(= gDictionaryWord 76)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance imaKeyFeature of Feature
	(properties
		x 217
		y 141
		noun 10
		nsTop 131
		nsLeft 197
		nsBottom 151
		nsRight 238
		sightAngle 40
	)

	(method (doVerb theVerb)
		(imaKey doVerb: theVerb)
	)
)

(instance imaKey of View
	(properties
		x 211
		y 139
		noun 10
		view 424
		loop 1
		cel 4
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if (IsFlag 399)
					(gMessager say: 10 6 3) ; "It's a key on a silk ribbon. It probably opens Ima's door."
				else
					(gMessager say: 10 6 4) ; "It's a key with a silk ribbon on it. It probably opens Ima's door!"
				)
			)
			(89 ; Teeth
				(if (== gAct 6)
					(gCurRoom setScript: sGetHangingKey)
				else
					(gCurRoom setScript: sTeethOnKey)
				)
			)
			(86 ; Nose
				(gCurRoom setScript: sSmellKey)
			)
			(30 ; Paw
				(gCurRoom setScript: sPawOnKey)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doggieBone of View
	(properties
		x 232
		y 135
		noun 27
		modNum 410
		approachX 223
		approachY 137
		_approachVerbs 113
		view 424
		loop 1
		cel 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(gCurRoom setScript: sTeethOnBone)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 18)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invDoggieBone of TWInvItem
	(properties
		loop 1
		cel 7
		message 25
		noun 33
		modNum 410
	)
)

(instance passageFea of Feature
	(properties
		x 198
		y 184
		nsTop 47
		nsLeft 171
		nsBottom 121
		nsRight 225
		sightAngle 40
		approachX 198
		approachY 125
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(passage doVerb: theVerb)
	)
)

(instance passage of Prop
	(properties
		x 198
		y 84
		approachX 198
		approachY 125
		_approachVerbs -32647
		view 424
		signal 1
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 76)
		(switch theVerb
			(3 ; Walk
				(cond
					(local0
						(gCurRoom setScript: sGoSecretRoom)
					)
					((> (gotchaTimer seconds:) 0)
						(gotchaTimer cycleCnt: 1)
					)
					(else
						(gCurRoom setScript: sGoToShelves)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clock of Prop
	(properties
		x 232
		y 84
		view 424
		loop 3
		signal 16384
	)
)

(instance boxFea of Feature
	(properties
		x 168
		y 144
		noun 9
		nsTop 137
		nsLeft 152
		nsBottom 151
		nsRight 184
		sightAngle 40
		approachX 190
		approachY 154
		_approachVerbs 113
	)

	(method (doVerb theVerb)
		(truffle doVerb: theVerb)
	)
)

(instance truffle of View
	(properties
		x 162
		y 142
		noun 9
		approachX 190
		approachY 154
		_approachVerbs 113
		view 424
		loop 1
		cel 3
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(= gDictionaryWord 73)
				(super doVerb: theVerb &rest)
			)
			(86 ; Nose
				(= gDictionaryWord 73)
				(super doVerb: theVerb &rest)
			)
			(30 ; Paw
				(gCurRoom setScript: sLJPaws 0 7)
			)
			(89 ; Teeth
				(gCurRoom setScript: sShredTruffles)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dresser of Feature
	(properties
		x 139
		y 100
		noun 8
		nsTop 105
		nsLeft 107
		nsBottom 138
		nsRight 171
		sightAngle 40
		approachX 191
		approachY 135
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(if (IsFlag 33)
					(gMessager say: 8 89 29) ; "Lockjaw found all the goodies in the dresser. He's got no reason to chew it any more."
				else
					(gCurRoom setScript: sTeethOnDresser)
				)
			)
			(86 ; Nose
				(if (IsFlag 396)
					(gMessager say: 8 86 29) ; "The dresser smells like rose water. Lockjaw can still faintly smell petit fours. Aaaaah!"
				else
					(gCurRoom setScript: sNoseDresser)
				)
			)
			(30 ; Paw
				(gCurRoom setScript: sLJPaws 0 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doggieBed of Feature
	(properties
		x 82
		y 120
		noun 6
		nsTop 91
		nsLeft 64
		nsBottom 143
		nsRight 101
		sightAngle 40
		approachX 54
		approachY 143
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; Ima_s_Room_Key
				(gCurRoom setScript: sHideKeyInBed)
			)
			(30 ; Paw
				(if (and (== (imaKey cel:) 4) (== ((gInventory at: 7) owner:) 410)) ; Ima_s_Room_Key
					(gCurRoom setScript: sPawOnBed)
				else
					(gCurRoom setScript: sLJPaws 0 5)
				)
			)
			(89 ; Teeth
				(if (and (== (imaKey cel:) 4) (== ((gInventory at: 7) owner:) 410)) ; Ima_s_Room_Key
					(gCurRoom setScript: sPawOnBed)
				else
					(gCurRoom setScript: sTeethOnBed)
				)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 1)
			)
			(25 ; Bone or invDoggieBone
				(if (not (== gAct 6))
					(gCurRoom setScript: sBuryBone)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance imaDoor of View
	(properties
		x 248
		y 49
		noun 25
		sightAngle 20
		approachX 236
		approachY 131
		_approachVerbs -32647
		view 424
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; Ima_s_Room_Key
				(if (== gAct 6)
					(gCurRoom setScript: sUseKeyDoor)
				else
					(gMessager say: 25 101 24) ; "That's a good idea, but Lockjaw's paws aren't coordinated enough to open the door."
				)
			)
			(30 ; Paw
				(gCurRoom setScript: sLJPaws 0 6)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance imaDoorFeature of Feature
	(properties
		x 253
		y 87
		noun 25
		nsTop 48
		nsLeft 242
		nsBottom 126
		nsRight 265
		sightAngle 40
		approachX 236
		approachY 131
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(imaDoor doVerb: theVerb)
	)
)

(instance fDoll of Feature
	(properties
		x 160
		y 180
		noun 2
		approachX 77
		approachY 170
		_approachVerbs 113
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(if (== gAct 4)
					(gMessager say: 2 89 33) ; "Lockjaw's swallowed as much doll stuffing as he can hold, thank you."
				else
					(gMessager say: 2 89) ; "Lockjaw doesn't want to get cotton between his teeth right at the moment. Besides, the doll smells like Ima. YUK!"
				)
			)
			(6 ; Look
				(if (== gAct 4)
					(gMessager say: 2 89 33) ; "Lockjaw's swallowed as much doll stuffing as he can hold, thank you."
				else
					(gMessager say: 2 89) ; "Lockjaw doesn't want to get cotton between his teeth right at the moment. Besides, the doll smells like Ima. YUK!"
				)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fPillow of Feature
	(properties
		x 160
		y 188
		noun 3
		approachX 177
		approachY 170
		_approachVerbs 113
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(if (== gAct 4)
					(= gDictionaryWord 76)
					(gMessager say: 3 89 33) ; "Lockjaw doesn't want to bite the pillow anymore. He's still nauseated from the first time. A dog can only hold so much |r||c0|potpourri|c||r|."
				else
					(gMessager say: 3 89) ; "The pillow smells too bad for Lockjaw to even TRY to bite it."
				)
			)
			(6 ; Look
				(if (== gAct 4)
					(gMessager say: 3 6 33) ; "Lockjaw managed to hold his breath and bite the pillow. He thinks it looks much more interesting now."
				else
					(gMessager say: 3 6) ; "Ima has more big, fluffy, silk things in her room than any ten people should have."
				)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance restPillow of View
	(properties
		x 164
		y 145
		noun 3
		approachX 177
		approachY 170
		_approachVerbs 113
		view 424
		loop 2
		cel 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(fPillow doVerb: theVerb)
	)
)

(instance dogBedPosts of Feature
	(properties
		noun 15
	)
)

(instance rug of Feature
	(properties
		noun 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; Paw
				(gCurRoom setScript: sLJPaws 0 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance books of Feature
	(properties
		x 185
		y 110
		noun 17
		nsTop 103
		nsLeft 174
		nsBottom 117
		nsRight 197
		approachX 182
		approachY 123
		approachDist 10
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 5)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bowl of Feature
	(properties
		x 211
		y 94
		noun 19
		nsTop 90
		nsLeft 202
		nsBottom 98
		nsRight 221
		approachX 182
		approachY 123
		approachDist 10
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 6)
			)
			(6 ; Look
				(= gDictionaryWord 75)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cuckoo_clock of Feature
	(properties
		x 232
		y 172
		noun 22
		nsTop 61
		nsLeft 224
		nsBottom 113
		nsRight 236
		approachX 200
		approachY 127
		approachDist 10
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(cond
					((and (== gAct 2) (not (IsFlag 97)))
						(gMessager say: 22 89 14) ; "Lockjaw decides to bite the pinecone--Yow! There's somebody out in the hall!"
						(gCurRoom setScript: sBathTime)
					)
					(local0
						(gMessager say: 22 89 32) ; "The secret door is already open. Lockjaw doesn't need to bite the pinecone again."
					)
					((== gAct 6)
						(gMessager say: 22 89 33) ; "Lockjaw doesn't have time to explore! He has to help Pepper get him out of here!"
					)
					(else
						(gCurRoom setScript: sOpenPassage)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dresserDoll of Feature
	(properties
		x 144
		y 94
		noun 11
		nsTop 85
		nsLeft 132
		nsBottom 104
		nsRight 157
		approachX 139
		approachY 141
		approachDist 10
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 8)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dress_dummy of Feature
	(properties
		x 275
		y 103
		noun 7
		nsTop 66
		nsLeft 263
		nsBottom 141
		nsRight 292
		approachX 220
		approachY 144
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(gCurRoom setScript: sChewDress)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 9)
			)
			(30 ; Paw
				(gCurRoom setScript: sLJPaws 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance imaBed of Feature
	(properties
		x 118
		y 66
		noun 12
		nsTop 29
		nsLeft 76
		nsBottom 103
		nsRight 160
		approachX 177
		approachY 129
		approachDist 10
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 10)
			)
			(30 ; Paw
				(gCurRoom setScript: sLJPaws 0 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pitcher of Feature
	(properties
		x 191
		y 92
		noun 18
		nsTop 87
		nsLeft 182
		nsBottom 97
		nsRight 201
		approachX 182
		approachY 123
		approachDist 10
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(= gDictionaryWord 75)
				(super doVerb: theVerb &rest)
			)
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 11)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shelfDolls of Feature
	(properties
		x 198
		y 97
		z 20
		noun 20
		nsTop 70
		nsLeft 175
		nsBottom 84
		nsRight 222
		approachX 182
		approachY 123
		approachDist 10
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 12)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance toys of Feature
	(properties
		x 197
		y 92
		z 30
		noun 21
		nsTop 56
		nsLeft 175
		nsBottom 68
		nsRight 220
		approachX 182
		approachY 123
		approachDist 10
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLJSmells 0 13)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waterBowl of Feature
	(properties
		x 116
		y 145
		noun 5
		nsTop 138
		nsLeft 107
		nsBottom 152
		nsRight 126
		sightAngle 40
		approachX 134
		approachY 145
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; Teeth
				(if local1
					(gCurRoom setScript: sFirstDrink)
				else
					(gCurRoom setScript: sSecondDrink)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance imaWindow of Feature
	(properties
		x 42
		y 73
		noun 14
		nsTop 50
		nsLeft 24
		nsBottom 97
		nsRight 61
		approachX 62
		approachY 143
		approachDist 10
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sLookOutWindow 0 1)
			)
			(30 ; Paw
				(gCurRoom setScript: sLookOutWindow 0 2)
			)
			(6 ; Look
				(gCurRoom setScript: sLookOutWindow 0 3)
			)
			(7 ; Do
				(gCurRoom setScript: sLookOutWindow 0 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance windowSill of Feature
	(properties
		x 44
		y 100
		noun 16
		nsTop 98
		nsLeft 26
		nsBottom 103
		nsRight 62
		sightAngle 40
		approachX 44
		approachY 100
		approachDist 10
		_approachVerbs -32647
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; Paw
				(gCurRoom setScript: sLookOutWindow 0 5)
			)
			(86 ; Nose
				(gCurRoom setScript: sLookOutWindow 0 6)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chamberPot of Feature
	(properties
		x 89
		y 140
		noun 26
		nsTop 134
		nsLeft 81
		nsBottom 147
		nsRight 98
		sightAngle 40
	)
)

(instance farShroud of View
	(properties
		x 173
		y 50
		view 424
		loop 2
		signal 16384
	)
)

(instance shredEye of View
	(properties
		x 25
		y 140
		noun 2
		view 427
		cel 1
		priority 15
		signal 16400
	)
)

(instance shreddummy of View
	(properties
		x 257
		y 70
		view 427
		cel 2
		priority 11
		signal 16400
	)
)

(instance shredcornerChest of View
	(properties
		x 152
		y 125
		noun 48
		view 427
		cel 6
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(= gDictionaryWord 73)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shredFrontPillow of View
	(properties
		x 170
		y 154
		noun 3
		view 427
		cel 5
		priority 15
		signal 16400
	)
)

(instance shredHoleBed of View
	(properties
		x 72
		y 134
		noun 6
		sightAngle 40
		approachX 54
		approachY 143
		_approachVerbs -32647
		view 427
		cel 7
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(doggieBed doVerb: theVerb)
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance song of Sound
	(properties)
)

(instance butlerT of BalloonTalker
	(properties
		x 8
		y 83
		talkWidth 150
		tailPosn 1
	)
)

(instance offScreen of BalloonTalker
	(properties
		x 138
		y 57
		talkWidth 160
		tailPosn 1
	)
)

(instance gotchaTimer of Timer
	(properties)

	(method (cue)
		(cond
			(local3
				(if (gCurRoom script:)
					((gCurRoom script:) next: sTeethOnFootman)
				else
					(gCurRoom setScript: sTeethOnFootman)
				)
			)
			(local4
				(if (gCurRoom script:)
					((gCurRoom script:) next: sPawOnFootman)
				else
					(gCurRoom setScript: sPawOnFootman)
				)
			)
			(local5
				(if (gCurRoom script:)
					((gCurRoom script:) next: sFleaOnFootman)
				else
					(gCurRoom setScript: sFleaOnFootman)
				)
			)
			((gCurRoom script:)
				((gCurRoom script:) next: sGotcha)
			)
			(else
				(gCurRoom setScript: sGotcha)
			)
		)
	)
)

(instance comeInTimer of Timer
	(properties)

	(method (cue)
		(if (gCurRoom script:)
			((gCurRoom script:) next: sBathTime)
		else
			(gCurRoom setScript: sBathTime)
		)
	)
)

(instance hideKeyTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom newRoom: 400) ; Maze
	)
)

