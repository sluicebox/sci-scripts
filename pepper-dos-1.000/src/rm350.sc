;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use ExitFeature)
(use CycleBet)
(use BalloonTalker)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm350 0
	redcoat1 1
	redcoat2 2
	sentry1Talker 11
	sentry2Talker 12
)

(local
	local0 = 1
	local1 = 1
	local2 = 1
	local3
)

(instance rm350 of ADRoom
	(properties
		noun 2
		picture 350
		horizon 75
		east 210
		west 360
		vanishingY 30
	)

	(method (init)
		(super init: &rest)
		(gEgo init: x: 319 y: 185 normalize:)
		(gLongSong number: 3600 loop: -1 flags: 1 play:)
		(if (not (== ((gInventory at: 36) owner:) gCurRoomNum)) ; Bonbons
			(gLongSong2 number: 300 setLoop: -1 play:)
		)
		(switch gPrevRoomNum
			(610
				(gEgo x: 223 y: 170)
				(if (> (gGame detailLevel:) 2)
					(sentry1 setScript: sCycleRiver)
				)
				(gGame handsOn:)
			)
			(else
				(gCurRoom setScript: sWalkIn)
				(if (> (gGame detailLevel:) 2)
					(sentry1 setScript: sCycleRiver)
				)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 177 156 93 192 0 192 0 105 8 86 87 40 91 64 37 84 23 124 75 152 130 126
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 144 118 252 124 247 107 319 56 319 97 262 109 319 139 319 161 212 162 185 154
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 64 83 74 115 97 131 83 138 41 122 39 88
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 85 92 84 79 104 73 103 39 222 26 237 83 231 98 195 95 184 77 158 76 177 93 94 93
					yourself:
				)
		)
		(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
			(sentry1
				view: 353
				loop: 0
				cel: 0
				posn: 249 153
				ignoreActors: 1
				setCycle: Fwd
				init:
			)
			(sentry1Feature init:)
		else
			(sentry1 ignoreActors: 1 init:)
			(sentry2 ignoreActors: 1 init:)
		)
		(river init:)
		(sentry3 init: stopUpd:)
		(sentry4 init: stopUpd:)
		(if (and (not (gEgo has: 15)) (<= gAct 3) (not (IsFlag 38))) ; Kite_String
			(string init:)
		)
		(bridge init: setOnMeCheck: 1 2048)
		(foliage init: setOnMeCheck: 1 8192)
		(frontTree init: setOnMeCheck: 1 16384)
		(hills init: setOnMeCheck: 1 4096)
		(mansion init:)
		(riverTrees init:)
		(eastExitFeature init:)
		(southExitFeature init:)
		(gWalkHandler addToFront: river)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((& (gEgo onControl: 1) $0800)
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gCurRoom setScript: sOverBridgeCaught)
				else
					(gCurRoom setScript: sComeBackHere)
				)
			)
			((& (gEgo onControl: 1) $0800)
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gCurRoom setScript: sInRiver_Caught 0 1)
				else
					(gMessager say: 5 7 11) ; "Stay away from the river, you little water rat!"
				)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gCurRoom setScript: sComeBackInNorth)
			)
			((& (gEgo onControl: 1) $0004)
				(gCurRoom setScript: sWalkOut)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(gCurRoom setScript: sComeBackInEast)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gWalkHandler delete: river)
		(gLongSong fade:)
		(gLongSong2 fade:)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb)
		(= global215 4)
		(super doVerb: theVerb)
	)
)

