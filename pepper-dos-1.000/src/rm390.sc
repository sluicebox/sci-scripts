;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use ExitFeature)
(use invCode)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2)
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(instance rm390 of ADRoom
	(properties
		noun 21
		picture 390
		horizon 75
		east 380
		vanishingY -60
		autoLoad 1
	)

	(method (init)
		(gEgo init: normalize: setScale: 0 actions: egoDoVerb x: 271 y: 111)
		(switch gPrevRoomNum
			(370
				(gCurRoom setScript: sImaNags)
			)
			(else
				(if (IsFlag 167)
					(gCurRoom setScript: sEnterEast)
				else
					(gCurRoom setScript: sImaNags)
				)
			)
		)
		(super init: &rest)
		(gLongSong number: 390 loop: -1 flags: 1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 88 132 96 139 87 149 54 147 44 156 122 162 155 162 314 161 314 142 230 117 271 111 285 117 319 0 319 189 0 189 0 0 240 1 243 112 221 113 195 130 181 124 77 125
					yourself:
				)
		)
		(gInventory
			addAfter:
				(gInventory at: 44) ; Wood_Cutting_c
				(invIron init: yourself:)
				(invPotHolder init: yourself:)
		)
		(if (> (gGame detailLevel:) 2)
			(dummy init: setScript: sCycleFire)
		)
		(dyePot init:)
		(if (IsFlag 83)
			(gEgo get: 46)
		else
			(potholder init:)
		)
		(if (IsFlag 79)
			(if (gEgo has: 46)
				(gEgo put: 46 get: 45)
				(invIron loop: 8 cel: 6 noun: 26)
			else
				(gEgo get: 45)
			)
		else
			(iron init:)
		)
		(if (not (IsFlag 80))
			(dress init:)
		)
		(if (not (IsFlag 81))
			(mop init:)
			(mopHead init:)
		)
		(if (not (IsFlag 82))
			(fan init:)
		)
		(apples init: setOnMeCheck: 1 512)
		(cabbage init: setOnMeCheck: 1 256)
		(candles init: setOnMeCheck: 1 16384)
		(cauldron init: approachVerbs: 39 7 6) ; Doctrine, Do, Look
		(corn init: setOnMeCheck: 1 8192)
		(fire init: setOnMeCheck: 1 4096)
		(hangingBasket init:)
		(ironingBoard init: setOnMeCheck: 1 2048)
		(ladle init:)
		(laundry init: setOnMeCheck: 1 1024)
		(meatFork init:)
		(onions init: setOnMeCheck: 1 128)
		(platters init:)
		(skillet init:)
		(spoon init:)
		(stool init:)
		(eastEFeature init:)
	)

	(method (dispose)
		(gInventory delete: invIron delete: invPotHolder)
		(gLongSong fade:)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((localproc_0 gEgo 2)
				(if (or (gEgo has: 45) (gEgo has: 46))
					(gCurRoom setScript: sPutStuffBack)
				else
					(gCurRoom newRoom: 380)
				)
			)
		)
	)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; ???
				(gMessager say: 18 81) ; "Hey, this will work to cover my face!"
			)
			(147 ; ???
				(gMessager say: 18 147) ; "Yeah, I guess these will work...if I can keep from spewing! But what am I going to do about my hair? It's not mud-blonde!"
			)
			(148 ; ???
				(gMessager say: 18 148) ; "Oh, excellent! I can wear the dress, cover my hair...but what am I going to do about my face?"
			)
			(149 ; ???
				(gMessager say: 18 149) ; "Yeah! I can cover my face with the fan, make a wig out of the mop...but my clothes aren't right!"
			)
			(82 ; ???
				(gMessager say: 18 82) ; "Oh, check it out! I'm Ima! Don't you love my bee-yoo-tiful hair?"
			)
			(114 ; outfitI
				(gMessager say: 18 114) ; "Hey, yeah! This will work... but not all by itself!"
			)
			(122 ; ???
				(gCurRoom setScript: sPutOutfitOn)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sEnterEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					edgeHit: EDGE_RIGHT
					setHeading: 270
					posn: 271 111
					setMotion: PolyPath 221 132 self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPutStuffBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (gEgo has: 45)
					(self setScript: sPutIronBack self)
				else
					(= cycles 1)
				)
			)
			(2
				(gMessager say: 23 0 12 0 self) ; "Pepper ditches the PUGH-trid potholder."
			)
			(3
				(gEgo setMotion: PolyPath 93 129 self)
			)
			(4
				(gEgo setHeading: 0)
				(= ticks 60)
			)
			(5
				(gEgo put: 46)
				(potholder init: stopUpd:)
				(potholderBack dispose:)
				(ClearFlag 83)
				(if (not (== (self client:) sPutOutfitOn))
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sPutIronBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 23 0 11 0 self) ; "I don't want to carry this heavy old iron around with me everywhere!"
			)
			(1
				((ScriptID 895 0) setMotion: MoveTo 98 132 self) ; pepper
			)
			(2
				(gEgo setMotion: PolyPath 135 120 self)
			)
			(3
				(gEgo setHeading: 0)
				(= ticks 60)
			)
			(4
				(gEgo put: 45)
				(iron init: stopUpd:)
				(ironBack dispose:)
				(ClearFlag 79)
				(self dispose:)
			)
		)
	)
)

