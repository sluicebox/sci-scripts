;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use ExitFeature)
(use CycleBet)
(use OccasionalCycle)
(use BalloonTalker)
(use ADRoom)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm300 0
	sentry1Talker 11
	sentry2Talker 12
	pughTalker 13
	percyTalker 14
)

(local
	local0
	local1
)

(instance rm300 of ADRoom
	(properties
		noun 1
		picture 300
		vanishingY 10
	)

	(method (doVerb theVerb)
		(= global215 92)
		(super doVerb: theVerb)
	)

	(method (init)
		(if (IsFlag 295)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 185 39 160 72 159 114 122 127 25 92 0 92 0 1
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 1 319 189 159 189 166 149 172 85 181 74 203 42
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 169 189 153 161 74 132 0 126 0 189
						yourself:
					)
					((Polygon new:)
						type: PContainedAccess
						init: 175 80 157 78 150 113 128 127 154 139
						yourself:
					)
			)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(340
				(gEgo
					init:
					normalize:
					setScale: Scaler 100 52 98 52
					setPri: 2
					setLoop: 2
				)
				(if (not (IsFlag 295))
					(stuff setCel: 3 init: stopUpd:)
				)
				(= local0 1)
				(self setScript: sEnterFromBen_s)
			)
			(116
				(= global114 0)
				(= picture 0)
				(DrawPic 300 100 1)
				((ScriptID 895 0) init: normalize:) ; pepper
			)
			(else
				(if (not (IsFlag 12))
					(genPugh init: stopUpd:)
					(percy view: 228 setLoop: 2 init: stopUpd:)
					(self setScript: taxCartoon)
				else
					(gEgo
						init:
						setScale: 0
						x: -18
						y: 236
						setLoop: 6
						setScale: Scaler 100 52 98 52
					)
					(if (not (IsFlag 295))
						(stuff init: setCel: 3 stopUpd:)
					)
					(self setScript: sEnterFrom230)
				)
			)
		)
		(if (IsFlag 295)
			(stile setCel: 1 init: addToPic:)
		)
		(if (not (IsFlag 295))
			(stile init: stopUpd:)
			(sentry1 init: stopUpd:)
			(sentry2 init: ignoreActors: 1 stopUpd:)
			(gLongSong number: 300 setLoop: -1 play:)
		)
		(if (and (not (gCast contains: sentry1)) (not (IsFlag 51)))
			(tin init: stopUpd:)
		)
		(benHouse init: setOnMeCheck: 1 16384)
		(foliage init: setOnMeCheck: 1 8192)
		(hedge init: setOnMeCheck: 1 4096)
		(road init: setOnMeCheck: 1 1028)
		(sky init: setOnMeCheck: 1 512)
		(southEFeature init:)
	)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((& (gEgo onControl: 1) $0002)
				(gCurRoom setScript: sExitTo270)
			)
			((& (gEgo onControl: 1) $0004)
				(gCurRoom setScript: sExitToBen_s)
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(gNarrator talkWidth: local1)
	)
)

(instance liftStile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 11 111 0 0 self) ; "Bring it all...big or small..."
				(gEgo put: 6) ; A_Shilling
			)
			(1
				(sentry2 view: 306 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(stile dispose:)
				(sentry2 setCycle: End self)
			)
			(3
				(sentry2 addToPic:)
				((ScriptID 895 0) setPri: 12 setMotion: MoveTo 152 122 self) ; pepper
			)
			(4
				(gCurRoom setScript: sExitToBen_s)
			)
		)
	)
)