(instance sComeBackInNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 0 setMotion: MoveFwd 10 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sComeBackInEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 90 setMotion: MoveFwd 10 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWalkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo (+ (gEgo x:) 30) 230 self)
			)
			(2
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance sWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 223 170 self)
			)
			(2
				(Face gEgo sentry2 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCycleRiver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(if (> (gGame detailLevel:) 2)
					(Palette palANIMATE 64 69 20)
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

(instance sComeBackHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(Face gEgo sentry1 self)
			)
			(2
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 12 0 19 0 self) ; MISSING MESSAGE
				else
					(switch local2
						(1
							(= global215 85)
							(gMessager say: 12 0 1 1 2 self) ; "Hey! Where do you think you're going? Halt!"
						)
						(2
							(gMessager say: 12 0 2 1 2 self) ; "Excuse me, sentries, but I have business in the Mansion."
						)
						(3
							(gMessager say: 12 0 3 1 2 self) ; "Halt, you wretched ragamuffin! Why are you so determined on getting into the Mansion, ay?"
						)
						(4
							(gMessager say: 12 0 4 0 self) ; "Halt, boy. We'll put up with no more of your nonsense."
						)
					)
				)
			)
			(3
				(gEgo setMotion: PolyPath 232 169 self)
			)
			(4
				(= cycles 3)
			)
			(5
				(Face gEgo mansion self)
			)
			(6
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(= cycles 1)
				else
					(switch local2
						(1
							(= global215 85)
							(++ local2)
							(gMessager say: 12 0 1 3 6 self) ; "Well, I was just going to--"
						)
						(2
							(++ local2)
							(gMessager say: 12 0 2 3 4 self) ; "Watch your double negatives, Cecil."
						)
						(3
							(++ local2)
							(gMessager say: 12 0 3 3 6 self) ; "AS IF! Don't make me hurl! That's beyond disgusting!"
						)
						(4
							(= cycles 1)
						)
					)
				)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOverBridgeCaught of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 2000 3) ; PepperTalker
					winX: 92
					winY: 109
					forceWidth: 1
					talkWidth: 75
					tailPosn: 1
				)
				(gMessager say: 12 0 16 0 self) ; "All right! I'll just walk right through the front door!"
			)
			(2
				((ScriptID 2000 3) winX: 0 winY: 0 forceWidth: 0 talkWidth: 0) ; PepperTalker
				(= global199 21)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sTakeString of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 345 2)
				(= cycles 1)
			)
			(1
				(gMessager say: 8 7 0 1 6 self) ; "Excuse me, sir, but I wonder if you'd hand me that string in the tree?"
			)
			(2
				(sentry1
					view: 350
					loop: 1
					cel: 1
					posn: 241 158
					cycleSpeed: 6
					setPri: 11
					setCycle: End self
				)
			)
			(3
				(string dispose:)
				(gEgo get: 15) ; Kite_String
				(sentry1 setCycle: CT 1 -1 self)
			)
			(4
				(gMessager say: 8 7 0 7 self) ; "Here you go, you silly little twit. Don't strangle yourself, now! Hee hee hee!"
			)
			(5
				(sentry1
					view: 351
					loop: 1
					cel: 0
					cycleSpeed: 18
					setPri: -1
					posn: 245 155
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSugarRush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 347 3)
				(gEgo setMotion: PolyPath 178 170 self)
			)
			(1
				(gEgo setHeading: 45)
				(= ticks 30)
			)
			(2
				(gMessager say: 13 75 0 1 self) ; "Hey! I've got BONBONS! Nice, fresh BONBONS!"
			)
			(3
				(gEgo
					view: 350
					loop: 4
					posn: (+ (gEgo x:) 5) (gEgo y:)
					setCycle: CT 2 1 self
				)
			)
			(4
				(sentry1 view: 350 setLoop: 5 cel: 0 setCycle: CT 4 1 self)
			)
			(5
				(gMessager say: 13 75 0 2 3 self) ; "Bonbons?!? GIMME!"
				(sentry1 setCycle: CycleBet 4 5 4 self)
			)
			(6
				(gEgo put: 36 gCurRoomNum) ; Bonbons
			)
			(7
				(sentry1 cel: 4 setCycle: End self)
			)
			(8
				(gEgo view: 350 loop: 4 cel: 2 setCycle: End self)
			)
			(9
				(sentry1 view: 351 setLoop: 1 cel: 0 setCycle: CT 6 1 self)
				(sentry2 setLoop: 0 cel: 0 setCycle: CT 6 1 self)
			)
			(10
				(sentry1 setCycle: CycleBet 5 6 2 self)
				(sentry2 setCycle: End self)
				(sFX number: 3500 loop: -1 play:)
			)
			(11 0)
			(12
				(sentry1 view: 354 setLoop: 3 cel: 0 setCycle: End self)
				(sentry2 setLoop: 2 cel: 0 setCycle: End self)
			)
			(13 0)
			(14
				(sFX number: 3501 loop: 1 play:)
				(sentry1 dispose:)
				(sentry2
					view: 354
					setLoop: 4
					cel: 0
					posn: 249 153
					ignoreActors: 1
					setCycle: End self
				)
			)
			(15
				(gLongSong2 number: 300 stop:)
				(sFX number: 947 loop: 1 play:)
				(sentry1Feature init:)
				(sentry2 view: 353 loop: 0 cel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(16
				(gMessager say: 13 75 0 4 self) ; "Geez! Talk about a sugar rush!"
			)
			(17
				(gGame handsOn:)
				(gEgo normalize: 790 6 posn: (- (gEgo x:) 5) (gEgo y:))
				(self dispose:)
			)
		)
	)
)