(instance sCycleFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(if (> (gGame detailLevel:) 2)
					(Palette palANIMATE 64 69 10)
				else
					(self dispose:)
				)
				(= ticks 10)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sImaNags of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 167)
				(= cycles 1)
			)
			(1
				(self setScript: sEnterEast self)
			)
			(2
				(gGame handsOff:)
				(= cycles 1)
			)
			(3
				(ima init:)
				(gEgo setMotion: PolyPath 173 134 self)
			)
			(4
				(gEgo setHeading: 90)
				(= cycles 2)
			)
			(5
				(ima setCycle: Walk setMotion: PolyPath 214 132 self)
			)
			(6
				(ima loop: 4 cel: 1 stopUpd:)
				(gMessager say: 23 0 10 0 self) ; "All right, now, listen up! I want you to pay attention, you hear me, boy?"
			)
			(7
				(ima setMotion: PolyPath 265 118 self)
			)
			(8
				(ima dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetIronOk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 380 1)
				(= cycles 1)
			)
			(1
				(SetFlag 79)
				(if (gEgo has: 46)
					(gEgo put: 46 get: 45)
					(invIron loop: 8 cel: 6 noun: 26)
				else
					(gEgo get: 45)
				)
				(gMessager say: 12 7 9 0 self) ; "Oh, man! That thing is heavy!"
			)
			(2
				(iron dispose:)
				(ironBack init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetIronNotOk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (gEgo cycleSpeed:))
				(= cycles 1)
			)
			(1
				(sFX number: 3900 play:)
				(gEgo
					view: 390
					loop: 2
					cel: 0
					posn: 135 120
					setSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gMessager say: 12 7 8 0 self) ; "OW! Darn it! That hurt!"
			)
			(3
				(gEgo normalize: setSpeed: local0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sIronDress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 381 1)
				(= local0 (gEgo cycleSpeed:))
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 79 142 self)
			)
			(2
				(gMessager say: 6 115 0 0 self) ; "Well... I guess I'll iron the stupid thing. Maybe I'll burn a hole in it! Ha!"
			)
			(3
				(gEgo
					view: 391
					loop: 0
					cel: 0
					x: 69
					y: 142
					setSpeed: 8
					setPri: 12
					setCycle: End self
				)
			)
			(4
				(gEgo loop: 1 cel: 0 x: 65 y: 137 setPri: 15 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(gEgo setCycle: 0)
				(= cycles 1)
			)
			(6
				(gEgo
					loop: 0
					cel: (gEgo lastCel:)
					x: 69
					y: 142
					setPri: 12
					setCycle: Beg self
				)
			)
			(7
				(gEgo posn: 79 142 normalize: 790 2)
				(= cycles 2)
			)
			(8
				(self setScript: sPutStuffBack self)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAlreadyIronedDress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 383 2)
				(= cycles 1)
			)
			(1
				(gMessager say: 6 115 5 0 self) ; "Pepper already ironed the dress. If it gets any flatter, it'll be two-dimensional."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetPotholder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 379 1)
				(= cycles 1)
			)
			(1
				(gEgo stopUpd:)
				(gMessager say: 20 7 6 0 self) ; "There! This should keep my mitt nice and cool."
			)
			(2
				(SetFlag 83)
				(potholder dispose:)
				(potholderBack init:)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(if (gEgo has: 45)
					(invIron loop: 8 cel: 6 noun: 26)
				else
					(gEgo get: 46)
				)
				(self dispose:)
			)
		)
	)
)