(instance sExitTo270 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setLoop: 5
					setMotion:
						MoveTo
						(- (gEgo x:) 30)
						(+ (gEgo y:) 60)
						self
				)
			)
			(1
				(gLongSong fade:)
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance sEnterFrom230 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					init:
					setScale: 0
					x: -18
					y: 236
					setLoop: 6
					setScale: Scaler 100 52 98 52
				)
				(= ticks 10)
			)
			(1
				(gEgo setMotion: MoveTo 26 176 self)
			)
			(2
				(if (gCast contains: sentry1)
					((ScriptID 895 0) setPri: 12) ; pepper
				)
				(gGame handsOn:)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance taxCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable:)
				(SetFlag 12)
				(= seconds 2)
			)
			(1
				(gMessager say: 10 0 1 1 self) ; "...So we let people go past the stile, but only AFTER we've given them money."
			)
			(2
				(genPugh setCycle: Fwd)
				(gMessager say: 10 0 1 2 self) ; "NO, you fool! You TAKE money FROM the people! You don't GIVE them money! You tell them it's part of the Stamp Tax, and you TAKE their money!"
			)
			(3
				(genPugh cel: 0 setCycle: 0 stopUpd:)
				(gMessager say: 10 0 1 3 4 self) ; "Okay, sure. I get it."
			)
			(4
				(genPugh setLoop: 2 setCycle: OccasionalCycle self 1 15 50)
				(gMessager say: 10 0 11 1 2 self) ; "Look, you fatwitted, bean-brained idiots! People pass THROUGH the gate! You take their money when they GO THROUGH!"
			)
			(5
				(genPugh cel: 0 setCycle: 0 stopUpd:)
				(gMessager say: 10 0 11 3 self) ; "Here now, we're not the brightest lights in the outhouse, but we're not stupid. We demand money from people that wants to go through the gate, right?"
			)
			(6
				(genPugh setLoop: 0 setCycle: Fwd)
				(gMessager say: 10 0 12 1 self) ; "Yes. Precisely."
			)
			(7
				(genPugh cel: 0 setCycle: 0 stopUpd:)
				(gMessager say: 10 0 12 2 self) ; "And then we can pocket it, like."
			)
			(8
				(genPugh setLoop: 2 setCycle: OccasionalCycle self 1 15 50)
				(gMessager say: 10 0 13 1 self) ; "NO, NO, NO! THAT MONEY IS MINE! YOU KEEP ONE HALF PENNY OF IT AND I'LL SEE YOU HUNG FROM THE TALLEST BUILDING IN PHILADELPHIA!"
			)
			(9
				(genPugh cel: 0 setCycle: 0 stopUpd:)
				(gMessager say: 10 0 13 2 3 self) ; "That'd be Nellie's shop, wouldn't it, Monty?"
			)
			(10
				(genPugh setLoop: 2 setCycle: OccasionalCycle self 1 15 50)
				(gMessager say: 10 0 13 4 self) ; "RRRRRRRRRRR! AAAAAAAH!"
			)
			(11
				(genPugh cel: 0 setCycle: 0 stopUpd:)
				(percy view: 2005 setCycle: Fwd)
				(gMessager say: 10 0 14 1 self) ; "See here, men, just remember it this way. <Ahem.> 'Take it all. Big or small. Take it to the General's hall.'"
			)
			(12
				(percy view: 228 setCycle: 0 setLoop: 2 setCel: 3 stopUpd:)
				(gMessager say: 10 0 14 2 self) ; "'Take it all. Big or small. Take it to the General's hall.' Oooh, I like that. It's got a ring to it, it does."
			)
			(13
				(genPugh setLoop: 0 setCycle: Fwd)
				(gMessager say: 10 0 14 3 self) ; "Finally! Carry on, you worthless ninnyhammers."
			)
			(14
				(gMessager say: 10 0 2 1 self) ; "Hmmph! You're lucky I came up with that rhyme for them to say. The money had better start rolling in, Percy, or I'll have ALL of you boiled in oil."
			)
			(15
				(percy view: 2005 setCycle: Fwd)
				(genPugh cel: 0 setCycle: 0 stopUpd:)
				(gMessager say: 10 0 2 2 self) ; "Yes, sir. I'm sure it will. And if I do say so, it was a nice touch putting the stile right in front of Ben Franklin's house, sir."
			)
			(16
				(percy view: 228 setCycle: 0 setLoop: 2 setCel: 3 stopUpd:)
				(genPugh setLoop: 0 setCycle: Fwd)
				(gMessager say: 10 0 2 3 self) ; "Yes, it WAS brilliant of me. The colonists won't fight the tax when they see that Ben won't lift a finger to get it off his front lawn. HA HA HA!!!"
			)
			(17
				(genPugh
					setPri: 9
					view: 818
					setLoop: -1
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo -20 146 self
				)
			)
			(18
				(genPugh dispose:)
				(percy
					view: 819
					setCycle: Walk
					setLoop: -1
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo -20 146 self
				)
			)
			(19
				(percy dispose:)
				(gTheIconBar enable:)
				(gCurRoom setScript: sEnterFrom230)
			)
		)
	)
)