(instance sRideKiteDownRiver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 348 3)
				(sentry1 stopUpd:)
				(sentry2 stopUpd:)
				(= local3 (gEgo cycleSpeed:))
				(gEgo stopUpd:)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: PolyPath 150 167 self)
			)
			(2
				(kite
					init:
					ignoreActors: 1
					setCycle: CycleBet 2 5 -1
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo moveSpeed:)
				)
				(gEgo
					view: 352
					setLoop: 7
					cel: 0
					posn: 132 162
					setSpeed: 8
					ignoreActors: 1
				)
				(gMessager say: 5 44 12 1 self) ; "Fly, baby, fly!"
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gMessager say: 5 44 12 2 self) ; "Bye bye, Redcoat boneheads!"
			)
			(5
				(gEgo
					setLoop: 8
					setCel: 0
					posn: 108 164
					scaleSignal: 3
					setScale: 160
					setMotion: MoveTo 39 169 self
				)
			)
			(6
				(gMessager say: 5 44 12 3 4 self) ; "<Yawn.> Nice kite, hmm...?"
			)
			(7
				(gEgo setMotion: MoveTo 3 148 self)
			)
			(8
				(gCurRoom newRoom: 360)
			)
		)
	)

	(method (doit)
		(if (>= state 3)
			(kite x: (- (gEgo x:) 37) y: (- (gEgo y:) 53))
		)
		(super doit:)
	)
)