(instance sGetFan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 382 1)
				(SetFlag 82)
				(= cycles 1)
			)
			(1
				(gMessager say: 8 7 6 0 self) ; "I wonder what I could do with this stupid fan..."
			)
			(2
				(gEgo setMotion: PolyPath 151 163 self)
			)
			(3
				(gEgo
					view: 803
					loop: 0
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(4
				(fan dispose:)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize: get: 42) ; outfitI
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetMopHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 384 2)
				(SetFlag 81)
				(= cycles 1)
			)
			(1
				(gMessager say: 16 7 6 0 self) ; "<Giggle!> That looks just like Ima's hair--stringy, limp, and mangy! Maybe I could use it..."
			)
			(2
				(gEgo
					view: 803
					loop: 0
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(3
				(mop dispose:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(gEgo normalize: get: 42) ; outfitI
				(self dispose:)
			)
		)
	)
)

(instance sGetDress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 383 2)
				(SetFlag 80)
				(= cycles 1)
			)
			(1
				(gMessager say: 6 7 3 0 self) ; "Hmm, I wonder if I could fool them..."
			)
			(2
				(gEgo
					view: 803
					loop: 1
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(3
				(dress dispose:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: get: 42) ; outfitI
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPutOutfitOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 385 4)
				(= local0 (gEgo cycleSpeed:))
				(= cycles 1)
			)
			(1
				(gEgo
					view: 391
					loop: 2
					cel: 0
					setSpeed: 5
					setCycle: End self
				)
			)
			(2
				(= seconds 1)
			)
			(3
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(4
				(= seconds 1)
			)
			(5
				(gEgo
					put: 42 ; outfitI
					loop: 4
					cel: 0
					posn: (- (gEgo x:) 12) (gEgo y:)
					setCycle: End self
				)
			)
			(6
				(= seconds 1)
			)
			(7
				(gEgo normalize: 388 0 setCycle: Walk setSpeed: local0)
				(= cycles 1)
			)
			(8
				(if (or (gEgo has: 46) (gEgo has: 45))
					(self setScript: sPutStuffBack self)
				else
					(= cycles 1)
				)
			)
			(9
				(gMessager say: 18 122 0 1 self) ; "Okay, here goes..."
			)
			(10
				(gEgo setHeading: 180)
				(= cycles 4)
			)
			(11
				(gMessager say: 18 122 0 2 self) ; "Hey, I'm ready! Stunning resemblance, don't you think?"
			)
			(12
				(gEgo setMotion: PolyPath 216 124 self)
			)
			(13
				(gEgo setMotion: MoveTo 264 115 self)
			)
			(14
				(SetFlag 76)
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance ima of Actor
	(properties
		x 265
		y 118
		view 832
		loop 1
	)
)

(instance dummy of Prop
	(properties
		y 1000
		view 390
		loop 1
	)
)

(instance dyePot of View
	(properties
		x 162
		y 102
		noun 7
		sightAngle 40
		approachX 187
		approachY 127
		_approachVerbs 8
		view 390
		cel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gMessager say: 7 84) ; "|c1|TRUE. Colonial blue dye probably would have been made from Indigo plants imported from India, or native New England blueberries.|c|"
				(sFX number: 927 play:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance iron of View
	(properties
		x 105
		y 106
		noun 12
		approachX 135
		approachY 120
		_approachVerbs 9
		view 390
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 12 6 6) ; "A heavy iron is warming by the fire."
			)
			(152 ; invPotHolder
				(gCurRoom setScript: sGetIronOk)
			)
			(7 ; Do
				(if (gEgo has: 46)
					(gCurRoom setScript: sGetIronOk)
				else
					(gCurRoom setScript: sGetIronNotOk)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invIron of TWInvItem
	(properties
		loop 8
		cel 4
		message 115
		noun 12
		modNum 390
	)
)

(instance dress of View
	(properties
		x 17
		y 114
		noun 6
		approachX 86
		approachY 140
		_approachVerbs 9
		view 390
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 6 6 6) ; "That is the ugliest dress on the planet! Eeow!"
			)
			(7 ; Do
				(if (IsFlag 381)
					(gCurRoom setScript: sGetDress)
				else
					(gMessager say: 6 7 4) ; "Yech! This thing looks like a wrinkled, lacy hairball!"
				)
			)
			(115 ; invIron
				(if (not (IsFlag 381))
					(if (gEgo has: 45)
						(gCurRoom setScript: sIronDress)
					else
						(gMessager say: 6 7 4) ; "Yech! This thing looks like a wrinkled, lacy hairball!"
					)
				else
					(gCurRoom setScript: sAlreadyIronedDress)
				)
			)
			(152 ; invPotHolder
				(if (not (gEgo has: 45))
					(gMessager say: 6 152 7) ; "The potholder would work better if it had an iron with it."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mop of View
	(properties
		x 192
		y 65
		noun 16
		approachX 187
		approachY 127
		_approachVerbs 8
		view 390
		cel 3
		signal 4096
	)

	(method (doVerb theVerb)
		(mopHead doVerb: theVerb &rest)
	)
)

(instance fan of View
	(properties
		x 173
		y 187
		z 40
		noun 8
		approachX 164
		approachY 162
		_approachVerbs 9
		view 907
		loop 7
		cel 2
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 8 6 6) ; "Ima's lace fan sits on the counter."
			)
			(7 ; Do
				(gCurRoom setScript: sGetFan)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potholder of View
	(properties
		x 86
		y 97
		noun 20
		approachX 93
		approachY 129
		_approachVerbs 8
		view 390
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 20 6 6) ; "It's a large, padded potholder."
			)
			(7 ; Do
				(gCurRoom setScript: sGetPotholder)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invPotHolder of TWInvItem
	(properties
		loop 8
		cel 5
		message 152
		noun 20
		modNum 390
	)
)

(instance apples of Feature
	(properties
		y 180
		noun 1
		sightAngle 40
	)
)

(instance cabbage of Feature
	(properties
		y 180
		sightAngle 40
	)
)

(instance candles of Feature
	(properties
		y 180
		noun 2
		sightAngle 40
	)
)

(instance cauldron of Feature
	(properties
		x 134
		y 95
		noun 3
		nsTop 78
		nsLeft 117
		nsBottom 112
		nsRight 152
		sightAngle 40
		approachX 126
		approachY 129
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gMessager say: 3 84) ; "|c1|TRUE. Foods like soup, stew, and gruel were often cooked in heavy iron cauldrons over an open fire. Meat was cooked on a long fork or spit over the fire, too.|c|"
				(sFX number: 927 play:)
			)
			(39 ; Doctrine
				(gMessager say: 9 153) ; "Pepper gleefully tosses the horrible Doctrine of Personal Mellowness into the fire, and watches it burn away to a cinder."
				(gEgo put: 10) ; Doctrine
			)
			((OneOf theVerb 85 7 6 86 30 89 84) ; Talk, Do, Look, Nose, Paw, Teeth, Trivia
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 9 19) ; "Pepper doesn't want to burn that up. She might need it."
			)
		)
	)
)

(instance corn of Feature
	(properties
		x 1
		y 182
		noun 4
		sightAngle 40
	)
)

(instance fire of Feature
	(properties
		y 108
		noun 9
		sightAngle 40
		approachX 126
		approachY 129
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(39 ; Doctrine
				(gMessager say: 9 153) ; "Pepper gleefully tosses the horrible Doctrine of Personal Mellowness into the fire, and watches it burn away to a cinder."
				(gEgo put: 10) ; Doctrine
			)
			((OneOf theVerb 85 7 6 86 30 89 84) ; Talk, Do, Look, Nose, Paw, Teeth, Trivia
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 9 19) ; "Pepper doesn't want to burn that up. She might need it."
			)
		)
	)
)