(instance sExitToBen_s of Script
	(properties
		name {sExitToBen's}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 3 setLoop: 6 setMotion: MoveTo 163 124 self)
			)
			(1
				(gEgo setLoop: 3 setMotion: MoveTo 167 110 self)
			)
			(2
				(gEgo setMotion: MoveTo 170 93 self)
			)
			(3
				(if (gCast contains: sentry2)
					(sentry2 setPri: 15)
				)
				(gEgo setPri: 14 setMotion: MoveTo 181 54 self)
			)
			(4
				(gLongSong fade:)
				(gEgo setPri: 0 setLoop: 3 setMotion: MoveTo 182 65 self)
			)
			(5
				(gEgo hide:)
				(= seconds 2)
			)
			(6
				(gEgo
					show:
					x: 215
					y: 71
					setLoop: 6
					setPri: 2
					setScale: 210
					setMotion: MoveTo 247 64 self
				)
			)
			(7
				(gEgo setLoop: 3 setMotion: MoveTo 256 59 self)
			)
			(8
				(gEgo setMotion: MoveTo 254 46 self)
			)
			(9
				(gLongSong fade:)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance sEnterFromBen_s of Script
	(properties
		name {sEnterFromBen's}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: 254
					y: 46
					setScale: 210
					setMotion: MoveTo 256 59 self
				)
			)
			(1
				(gEgo setLoop: 5 setMotion: MoveTo 247 64 self)
			)
			(2
				(gEgo setMotion: MoveTo 182 65 self)
			)
			(3
				(gEgo hide:)
				(= seconds 2)
			)
			(4
				(gEgo
					show:
					setPri: 3
					x: 186
					y: 54
					setLoop: 2
					setScale: Scaler 100 52 98 52
					setMotion: MoveTo 174 75 self
				)
			)
			(5
				(gEgo setMotion: MoveTo 170 93 self)
			)
			(6
				(gEgo setMotion: MoveTo 167 110 self)
			)
			(7
				(gEgo setMotion: MoveTo 148 126 self)
			)
			(8
				(gEgo normalize: setScale: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkSentry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((IsFlag 294)
						(gGame points: 295 1)
					)
					((IsFlag 293)
						(gGame points: 294 1)
					)
					(else
						(gGame points: 293 1)
					)
				)
				(= ticks 20)
			)
			(1
				(cond
					((IsFlag 295)
						(self setScript: confuseEm self)
					)
					((IsFlag 294)
						(gMessager say: 11 85 6 1 10 self) ; "You know, of the seasons all, I like the fall. That's when the trees grow sweet and tall."
					)
					(else
						(gMessager say: 11 85 5 0 self) ; "...Big or small..."
					)
				)
			)
			(2
				(if (and (not (IsFlag 295)) (IsFlag 294))
					(gMessager say: 11 85 6 11 self) ; "Big and tall, I like that! My head looks good when it's big and tall."
					(sentry2 view: 301 setLoop: 1 setCel: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(3
				(if (and (not (IsFlag 295)) (IsFlag 294))
					(sentry2 setCycle: CycleBet 2 3 3 self)
				else
					(self cue:)
				)
			)
			(4
				(if (and (not (IsFlag 295)) (IsFlag 294))
					(sentry2 setCycle: Beg self)
					(gMessager say: 11 85 6 12 16 self) ; "Oh wear a wig ye in the fall! Wear a wig both big and tall! You too shall dance at the General's ball!"
				else
					(self cue:)
				)
			)
			(5
				(if (or (IsFlag 295) (not (IsFlag 294)))
					(self cue:)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance confuseEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 11 85 7 0 self) ; "You've got LOTS of money! Percy said 'Take it all! Big or small! Buy a wig at the downtown mall!'"
			)
			(1
				(sentry2
					view: 306
					loop: 0
					cel: 0
					illegalBits: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(stile dispose:)
				(sentry2 setCycle: End self)
			)
			(3
				(stuff setPri: 14)
				((ScriptID 895 0) setHeading: 270) ; pepper
				(stile setCel: 1 init: addToPic:)
				(sentry2
					view: 833
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 51 119 self
				)
			)
			(4
				(sentry2 view: 304 setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(5
				(stuff setCel: 2 stopUpd:)
				(sentry2 setCycle: End self)
			)
			(6
				(sentry2
					view: 833
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -10 119 self
				)
			)
			(7
				(sentry2 dispose:)
				(sentry1
					view: 834
					setLoop: 1
					setCycle: Walk
					illegalBits: 0
					setMotion: MoveTo 65 112 self
				)
			)
			(8
				(sentry1
					view: 300
					x: 65
					y: 112
					setLoop: 1
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(9
				(stuff dispose:)
				(tin init: stopUpd:)
				(sentry1 setCycle: End self)
			)
			(10
				(sentry1
					view: 834
					setCycle: Walk
					setMotion: MoveTo -20 112 self
				)
			)
			(11
				(sentry1 dispose:)
				((ScriptID 895 0) setPri: -1) ; pepper
				(gLongSong fade:)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 185 39 160 72 159 114 122 127 25 92 0 92 0 1
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 319 1 319 189 159 189 166 149 172 85 181 74 203 42
							yourself:
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance getTin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: PolyPath 79 125 self) ; pepper
			)
			(1
				(gMessager say: 9 7 0 1 self) ; "Hey, they left something behind! I wonder what it is..."
			)
			(2
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(tin dispose:)
				(gEgo get: 19) ; Tin
				(SetFlag 51)
				(gGame points: 296 1)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(4
				(gMessager say: 9 7 0 2 self) ; "A piece of tin! I guess I'll hang onto it."
			)
			(5
				((ScriptID 895 0) normalize:) ; pepper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance attemptStile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== local0 1)
					(gMessager say: 5 7 4 1 self) ; "Halt, you little mutt! Give us a |r||c0|shilling|c||r|, or you can't pass!"
				else
					(gMessager say: 5 7 3 1 self) ; "HALT! If you want to pass, laddie, you must pay the tax!"
				)
			)
			(1
				(if local0
					(gMessager say: 5 7 4 2 self) ; "Right, give us one!"
				else
					(gMessager say: 5 7 3 2 self) ; "Right, pay the tax!"
				)
			)
			(2
				(if local0
					(self cue:)
				else
					(gMessager say: 5 7 3 3 self) ; "Pay a tax, huh? And just what is this tax going to? New roads? New schools?"
				)
			)
			(3
				(if local0
					(self cue:)
				else
					(gMessager say: 5 7 3 4 self) ; "Oh, the General's wig collection, most likely."
				)
			)
			(4
				(if local0
					(self cue:)
				else
					(gMessager say: 5 7 3 5 self) ; "Hush up, you fool! Who are you, anyway, you nosy lad! I don't think I've seen you before."
				)
			)
			(5
				(if local0
					(self cue:)
				else
					(gMessager say: 5 7 3 6 self) ; "I am what I am, dude, which is more than you can say."
				)
			)
			(6
				(if local0
					(self cue:)
				else
					(gMessager say: 5 7 3 7 self) ; "...Huh?"
				)
			)
			(7
				(if local0
					(self cue:)
				else
					(gMessager say: 5 7 3 8 self) ; "Stop, stop, your brilliance is blinding!"
				)
			)
			(8
				(if local0
					(self cue:)
				else
					(gMessager say: 5 7 3 9 self) ; "Here now! I think you're insulting me!"
				)
			)
			(9
				(if local0
					(self cue:)
				else
					(gMessager say: 5 7 3 10 self) ; "He's insulting you, Cecil."
				)
			)
			(10
				(if local0
					(self cue:)
				else
					(gMessager say: 5 7 3 11 self) ; "Well, stop it! The price for YOU to pass is a whole |r||c0|SHILLING|c||r|, you little smart-aleck!"
				)
			)
			(11
				(if local0
					(self cue:)
				else
					(= local0 1)
					(gMessager say: 5 7 3 12 self) ; "A |r||c0|shilling|c||r|, and that's final!"
				)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance saySDSA of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 5 7 4 1 self) ; "Halt, you little mutt! Give us a |r||c0|shilling|c||r|, or you can't pass!"
			)
			(1
				(gMessager say: 5 7 4 2 self) ; "Right, give us one!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance saySDFA of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 5 7 3 1 11 self) ; "HALT! If you want to pass, laddie, you must pay the tax!"
			)
			(1
				(gMessager say: 5 7 3 12 self) ; "A |r||c0|shilling|c||r|, and that's final!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sentry1Talker of BalloonTalker
	(properties
		x 115
		y 85
		talkWidth 160
	)
)

(instance sentry2Talker of BalloonTalker
	(properties
		x 10
		y 100
		talkWidth 160
		tailPosn 1
	)
)

(instance pughTalker of BalloonTalker
	(properties
		x 80
		y 100
		talkWidth 160
	)
)

(instance percyTalker of BalloonTalker
	(properties
		x 33
		y 95
		talkWidth 160
	)
)

(instance percy of Actor
	(properties
		x 27
		y 146
		view 819
		loop 8
		cel 3
		signal 16384
	)
)

(instance genPugh of Actor
	(properties
		x 70
		y 146
		view 305
		loop 3
		cel 6
		signal 16384
	)

	(method (doit)
		(if (and (== view 305) (== loop 2) (== cel 2))
			(gLongSong2 number: 3000 setLoop: 1 play:)
		)
		(super doit: &rest)
	)
)

(instance sentry1 of Actor
	(properties
		x 110
		y 127
		noun 11
		view 307
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(= global215 87)
		(switch theVerb
			(85 ; Talk
				(cond
					((== gPrevRoomNum 340)
						(gCurRoom setScript: talkSentry)
					)
					(local0
						(= global215 87)
						(gCurRoom setScript: saySDSA)
					)
					(else
						(++ local0)
						(= global215 87)
						(gCurRoom setScript: saySDFA)
					)
				)
			)
			(111 ; A_Shilling
				(gGame points: 297 1)
				(gCurRoom setScript: liftStile)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sentry2 of Actor
	(properties
		x 178
		y 149
		view 301
		priority 12
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gMessager say: 12 7) ; "Help! Help! He's trying to get me! Get away from me, you horrid child!"
			)
			(6 ; Look
				(gMessager say: 12 6) ; "Oh, man, LOOK at that silly guy! No wonder the British lost the war!"
			)
			(else
				(sentry1 doVerb: theVerb)
			)
		)
	)
)

(instance stuff of View
	(properties
		y 92
		noun 8
		view 316
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(= global215 92)
		(switch theVerb
			(6 ; Look
				(switch (stuff cel:)
					(1
						(gMessager say: 8 6 8) ; "There's a pile of stuff next to the tax |r||c0|stile|c||r|. It looks like the Tax Sentries have been taking all kinds of things from people for the Stamp Tax."
					)
					(2
						(gMessager say: 8 6 9) ; "The pile of stuff has grown even bigger! The Tax Sentries are wringing the poor colonists dry!"
					)
					(3
						(gMessager say: 8 6 10) ; "The pile of stuff has grown to staggering proportions! Is there anything the awful Tax Sentries won't steal?"
					)
				)
			)
			(85 ; Talk
				(switch (stuff cel:)
					(1
						(gMessager say: 8 85 8) ; "Geez! Look at all that stuff they stole from people!"
					)
					(2
						(gMessager say: 8 85 9) ; "Oh, wow! These guys are total highway robbers!"
					)
					(3
						(gMessager say: 8 85 10) ; "This is outrageous! These guys should be put in the stocks themselves!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tin of View
	(properties
		x 47
		y 124
		noun 9
		view 316
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: getTin)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stile of View
	(properties
		x 113
		y 99
		noun 5
		view 303
		priority 12
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(= global215 87)
				(if (gCast contains: sentry1)
					(if (not (IsFlag 295))
						(gCurRoom setScript: attemptStile)
					)
				else
					(gMessager say: 5 7 15) ; "Pepper doesn't want to close the stile. She's GLAD the sentries are gone!"
				)
			)
			(6 ; Look
				(= global215 92)
				(if (gCast contains: sentry1)
					(super doVerb: theVerb)
				else
					(gMessager say: 5 6 15) ; "The stile is now open, and no one is guarding it."
				)
			)
			(84 ; Trivia
				(= global215 92)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance benHouse of Feature
	(properties
		y 30
		noun 6
	)
)

(instance foliage of Feature
	(properties
		y 180
		noun 3
		sightAngle 360
	)

	(method (doVerb theVerb)
		(= global215 59)
		(super doVerb: theVerb)
	)
)

(instance hedge of Feature
	(properties
		y 20
		noun 4
	)

	(method (doVerb theVerb)
		(= global215 8)
		(if (== theVerb 84) ; Trivia
			(= local1 (gNarrator talkWidth:))
			(gNarrator talkWidth: 250)
			(gMessager say: 4 84 0 1 gCurRoom) ; "FALSE. It's pretty unlikely that there would be a thick, trimmed hedge right in the middle of the road. Hedges were usually around people's houses. Oh, well, |r||c0|artistic license|c||r| strikes again!"
		else
			(super doVerb: theVerb)
		)
	)
)

(instance road of Feature
	(properties
		y 160
		noun 2
	)
)

(instance sky of Feature
	(properties
		y 10
		noun 7
	)
)

(instance southEFeature of ExitFeature
	(properties
		nsTop 181
		nsBottom 189
		nsRight 165
		cursor 910
		exitDir 3
	)
)