(instance sDunkJar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 490 1)
				(= local3 (gEgo cycleSpeed:))
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 148 168 self)
			)
			(2
				(gMessager say: 5 53 0 0 self) ; "I'll just fill this jar with water, if you don't mind."
			)
			(3
				(SetFlag 142)
				((gInventory at: 18) loop: 4 cel: 11) ; Glass_Jar
				((ScriptID 894 2) init:) ; inventoryCursor
				(gEgo
					view: 805
					loop: 1
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(4
				(= ticks 120)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo normalize: setSpeed: local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkSentry1_1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 346 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 13 85 5 0 self) ; "Excuse me, sir--"
				(++ local0)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkSentry2_1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 346 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 14 85 5 0 self) ; "Excuse me, sir, but I'd like to go into the Mansion. I'm a delivery boy."
				(++ local1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInRiver_Caught of Script
	(properties
		name {sInRiver&Caught}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 (gEgo cycleSpeed:))
				(= cycles 1)
			)
			(1
				(switch register
					(1
						(gMessager say: 5 7 12 0 self) ; "I hope this isn't too cold... Cowabunga!"
					)
					(2
						(gMessager say: 5 3 12 0 self) ; "Okay, It's time for my fish imitation!"
					)
					(3)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gEgo setMotion: PolyPath 150 166 self)
			)
			(3
				(sFX number: 933 setLoop: -1 flags: 1 play:)
				(gEgo
					view: 352
					setLoop: 7
					cel: 0
					posn: 128 162
					setSpeed: 8
					ignoreActors: 1
					setCycle: End self
				)
			)
			(4
				(gMessager say: 12 0 13 0 self) ; "Hey, Tony! Did you hear something in the river?"
			)
			(5
				(sFX stop:)
				(= cycles 1)
			)
			(6
				(= global199 6)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sChocOnSentry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(SetFlag 95)
				(= global215 17)
				(switch register
					(1
						(gMessager say: 13 74 0 1 self) ; "I have some nice, delicious chocolate for you!"
					)
					(2
						(gMessager say: 14 74 0 1 7 self) ; "Here you go, bud. Some delicious chocolate!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(switch register
					(1
						(gMessager say: 14 74 0 2 7 self) ; "CHOCOLATE! Ummmm! Give it to me, give it to me!"
					)
					(2
						(gMessager say: 14 74 0 8 self) ; "We'll eat 'em for you, right! Ha ha!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(= global215 17)
				(switch register
					(1
						(gMessager say: 14 74 0 8 self) ; "We'll eat 'em for you, right! Ha ha!"
					)
					(2
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPaddlesRiver_Caught of Script
	(properties
		name {sPaddlesRiver&Caught}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 (gEgo cycleSpeed:))
				(= cycles 1)
			)
			(1
				(gMessager say: 5 61 12 0 self) ; "All right! With Ben's paddles, I'll be downstream in no time!"
			)
			(2
				(gEgo setMotion: PolyPath 150 166 self)
			)
			(3
				(sFX number: 933 setLoop: -1 play:)
				(gEgo
					view: 352
					setLoop: 7
					cel: 0
					posn: 128 162
					ignoreActors: 1
					setSpeed: 8
					setCycle: End self
				)
			)
			(4
				(gMessager say: 12 0 13 0 self) ; "Hey, Tony! Did you hear something in the river?"
			)
			(5
				(sFX stop:)
				(= global199 6)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sentry1 of Actor
	(properties
		x 245
		y 155
		noun 13
		sightAngle 40
		view 351
		loop 1
		cycleSpeed 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 13 6 12) ; "Well, he's not going anywhere in a big fat hurry!"
				else
					(gMessager say: 13 6 11) ; "That sentry looks big, dumb, and hungry!"
				)
			)
			(7 ; Do
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 13 7 12) ; "Hmm? Go 'way. I don't feel so good..."
				else
					(gMessager say: 13 7 11) ; "Here now! Touch me and I'll have you arrested so fast your little red head spins!"
				)
			)
			(75 ; Bonbons
				(gCurRoom setScript: sSugarRush)
			)
			(85 ; Talk
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 13 85 14) ; "Oh, wow! And I thought sugar had a bad effect on ME!"
				else
					(switch local0
						(1
							(gCurRoom setScript: sTalkSentry1_1)
						)
						(2
							(gMessager say: 13 85 6) ; "Hey, I think my dog is inside the mansion! Have you seen him?"
							(++ local1)
						)
						(3
							(gMessager say: 13 85 7) ; "I think you know where my dog is, mister. You'd just better tell me!"
							(++ local1)
						)
						(4
							(gMessager say: 13 85 8) ; "Hey, buddy! I've got some food for you!"
							(++ local1)
						)
						(5
							(gMessager say: 13 85 9) ; "Oh, Sentry! Look behind you!"
							(++ local1)
						)
						(6
							(gMessager say: 13 85 10) ; "Excuse me--"
						)
						(else
							(gMessager say: 13 85 10) ; "Excuse me--"
						)
					)
				)
			)
			(52 ; Glass_Jar
				(if (IsFlag 93)
					(gMessager say: 13 52 17) ; "TAKE IT AWAY!"
				else
					(SetFlag 93)
					(gMessager say: 13 52) ; "Here you go, boys! Some nice, delicious cabbage!"
				)
			)
			(41 ; Tomato
				(if (IsFlag 94)
					(gMessager say: 13 41 17) ; "TAKE IT AWAY! You'll not poison us, you little wretch!"
				else
					(SetFlag 94)
					(gMessager say: 13 41) ; "Well...I guess you can have this tomato."
				)
			)
			(74 ; Chocolate
				(if (IsFlag 95)
					(gMessager say: 13 74 17) ; "Bring us something better, you little cheapskate!"
				else
					(gCurRoom setScript: sChocOnSentry 0 1)
				)
			)
			(44 ; Kite
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 13 44 12) ; "Mm-hmm. Very nice... <zzrk>"
				else
					(gMessager say: 13 44) ; "That's a lovely kite, lad. Now bring me some roast beef."
				)
			)
			(84 ; Trivia
				(gMessager say: 13 84) ; "FALSE. There were some redcoats in the colonies at this time, but not very many. A large number of troops were withdrawn from the colonies after the French and Indian War (or Seven Years War) ended in 1763. It was just too expensive to keep them there."
			)
			(else
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 13 19 12) ; "...No thanks... I have everything I need... Like that purple squirrel over there..."
				else
					(gMessager say: 13 19 11) ; "You young rascal! I should have you arrested for attempted bribery!"
				)
			)
		)
	)
)