(instance hangingBasket of Feature
	(properties
		x 258
		y 14
		noun 10
		nsLeft 198
		nsBottom 29
		nsRight 319
		sightAngle 40
		approachX 217
		approachY 137
		approachDist 173
		_approachVerbs 9
	)
)

(instance ironingBoard of Feature
	(properties
		y 113
		noun 11
	)
)

(instance ladle of Feature
	(properties
		x 161
		y 72
		noun 13
		nsTop 56
		nsLeft 155
		nsBottom 88
		nsRight 167
		sightAngle 40
		approachX 170
		approachY 127
		approachDist 60
		_approachVerbs 9
	)
)

(instance laundry of Feature
	(properties
		y 116
		noun 14
		sightAngle 40
	)
)

(instance meatFork of Feature
	(properties
		x 182
		y 67
		noun 15
		nsTop 54
		nsLeft 177
		nsBottom 80
		nsRight 187
		sightAngle 40
		approachX 170
		approachY 127
		approachDist 70
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gMessager say: 15 84) ; "|c1|TRUE. Colonists couldn't just pop meat into the microwave like we can. They had to cook it on a long fork or spit over the fireplace.|c|"
				(sFX number: 927 play:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mopHead of Feature
	(properties
		x 200
		y 112
		noun 16
		nsTop 104
		nsLeft 188
		nsBottom 121
		nsRight 212
		sightAngle 40
		approachX 187
		approachY 127
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 16 6 6) ; "It's a mop. The mop head is made of yellow, greasy, curly yarn that looks strangely familiar..."
			)
			(7 ; Do
				(gCurRoom setScript: sGetMopHead)
			)
			(85 ; Talk
				(gMessager say: 16 85 6) ; "<Snicker!> That mop looks like Ima upside-down!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onions of Feature
	(properties
		y 80
		noun 17
		sightAngle 40
	)
)

(instance platters of Feature
	(properties
		x 156
		y 42
		noun 19
		nsTop 31
		nsLeft 132
		nsBottom 53
		nsRight 180
		sightAngle 40
		approachX 170
		approachY 127
		approachDist 103
		_approachVerbs 9
	)
)

(instance skillet of Feature
	(properties
		x 69
		y 81
		noun 22
		nsTop 63
		nsLeft 62
		nsBottom 99
		nsRight 77
		sightAngle 40
		approachX 91
		approachY 130
		approachDist 78
		_approachVerbs 9
	)
)

(instance spoon of Feature
	(properties
		x 173
		y 68
		noun 24
		nsTop 55
		nsLeft 169
		nsBottom 81
		nsRight 177
		sightAngle 40
		approachX 170
		approachY 127
		approachDist 66
		_approachVerbs 9
	)
)

(instance stool of Feature
	(properties
		x 72
		y 140
		noun 25
		nsTop 132
		nsLeft 61
		nsBottom 149
		nsRight 84
		sightAngle 40
		approachX 97
		approachY 145
		approachDist 50
		_approachVerbs 9
	)
)

(instance potholderBack of Feature
	(properties
		x 89
		y 1
		noun 21
		nsTop 88
		nsLeft 79
		nsBottom 114
		nsRight 100
	)

	(method (doVerb theVerb)
		(switch theVerb
			(152 ; invPotHolder
				(gCurRoom setScript: sPutStuffBack)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ironBack of Feature
	(properties
		x 112
		y 1
		noun 21
		nsTop 97
		nsLeft 101
		nsBottom 123
		nsRight 124
		approachX 135
		approachY 120
	)

	(method (doVerb theVerb)
		(switch theVerb
			(115 ; invIron
				(gCurRoom setScript: sPutStuffBack)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance eastEFeature of ExitFeature
	(properties
		nsTop 42
		nsLeft 229
		nsBottom 120
		nsRight 249
		cursor 913
		exitDir 2
		noun 21
	)
)

(instance sFX of Sound
	(properties)
)