(instance sentry2 of Actor
	(properties
		x 214
		y 153
		noun 14
		sightAngle 40
		view 351
		cycleSpeed 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 14 6 12) ; "Wow! He looks like a little bitty beached whale!"
				else
					(gMessager say: 14 6 11) ; "That guy has a stunning resemblance to a beach ball..."
				)
			)
			(7 ; Do
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 14 7 12) ; "Wha...? Oh, go away. I feel soooo weird..."
				else
					(gMessager say: 14 7 11) ; "Stop! Not an inch closer!"
				)
			)
			(85 ; Talk
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 14 85 14) ; "See you pathetic, sugar-shocked dudes later!"
				else
					(switch local1
						(1
							(gCurRoom setScript: sTalkSentry2_1)
						)
						(2
							(gMessager say: 14 85 6) ; "If you let me in, Sentry, I'll give you something."
							(++ local1)
						)
						(3
							(gMessager say: 14 85 7) ; "You're a pretty important guy around here, aren't you. I'll bet you know a lot about what goes on in the Mansion."
							(++ local1)
						)
						(4
							(gMessager say: 14 85 8) ; "Ima's not REALLY gonna do all that stuff to my dog, is she? I mean, no one could be that cruel."
							(++ local1)
						)
						(5
							(gMessager say: 14 85 9) ; "If you'll just let me by, I'll--"
							(++ local1)
						)
						(6
							(gMessager say: 14 85 10) ; "Sentry, all I want is to--"
						)
						(else
							(gMessager say: 14 85 10) ; "Sentry, all I want is to--"
						)
					)
				)
			)
			(75 ; Bonbons
				(gCurRoom setScript: sSugarRush)
			)
			(52 ; Glass_Jar
				(if (IsFlag 93)
					(gMessager say: 14 52 17) ; "TAKE IT AWAY!"
				else
					(SetFlag 93)
					(gMessager say: 14 52) ; "Here you go, boys. Some nice, yummy cabbage!"
				)
			)
			(41 ; Tomato
				(if (IsFlag 94)
					(gMessager say: 14 41 17) ; "TAKE IT AWAY! You'll not poison us, you little wretch!"
				else
					(SetFlag 94)
					(gMessager say: 14 41) ; "Well...I guess you can have this tomato."
				)
			)
			(74 ; Chocolate
				(if (IsFlag 95)
					(gMessager say: 14 74 17) ; "Bring us something better, you little cheapskate!"
				else
					(gCurRoom setScript: sChocOnSentry 0 2)
				)
			)
			(44 ; Kite
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 14 44 12) ; "Aaah! Aaah! A terrible red beastie! Take it away!"
				else
					(gMessager say: 14 44) ; "That's nice. Why don't you fly it on over to the tavern and bring me a joint of mutton, hmm? Ha ha!"
				)
			)
			(84 ; Trivia
				(gMessager say: 14 84) ; "FALSE. There were some redcoats in the colonies at this time, but not very many. A large number of troops were withdrawn from the colonies after the French and Indian War (or Seven Years War) ended in 1763. It was just too expensive to keep them there."
			)
			(else
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gMessager say: 14 19 12) ; "Aaaah! Take it away! I'm scared!"
				else
					(gMessager say: 14 19 11) ; "Don't try it, little laddie! I can't be bribed! (You don't have any gold or mutton, do you?)"
				)
			)
		)
	)
)

(instance kite of Actor
	(properties
		x 95
		y 108
		view 352
		loop 6
		cel 6
		signal 10240
	)
)

(instance sentry3 of Prop
	(properties
		x 73
		y 120
		noun 11
		view 350
		loop 2
		priority 3
		signal 16401
	)
)

(instance sentry4 of Prop
	(properties
		x 129
		y 117
		noun 11
		view 350
		loop 3
		priority 6
		signal 16401
	)
)

(instance sentry1Feature of Feature
	(properties
		x 280
		y 166
		noun 13
		nsTop 133
		nsLeft 242
		nsBottom 160
		nsRight 319
		sightAngle 40
		approachX 178
		approachY 170
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(sentry1 doVerb: theVerb)
	)
)

(instance river of Feature
	(properties
		x 97
		y 153
		noun 5
		nsTop 135
		nsLeft 40
		nsBottom 171
		nsRight 155
		sightAngle 40
		approachX 137
		approachY 174
		_approachVerbs 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gCurRoom setScript: sInRiver_Caught 0 1)
				else
					(gMessager say: 5 7 11) ; "Stay away from the river, you little water rat!"
				)
			)
			(44 ; Kite
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gCurRoom setScript: sRideKiteDownRiver)
				else
					(gMessager say: 5 44 11) ; "Here, now! Stay away from there!"
				)
			)
			(61 ; Paddles
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gCurRoom setScript: sPaddlesRiver_Caught)
				else
					(gMessager say: 5 61 11) ; "The river's quite stirred up enough as it is, you rascal! Keep your silly paddles away from it!"
				)
			)
			(3 ; Walk
				(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
					(gCurRoom setScript: sInRiver_Caught 0 2)
				else
					(gMessager say: 5 3 11) ; "You do need a bath, boy, but you'll not take it in my river! Get away from there!"
				)
			)
			(53 ; Glass_Jar [tin]
				(if (not (IsFlag 142))
					(gCurRoom setScript: sDunkJar)
				else
					(gMessager say: 5 144 18) ; "The jar is already full of water. Pepper doesn't need any more."
				)
			)
			(144 ; Glass_Jar [tin+water]
				(gMessager say: 5 144 18) ; "The jar is already full of water. Pepper doesn't need any more."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance string of Prop
	(properties
		x 253
		y 81
		noun 8
		sightAngle 40
		approachX 258
		approachY 166
		_approachVerbs 9
		view 350
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: sTakeString)
			)
			(6 ; Look
				((ScriptID 895 0) view: 1790) ; pepper
				(gMessager say: 8 6 0 0 self) ; "Hey! There's some kind of string in that tree! I wonder if some poor kid's kite got caught up there."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		((ScriptID 895 0) normalize:) ; pepper
	)
)

(instance bridge of Feature
	(properties
		y 150
		noun 4
	)
)

(instance foliage of Feature
	(properties
		y 180
		noun 9
	)

	(method (doVerb theVerb)
		(= global215 59)
		(super doVerb: theVerb)
	)
)

(instance frontTree of Feature
	(properties
		y 80
		noun 6
	)
)

(instance hills of Feature
	(properties
		y 20
		noun 10
	)
)

(instance mansion of Feature
	(properties
		x 160
		y 58
		noun 3
		nsTop 18
		nsLeft 98
		nsBottom 99
		nsRight 223
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gMessager say: 3 84) ; "|c1|TRUE. Penn Mansion was built by William Penn, who owned large portions of Philadelphia. He was generally considered to be a just governor. Once his sons inherited the property, however, they decided to stay in London and party instead of taking care of their lands.|c|"
				(sFX number: 927 loop: 1 play:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance riverTrees of Feature
	(properties
		x 51
		y 102
		noun 7
		nsTop 71
		nsLeft 33
		nsBottom 133
		nsRight 70
		sightAngle 40
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		nsTop 151
		nsLeft 306
		nsBottom 189
		nsRight 319
		cursor 913
		exitDir 2
		noun 15
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsLeft 232
		nsBottom 189
		nsRight 319
		cursor 910
		exitDir 3
		noun 2
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance sentry1Talker of BalloonTalker
	(properties
		x 70
		y 107
		talkWidth 160
	)

	(method (init)
		(gEgo stopUpd:)
		(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
			(self x: 125 y: 135 tailPosn: 1)
		else
			(self x: 75 y: 105 tailPosn: 1)
		)
		(super init:)
	)
)

(instance sentry2Talker of BalloonTalker
	(properties
		x 70
		y 107
		talkWidth 160
	)

	(method (init)
		(gEgo stopUpd:)
		(if (== ((gInventory at: 36) owner:) gCurRoomNum) ; Bonbons
			(self x: 45 y: 115 tailPosn: 1)
		else
			(self x: 30 y: 105 tailPosn: 1)
		)
		(super init:)
	)
)

(instance redcoat1 of BalloonTalker
	(properties
		x 140
		y 85
		talkWidth 150
	)
)

(instance redcoat2 of BalloonTalker
	(properties
		x 77
		y 82
		talkWidth 150
	)
)

